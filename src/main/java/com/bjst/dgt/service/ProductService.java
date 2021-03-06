package com.bjst.dgt.service;

import com.bjst.dgt.core.ProjectConstant;
import com.bjst.dgt.dao.ProductMapper;
import com.bjst.dgt.dao.UserProductOrderMapper;
import com.bjst.dgt.model.Product;
import com.bjst.dgt.model.UserProductOrder;
import org.aspectj.weaver.patterns.PerObject;
import org.json.JSONArray;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 行情模块service层
 * @Author: yd
 * @CreateDate: 2018/06/13 04:59 PM
 * @UpdateUser: yd
 * @UpdateDate: 2018年6月26日13:35:29
 * @UpdateRemark: 添加Redis缓存
 * @Version: 1.0
 */
@Service
@Transactional
public class ProductService {

    @Resource
    private ProductMapper productMapper;

    @Resource
    private UserProductOrderService userProductOrderService;

    @Resource
    private RedisService redisService;


    /**
     * 获取行情列表
     *
     * @param products products对象
     * @return 产品列表
     */
    public List<Product> getProduct(Product products) {
        UserProductOrder userProductOrder = new UserProductOrder();
        userProductOrder.setUserId(products.getUserId());
        List<Product> productList = new ArrayList<Product>();
        boolean exists = redisService.exists(ProjectConstant.MARKET_GETPRODUCT + products.getUserId());
        if (exists) {
            productList = (List<Product>) redisService.get(ProjectConstant.MARKET_GETPRODUCT + products.getUserId());
        } else {
            productList = productMapper.getProduct();
            redisService.set(ProjectConstant.MARKET_GETPRODUCT + products.getUserId(), productList, new Long(100), TimeUnit.MILLISECONDS);
        }
        if (products.getOrder() == ProjectConstant.SORT_DEFAULT) {
            //默认排序
            //判断用户是否已经进行自定义排序
            boolean falg = userProductOrderService.getUserProducByUserId(userProductOrder);
            if (falg) {
                //已经进行了自定义排序的则返回自定义排序的产品列表
                productList = userProductOrderService.getUserProductOrderByUserId(userProductOrder);
            } else {
                //没有进行了自定义排序的则返回默认排序的产品列表
                Collections.sort(productList, (p1, p2) -> {
                    if (p1.getOrder() > p2.getOrder()) {
                        return 1;
                    } else {
                        return -1;
                    }
                });
            }
        } else if (products.getOrder() == ProjectConstant.SORT_ZHENGXU) {
            //正序
            Collections.sort(productList, (p1, p2) -> {
                if (p1.getChangeCount().compareTo(p2.getChangeCount()) == 1) {
                    return 1;
                } else {
                    return -1;
                }
            });
        } else if (products.getOrder() == ProjectConstant.SORT_DAOXU) {
            //倒序
            Collections.sort(productList, (p1, p2) -> {
                if (p1.getChangeCount().compareTo(p2.getChangeCount()) == -1) {
                    return 1;
                } else {
                    return -1;
                }
            });
        }
        return productList;
    }

    /**
     * 用户产品自定义排序
     *
     * @param map ajax发送过来的数据
     * @return 自定义产品列表
     */
    public List<Product> setOrder(Map<String, String> map) {
        UserProductOrder userProductOrder = new UserProductOrder();
        int userId = Integer.parseInt(map.get("userId"));
        String order = map.get("orders");
        String code = map.get("codes");
        order = order.substring(1, order.length() - 1);
        code = code.substring(1, code.length() - 1);
        String orders[] = order.split(",");
        String codes[] = code.split(",");
        for (int i = 0; i < 15; i++) {
            userProductOrder.setUserId(userId);
            userProductOrder.setOrder(Byte.valueOf(orders[i]));
            userProductOrder.setCode(codes[i].substring(1, codes[i].length() - 1));
            //判断是否用户已经进行了自定义排序
            boolean falg = userProductOrderService.getUserProducByUserId(userProductOrder);
            if (falg) {
                //已经进行了自定义排序的 则 修改产品自定义排序列表
                userProductOrderService.updateUserProductOrderByUserId(userProductOrder);
            } else {
                //没有进行了自定义排序的 则 新增产品自定义排序列表
                userProductOrderService.insertUserProductOrderByUserId(userProductOrder);
            }
        }
        List<Product> userProductOrderList = userProductOrderService.getUserProductOrderByUserId(userProductOrder);
        return userProductOrderList;
    }

}

package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcQryTradingNoticeField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] InvestorID = new byte[13];
    public byte[] InvestUnitID = new byte[17];

    public static class ByReference extends CThostFtdcQryTradingNoticeField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcQryTradingNoticeField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("InvestorID");
        a.add("InvestUnitID");
        return a;
    }
};

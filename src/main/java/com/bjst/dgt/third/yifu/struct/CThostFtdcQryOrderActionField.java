package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcQryOrderActionField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] InvestorID = new byte[13];
    public byte[] ExchangeID = new byte[9];

    public static class ByReference extends CThostFtdcQryOrderActionField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcQryOrderActionField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("InvestorID");
        a.add("ExchangeID");
        return a;
    }
};

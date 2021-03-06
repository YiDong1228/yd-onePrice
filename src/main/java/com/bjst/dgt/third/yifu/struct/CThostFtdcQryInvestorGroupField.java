package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcQryInvestorGroupField extends Structure {
    public byte[] BrokerID = new byte[11];

    public static class ByReference extends CThostFtdcQryInvestorGroupField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcQryInvestorGroupField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        return a;
    }
};

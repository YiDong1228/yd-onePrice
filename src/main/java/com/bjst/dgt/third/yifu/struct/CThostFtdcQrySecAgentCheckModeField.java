package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcQrySecAgentCheckModeField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] InvestorID = new byte[13];

    public static class ByReference extends CThostFtdcQrySecAgentCheckModeField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcQrySecAgentCheckModeField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("InvestorID");
        return a;
    }
};

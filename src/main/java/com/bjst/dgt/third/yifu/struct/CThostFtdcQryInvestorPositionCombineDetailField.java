package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcQryInvestorPositionCombineDetailField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] InvestorID = new byte[13];
    public byte[] CombInstrumentID = new byte[31];
    public byte[] ExchangeID = new byte[9];
    public byte[] InvestUnitID = new byte[17];

    public static class ByReference extends CThostFtdcQryInvestorPositionCombineDetailField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcQryInvestorPositionCombineDetailField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("InvestorID");
        a.add("CombInstrumentID");
        a.add("ExchangeID");
        a.add("InvestUnitID");
        return a;
    }
};

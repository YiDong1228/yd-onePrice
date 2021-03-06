package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcPositionProfitAlgorithmField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] AccountID = new byte[13];
    public byte Algorithm;
    public byte[] Memo = new byte[161];
    public byte[] CurrencyID = new byte[4];

    public static class ByReference extends CThostFtdcPositionProfitAlgorithmField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcPositionProfitAlgorithmField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("AccountID");
        a.add("Algorithm");
        a.add("Memo");
        a.add("CurrencyID");
        return a;
    }
};

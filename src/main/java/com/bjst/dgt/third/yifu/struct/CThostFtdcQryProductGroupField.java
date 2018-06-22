package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcQryProductGroupField extends Structure {
    public byte[] ProductID = new byte[31];
    public byte[] ExchangeID = new byte[9];

    public static class ByReference extends CThostFtdcQryProductGroupField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcQryProductGroupField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("ProductID");
        a.add("ExchangeID");
        return a;
    }
};

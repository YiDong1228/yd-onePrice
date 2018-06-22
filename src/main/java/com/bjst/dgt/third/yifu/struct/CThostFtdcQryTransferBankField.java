package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcQryTransferBankField extends Structure {
    public byte[] BankID = new byte[4];
    public byte[] BankBrchID = new byte[5];

    public static class ByReference extends CThostFtdcQryTransferBankField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcQryTransferBankField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BankID");
        a.add("BankBrchID");
        return a;
    }
};

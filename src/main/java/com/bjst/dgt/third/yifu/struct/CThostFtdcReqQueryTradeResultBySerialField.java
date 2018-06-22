package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcReqQueryTradeResultBySerialField extends Structure {
    public byte[] TradeCode = new byte[7];
    public byte[] BankID = new byte[4];
    public byte[] BankBranchID = new byte[5];
    public byte[] BrokerID = new byte[11];
    public byte[] BrokerBranchID = new byte[31];
    public byte[] TradeDate = new byte[9];
    public byte[] TradeTime = new byte[9];
    public byte[] BankSerial = new byte[13];
    public byte[] TradingDay = new byte[9];
    public int PlateSerial;
    public byte LastFragment;
    public int SessionID;
    public int Reference;
    public byte RefrenceIssureType;
    public byte[] RefrenceIssure = new byte[36];
    public byte[] CustomerName = new byte[51];
    public byte IdCardType;
    public byte[] IdentifiedCardNo = new byte[51];
    public byte CustType;
    public byte[] BankAccount = new byte[41];
    public byte[] BankPassWord = new byte[41];
    public byte[] AccountID = new byte[13];
    public byte[] Password = new byte[41];
    public byte[] CurrencyID = new byte[4];
    public double TradeAmount;
    public byte[] Digest = new byte[36];
    public byte[] LongCustomerName = new byte[161];

    public static class ByReference extends CThostFtdcReqQueryTradeResultBySerialField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcReqQueryTradeResultBySerialField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("TradeCode");
        a.add("BankID");
        a.add("BankBranchID");
        a.add("BrokerID");
        a.add("BrokerBranchID");
        a.add("TradeDate");
        a.add("TradeTime");
        a.add("BankSerial");
        a.add("TradingDay");
        a.add("PlateSerial");
        a.add("LastFragment");
        a.add("SessionID");
        a.add("Reference");
        a.add("RefrenceIssureType");
        a.add("RefrenceIssure");
        a.add("CustomerName");
        a.add("IdCardType");
        a.add("IdentifiedCardNo");
        a.add("CustType");
        a.add("BankAccount");
        a.add("BankPassWord");
        a.add("AccountID");
        a.add("Password");
        a.add("CurrencyID");
        a.add("TradeAmount");
        a.add("Digest");
        a.add("LongCustomerName");
        return a;
    }
};

package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcOrderActionField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] InvestorID = new byte[13];
    public int OrderActionRef;
    public byte[] OrderRef = new byte[13];
    public int RequestID;
    public int FrontID;
    public int SessionID;
    public byte[] ExchangeID = new byte[9];
    public byte[] OrderSysID = new byte[21];
    public byte ActionFlag;
    public double LimitPrice;
    public int VolumeChange;
    public byte[] ActionDate = new byte[9];
    public byte[] ActionTime = new byte[9];
    public byte[] TraderID = new byte[21];
    public int InstallID;
    public byte[] OrderLocalID = new byte[13];
    public byte[] ActionLocalID = new byte[13];
    public byte[] ParticipantID = new byte[11];
    public byte[] ClientID = new byte[11];
    public byte[] BusinessUnit = new byte[21];
    public byte OrderActionStatus;
    public byte[] UserID = new byte[16];
    public byte[] StatusMsg = new byte[81];
    public byte[] InstrumentID = new byte[31];
    public byte[] BranchID = new byte[9];
    public byte[] InvestUnitID = new byte[17];
    public byte[] IPAddress = new byte[16];
    public byte[] MacAddress = new byte[21];

    public static class ByReference extends CThostFtdcOrderActionField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcOrderActionField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("InvestorID");
        a.add("OrderActionRef");
        a.add("OrderRef");
        a.add("RequestID");
        a.add("FrontID");
        a.add("SessionID");
        a.add("ExchangeID");
        a.add("OrderSysID");
        a.add("ActionFlag");
        a.add("LimitPrice");
        a.add("VolumeChange");
        a.add("ActionDate");
        a.add("ActionTime");
        a.add("TraderID");
        a.add("InstallID");
        a.add("OrderLocalID");
        a.add("ActionLocalID");
        a.add("ParticipantID");
        a.add("ClientID");
        a.add("BusinessUnit");
        a.add("OrderActionStatus");
        a.add("UserID");
        a.add("StatusMsg");
        a.add("InstrumentID");
        a.add("BranchID");
        a.add("InvestUnitID");
        a.add("IPAddress");
        a.add("MacAddress");
        return a;
    }
};

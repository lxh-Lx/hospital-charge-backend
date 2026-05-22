package edu.gdpu.hospitalcharge.service;

import edu.gdpu.hospitalcharge.entity.ChargeItem;
import edu.gdpu.hospitalcharge.entity.ChargeOrder;
import java.util.List;

public interface ChargeService {
    List<ChargeItem> getUnpaidItems(Integer patientId);

    void settleCharge(ChargeOrder chargeOrder);

    void refundCharge(Integer orderId);

    List<ChargeOrder> getChargeList(String startDate, String endDate, Integer operatorId);
}
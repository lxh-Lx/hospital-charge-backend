package edu.gdpu.hospitalcharge.service;

import edu.gdpu.hospitalcharge.entity.ChargeItem;
import java.util.List;

public interface ChargeItemService {
    List<ChargeItem> getAllChargeItems();

    ChargeItem getChargeItemById(Integer itemId);

    void addChargeItem(ChargeItem chargeItem);

    void updateChargeItem(ChargeItem chargeItem);

    void deleteChargeItem(Integer itemId);
}
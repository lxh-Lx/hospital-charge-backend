package edu.gdpu.hospitalcharge.service.impl;

import edu.gdpu.hospitalcharge.entity.ChargeItem;
import edu.gdpu.hospitalcharge.mapper.ChargeItemMapper;
import edu.gdpu.hospitalcharge.service.ChargeItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ChargeItemServiceImpl implements ChargeItemService {

    @Autowired
    private ChargeItemMapper chargeItemMapper;

    @Override
    public List<ChargeItem> getAllChargeItems() {
        return chargeItemMapper.selectAll();
    }

    @Override
    public ChargeItem getChargeItemById(Integer itemId) {
        return chargeItemMapper.selectById(itemId);
    }

    @Override
    public void addChargeItem(ChargeItem chargeItem) {
        chargeItemMapper.insert(chargeItem);
    }

    @Override
    public void updateChargeItem(ChargeItem chargeItem) {
        chargeItemMapper.update(chargeItem);
    }

    @Override
    public void deleteChargeItem(Integer itemId) {
        chargeItemMapper.deleteById(itemId);
    }
}
package edu.gdpu.hospitalcharge.service.impl;

import edu.gdpu.hospitalcharge.entity.ChargeDetail;
import edu.gdpu.hospitalcharge.entity.ChargeItem;
import edu.gdpu.hospitalcharge.entity.ChargeOrder;
import edu.gdpu.hospitalcharge.entity.Invoice;
import edu.gdpu.hospitalcharge.mapper.*;
import edu.gdpu.hospitalcharge.service.ChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class ChargeServiceImpl implements ChargeService {

    @Autowired
    private ChargeOrderMapper chargeOrderMapper;

    @Autowired
    private ChargeDetailMapper chargeDetailMapper;

    @Autowired
    private InvoiceMapper invoiceMapper;

    // ✅ 之前漏掉了这一行！这就是500错误的根源
    @Autowired
    private ChargeItemMapper chargeItemMapper;

    @Override
    public List<ChargeItem> getUnpaidItems(Integer patientId) {
        // 先查询所有随机排序的项目
        List<ChargeItem> allItems = chargeItemMapper.selectUnpaidByPatientId(patientId);

        // 随机截取1-5条
        int randomCount = 1 + (int) (Math.random() * 5);
        if (allItems.size() > randomCount) {
            return allItems.subList(0, randomCount);
        }
        return allItems;
    }
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void settleCharge(ChargeOrder chargeOrder) {
        // 1. 保存收费单
        chargeOrder.setStatus("已支付");
        chargeOrder.setOperatorId(1); // 测试用，实际从登录信息获取
        chargeOrderMapper.insert(chargeOrder);

        // 2. 保存收费明细
        for (ChargeDetail detail : chargeOrder.getDetails()) {
            detail.setOrderId(chargeOrder.getOrderId());
            chargeDetailMapper.insert(detail);
        }

        // 3. 生成发票
        Invoice invoice = new Invoice();
        invoice.setOrderId(chargeOrder.getOrderId());
        invoice.setInvoiceNo("FP" + UUID.randomUUID().toString().substring(0, 8).toUpperCase());
        invoiceMapper.insert(invoice);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void refundCharge(Integer orderId) {
        // 1. 检查收费单状态
        ChargeOrder chargeOrder = chargeOrderMapper.selectById(orderId);
        if (chargeOrder == null) {
            throw new RuntimeException("收费单不存在");
        }
        if (chargeOrder.getStatus().equals("已退费")) {
            throw new RuntimeException("该收费单已退费");
        }

        // 2. 更新收费单状态
        chargeOrderMapper.updateStatus(orderId, "已退费");

        // 3. 删除发票
        invoiceMapper.deleteByOrderId(orderId);
    }

    @Override
    public List<ChargeOrder> getChargeList(String startDate, String endDate, Integer operatorId) {
        return chargeOrderMapper.selectByCondition(startDate, endDate, operatorId);
    }
}
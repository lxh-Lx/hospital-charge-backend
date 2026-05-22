package edu.gdpu.hospitalcharge.controller;

import edu.gdpu.hospitalcharge.common.Result;
import edu.gdpu.hospitalcharge.entity.ChargeOrder;
import edu.gdpu.hospitalcharge.service.ChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/charge")
@CrossOrigin(origins = "*", maxAge = 3600) // 解决跨域问题
public class ChargeController {

    @Autowired
    private ChargeService chargeService;

    // 根据患者ID查询未收费项目
    @GetMapping("/unpaid/{patientId}")
    public Result getUnpaidItems(@PathVariable Integer patientId) {
        return Result.success(chargeService.getUnpaidItems(patientId));
    }

    // 收费结算
    @PostMapping("/settle")
    public Result settleCharge(@RequestBody ChargeOrder chargeOrder) {
        try {
            chargeService.settleCharge(chargeOrder);
            return Result.success("收费成功");
        } catch (Exception e) {
            return Result.error("收费失败：" + e.getMessage());
        }
    }

    // 退费
    @PostMapping("/refund/{orderId}")
    public Result refundCharge(@PathVariable Integer orderId) {
        try {
            chargeService.refundCharge(orderId);
            return Result.success("退费成功");
        } catch (Exception e) {
            return Result.error("退费失败：" + e.getMessage());
        }
    }

    // 查询收费记录
    @GetMapping("/list")
    public Result getChargeList(
            @RequestParam(required = false) String startDate,
            @RequestParam(required = false) String endDate,
            @RequestParam(required = false) Integer operatorId
    ) {
        return Result.success(chargeService.getChargeList(startDate, endDate, operatorId));
    }
}
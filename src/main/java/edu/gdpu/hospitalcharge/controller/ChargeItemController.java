package edu.gdpu.hospitalcharge.controller;

import edu.gdpu.hospitalcharge.common.Result;
import edu.gdpu.hospitalcharge.entity.ChargeItem;
import edu.gdpu.hospitalcharge.service.ChargeItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/charge-item")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ChargeItemController {

    @Autowired
    private ChargeItemService chargeItemService;

    @GetMapping("/list")
    public Result getAllChargeItems() {
        return Result.success(chargeItemService.getAllChargeItems());
    }

    @GetMapping("/{itemId}")
    public Result getChargeItemById(@PathVariable Integer itemId) {
        return Result.success(chargeItemService.getChargeItemById(itemId));
    }

    @PostMapping("/add")
    public Result addChargeItem(@RequestBody ChargeItem chargeItem) {
        try {
            chargeItemService.addChargeItem(chargeItem);
            return Result.success("添加成功");
        } catch (Exception e) {
            return Result.error("添加失败：" + e.getMessage());
        }
    }

    @PostMapping("/update")
    public Result updateChargeItem(@RequestBody ChargeItem chargeItem) {
        try {
            chargeItemService.updateChargeItem(chargeItem);
            return Result.success("修改成功");
        } catch (Exception e) {
            return Result.error("修改失败：" + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{itemId}")
    public Result deleteChargeItem(@PathVariable Integer itemId) {
        try {
            chargeItemService.deleteChargeItem(itemId);
            return Result.success("删除成功");
        } catch (Exception e) {
            return Result.error("删除失败：" + e.getMessage());
        }
    }
}
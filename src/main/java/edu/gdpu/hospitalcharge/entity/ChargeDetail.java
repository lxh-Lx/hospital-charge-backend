package edu.gdpu.hospitalcharge.entity;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class ChargeDetail {
    private Integer detailId;
    private Integer orderId;
    private Integer itemId;
    private Integer quantity;
    private BigDecimal amount;
    private String itemName; // 关联查询用
    private String itemType; // 关联查询用
    private BigDecimal price; // 关联查询用
}
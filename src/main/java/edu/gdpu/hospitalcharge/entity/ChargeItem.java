package edu.gdpu.hospitalcharge.entity;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class ChargeItem {
    private Integer itemId;
    private String itemName;
    private String itemType;
    private BigDecimal price;
    private String unit;
    private Integer status;
}
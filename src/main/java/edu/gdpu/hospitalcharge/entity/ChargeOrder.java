package edu.gdpu.hospitalcharge.entity;

import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class ChargeOrder {
    private Integer orderId;
    private Integer patientId;
    private Integer operatorId;
    private BigDecimal totalAmount;
    private String payType;
    private String status;
    private Date createTime;
    private String patientName; // 关联查询用
    private String operatorName; // 关联查询用
    private List<ChargeDetail> details; // 接收前端传的明细
}
package edu.gdpu.hospitalcharge.entity;

import lombok.Data;
import java.util.Date;

@Data
public class Invoice {
    private Integer invoiceId;
    private Integer orderId;
    private String invoiceNo;
    private Date printTime;
}
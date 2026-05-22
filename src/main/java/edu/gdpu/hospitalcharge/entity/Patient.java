package edu.gdpu.hospitalcharge.entity;

import lombok.Data;
import java.util.Date;

@Data
public class Patient {
    private Integer patientId;
    private String name;
    private String idCard;
    private String phone;
    private String gender;
    private Integer age;
    private Date createTime;
}
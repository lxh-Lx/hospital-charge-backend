package edu.gdpu.hospitalcharge.entity;

import lombok.Data;
import java.util.Date;

@Data
public class ChargeOperator {
    private Integer operatorId;
    private String username;
    private String password;
    private String realName;
    private String role;
    private Date createTime;
}
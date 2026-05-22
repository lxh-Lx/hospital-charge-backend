package edu.gdpu.hospitalcharge.mapper;

import edu.gdpu.hospitalcharge.entity.ChargeOperator;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ChargeOperatorMapper {
    ChargeOperator selectByUsernameAndPassword(
            @Param("username") String username,
            @Param("password") String password
    );
}
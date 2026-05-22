package edu.gdpu.hospitalcharge.mapper;

import edu.gdpu.hospitalcharge.entity.ChargeOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface ChargeOrderMapper {
    int insert(ChargeOrder chargeOrder);

    ChargeOrder selectById(@Param("orderId") Integer orderId);

    int updateStatus(@Param("orderId") Integer orderId, @Param("status") String status);

    List<ChargeOrder> selectByCondition(
            @Param("startDate") String startDate,
            @Param("endDate") String endDate,
            @Param("operatorId") Integer operatorId
    );
}
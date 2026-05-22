package edu.gdpu.hospitalcharge.mapper;

import edu.gdpu.hospitalcharge.entity.ChargeDetail;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface ChargeDetailMapper {
    @Insert("INSERT INTO charge_detail (order_id, item_id, quantity, amount) VALUES (#{orderId}, #{itemId}, #{quantity}, #{amount})")
    int insert(ChargeDetail chargeDetail);

    List<ChargeDetail> selectByOrderId(@Param("orderId") Integer orderId);

    int deleteByOrderId(@Param("orderId") Integer orderId);
}
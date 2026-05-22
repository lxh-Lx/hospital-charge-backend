package edu.gdpu.hospitalcharge.mapper;

import edu.gdpu.hospitalcharge.entity.ChargeItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface ChargeItemMapper {
    List<ChargeItem> selectAll();

    ChargeItem selectById(@Param("itemId") Integer itemId);

    int insert(ChargeItem chargeItem);

    int update(ChargeItem chargeItem);

    int deleteById(@Param("itemId") Integer itemId);

    // 模拟从医生工作站获取患者未收费项目
    List<ChargeItem> selectUnpaidByPatientId(@Param("patientId") Integer patientId);
}
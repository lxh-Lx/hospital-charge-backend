package edu.gdpu.hospitalcharge.mapper;

import edu.gdpu.hospitalcharge.entity.Patient;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PatientMapper {
    @Select("SELECT * FROM patient WHERE patient_id = #{patientId}")
    Patient selectById(@Param("patientId") Integer patientId);
}
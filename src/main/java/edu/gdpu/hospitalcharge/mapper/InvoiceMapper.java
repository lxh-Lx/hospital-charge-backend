package edu.gdpu.hospitalcharge.mapper;

import edu.gdpu.hospitalcharge.entity.Invoice;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface InvoiceMapper {
    @Insert("INSERT INTO invoice (order_id, invoice_no) VALUES (#{orderId}, #{invoiceNo})")
    int insert(Invoice invoice);

    @Delete("DELETE FROM invoice WHERE order_id = #{orderId}")
    int deleteByOrderId(@Param("orderId") Integer orderId);
}
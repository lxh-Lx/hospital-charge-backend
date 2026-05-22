package edu.gdpu.hospitalcharge;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("edu.gdpu.hospitalcharge.mapper") // 扫描Mapper接口，必须加！
public class HospitalChargeApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalChargeApplication.class, args);
    }

}
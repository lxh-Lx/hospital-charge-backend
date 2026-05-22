package edu.gdpu.hospitalcharge.controller;

import edu.gdpu.hospitalcharge.common.Result;
import edu.gdpu.hospitalcharge.entity.ChargeOperator;
import edu.gdpu.hospitalcharge.mapper.ChargeOperatorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/login")
@CrossOrigin(origins = "*", maxAge = 3600)
public class LoginController {

    @Autowired
    private ChargeOperatorMapper chargeOperatorMapper;

    @PostMapping
    public Result login(@RequestBody Map<String, String> loginForm) {
        String username = loginForm.get("username");
        String password = loginForm.get("password");

        // MD5加密密码
        String md5Password = org.springframework.util.DigestUtils.md5DigestAsHex(password.getBytes());

        ChargeOperator operator = chargeOperatorMapper.selectByUsernameAndPassword(username, md5Password);
        if (operator == null) {
            return Result.error("用户名或密码错误");
        }

        // 生成token（简单模拟）
        String token = "token_" + System.currentTimeMillis();
        Map<String, Object> result = new HashMap<>();
        result.put("token", token);
        result.put("user", operator);

        return Result.success(result);
    }
}
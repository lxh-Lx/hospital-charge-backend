package edu.gdpu.hospitalcharge.common;

public class ResultUtil {
    public static Result success() {
        return Result.success(null);
    }

    public static Result error() {
        return Result.error("操作失败");
    }
}
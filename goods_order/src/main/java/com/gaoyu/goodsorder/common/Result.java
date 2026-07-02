package com.gaoyu.goodsorder.common;

import lombok.Data;

/**
 * 统一结果封装类
 *
 * 所有 Controller 方法的返回值都是这个类，格式永远一致：
 * {
 *   "code": 200,
 *   "msg": "操作成功",
 *   "data": ...
 * }
 *
 * 泛型 T 表示 data 的类型，可以是 Goods、List<Order> 等任何类型
 */
@Data
public class Result<T> {

    private int code;      // 状态码
    private String msg;    // 提示信息
    private T data;        // 数据（成功时才有值）

    // 私有构造，只能通过静态方法创建实例
    private Result() {}

    /** 成功 —— 带数据 */
    public static <T> Result<T> success(T data) {
        Result<T> r = new Result<>();
        r.setCode(ResultCode.SUCCESS.getCode());
        r.setMsg(ResultCode.SUCCESS.getMsg());
        r.setData(data);
        return r;
    }

    /** 成功 —— 自定义提示信息 + 数据 */
    public static <T> Result<T> success(String msg, T data) {
        Result<T> r = new Result<>();
        r.setCode(ResultCode.SUCCESS.getCode());
        r.setMsg(msg);
        r.setData(data);
        return r;
    }

    /** 失败 —— 指定状态码 */
    public static <T> Result<T> fail(ResultCode resultCode) {
        Result<T> r = new Result<>();
        r.setCode(resultCode.getCode());
        r.setMsg(resultCode.getMsg());
        return r;
    }

    /** 失败 —— 自定义信息 */
    public static <T> Result<T> fail(int code, String msg) {
        Result<T> r = new Result<>();
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }
}
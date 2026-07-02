package com.gaoyu.goodsorder.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 统一状态码枚举
 *
 * 为什么用枚举而不是直接写数字？
 * 1. 代码可读性：看到 SUCCESS 就知道是成功，不用猜 200 是什么意思
 * 2. 防止魔鬼数字：到处写 200、500、404，很容易写错
 * 3. 统一管理：要改状态码，只改这一处
 */
@Getter
@AllArgsConstructor
public enum ResultCode {

    // ========== 成功 ==========
    SUCCESS(200, "操作成功"),

    // ========== 客户端错误 4xx ==========
    BAD_REQUEST(400, "请求参数错误"),
    NOT_FOUND(404, "资源不存在"),

    // ========== 服务端错误 5xx ==========
    INTERNAL_ERROR(500, "服务器内部错误");

    private final int code;      // 状态码
    private final String msg;    // 提示信息
}
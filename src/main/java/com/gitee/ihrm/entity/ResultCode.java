package com.gitee.ihrm.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 公共的返回码
 *
 * @author jianghao
 * @date 2019/10/23 10:11
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ResultCode {

    /**
     * 操作成功
     */
    SUCCESS(true, 10000, "操作成功！"),
    FAIL(false, 10001, "操作失败"),
    UNAUTHENTICATED(false, 10002, "您还未登录"),
    UN_AUTHORISE(false, 10003, "权限不足"),
    SERVER_ERROR(false, 99999, "抱歉，系统繁忙，请稍后重试！");

    /**
     * 操作是否成功
     */
    Boolean success;
    /**
     * 操作代码
     */
    Integer code;
    /**
     * 提示信息
     */
    String message;

}

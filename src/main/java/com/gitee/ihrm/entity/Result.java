package com.gitee.ihrm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 数据响应对象
 * {
 * success ：是否成功
 * code    ：返回码
 * message ：返回信息
 * //返回数据
 * data：  ：{
 * }
 * }
 *
 * @author jianghao
 * @date 2019/10/23 9:56
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {

    /**
     * 是否成功
     */
    private boolean success;
    /**
     * 返回码
     */
    private Integer code;
    /**
     * 返回信息
     */
    private String message;
    /**
     * 返回数据
     */
    private Object data;

    public Result(boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }
}

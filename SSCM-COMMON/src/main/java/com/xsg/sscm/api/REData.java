package com.xsg.sscm.api;

import lombok.*;

/**
 * @des: 返回的对象
 * @package: com.xsg.sscm.common
 * @author: xsg
 * @date: 2020/9/5
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class REData<T> {
    private Long code;
    private String message;
    private T data;

    /**
     * success(200)
     * 成功返回的结果(没有提示信息时)
     */
    public static <T> REData<T> success(T data){
        return new REData<T>(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage(),data);
    }

    /**
     * success(200)
     * 成功返回的结果(有提示信息时)
     */
    public static <T> REData<T> success(String message, T data){
        return new REData<T>(ResultCode.SUCCESS.getCode(), message, data);
    }

    /**
     * failed(500)
     * 失败返回的结果(有提示信息时)
     */
    public static <T> REData<T> failed(String message){
        return new REData<T>(ResultCode.FAILED.getCode(), message,null);
    }

    /**
     *failed(500)
     * 失败返回结果(没有提示信息时)
     */
    public static <T> REData<T> failed(){
        return new REData<T>(ResultCode.FAILED.getCode(),ResultCode.FAILED.getMessage(),null);
    }

    /**
     * failed(404)
     * 找不到文件(没有错误提示)
     */
    public static <T> REData<T> NOTFINDFILE(){
        return new REData<T>(ResultCode.NOTFINDFILE.getCode(), ResultCode.NOTFINDFILE.getMessage(),null);
    }

    /**
     * 参数验证失败返回结果(有错误提示)
     */
    public static <T> REData<T> NOTFINDFILE(String message) {
        return new REData<T>(ResultCode.NOTFINDFILE.getCode(), message, null);
    }

    /**
     * 身份验证登录失败(token错误)(有错误提示)
     */
    public static <T> REData<T> UNAUTHORIZED(String message) {
        return new REData<T>(ResultCode.UNAUTHORIZED.getCode(), message, null);
    }

    /**
     * 身份验证登录失败(token错误)(没有错误提示)
     */
    public static <T> REData<T> UNAUTHORIZED() {
        return new REData<T>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), null);
    }

    /**
     * 权限不足(没有错误提示)
     */
    public static <T> REData<T> FORBIDDEN() {
        return new REData<T>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(), null);
    }

    /**
     * 权限不足(有错误提示)
     */
    public static <T> REData<T> FORBIDDEN(String message) {
        return new REData<T>(ResultCode.FORBIDDEN.getCode(), message, null);
    }

}

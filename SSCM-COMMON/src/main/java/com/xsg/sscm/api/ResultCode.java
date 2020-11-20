package com.xsg.sscm.api;

import lombok.Getter;

/**
 * @des: resultcode(200,500,404)
 * @package: com.xsg.sscm.common
 * @author: xsg
 * @date: 2020/9/5
 **/
@Getter
public enum ResultCode {
    SUCCESS(200, "operation success"),
    FAILED(500, "operation failed"),
    UNAUTHORIZED(401, "Login failed or token expired"),
    FORBIDDEN(403, "Insufficient authority"),
    NOTFINDFILE(400, "cannot find file");

    private long code;
    private String message;

    private ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

}

package com.alibaba.xingchen.model.ext;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/**
 * @author zhiyong.fzy@alibaba-inc.com
 * @date 2023/9/26 6:57 PM
 */
@Data
@SuperBuilder
@NoArgsConstructor
public class BaseResponse implements Serializable {
    private static final long serialVersionUID = 918308331694988945L;

    // 网关出参
    private String requestId;

    private Integer errorCode;

    private String errorMessage;

    private String errorName;

    private Integer httpStatusCode;

    // 业务参数
    private Integer code;

    private String errorMessageKey;

    private Boolean success;
}

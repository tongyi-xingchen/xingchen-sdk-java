package com.alibaba.xingchen.model.ext.chat;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author zhiyong.fzy@alibaba-inc.com
 * @date 2023/9/22 5:41 PM
 */
@Data
@SuperBuilder
@NoArgsConstructor
public class UserProfile implements Serializable {

    private static final long serialVersionUID = 900523689142965757L;

    /**
     * 对话用户ID，必填
     */
    @NotBlank
    private String userId;

    /**
     * 对话用户名称，非必填
     */
    private String userName;

    /**
     * 用户信息，非必填
     */
    private String basicInfo;
}
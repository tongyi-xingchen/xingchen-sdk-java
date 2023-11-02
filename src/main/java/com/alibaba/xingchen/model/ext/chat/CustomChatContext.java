package com.alibaba.xingchen.model.ext.chat;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/**
 * @author zhiyong.fzy@alibaba-inc.com
 * @date 2023/9/4 7:31 PM
 * 自拼接Prompt对话上下文
 */
@Data
@SuperBuilder
public class CustomChatContext implements Serializable {


    private static final long serialVersionUID = 6915145783935288269L;

    /**
     * 是否启用SSE，默认否
     */
    private Boolean enableSse;

    /**
     * 是否启用绿网检查，默认否
     */
    private Boolean enableDataInspection;
}

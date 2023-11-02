package com.alibaba.xingchen.model.ext.chat;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/**
 * @decription: 对话消息
 * @author: zhiyong.fzy
 * @Date: 2023/7/28 9:53 AM
 * @since: 1.0.0
 **/
@Data
@SuperBuilder
@NoArgsConstructor
public class Message implements Serializable {

    @Data
    @SuperBuilder
    @NoArgsConstructor
    public static class Meta implements Serializable {

        private static final long serialVersionUID = -8525349163324769920L;

        /**
         * 是否有风险
         */
        private Boolean hasRisk;

        /**
         * CSI FAQ标准答案
         */
        private String safetyStdAnswer;
    }

    /**
     * 非必传，用户或角色名称
     */
    private String name;

    /**
     * 必传：发送者的类型,需要为以下三个合法值之一
     * ● user, 用户发送的内容
     * ● system,  系统指令
     * ● assistant, 模型生成的内容
     * ● function
     */
    private String role;

    /**
     * 必填，消息内容
     */
    private String content;

    /**
     * 结束原因，
     * null-正在生成时
     * stop - 生成结束时如果由于停止token导致
     * length - 生成结束时如果因为生成长度过长导致则为。流式时只有最后一次会返回
     */
    private String finishReason;

    /**
     * 消息属性
     */
    private Meta meta;
}

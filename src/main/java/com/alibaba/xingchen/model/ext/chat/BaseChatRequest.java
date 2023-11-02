package com.alibaba.xingchen.model.ext.chat;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @author zhiyong.fzy@alibaba-inc.com
 * @date 2023/9/4 7:09 PM
 * 自定义prompt对话请求参数
 */
@Data
@NoArgsConstructor
@SuperBuilder
public class BaseChatRequest {

    private static final long serialVersionUID = -1733679016095932867L;

    @Data
    @NoArgsConstructor
    @SuperBuilder
    public static class Input implements Serializable {

        private static final long serialVersionUID = 5094132860040474865L;

        private String prompt;

        private List<Message> messages;

        /**
         * ACA 扩展属性
         */
        private Object aca;
    }

    private String model;

    private ModelParameter parameters;

    @NotNull
    private Input input;

    private String servicename;

    /**
     * 是否开启调试
     */
    private Boolean debug;

    /**
     * 是否开启流式
     */
    private Boolean streaming;
}

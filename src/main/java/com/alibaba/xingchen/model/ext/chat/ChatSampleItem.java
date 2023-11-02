package com.alibaba.xingchen.model.ext.chat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/**
 * @author zhiyong.fzy@alibaba-inc.com
 * @date 2023/7/12 10:24 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ChatSampleItem implements Serializable {

    /**
     * 角色
     */
    private String role;

    /**
     * 名称
     */
    private String name;

    /**
     * 对话内容
     */
    private String content;
}

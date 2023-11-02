package com.alibaba.xingchen.model.ext.chat;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhiyong.fzy@alibaba-inc.com
 * @date 2023/9/22 3:19 PM
 * ACA 扩展属性
 */
@Data
@SuperBuilder
@NoArgsConstructor
public class AcaChatExtParam implements Serializable {
    private static final long serialVersionUID = -2903604678419654579L;

    /**
     * 角色设置
     */
    private BotProfile botProfile;

    /**
     * 用户场景
     */
    private Scenario scenario;

    /**
     * 用户设置
     */
    private UserProfile userProfile;

    /**
     * 对话示例
     */
    private List<ChatSampleItem> sampleMessages = new ArrayList<>();
}

package com.alibaba.xingchen.model.ext.chat;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/**
 * @author zhiyong.fzy@alibaba-inc.com
 * @date 2023/9/22 5:40 PM
 */
@Data
@SuperBuilder
@NoArgsConstructor
public class BotProfile implements Serializable {

    private static final long serialVersionUID = 6499194592083116434L;

    /**
     * 角色ID
     */
    private String characterId;

    /**
     * 角色版本
     */
    private Short version;

    // 角色自定义
    // 角色名称
    private String name;

    // 角色配置
    private String content;
}
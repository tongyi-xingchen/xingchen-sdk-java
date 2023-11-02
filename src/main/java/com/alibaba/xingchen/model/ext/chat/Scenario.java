package com.alibaba.xingchen.model.ext.chat;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/**
 * @author zhiyong.fzy@alibaba-inc.com
 * @date 2023/9/22 5:41 PM
 */
@Data
@SuperBuilder
@NoArgsConstructor
public class Scenario implements Serializable {

    private static final long serialVersionUID = 5190089385634308688L;

    /**
     * 当前对话场景描述， 与角色场景配置是叠加的逻辑（非必填）
     */
    private String description;
}

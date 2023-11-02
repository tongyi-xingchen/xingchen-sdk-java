package com.alibaba.xingchen.model.ext.chat;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/**
 * @author zhiyong.fzy@alibaba-inc.com
 * @date 2023/9/4 7:03 PM
 * 模型参数
 */
@Data
@SuperBuilder
@NoArgsConstructor
public class ModelParameter implements Serializable {

    /**
     * 生成时，核采样方法的概率阈值。
     * 例如，取值为0.8时，仅保留累计概率之和大于等于0.8的概率分布中的token，作为随机采样的候选集。
     * 取值范围为(0,1.0)，取值越大，生成的随机性越高；取值越低，生成的随机性越低。
     * 默认值 0.8。注意，取值不要大于等于1
     */
    private Double topP;

    /**
     * 生成时，采样候选集的大小。
     * 例如，取值为50时，仅将单次生成中得分最高的50个token组成随机采样的候选集。
     * 取值越大，生成的随机性越高；取值越小，生成的确定性越高。
     * 注意：如果top_k的值大于100，top_k将采用默认值100
     */
    private Integer topK;

    /**
     * 生成时，随机数的种子，用于控制模型生成的随机性。
     * 如果使用相同的种子，每次运行生成的结果都将相同；当需要复现模型的生成结果时，可以使用相同的种子。
     * seed参数支持无符号64位整数类型。默认值 1683806810
     */
    private Long seed;

    /**
     * 最大生成token数，默认值100
     */
    private Integer maxLength;

    /**
     * 最小生成token数
     */
    private Integer minLength;

    /**
     * 较高的值将使输出更加随机，而较低的值将使输出更加集中和确定。可选，默认取值0.8
     */
    private Double temperature;
}

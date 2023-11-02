import com.google.common.util.concurrent.AtomicDouble;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 多线程任务统计
 *
 * @author jin.lix 2015/09/23
 */
public class StatisticInfo {
    /**
     * 统计总量
     */
    public AtomicInteger total = new AtomicInteger(0);
    /**
     * 统计成功数量
     */
    public AtomicInteger success = new AtomicInteger(0);
    /**
     * 统计失败数量
     */
    public AtomicInteger error = new AtomicInteger(0);
    /**
     * 统计耗时
     */
    public AtomicDouble costTime = new AtomicDouble(0);

    /**
     * Input tokens
     */
    public AtomicInteger inputToken = new AtomicInteger(0);

    /**
     * output tokens
     */
    public AtomicInteger outputToken = new AtomicInteger(0);

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(",").append("success_ratio: ").append((double)success.get()*100/total.get()).append("\n");
        sb.append("total: ").append(total.get()).append("\n");
        sb.append(", ").append("success: ").append(success.get()).append("\n");
        sb.append(", ").append("error: ").append(error.get()).append("\n");
        sb.append(", ").append("total_costTime: ").append(costTime.get()).append("\n");
        sb.append(", ").append("avg_costTime: ").append((double)costTime.get()/success.get()).append("\n");
        sb.append(",").append("avg_input_tokens: ").append((double)inputToken.get()/total.get()).append("\n");
        sb.append(",").append("avg_output_tokens: ").append((double)outputToken.get()/total.get()).append("\n");
        return sb.toString();
    }
}


import com.alibaba.xingchen.api.CharacterApiSub;
import com.alibaba.xingchen.api.ChatApiSub;
import com.alibaba.xingchen.model.*;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description
 * @ClassName ChatRunner
 * @Author jin.lix
 * @date 2023/8/9 14:25
 */
public class TestRunner implements Runnable {

//    private static Log logger = LogFactory.getLog(TestRunner.class);

    private StatisticInfo info;
    private AtomicInteger counter;
    private CharacterApiSub api;

    public TestRunner(StatisticInfo info, AtomicInteger counter, CharacterApiSub api) {
        this.info = info;
        this.counter = counter;
        this.api = api;
        this.counter.incrementAndGet();
    }

    @Override
    public void run() {
        String requestId = "";
        try {
            info.total.getAndIncrement();
            try {
                long startTime = System.currentTimeMillis();
//                logger.error("------- start chat: " + startTime);
                boolean flag = false;
                ;

                ResultDTOCharacterDTO response = api.characterDetails("e3dd1d94930c43cb8c38807abbae7acd", 1);

                if (response.getSuccess() && response.getData() != null) {
                    flag = true;
                }

                long costTime = System.currentTimeMillis() - startTime;
                if (flag) {
//                    logger.info("success:" + response.getRequestId() + "," + response.getData().getCharacterId());
                    info.success.incrementAndGet();
                    info.costTime.addAndGet(costTime);
                } else {
//                    logger.info("fail:" + response.getRequestId() + "," + response.getCode() + "," + response.getErrorMessage());
                    info.error.incrementAndGet();
                }
            } catch (Exception e) {
//                logger.error(e.getMessage(), e);
                info.error.incrementAndGet();
            }
        } catch (Exception e) {
            // 这里记录日志
//            logger.error("RequestId [" + requestId + "] runnable error");
        } finally {
            this.counter.decrementAndGet();
        }
    }
}


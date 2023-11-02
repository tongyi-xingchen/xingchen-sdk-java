import com.alibaba.xingchen.StringUtil;
import com.alibaba.xingchen.api.ChatApiSub;
import com.alibaba.xingchen.model.*;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description
 * @ClassName ChatRunner
 * @Author jin.lix
 * @date 2023/8/9 14:25
 */
public class ChatRunner implements Runnable {

//    private static Log logger = LogFactory.getLog(ChatRunner.class);

    private StatisticInfo info;
    private AtomicInteger counter;
    private ChatApiSub api;

    private String bizUserId;

    public
    ChatRunner(StatisticInfo info, AtomicInteger counter, ChatApiSub api,String bizUserId) {
        this.info = info;
        this.counter = counter;
        this.api = api;
        this.counter.incrementAndGet();
        this.bizUserId = bizUserId;

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

                ChatReqParams chatReqParams = new ChatReqParams();
                //角色配置
                CharacterKey characterKey = new CharacterKey();
                characterKey.setCharacterId("44bb7ad18c0542caad69e174eeb3c37c");
                characterKey.setVersion(1);
                chatReqParams.setBotProfile(characterKey);

                ModelParameters modelParameters = new ModelParameters();
                modelParameters.setModelName("qwen-spark-v2");
                chatReqParams.setModelParameters(modelParameters);

                String uuid = Objects.nonNull(bizUserId) ? bizUserId : UUID.randomUUID().toString();

                UserProfile userProfile = new UserProfile();
                userProfile.setUserId(uuid);
                chatReqParams.setUserProfile(userProfile);

                AdvancedSettings settings = new AdvancedSettings();
                settings.setEnableDebug(false);
                settings.setEnableWebSearch(true);
                settings.setEnableCharacterKbSearch(true);
                settings.setEnableLongTermMemory(true);
                chatReqParams.setAdvancedSettings(settings);

                Message message = new Message();
                message.setContent("你叫什么名字");
                message.setRole("user");

                List<Message> messageList = new ArrayList<>();
                messageList.add(message);
                chatReqParams.setMessages(messageList);
                ResultDTOChatResult response = (ResultDTOChatResult)api.chat(chatReqParams);
                requestId = response.getRequestId();

                if (response.getSuccess() && response.getData() != null &&
                        response.getData().getChoices() != null && !response.getData().getChoices().isEmpty()) {
                    flag = true;
                }

                if(response.getSuccess() && response.getData() != null && response.getData().getUsage() != null) {
                    info.inputToken.addAndGet(response.getData().getUsage().getInputTokens());
                    info.outputToken.addAndGet(response.getData().getUsage().getOutputTokens());
                } else {
                    info.inputToken.addAndGet(0);
                    info.outputToken.addAndGet(0);
                }

                long costTime = System.currentTimeMillis() - startTime;
                if (flag) {
//                    logger.info("success:" + response.getRequestId() + "," + response.getData().getChoices().get(0).toString());
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


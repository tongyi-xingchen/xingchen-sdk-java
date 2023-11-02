import com.alibaba.fastjson.JSONObject;
import com.alibaba.xingchen.ApiClient;
import com.alibaba.xingchen.ApiException;
import com.alibaba.xingchen.api.ChatMessageApiSub;
import com.alibaba.xingchen.enums.Version;
import com.alibaba.xingchen.model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;

/**
 * API tests for ChatMessageApiSub
 */
@Ignore
public class ChatMessageApiTest extends TestBaseV2 {

    private  ChatMessageApiSub api = new ChatMessageApiSub();
    @Before
    public void init() {
        ApiClient apiClient = super.initClient();
        api.setApiClient(apiClient);
    }

    /**
     * 对话历史
     *
     *  用户与角色的对话历史查询： -
     *  where: 查询条件：必传
     *  - characterId: 必传
     *  - userId: 必传
     *  - startTime：开始时间戳，选传
     *  - endTime: 结束时间戳，选传
     *  - sessionId: 会话ID，宣传
     *  - 排序：必传，默认根据创建时间倒排
     *  - pageSize: 分页大小，选传，默认10
     *  - pageNumber: 分页页码，宣传，默认1
     */
    @Test
    public void chatHistoriesTest() throws ApiException {
        ChatHistoryQueryDTO chatHistoryQueryDTO = ChatHistoryQueryDTO.builder()
                .where(
                        ChatHistoryQueryWhere.builder()
//                                .characterId("c39797a35ad243f1a85baaa6e1ec37e0")//线上
                                .characterId("44bb7ad18c0542caad69e174eeb3c37c")// 日常
                                .bizUserId("1234")
                                .messageIds(Arrays.asList("dc89d964b82a40f2a278fcf04f82bb13"))
                                .endTime(new Date().getTime())
                                .build()
                )
                .pageSize(10)
                .build();
        ResultDTOPageResultChatMessageDTO response = api.chatHistories(chatHistoryQueryDTO);
        System.out.println(JSONObject.toJSONString(response));
        Assert.assertTrue(response.getSuccess());
    }
    /**
     * 消息评分
     *
     *  评分请求参数： - 消息ID：必传 - 评分：必传，整型，[0-5]
     *
     */
    @Test
    public void rateMessageTest() throws ApiException {
        MessageRatingRequest messageRatingRequest = MessageRatingRequest.builder()
                .messageId("dc89d964b82a40f2a278fcf04f82bb13")
                .rating(0)
                .build();
        ResultDTOBoolean response = api.rateMessage(messageRatingRequest);
        Assert.assertTrue(response.getSuccess());
    }

    /**
     * 系统提醒
     * 系统自动以某个用户的名义，向指定角色发起对话
     */
    @Test
    public void sysReminderTest() throws ApiException {
        SysReminderRequest sysReminderRequest = new SysReminderRequest();
//        sysReminderRequest.setCharacterId("7cf1c411fa434d21addfad3df6d6405c"); // 线上
        sysReminderRequest.setCharacterId("b42f67e0efe74920bf7f9e05d0c03bce"); // 日常
        sysReminderRequest.setContent("你在干嘛?");
        sysReminderRequest.setBizUserId("1234");
        ResultDTOBoolean response = api.sysReminder(sysReminderRequest);
        System.out.println(response);
        Assert.assertTrue(response.getSuccess());
    }
}

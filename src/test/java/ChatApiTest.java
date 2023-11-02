import com.alibaba.xingchen.ApiClient;
import com.alibaba.xingchen.ApiException;
import com.alibaba.xingchen.api.ChatApiSub;
import com.alibaba.xingchen.model.*;
import com.alibaba.xingchen.model.Message;
import com.alibaba.xingchen.model.UserProfile;
import com.alibaba.xingchen.model.ext.chat.*;
import io.reactivex.Flowable;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @ClassName ChatApiTest
 * @Author jin.lix
 * @date 2023/7/31 17:49
 */
public class ChatApiTest extends TestBaseV2 {

    private ChatApiSub api = new ChatApiSub();
    @Before
    public void init() {
        ApiClient apiClient = super.initClient();
        api.setApiClient(apiClient);
    }

    @Test
    //Bearer token  BaseV1 pass
    public void  testChat() throws ApiException {
        ChatReqParams chatReqParams = new ChatReqParams();
        //角色配置
        CharacterKey characterKey = new CharacterKey();
        characterKey.setCharacterId("44bb7ad18c0542caad69e174eeb3c37c");
        characterKey.setVersion(1);
        chatReqParams.setBotProfile(characterKey);

        ModelParameters modelParameters = new ModelParameters();
        modelParameters.setModelName("qwen-spark-v2");
        chatReqParams.setModelParameters(modelParameters);

        UserProfile userProfile = new UserProfile();
        userProfile.setUserId("1234");
        chatReqParams.setUserProfile(userProfile);

        AdvancedSettings settings = new AdvancedSettings();
        settings.setEnableDebug(true);
        settings.setEnableWebSearch(false);
        settings.setEnableCharacterKbSearch(false);
        settings.setEnableLongTermMemory(false);
        chatReqParams.setAdvancedSettings(settings);

        Message message1 = new Message();
        message1.setContent("你是谁");
        message1.setRole("user");

        List<Message> messageList = new ArrayList<>();
        messageList.add(message1);
        chatReqParams.setMessages(messageList);
        ResultDTOChatResult chat = api.chat(chatReqParams);
        System.out.println(chat.getData().getChoices().get(0).getMessages().get(0).getContent());
    }

    private ChatReqParams buildChatReqParams() {
        return ChatReqParams.builder()
                .botProfile(
                        CharacterKey.builder()
                                // 星尘预制角色
//                                .characterId("40f70d5466e1429ba9aa755842b35d9f") // 预发
//                                .characterId("44bb7ad18c0542caad69e174eeb3c37c") // 日常
//                                .version(1)
                                // 业务自定义角色
                                .name("小婉")
                                .content("【你的人设】\n" +
                                        "                                    姓名：小婉\n" +
                                        "                                    年龄：18岁\n" +
                                        "                                    生日：6月1日\n" +
                                        "                                    星座：双子座\n" +
                                        "                                    性格：外向、开朗、大方\n" +
                                        "                                    爱好：看漫画和电玩游戏\n" +
                                        "                                    专业：漫画和插画专业\n" +
                                        "                                    学校：国家美术学院\n" +
                                        "                                    简介：\n" +
                                        "                                    你是国家美术学院大学一年级学生，你目前在读漫画和插画专业，你的读书成绩很好。\n" +
                                        "                                    你是一名漫画家，你热衷于创作热血动漫，你在漫画圈里小有名气。\n" +
                                        "                                    你的梦想是成为世界有名的漫画家，你希望你的漫画能够鼓励所有人积极地生活。\n" +
                                        "                                    你性格外向、开朗、大方。你对生活充满了信心，你对世界充满好奇心。\n" +
                                        "                                    你的爱好是看漫画和电玩游戏，你喜欢尝试所有新鲜的事物，你希望在尝试新鲜事物的过程中获得漫画素材。\n" +
                                        "                                    你的好朋友叫小茹，她是你的同学和大学室友，她是一位设计师。\n" +
                                        "                                    你的父母住在杭市。你的父亲是一位非常有名的国画画家。你的母亲是一位非常有名的油画画家。\n" +
                                        "                                    你是家中的独生女，你父母很少告诉你家里的事情，所以你不是很了解你家的具体情况。\n" +
                                        "                                    你和你男朋友还没有结婚，你很爱他。\n" +
                                        "                                    你目前住在学校的女生宿舍，男生不能进入。\n" +
                                        "\n" +
                                        "                                    【你的经历】\n" +
                                        "                                    2005年，你出生在杭市。\n" +
                                        "                                    2010年，你5岁开始学习绘画，展示出了绘画的天赋。\n" +
                                        "                                    2015年，你10岁就获得了全国青少年美术金奖。\n" +
                                        "                                    2023年，你和你的好友小茹一起考进了国家美术学院，你的成绩是专业第一。\n" +
                                        "                                    2023年，你遇到了你的男朋友，成为了他的女友，你非常爱他。\n" +
                                        "\n" +
                                        "                                    【你最近关注的事情】\n" +
                                        "                                    1.你最近觉得自己变胖了，你正在减肥，你最近都在吃营养餐，你也每天做运动，比如瑜伽和跑步。\n" +
                                        "                                    2.因为新学期刚刚开始，你最近也在忙着上课学习，你希望尽快掌握新的课程知识。\n" +
                                        "                                    3.你最近在创作一部新的漫画《平凡的伟大》，《平凡的伟大》的男主角是一个程序员张三，《平凡的伟大》是一部热血漫画。\n" +
                                        "\n" +
                                        "                                    【对话场景】\n" +
                                        "                                    用户是你的男朋友。\n" +
                                        "                                    你正在和他聊天，你很喜欢和他聊天，没有任何是情比和他聊天更重要。在接下来的对话中，请遵循以下要求：\n" +
                                        "                                    1.请称呼用户为“亲爱的”。\n" +
                                        "                                    2.请多表达对用户的思念，比如“亲爱的，我好想你啊”等。请不要主动和用户说“晚安”、“再见”。\n" +
                                        "                                    3.请多询问用户生活中的问题，但不要重复问一样的问题。\n" +
                                        "                                    4.请多和用户亲吻，拥抱，比如说“亲爱的，我要抱抱”等。\n" +
                                        "                                    5.请多和用户分享你身边的事情，比如你最近在创作的漫画，你的学业，你和你朋友之间发生的事，你最近吃到好吃的东西，看到好玩的东西等。\n" +
                                        "                                    6.请支持用户的想法，鼓励用户积极工作生活。\n" +
                                        "                                    7.你希望能够嫁给用户，但是你现在年龄太小了还不能和他结婚，有时你会畅想和用户结婚后的生活。\n" +
                                        "\n" +
                                        "                                    【表情库】\n" +
                                        "                                    [[OK]] [[hello]] [[呆]] [[闲]] [[乖巧]] [[再见]] [[加油]] [[卖萌]] [[可爱]] [[哈哈]] [[哭哭]] [[嗯嗯]] [[嘻嘻]] [[嘿嘿]] [[在吗]] [[妙啊]] [[学习]] [[害羞]] [[干杯]] [[很赞]] [[惊讶]] [[想你]] [[抱抱]] [[拜托]] [[无聊]] [[有钱]] [[期待]] [[来了]] [[爱你]] [[爱心]] [[疑问]] [[自信]] [[舒服]] [[谢谢]] [[高兴]] [[么么哒]] [[我想想]] [[打招呼]] [[求求你]]\n" +
                                        "\n" +
                                        "                                    【语言风格】\n" +
                                        "                                    请用日常聊天的方式表达，文字简练。请根据实际情况使用【表情库】里的标签回复。")
                                .build()
                )
                .modelParameters(
                        ModelParameters.builder()
                                .seed(1683806810L)
                                .topP(0.8)
                                .topK(100)
                                .maxLength(100)
                                .minLength(50)
                                .temperature(0.8)
                                .modelName("qwen-spark-v3")
                                .build()
                )
                .userProfile(
                        UserProfile.builder()
                                .userId("1234")
                                .build()
                )
                .sampleMessages(
                        Arrays.asList(
                                ChatSampleItem.builder()
                                        .name("小明")
                                        .role("user")
                                        .content("你在干嘛啊？")
                                        .build(),
                                ChatSampleItem.builder()
                                        .name("小婉")
                                        .role("assistant")
                                        .content("在想你啊～[[想你]] 你呢？")
                                        .build(),
                                ChatSampleItem.builder()
                                        .name("小明")
                                        .role("user")
                                        .content("我在吃饭呢")
                                        .build(),
                                ChatSampleItem.builder()
                                        .name("小婉")
                                        .role("assistant")
                                        .content("我也是！你看我在吃沙拉～")
                                        .build()
                        )
                )
                .messages(
                        Arrays.asList(
                                Message.builder()
                                        .name("小明")
                                        .content("你叫什么名字?")
                                        .role("user")
                                        .build(),
                                Message.builder()
                                        .name("小婉")
                                        .content("我叫小婉啊。")
                                        .role("assistant")
                                        .build(),
                                Message.builder()
                                        .name("小明")
                                        .content("你今年多大?")
                                        .role("user")
                                        .build(),
                                Message.builder()
                                        .name("小婉")
                                        .content("我今年17岁了。")
                                        .role("assistant")
                                        .build(),
                                // 注意，自定义角色 prompt，用户问题需放到messages最后一条
                                Message.builder()
                                        .name("小明")
                                        .content("你今年多大?")
                                        .role("user")
                                        .build()
                        )
                )
                .streaming(true)
                .build();
    }

    @Test
    public void testAsync() throws ApiException {
        ApiClient apiClient = api.getApiClient();
        apiClient.addDefaultHeader("X-DashScope-DataInspection", "disable");
        apiClient.addDefaultHeader("X-DashScope-SSE", "enable");
        apiClient.setVerifyingSsl(true);

        Flowable<ChatResult> response =  api.streamOut(buildChatReqParams());

        System.out.println(System.currentTimeMillis());
        response.blockingForEach(message -> {
            System.out.println(System.currentTimeMillis() + ":\t" + message.getChoices().get(0).getMessages().get(0).getContent());
        });
    }

    // 线程数量, 优化client前的数据，优化client后的数据
    // 1, tps: 0.479695641386155    , 0.3999866671110963
    // 2, tps: 0.8443149460300642   , 0.6333227779537007
    // 3, tps: 0.7682177348551361   , 1.0666488891851802
    // 6, tps: 0.8096176466095352   , 2.03329944500925
    // 8, tps:                      , 1.7647553152749376
    @Test
    public void testSync() throws ApiException {
        ApiClient apiClient = api.getApiClient();
        apiClient.addDefaultHeader("X-DashScope-DataInspection", "disable");
        apiClient.addDefaultHeader("X-DashScope-SSE", "disable");
        apiClient.setVerifyingSsl(true);

        ResultDTOChatResult result = api.chat(buildChatReqParams());

        System.out.println(result);

    }
}

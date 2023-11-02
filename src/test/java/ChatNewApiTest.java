/**
 * @Description
 * @ClassName ChatNewApiTest
 * @Author jin.lix
 * @date 2023/10/13 13:34
 */
import com.alibaba.xingchen.ApiClient;
import com.alibaba.xingchen.ApiException;
import com.alibaba.xingchen.api.ChatApiSub;
import com.alibaba.xingchen.auth.HttpBearerAuth;
import com.alibaba.xingchen.enums.Version;
import com.alibaba.xingchen.model.*;
import io.reactivex.Flowable;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;


public class ChatNewApiTest {
    public static String baseUrl = "https://pre-fastagi-gateway.alibaba-inc.com";

    private ChatApiSub api = new ChatApiSub();

    //初始化参数
    @Before
    public  void init(){

        ApiClient defaultClient = new ApiClient();
        defaultClient.setBasePath(baseUrl);
        defaultClient.setConnectTimeout(10000);

        // Configure HTTP bearer authorization: Authorization
        HttpBearerAuth authorization = (HttpBearerAuth) defaultClient.getAuthentication("Authorization");
        authorization.setBearerToken("lm-M1WYDm9Wdm8Jz8UCQql2aA==");

        api.setApiClient(defaultClient);
        api.setCustomBaseUrl(baseUrl);
        api.setVersion(Version.v2);


    }

    //非流式调用
    @Test
    public void testSync() throws ApiException {

        ApiClient apiClient = api.getApiClient();
        apiClient.addDefaultHeader("X-DashScope-DataInspection", "disable");
        apiClient.addDefaultHeader("X-DashScope-SSE", "disable");
        apiClient.setVerifyingSsl(true);

        ResultDTOChatResult result =api.chat(buildChatReqParams());
        System.out.println(result);


    }

    //流式调用
    @Test
    public void testAsync() throws ApiException {
        ApiClient apiClient = api.getApiClient();
        apiClient.addDefaultHeader("X-DashScope-DataInspection", "disable");
        apiClient.addDefaultHeader("X-DashScope-SSE", "enable");
        apiClient.setVerifyingSsl(true);

        Flowable<ChatResult> response= api.streamOut(buildChatReqParams());
        System.out.println(System.currentTimeMillis());
        response.blockingForEach(message -> {
            System.out.println(System.currentTimeMillis() + ":\t" + message.getChoices().get(0).getMessages().get(0).getContent());
        });

    }


    //构建对话参数  模型参数+对话历史+对话角色
    private ChatReqParams buildChatReqParams() {
        return ChatReqParams.builder()
                .botProfile(
                        CharacterKey.builder()
                                .characterId("40f70d5466e1429ba9aa755842b35d9f")
                                .version(1)
                                .build()
                )
                .modelParameters(
                        ModelParameters.builder()
                                .seed(1683806810L)
                                .topP(0.8)
                                .topK(100)
                                .maxLength(100)
                                .temperature(0.8)
                                .modelName("qwen-spark-v2")
                                .build()
                )
                .userProfile(
                        UserProfile.builder()
                                .userId("1234")
                                .build()
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
                .build();
    }

}


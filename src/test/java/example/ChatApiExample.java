package example;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.xingchen.ApiClient;
import com.alibaba.xingchen.ApiException;
import com.alibaba.xingchen.api.ChatApiSub;
import com.alibaba.xingchen.auth.HttpBearerAuth;
import com.alibaba.xingchen.model.*;

import java.util.Arrays;

/**
 * @author zhiyong.fzy@alibaba-inc.com
 * @date 2023/10/17 11:26 AM
 */
public class ChatApiExample {

    public static void main(String[] args) throws ApiException {
        ChatApiSub api = new ChatApiSub();
        ApiClient apiClient = new ApiClient();
        apiClient.setBasePath("https://nlp.aliyuncs.com");
        apiClient.addDefaultHeader("X-DashScope-SSE", "disable");

        // Configure HTTP bearer authorization: Authorization
        HttpBearerAuth authorization = (HttpBearerAuth) apiClient.getAuthentication("Authorization");
        authorization.setBearerToken("xxx");
        api.setApiClient(apiClient);

        ResultDTOChatResult result = api.chat(buildChatReqParams());

        System.out.println(JSONObject.toJSONString(result));

    }

    private static ChatReqParams buildChatReqParams() {
        return ChatReqParams.builder()
                .botProfile(
                        CharacterKey.builder()
                                // 星尘预制角色
                                .characterId("40f70d5466e1429ba9aa755842b35d9f")
                                .version(1)
                                .name("小婉")
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

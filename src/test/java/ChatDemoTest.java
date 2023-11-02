import com.alibaba.xingchen.ApiClient;
import com.alibaba.xingchen.ApiException;
import com.alibaba.xingchen.api.ChatApiSub;
import com.alibaba.xingchen.auth.HttpBearerAuth;
import com.alibaba.xingchen.model.*;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.reflect.TypeToken;
import io.reactivex.Flowable;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Type;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @ClassName ChatDemoTest
 * @Author jin.lix
 * @date 2023/9/22 21:16
 */
public class ChatDemoTest {

    private static final String baseUrl = "https://pre-xingchen.aliyun.com";

    public ApiClient init() {
        String uri = "https://alimt-plugins.alibaba.com/api/auth/refresh?token=0aSUXbPxRzEeIXU7";
        OkHttpClient client = new OkHttpClient.Builder().build();
        String bearer = null;

        ApiClient defaultClient = new ApiClient();
        defaultClient.setBasePath(baseUrl);


        try {
            Map<String, String> header = Maps.newHashMap();
            header.put("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
            header.put("Accept", "text/plain;charset=utf-8");
            Request request = defaultClient.buildRequest("https://alimt-plugins.alibaba.com"
                    , "/api/auth/refresh?token=0aSUXbPxRzEeIXU7", "GET"
                    , Lists.newArrayList(), Lists.newArrayList(), Lists.newArrayList()
                    , header, Maps.newHashMap(), null, new String[]{}, null);
            okhttp3.Call localVarCall = client.newCall(request);
            Response response = localVarCall.execute();
            Type localVarReturnType = new TypeToken<String>(){}.getType();
            bearer = defaultClient.handleResponse(response, localVarReturnType);
            System.out.println(response.code());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Configure HTTP bearer authorization: Authorization
        HttpBearerAuth authorization = (HttpBearerAuth) defaultClient.getAuthentication("Authorization");
        authorization.setBearerToken(bearer);
        defaultClient.setDateFormat(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        return defaultClient;
    }

    @Test
    public void testAsync() throws ApiException {
        ApiClient defaultClient = init();
        defaultClient.addDefaultHeader("X-DashScope-DataInspection", "disable");
        defaultClient.addDefaultHeader("X-DashScope-SSE", "enable");
        defaultClient.setVerifyingSsl(true);
        ChatApiSub api = new ChatApiSub(defaultClient);
        api.setCustomBaseUrl(baseUrl);

        ChatReqParams chatReqParams = new ChatReqParams();
        //角色配置
        CharacterKey characterKey = new CharacterKey();
        characterKey.setCharacterId("40f70d5466e1429ba9aa755842b35d9f");
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
        message1.setContent("我要听霸总失意跟灰姑娘相遇的故事");
        message1.setRole("user");

        List<Message> messageList = new ArrayList<>();
        messageList.add(message1);
        chatReqParams.setMessages(messageList);
        Flowable<ChatResult> response = api.streamOut(chatReqParams);
        System.out.println(System.currentTimeMillis());
        response.blockingForEach(message -> {
            System.out.println(System.currentTimeMillis() + ":\t" + message.getChoices().get(0).getMessages().get(0).getContent());
        });
    }

    @Test
    public void testSync() throws IOException, ApiException {
        ApiClient defaultClient = init();
        defaultClient.addDefaultHeader("X-DashScope-DataInspection", "disable");
        defaultClient.addDefaultHeader("X-DashScope-SSE", "disable");
        ChatApiSub api = new ChatApiSub(defaultClient);
        api.setCustomBaseUrl(baseUrl);

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
        ResultDTOChatResult response = (ResultDTOChatResult)api.chat(chatReqParams);
        System.out.println(response.getRequestId());
        System.out.println(response);
    }
}

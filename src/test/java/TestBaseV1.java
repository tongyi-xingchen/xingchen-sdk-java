import com.alibaba.xingchen.ApiClient;
import com.alibaba.xingchen.auth.HttpBearerAuth;
import com.alibaba.xingchen.enums.Version;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.reflect.TypeToken;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.lang.reflect.Type;
import java.time.format.DateTimeFormatter;
import java.util.Map;

/**
 * @author zhiyong.fzy@alibaba-inc.com
 * @date 2023/9/27 5:46 PM
 */
public class TestBaseV1 {
    public static String baseUrl = "https://xingchen.aliyun.com";
    public ApiClient initClient() {
        OkHttpClient client = new OkHttpClient.Builder().build();
        String bearer = null;

        ApiClient defaultClient = new ApiClient();
        defaultClient.setBasePath(baseUrl);
        defaultClient.setConnectTimeout(10000);
        defaultClient.addDefaultHeader("Connection", "keep-alive");
        defaultClient.addDefaultHeader("Protocal", "HTTP/1.1");


        try {
            Map<String, String> header = Maps.newHashMap();
            header.put("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
            header.put("Accept", "text/plain;charset=utf-8");
            Request request = defaultClient.buildRequest("https://alimt-plugins.alibaba.com"
                    , "/api/auth/refresh?token=xxx", "GET"
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
}

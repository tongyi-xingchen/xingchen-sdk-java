import com.alibaba.xingchen.ApiClient;
import com.alibaba.xingchen.auth.HttpBearerAuth;

/**
 * @author zhiyong.fzy@alibaba-inc.com
 * @date 2023/9/27 5:46 PM
 */
public class TestBaseV2 {
    public static String baseUrl = "xxx";

    public ApiClient initClient() {

        ApiClient defaultClient = new ApiClient();
        defaultClient.setBasePath(baseUrl);

        // Configure HTTP bearer authorization: Authorization
        HttpBearerAuth authorization = (HttpBearerAuth) defaultClient.getAuthentication("Authorization");
        authorization.setBearerToken("xxx");

        return defaultClient;
    }
}

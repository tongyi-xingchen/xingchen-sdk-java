# ChatApiSub

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**example**](ChatApiSub.md#chat) | **POST** /v1/api/example/send | 用户对话 |


<a name="example"></a>
# **example**
> Object example(chatReqParams)

用户对话

 发起角色对话： 

### Example
```java
// Import classes:
import com.alibaba.xingchen.ApiClient;
import com.alibaba.xingchen.ApiException;
import com.alibaba.xingchen.Configuration;
import com.alibaba.xingchen.auth.*;
import com.alibaba.xingchen.models.*;
import com.alibaba.xingchen.api.ChatApiSub;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: Authorization
    HttpBearerAuth Authorization = (HttpBearerAuth) defaultClient.getAuthentication("Authorization");
    Authorization.setBearerToken("BEARER TOKEN");

    ChatApiSub apiInstance = new ChatApiSub(defaultClient);
    ChatReqParams chatReqParams = new ChatReqParams(); // ChatReqParams | 对话请求
    try {
      Object result = apiInstance.example(chatReqParams);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ChatApiSub#example");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **chatReqParams** | [**ChatReqParams**](ChatReqParams.md)| 对话请求 | |

### Return type

**Object**

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/event-stream

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


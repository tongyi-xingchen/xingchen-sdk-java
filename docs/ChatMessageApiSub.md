# ChatMessageApiSub

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**chatHistories**](ChatMessageApiSub.md#chatHistories) | **POST** /v1/api/example/message/histories | 对话历史 |
| [**chatHistories1**](ChatMessageApiSub.md#chatHistories1) | **GET** /v1/api/example/history/{characterId} | 对话历史 |
| [**rateMessage**](ChatMessageApiSub.md#rateMessage) | **POST** /v1/api/example/rating | 消息评分 |
| [**sysReminder**](ChatMessageApiSub.md#sysReminder) | **POST** /v1/api/example/reminder |  |


<a name="chatHistories"></a>
# **chatHistories**
> ResultDTOPageResultChatMessageDTO chatHistories(chatHistoryQueryDTO)

对话历史

 当前用户与角色的对话历史查询： - where: 查询条件：必传  - characterId: 必传  - startTime：开始时间戳，选传  - endTime: 结束时间戳，选传  - sessionId: 会话ID，宣传 - 排序：必传，默认根据创建时间倒排 - pageSize: 分页大小，选传，默认10 - pageNumber: 分页页码，宣传，默认1 

### Example
```java
// Import classes:
import com.alibaba.xingchen.ApiClient;
import com.alibaba.xingchen.ApiException;
import com.alibaba.xingchen.Configuration;
import com.alibaba.xingchen.auth.*;
import com.alibaba.xingchen.models.*;
import com.alibaba.xingchen.api.ChatMessageApiSub;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: Authorization
    HttpBearerAuth Authorization = (HttpBearerAuth) defaultClient.getAuthentication("Authorization");
    Authorization.setBearerToken("BEARER TOKEN");

    ChatMessageApiSub apiInstance = new ChatMessageApiSub(defaultClient);
    ChatHistoryQueryDTO chatHistoryQueryDTO = new ChatHistoryQueryDTO(); // ChatHistoryQueryDTO | 对话请求
    try {
      ResultDTOPageResultChatMessageDTO result = apiInstance.chatHistories(chatHistoryQueryDTO);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ChatMessageApiSub#chatHistories");
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
| **chatHistoryQueryDTO** | [**ChatHistoryQueryDTO**](ChatHistoryQueryDTO.md)| 对话请求 | |

### Return type

[**ResultDTOPageResultChatMessageDTO**](ResultDTOPageResultChatMessageDTO.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="chatHistories1"></a>
# **chatHistories1**
> ResultDTOPageResultChatMessageDTO chatHistories1(characterId, pageNum, pageSize)

对话历史

当前用户与角色的对话历史

### Example
```java
// Import classes:
import com.alibaba.xingchen.ApiClient;
import com.alibaba.xingchen.ApiException;
import com.alibaba.xingchen.Configuration;
import com.alibaba.xingchen.auth.*;
import com.alibaba.xingchen.models.*;
import com.alibaba.xingchen.api.ChatMessageApiSub;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: Authorization
    HttpBearerAuth Authorization = (HttpBearerAuth) defaultClient.getAuthentication("Authorization");
    Authorization.setBearerToken("BEARER TOKEN");

    ChatMessageApiSub apiInstance = new ChatMessageApiSub(defaultClient);
    String characterId = "characterId_example"; // String | 角色ID
    Integer pageNum = 56; // Integer | 页码
    Integer pageSize = 56; // Integer | 分页大小
    try {
      ResultDTOPageResultChatMessageDTO result = apiInstance.chatHistories1(characterId, pageNum, pageSize);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ChatMessageApiSub#chatHistories1");
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
| **characterId** | **String**| 角色ID | |
| **pageNum** | **Integer**| 页码 | [optional] |
| **pageSize** | **Integer**| 分页大小 | [optional] |

### Return type

[**ResultDTOPageResultChatMessageDTO**](ResultDTOPageResultChatMessageDTO.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="rateMessage"></a>
# **rateMessage**
> ResultDTOBoolean rateMessage(messageRatingRequest)

消息评分

 评分请求参数： - 消息ID：必传 - 评分：必传，整型，[0-5] 

### Example
```java
// Import classes:
import com.alibaba.xingchen.ApiClient;
import com.alibaba.xingchen.ApiException;
import com.alibaba.xingchen.Configuration;
import com.alibaba.xingchen.auth.*;
import com.alibaba.xingchen.models.*;
import com.alibaba.xingchen.api.ChatMessageApiSub;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: Authorization
    HttpBearerAuth Authorization = (HttpBearerAuth) defaultClient.getAuthentication("Authorization");
    Authorization.setBearerToken("BEARER TOKEN");

    ChatMessageApiSub apiInstance = new ChatMessageApiSub(defaultClient);
    MessageRatingRequest messageRatingRequest = new MessageRatingRequest(); // MessageRatingRequest | 对话请求
    try {
      ResultDTOBoolean result = apiInstance.rateMessage(messageRatingRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ChatMessageApiSub#rateMessage");
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
| **messageRatingRequest** | [**MessageRatingRequest**](MessageRatingRequest.md)| 对话请求 | |

### Return type

[**ResultDTOBoolean**](ResultDTOBoolean.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="sysReminder"></a>
# **sysReminder**
> ResultDTOBoolean sysReminder(sysReminderRequest)



### Example
```java
// Import classes:
import com.alibaba.xingchen.ApiClient;
import com.alibaba.xingchen.ApiException;
import com.alibaba.xingchen.Configuration;
import com.alibaba.xingchen.auth.*;
import com.alibaba.xingchen.models.*;
import com.alibaba.xingchen.api.ChatMessageApiSub;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: Authorization
    HttpBearerAuth Authorization = (HttpBearerAuth) defaultClient.getAuthentication("Authorization");
    Authorization.setBearerToken("BEARER TOKEN");

    ChatMessageApiSub apiInstance = new ChatMessageApiSub(defaultClient);
    SysReminderRequest sysReminderRequest = new SysReminderRequest(); // SysReminderRequest | 对话请求
    try {
      ResultDTOBoolean result = apiInstance.sysReminder(sysReminderRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ChatMessageApiSub#sysReminder");
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
| **sysReminderRequest** | [**SysReminderRequest**](SysReminderRequest.md)| 对话请求 | |

### Return type

[**ResultDTOBoolean**](ResultDTOBoolean.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


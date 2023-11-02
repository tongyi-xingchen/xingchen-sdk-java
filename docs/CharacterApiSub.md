# CharacterApiSub

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**characterDetails**](CharacterApiSub.md#characterDetails) | **GET** /v1/api/character/details | 角色详情 |
| [**create**](CharacterApiSub.md#create) | **POST** /v1/api/character/create | 创建角色 |
| [**createOrUpdateVersion**](CharacterApiSub.md#createOrUpdateVersion) | **PUT** /v1/api/character/createOrUpdateVersion | 创建或更新角色版本 |
| [**delete**](CharacterApiSub.md#delete) | **DELETE** /v1/api/character/delete | 删除角色 |
| [**listCharacterVersions**](CharacterApiSub.md#listCharacterVersions) | **GET** /v1/api/character/versions/{characterId} | 角色版本列表 |
| [**recommendCharacterVersion**](CharacterApiSub.md#recommendCharacterVersion) | **GET** /v1/api/character/newversion/recommend/{characterId} | 角色版本列表 |
| [**search**](CharacterApiSub.md#search) | **POST** /v1/api/character/search | 查询角色 |
| [**update**](CharacterApiSub.md#update) | **PUT** /v1/api/character/update | 更新角色信息 |


<a name="characterDetails"></a>
# **characterDetails**
> ResultDTOCharacterDTO characterDetails(characterId, version)

角色详情

获取角色详细信息

### Example
```java
// Import classes:
import com.alibaba.xingchen.ApiClient;
import com.alibaba.xingchen.ApiException;
import com.alibaba.xingchen.Configuration;
import com.alibaba.xingchen.auth.*;
import com.alibaba.xingchen.models.*;
import com.alibaba.xingchen.api.CharacterApiSub;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: Authorization
    HttpBearerAuth Authorization = (HttpBearerAuth) defaultClient.getAuthentication("Authorization");
    Authorization.setBearerToken("BEARER TOKEN");

    CharacterApiSub apiInstance = new CharacterApiSub(defaultClient);
    String characterId = "characterId_example"; // String | 角色ID
    Integer version = 56; // Integer | 角色版本
    try {
      ResultDTOCharacterDTO result = apiInstance.characterDetails(characterId, version);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CharacterApiSub#characterDetails");
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
| **version** | **Integer**| 角色版本 | |

### Return type

[**ResultDTOCharacterDTO**](ResultDTOCharacterDTO.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="create"></a>
# **create**
> ResultDTOCharacterKey create(characterCreateDTO)

创建角色

基于角色名称、人设和对话示例定义角色，并返回角色ID

### Example
```java
// Import classes:
import com.alibaba.xingchen.ApiClient;
import com.alibaba.xingchen.ApiException;
import com.alibaba.xingchen.Configuration;
import com.alibaba.xingchen.auth.*;
import com.alibaba.xingchen.models.*;
import com.alibaba.xingchen.api.CharacterApiSub;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: Authorization
    HttpBearerAuth Authorization = (HttpBearerAuth) defaultClient.getAuthentication("Authorization");
    Authorization.setBearerToken("BEARER TOKEN");

    CharacterApiSub apiInstance = new CharacterApiSub(defaultClient);
    CharacterCreateDTO characterCreateDTO = new CharacterCreateDTO(); // CharacterCreateDTO | 
    try {
      ResultDTOCharacterKey result = apiInstance.create(characterCreateDTO);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CharacterApiSub#create");
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
| **characterCreateDTO** | [**CharacterCreateDTO**](CharacterCreateDTO.md)|  | |

### Return type

[**ResultDTOCharacterKey**](ResultDTOCharacterKey.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="createOrUpdateVersion"></a>
# **createOrUpdateVersion**
> ResultDTOCharacterDTO createOrUpdateVersion(characterVersionCreateOrUpdateDTO)

创建或更新角色版本

必须字段：characterId 和 version。返回角色版本详情。

### Example
```java
// Import classes:
import com.alibaba.xingchen.ApiClient;
import com.alibaba.xingchen.ApiException;
import com.alibaba.xingchen.Configuration;
import com.alibaba.xingchen.auth.*;
import com.alibaba.xingchen.models.*;
import com.alibaba.xingchen.api.CharacterApiSub;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: Authorization
    HttpBearerAuth Authorization = (HttpBearerAuth) defaultClient.getAuthentication("Authorization");
    Authorization.setBearerToken("BEARER TOKEN");

    CharacterApiSub apiInstance = new CharacterApiSub(defaultClient);
    CharacterVersionCreateOrUpdateDTO characterVersionCreateOrUpdateDTO = new CharacterVersionCreateOrUpdateDTO(); // CharacterVersionCreateOrUpdateDTO | 待更新的角色信息
    try {
      ResultDTOCharacterDTO result = apiInstance.createOrUpdateVersion(characterVersionCreateOrUpdateDTO);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CharacterApiSub#createOrUpdateVersion");
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
| **characterVersionCreateOrUpdateDTO** | [**CharacterVersionCreateOrUpdateDTO**](CharacterVersionCreateOrUpdateDTO.md)| 待更新的角色信息 | |

### Return type

[**ResultDTOCharacterDTO**](ResultDTOCharacterDTO.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="delete"></a>
# **delete**
> ResultDTOBoolean delete(characterId, version)

删除角色

（逻辑）删除 character。返回成功或失败。

### Example
```java
// Import classes:
import com.alibaba.xingchen.ApiClient;
import com.alibaba.xingchen.ApiException;
import com.alibaba.xingchen.Configuration;
import com.alibaba.xingchen.auth.*;
import com.alibaba.xingchen.models.*;
import com.alibaba.xingchen.api.CharacterApiSub;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: Authorization
    HttpBearerAuth Authorization = (HttpBearerAuth) defaultClient.getAuthentication("Authorization");
    Authorization.setBearerToken("BEARER TOKEN");

    CharacterApiSub apiInstance = new CharacterApiSub(defaultClient);
    String characterId = "characterId_example"; // String | 待删除的 characterId
    Integer version = 56; // Integer | 待删除的版本
    try {
      ResultDTOBoolean result = apiInstance.delete(characterId, version);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CharacterApiSub#delete");
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
| **characterId** | **String**| 待删除的 characterId | |
| **version** | **Integer**| 待删除的版本 | |

### Return type

[**ResultDTOBoolean**](ResultDTOBoolean.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="listCharacterVersions"></a>
# **listCharacterVersions**
> ResultDTOListCharacterDTO listCharacterVersions(characterId)

角色版本列表

获取角色版本列表

### Example
```java
// Import classes:
import com.alibaba.xingchen.ApiClient;
import com.alibaba.xingchen.ApiException;
import com.alibaba.xingchen.Configuration;
import com.alibaba.xingchen.auth.*;
import com.alibaba.xingchen.models.*;
import com.alibaba.xingchen.api.CharacterApiSub;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: Authorization
    HttpBearerAuth Authorization = (HttpBearerAuth) defaultClient.getAuthentication("Authorization");
    Authorization.setBearerToken("BEARER TOKEN");

    CharacterApiSub apiInstance = new CharacterApiSub(defaultClient);
    String characterId = "characterId_example"; // String | 角色 characterId
    try {
      ResultDTOListCharacterDTO result = apiInstance.listCharacterVersions(characterId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CharacterApiSub#listCharacterVersions");
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
| **characterId** | **String**| 角色 characterId | |

### Return type

[**ResultDTOListCharacterDTO**](ResultDTOListCharacterDTO.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="recommendCharacterVersion"></a>
# **recommendCharacterVersion**
> ResultDTOCharacterDTO recommendCharacterVersion(characterId)

角色版本列表

获取角色版本列表

### Example
```java
// Import classes:
import com.alibaba.xingchen.ApiClient;
import com.alibaba.xingchen.ApiException;
import com.alibaba.xingchen.Configuration;
import com.alibaba.xingchen.auth.*;
import com.alibaba.xingchen.models.*;
import com.alibaba.xingchen.api.CharacterApiSub;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: Authorization
    HttpBearerAuth Authorization = (HttpBearerAuth) defaultClient.getAuthentication("Authorization");
    Authorization.setBearerToken("BEARER TOKEN");

    CharacterApiSub apiInstance = new CharacterApiSub(defaultClient);
    String characterId = "characterId_example"; // String | 角色 characterId
    try {
      ResultDTOCharacterDTO result = apiInstance.recommendCharacterVersion(characterId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CharacterApiSub#recommendCharacterVersion");
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
| **characterId** | **String**| 角色 characterId | |

### Return type

[**ResultDTOCharacterDTO**](ResultDTOCharacterDTO.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="search"></a>
# **search**
> ResultDTOPageResultCharacterDTO search(characterQueryDTO)

查询角色

查询角色： - 可以指定的查询字段，and 关系：    - 角色名称：左匹配    - 查询范围      - my - 只查询我创建的角色      - public - 查询平台开放的角色      - pre_configured - 预制角色 - 可以指定一定的排序规则，如更新时间倒排。 - 搜索结果为 角色详情。 - 支持分页。 

### Example
```java
// Import classes:
import com.alibaba.xingchen.ApiClient;
import com.alibaba.xingchen.ApiException;
import com.alibaba.xingchen.Configuration;
import com.alibaba.xingchen.auth.*;
import com.alibaba.xingchen.models.*;
import com.alibaba.xingchen.api.CharacterApiSub;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: Authorization
    HttpBearerAuth Authorization = (HttpBearerAuth) defaultClient.getAuthentication("Authorization");
    Authorization.setBearerToken("BEARER TOKEN");

    CharacterApiSub apiInstance = new CharacterApiSub(defaultClient);
    CharacterQueryDTO characterQueryDTO = new CharacterQueryDTO(); // CharacterQueryDTO | 查询条件
    try {
      ResultDTOPageResultCharacterDTO result = apiInstance.search(characterQueryDTO);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CharacterApiSub#search");
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
| **characterQueryDTO** | [**CharacterQueryDTO**](CharacterQueryDTO.md)| 查询条件 | |

### Return type

[**ResultDTOPageResultCharacterDTO**](ResultDTOPageResultCharacterDTO.md)

### Authorization

[Authorization](../README.md#Authorization)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="update"></a>
# **update**
> ResultDTOBoolean update(characterUpdateDTO)

更新角色信息

必须字段：characterId。返回成功或失败。

### Example
```java
// Import classes:
import com.alibaba.xingchen.ApiClient;
import com.alibaba.xingchen.ApiException;
import com.alibaba.xingchen.Configuration;
import com.alibaba.xingchen.auth.*;
import com.alibaba.xingchen.models.*;
import com.alibaba.xingchen.api.CharacterApiSub;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: Authorization
    HttpBearerAuth Authorization = (HttpBearerAuth) defaultClient.getAuthentication("Authorization");
    Authorization.setBearerToken("BEARER TOKEN");

    CharacterApiSub apiInstance = new CharacterApiSub(defaultClient);
    CharacterUpdateDTO characterUpdateDTO = new CharacterUpdateDTO(); // CharacterUpdateDTO | 待更新的角色信息
    try {
      ResultDTOBoolean result = apiInstance.update(characterUpdateDTO);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CharacterApiSub#update");
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
| **characterUpdateDTO** | [**CharacterUpdateDTO**](CharacterUpdateDTO.md)| 待更新的角色信息 | |

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


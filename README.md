# xingchen-java-client

xingchen 开放接口定义

- API version: v1

- Build date: 2023-08-07T18:25:55.099817+08:00[Asia/Shanghai]


## Requirements

Building the API client library requires:

1. Java 1.8+
2. Maven/Gradle

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn clean install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn clean deploy
```

Refer to the [OSSRH Guide](http://central.sonatype.org/pages/ossrh-guide.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>com.alibaba.xingchen</groupId>
  <artifactId>xingchen-java-client</artifactId>
  <version>1.0.0-SNAPSHOT</version>
  <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "com.alibaba.xingchen:xingchen-java-client:1.0.0-SNAPSHOT"
```

### Others

At first generate the JAR by executing:

```shell
mvn clean package
```

Then manually install the following JARs:

- `target/xingchen-java-client-1.0.0-SNAPSHOT.jar`
- `target/lib/*.jar`

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import com.alibaba.xingchen.*;
import com.alibaba.xingchen.auth.*;
import com.alibaba.xingchen.model.*;
import com.alibaba.xingchen.api.CharacterApiSub;

public class CharacterApiSubExample {

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

## Documentation for API Endpoints

All URIs are relative to *http://localhost*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*CharacterApiSub* | [**characterDetails**](docs/CharacterApiSub.md#characterDetails) | **GET** /v1/api/character/details | 角色详情
*CharacterApiSub* | [**create**](docs/CharacterApiSub.md#create) | **POST** /v1/api/character/create | 创建角色
*CharacterApiSub* | [**createOrUpdateVersion**](docs/CharacterApiSub.md#createOrUpdateVersion) | **PUT** /v1/api/character/createOrUpdateVersion | 创建或更新角色版本
*CharacterApiSub* | [**delete**](docs/CharacterApiSub.md#delete) | **DELETE** /v1/api/character/delete | 删除角色
*CharacterApiSub* | [**listCharacterVersions**](docs/CharacterApiSub.md#listCharacterVersions) | **GET** /v1/api/character/versions/{characterId} | 角色版本列表
*CharacterApiSub* | [**recommendCharacterVersion**](docs/CharacterApiSub.md#recommendCharacterVersion) | **GET** /v1/api/character/newversion/recommend/{characterId} | 角色版本列表
*CharacterApiSub* | [**search**](docs/CharacterApiSub.md#search) | **POST** /v1/api/character/search | 查询角色
*CharacterApiSub* | [**update**](docs/CharacterApiSub.md#update) | **PUT** /v1/api/character/update | 更新角色信息
*ChatApiSub* | [**example**](docs/ChatApiSub.md#chat) | **POST** /v1/api/example/send | 用户对话
*ChatMessageApiSub* | [**chatHistories**](docs/ChatMessageApiSub.md#chatHistories) | **POST** /v1/api/example/message/histories | 对话历史
*ChatMessageApiSub* | [**chatHistories1**](docs/ChatMessageApiSub.md#chatHistories1) | **GET** /v1/api/example/history/{characterId} | 对话历史
*ChatMessageApiSub* | [**rateMessage**](docs/ChatMessageApiSub.md#rateMessage) | **POST** /v1/api/example/rating | 消息评分
*ChatMessageApiSub* | [**sysReminder**](docs/ChatMessageApiSub.md#sysReminder) | **POST** /v1/api/example/reminder | 


## Documentation for Models

 - [AdvancedSettings](docs/AdvancedSettings.md)
 - [CharacterAdvancedConfig](docs/CharacterAdvancedConfig.md)
 - [CharacterCreateDTO](docs/CharacterCreateDTO.md)
 - [CharacterDTO](docs/CharacterDTO.md)
 - [CharacterKey](docs/CharacterKey.md)
 - [CharacterPermissionConfig](docs/CharacterPermissionConfig.md)
 - [CharacterQueryDTO](docs/CharacterQueryDTO.md)
 - [CharacterQueryWhere](docs/CharacterQueryWhere.md)
 - [CharacterUpdateDTO](docs/CharacterUpdateDTO.md)
 - [CharacterVersionCreateOrUpdateDTO](docs/CharacterVersionCreateOrUpdateDTO.md)
 - [ChatHistoryQueryDTO](docs/ChatHistoryQueryDTO.md)
 - [ChatHistoryQueryWhere](docs/ChatHistoryQueryWhere.md)
 - [ChatMessageDTO](docs/ChatMessageDTO.md)
 - [ChatReqParams](docs/ChatReqParams.md)
 - [ChatResult](docs/ChatResult.md)
 - [ChatRoomUserDTO](docs/ChatRoomUserDTO.md)
 - [Choice](docs/Choice.md)
 - [Context](docs/Context.md)
 - [FileInfoVO](docs/FileInfoVO.md)
 - [Message](docs/Message.md)
 - [MessageRatingRequest](docs/MessageRatingRequest.md)
 - [ModelParameters](docs/ModelParameters.md)
 - [PageResultCharacterDTO](docs/PageResultCharacterDTO.md)
 - [PageResultChatMessageDTO](docs/PageResultChatMessageDTO.md)
 - [Repository](docs/Repository.md)
 - [RepositoryInfo](docs/RepositoryInfo.md)
 - [ResultDTOBoolean](docs/ResultDTOBoolean.md)
 - [ResultDTOCharacterDTO](docs/ResultDTOCharacterDTO.md)
 - [ResultDTOCharacterKey](docs/ResultDTOCharacterKey.md)
 - [ResultDTOChatResult](docs/ResultDTOChatResult.md)
 - [ResultDTOListCharacterDTO](docs/ResultDTOListCharacterDTO.md)
 - [ResultDTOPageResultCharacterDTO](docs/ResultDTOPageResultCharacterDTO.md)
 - [ResultDTOPageResultChatMessageDTO](docs/ResultDTOPageResultChatMessageDTO.md)
 - [Scenario](docs/Scenario.md)
 - [SysReminderRequest](docs/SysReminderRequest.md)
 - [Usage](docs/Usage.md)
 - [UserProfile](docs/UserProfile.md)


## Documentation for Authorization

Authentication schemes defined for the API:
### Authorization


- **Type**: HTTP basic authentication


## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author




# xingchen-java-client

xingchen 开放接口定义
- API 版本: v2

## 运行/编译

1. Java 1.8+
2. Maven/Gradle

## 安装

### Maven 用户

添加依赖到POM:

```xml
<dependency>
  <groupId>com.alibaba.xingchen</groupId>
  <artifactId>xingchen-java-client</artifactId>
  <version>1.0.2</version>
  <scope>compile</scope>
</dependency>
```

### Gradle用户

添加依赖到项目构建文件:

```groovy
compile "com.alibaba.xingchen:xingchen-java-client:1.0.2"
```

### 编译/打包

构建jar包:

```shell
mvn clean package
```

执行完后会生成以下JARs:

- `target/xingchen-java-client-1.0.2.jar`
- `target/lib/*.jar`

## 快速开始

```java

package example;

import com.alibaba.xingchen.ApiClient;
import com.alibaba.xingchen.ApiException;
import com.alibaba.xingchen.api.ChatApiSub;
import com.alibaba.xingchen.auth.HttpBearerAuth;
import com.alibaba.xingchen.model.*;
import io.reactivex.Flowable;

import java.util.Arrays;

public class ChatApiSseExample {

    public static void main(String[] args) throws ApiException {
        ChatApiSub api = new ChatApiSub();
        ApiClient apiClient = new ApiClient();
        apiClient.setBasePath("https://nlp.aliyuncs.com");
        apiClient.addDefaultHeader("X-DashScope-SSE", "enable");

        // 配置API-KEY，可通过通义星尘官网生成 https://tongyi.aliyun.com/xingchen
        HttpBearerAuth authorization = (HttpBearerAuth) apiClient.getAuthentication("Authorization");
        authorization.setBearerToken("xxx");
        api.setApiClient(apiClient);

        Flowable<ChatResult> response =  api.streamOut(buildChatReqParams());

        response.blockingForEach(message -> {
            System.out.println(message.getChoices().get(0).getMessages().get(0).getContent());
        });
    }

    private static ChatReqParams buildChatReqParams() {
        return ChatReqParams.builder()
                .botProfile(
                        CharacterKey.builder()
                                // 星尘预制角色
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
                                .modelName("qwen-spark-v3")
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


```

## API 接口列表

请求HOST *https://nlp.aliyuncs.com*

Class | Method | HTTP request                                                 | Description
------------ | ------------- |--------------------------------------------------------------| -------------
*CharacterApiSub* | [**characterDetails**](docs/CharacterApiSub.md#characterDetails) | **GET** /v2/api/character/details                            | 角色详情
*CharacterApiSub* | [**create**](docs/CharacterApiSub.md#create) | **POST** /v2/api/character/create                            | 创建角色
*CharacterApiSub* | [**createOrUpdateVersion**](docs/CharacterApiSub.md#createOrUpdateVersion) | **PUT** /v2/api/character/createOrUpdateVersion              | 创建或更新角色版本
*CharacterApiSub* | [**delete**](docs/CharacterApiSub.md#delete) | **DELETE** /v2/api/character/delete                          | 删除角色
*CharacterApiSub* | [**listCharacterVersions**](docs/CharacterApiSub.md#listCharacterVersions) | **GET** /v2/api/character/versions/{characterId}             | 角色版本列表
*CharacterApiSub* | [**recommendCharacterVersion**](docs/CharacterApiSub.md#recommendCharacterVersion) | **GET** /v2/api/character/newversion/recommend/{characterId} | 角色版本列表
*CharacterApiSub* | [**search**](docs/CharacterApiSub.md#search) | **POST** /v2/api/character/search                            | 查询角色
*CharacterApiSub* | [**update**](docs/CharacterApiSub.md#update) | **PUT** /v2/api/character/update                             | 更新角色信息
*ChatApiSub* | [**example**](docs/ChatApiSub.md#chat) | **POST** /v2/api/example/send                                | 用户对话
*ChatMessageApiSub* | [**chatHistories**](docs/ChatMessageApiSub.md#chatHistories) | **POST** /v2/api/example/message/histories                   | 对话历史
*ChatMessageApiSub* | [**rateMessage**](docs/ChatMessageApiSub.md#rateMessage) | **POST** /v2/api/example/rating                              | 消息评分
*ChatMessageApiSub* | [**sysReminder**](docs/ChatMessageApiSub.md#sysReminder) | **POST** /v2/api/example/reminder                            | 


## 接口请求参数对象列表

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

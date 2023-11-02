

# ChatMessageDTO

聊天消息

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**content** | **String** | 消息内容 |  [optional] |
|**messageType** | **String** | 消息类型，opening_remarks: 开场白，sys_greetings: 系统问候，user: 用户, character: 角色 |  [optional] |
|**messageId** | **String** | 消息ID |  [optional] |
|**messageIssuer** | [**ChatRoomUserDTO**](ChatRoomUserDTO.md) |  |  [optional] |
|**sessionId** | **String** | 消息对话session_id |  [optional] |
|**chatId** | **String** | 一次对话ID |  [optional] |
|**gmtCreate** | **Date** | 消息创建时间 |  [optional] |
|**isGreeting** | **Boolean** | 是否为开场白 |  [optional] |
|**rating** | **Double** | 消息评分 |  [optional] |
|**regenerateTimes** | **Integer** | 重新生成次数 |  [optional] |




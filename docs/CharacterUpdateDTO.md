

# CharacterUpdateDTO

角色更新对象

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**name** | **String** | 角色名称(最多20个字符) |  |
|**avatar** | [**FileInfoVO**](FileInfoVO.md) |  |  [optional] |
|**introduction** | **String** | 角色描述 |  [optional] |
|**basicInformation** | **String** | 基本信息 |  |
|**openingLine** | **String** | 开场白 |  [optional] |
|**traits** | **String** | 角色特点 |  [optional] |
|**chatExample** | **String** | 聊天示例 |  [optional] |
|**type** | **String** | 角色类型，virtual:虚拟角色，reproduction:已知角色复刻 |  [optional] |
|**chatObjective** | **String** | 对话目标 |  [optional] |
|**advancedConfig** | [**CharacterAdvancedConfig**](CharacterAdvancedConfig.md) |  |  [optional] |
|**characterId** | **String** | 角色ID |  |
|**version** | **Integer** | 角色版本 |  |
|**permConfig** | [**CharacterPermissionConfig**](CharacterPermissionConfig.md) |  |  [optional] |




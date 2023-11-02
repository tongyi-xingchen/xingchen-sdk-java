

# CharacterDTO

角色信息

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
|**characterId** | **String** | 角色唯一ID |  [optional] |
|**version** | **Integer** | 角色版本 |  [optional] |
|**majorVersion** | **Integer** | 主版本 |  [optional] |
|**gmtCreate** | **Date** | 创建时间 |  [optional] |
|**gmtModified** | **Date** | 修改时间 |  [optional] |
|**userId** | **String** | 角色创建用户ID |  [optional] |
|**modifiedBy** | **String** | 角色最后修改人ID |  [optional] |
|**tags** | **List&lt;String&gt;** | 角色标签 |  [optional] |
|**backgroundImgUrl** | **String** | 背景图片 |  [optional] |
|**permConfig** | [**CharacterPermissionConfig**](CharacterPermissionConfig.md) |  |  [optional] |
|**versions** | **List&lt;Integer&gt;** | 版本列表 |  [optional] |
|**manageable** | **Boolean** | 当前用户是否可管理 |  [optional] |
|**creator** | **String** | 创建者 |  [optional] |
|**isPreConfigured** | **Boolean** | 是否官方创建 |  [optional] |




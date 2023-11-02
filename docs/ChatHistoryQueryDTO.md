

# ChatHistoryQueryDTO

聊天历史查询对象

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**where** | [**ChatHistoryQueryWhere**](ChatHistoryQueryWhere.md) |  |  [optional] |
|**orderBy** | **List&lt;String&gt;** | 排序条件，支持的排序字段为： - gmtCreate 排序优先级按列表顺序，默认降序，如果期望升序，需要在字段后指定，如：orderBy: [\\\&quot;gmtCreate desc\\\&quot;] （gmtCreate 按降序）  |  [optional] |
|**pageNum** | **Integer** | 页码，默认为 0 |  [optional] |
|**pageSize** | **Integer** | 页条目数，1～50，默认为 10 |  [optional] |




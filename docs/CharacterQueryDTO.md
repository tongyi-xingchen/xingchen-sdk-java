

# CharacterQueryDTO

角色查询请求对象

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**where** | [**CharacterQueryWhere**](CharacterQueryWhere.md) |  |  [optional] |
|**orderBy** | **List&lt;String&gt;** | 排序条件，支持的排序字段为： - modifiedTime - createTime 排序优先级按列表顺序，默认降序，如果期望升序，需要在字段后指定，如：orderBy: [\\\&quot;gmtModified desc\\\&quot;] （gmtModified 按降序）  |  [optional] |
|**pageNum** | **Long** | 页码，默认为 0 |  [optional] |
|**pageSize** | **Long** | 页条目数，1～50，默认为 10 |  [optional] |




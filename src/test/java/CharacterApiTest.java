import com.alibaba.fastjson.JSONObject;
import com.alibaba.xingchen.ApiClient;
import com.alibaba.xingchen.ApiException;
import com.alibaba.xingchen.api.CharacterApiSub;
import com.alibaba.xingchen.model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Description
 * @ClassName CharacterApiTest
 * @Author jin.lix
 * @date 2023/7/28 12:43
 */
public class CharacterApiTest extends TestBaseV2 {
    private CharacterApiSub api = new CharacterApiSub();
    @Before
    public void init() {
        ApiClient apiClient = super.initClient();
        api.setApiClient(apiClient);
    }

    /**
     * 角色详情
     *
     * 获取角色详细信息
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void characterDetailsTest() throws ApiException {
        String characterId = "346a45cbb8674cbca0f6d155762e56fb"; // 线上
//        String characterId = "b42f67e0efe74920bf7f9e05d0c03bce"; // 日常
        Integer version = 2;
        ResultDTOCharacterDTO response = api.characterDetails(characterId, version);
        System.out.println(response.getData());
        Assert.assertTrue(response.getSuccess());

    }

    /**
     * 创建角色
     *
     * 基于角色名称、人设和对话示例定义角色，并返回角色ID
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void createTest() throws ApiException {
        CharacterCreateDTO characterCreateDTO = CharacterCreateDTO.builder()
                .name("关云长2")
                .type("virtual")
                .avatar(
                        FileInfoVO.builder()
                                //.fileSavePath("oss-83de76cbd9034cd88dcb412be88004bd-guanyu.png")
                                .filename("关云长.png")
                                .fileUrl("https://ai-character.oss-cn-hangzhou.aliyuncs.com/img/guanyu.jpg")
                                .build()
                )
                .introduction("满腔忠义的关云长")
                .traits("请在对话时尽可能的展现你的性格、感情， 用文言文回答， 并使用古人的语气和用词。")
                .openingLine("我是「关云长」，很高心与你玩游戏")
                .basicInformation("我们来玩一个角色扮演的游戏， 你是「满腔忠义的关云长」。")
                .chatExample("{{user}}:敢问阁下尊姓大名。\\n{{char}}:吾姓关名羽，字长生，后改云长，河东解良人也。")
                .advancedConfig(
                        CharacterAdvancedConfig.builder()
                                .repositoryInfo(
                                        RepositoryInfo.builder()
                                                .repositoryFiles(
                                                        Arrays.asList(
                                                                Repository.builder()
                                                                        .fileUrl("https://77274.oss-cn-hangzhou.aliyuncs.com/aca/%E5%85%B3%E4%BA%91%E9%95%BF%E4%BC%A0%E8%AE%B0.docx")
                                                                        .filename("关云长传")
                                                                        .build()
                                                        )
                                                )
                                                .build()
                                )
                                .build()
                )
                .permConfig(
                        CharacterPermissionConfig.builder()
                                .allowApi(0)
                                .allowChat(0)
                                .isPublic(0)
                                .build()
                )
                .build();
        ResultDTOCharacterKey response = api.create(characterCreateDTO);
        System.out.println(JSONObject.toJSONString(response));
        Assert.assertTrue(response.getSuccess());
    }
    /**
     * 创建或更新角色版本
     *
     * 必须字段：characterId 和 version。返回角色版本详情。
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void createOrUpdateVersionTest() throws ApiException {
        CharacterVersionCreateOrUpdateDTO characterVersionCreateOrUpdateDTO = CharacterVersionCreateOrUpdateDTO.builder()
                .characterId("346a45cbb8674cbca0f6d155762e56fb")
                .version(2)
                .name("满腔忠义的关云长")
                .type("virtual")
                .avatar(
                        FileInfoVO.builder()
                                .fileSavePath("oss-83de76cbd9034cd88dcb412be88004bd-guanyu.png")
                                .filename("关云长.png")
                                .build()
                )
                .introduction("满腔忠义的关云长22")
                .traits("请在对话时尽可能的展现你的性格、感情， 用文言文回答， 并使用古人的语气和用词。")
                .openingLine("我是「关云长」，很高心与你玩游戏")
                .basicInformation("我们来玩一个角色扮演的游戏， 你是「满腔忠义的关云长」。")
                .chatExample("{{user}}:敢问阁下尊姓大名。\\n{{char}}:吾姓关名羽，字长生，后改云长，河东解良人也。")
                .build();
        ResultDTOCharacterDTO response = api.createOrUpdateVersion(characterVersionCreateOrUpdateDTO);
        System.out.println(JSONObject.toJSONString(response));
        Assert.assertTrue(response.getSuccess());
    }
    /**
     * 删除角色
     *
     * （逻辑）删除 character。返回成功或失败。
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteTest() throws ApiException {
        String characterId = null;
        Integer version = null;
        ResultDTOBoolean response = api.delete(characterId, version);

        // TODO: test validations
    }
    /**
     * 角色版本列表
     *
     * 获取角色版本列表
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void listCharacterVersionsTest() throws ApiException {
        String characterId = "346a45cbb8674cbca0f6d155762e56fb";
        ResultDTOListCharacterDTO response = api.listCharacterVersions(characterId);
        System.out.println(JSONObject.toJSONString(response));
        Assert.assertTrue(response.getSuccess());
    }
    /**
     * 角色版本列表
     *
     * 获取角色版本列表
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void recommendCharacterVersionTest() throws ApiException {
        String characterId = "346a45cbb8674cbca0f6d155762e56fb";
        ResultDTOCharacterDTO response = api.recommendCharacterVersion(characterId);
        System.out.println(JSONObject.toJSONString(response));
        Assert.assertTrue(response.getSuccess());
    }

    @Test
    public void searchTest() throws ApiException {
        CharacterQueryDTO characterQueryDTO = new CharacterQueryDTO();
        characterQueryDTO.setPageNum(1L);
        characterQueryDTO.setPageSize(10L);
        CharacterQueryWhere where=new CharacterQueryWhere();

        //查询我的角色
        where.setScope("my");
        //查询预置角色
//        where.setScope("pre_configured");
        characterQueryDTO.setWhere(where);
        ResultDTOPageResultCharacterDTO response = api.search(characterQueryDTO);
        System.out.println(JSONObject.toJSONString(response));
        Assert.assertTrue(response.getSuccess());
    }
    /**
     * 更新角色信息
     *
     * 必须字段：characterId。返回成功或失败。
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void updateTest() throws ApiException {
        CharacterUpdateDTO characterUpdateDTO = CharacterUpdateDTO.builder()
                .characterId("346a45cbb8674cbca0f6d155762e56fb")
                .version(1)
                .name("满腔忠义的关云长2")
                .type("virtual")
                .avatar(
                        FileInfoVO.builder()
                                .fileSavePath("oss-83de76cbd9034cd88dcb412be88004bd-guanyu.png")
                                .filename("关云长.png")
                                .build()
                )
                .introduction("满腔忠义的关云长2")
                .traits("请在对话时尽可能的展现你的性格、感情， 用文言文回答， 并使用古人的语气和用词。")
                .openingLine("我是「关云长」，很高心与你玩游戏")
                .basicInformation("我们来玩一个角色扮演的游戏， 你是「满腔忠义的关云长」。")
                .chatExample("{{user}}:敢问阁下尊姓大名。\\n{{char}}:吾姓关名羽，字长生，后改云长，河东解良人也。")
                .build();
        ResultDTOBoolean response = api.update(characterUpdateDTO);
        System.out.println(JSONObject.toJSONString(response));
        Assert.assertTrue(response.getSuccess());
    }
}
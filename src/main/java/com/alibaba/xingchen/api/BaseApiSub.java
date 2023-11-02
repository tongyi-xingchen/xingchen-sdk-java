package com.alibaba.xingchen.api;

import com.alibaba.xingchen.enums.AcaOpenApiEnum;
import com.alibaba.xingchen.enums.Version;
import com.alibaba.xingchen.model.ChatResult;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.gsonfire.GsonFireBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.alibaba.xingchen.constant.AcaConstants.*;

/**
 * @author zhiyong.fzy@alibaba-inc.com
 * @date 2023/9/26 2:19 PM
 */
public class BaseApiSub {

    private Version version;

    public BaseApiSub() {
    }

    public BaseApiSub(Version version) {
        this.version = version;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

    public String getApiVersion() {
        return Objects.nonNull(version) ? version.name() : Version.v2.name();
    }

    public static Map<String, String> setServiceRouterHeader(Map<String, String> headers, String apiPath) {
        if (Objects.isNull(headers)) {
            headers = new HashMap<>();
        }

        if (AcaOpenApiEnum.CHAT_SYNC.getPath().equals(apiPath)) {
            // sse enabled
            String sseHeader = headers.get("X-DashScope-SSE");
            if (Objects.nonNull(sseHeader) && sseHeader.equals("enable")) {
                headers.put(GATEWAY_HEADER_SERVICE_ROUTER, AcaOpenApiEnum.CHAT_ASYNC.getGatewayRoute());
            } else {
                headers.put(GATEWAY_HEADER_SERVICE_ROUTER, AcaOpenApiEnum.CHAT_SYNC.getGatewayRoute());
            }
        } else {
            String serviceName = AcaOpenApiEnum.getApiRouterByPath(apiPath);
            if (Objects.nonNull(serviceName)) {
                headers.put(GATEWAY_HEADER_SERVICE_ROUTER, serviceName);
            }
        }

        headers.put(GATEWAY_HEADER_APPCODE, APP_CODE);
        return headers;
    }
    public static void main(String[] args) {
        GsonFireBuilder fireBuilder = new GsonFireBuilder();
        GsonBuilder gsonBuilder = fireBuilder.createGsonBuilder();

        Gson gson = gsonBuilder.create();

        String chatResultString = "{\"requestId\":\"210f470116957192268516247e84fd\",\"choices\":[{\"messages\":[{\"role\":\"assistant\",\"content\":\"从前有\",\"finishReason\":\"null\"}],\"stopReason\":\"null\"}],\"context\":{\"chatRoomId\":55897,\"sessionId\":\"5dfe4fcfd9774eabb609de2155bbaa1f\",\"chatId\":\"6db7f84b94154c1f9096978d4c106a2a\",\"messageId\":\"e7cf93ceae5b47238aa99d01d6019268\",\"enableDataInspection\":false,\"isSave\":true,\"requestId\":\"210f470116957192268516247e84fd\",\"modelRequestId\":\"1df41bbd-3fdf-94c0-8242-ae7f944ed7a9\"},\"stop\":false}";
        System.out.println(gson.fromJson(chatResultString, ChatResult.class));
    }
}

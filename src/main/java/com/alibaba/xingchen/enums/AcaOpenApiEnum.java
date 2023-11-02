package com.alibaba.xingchen.enums;

import java.util.HashMap;
import java.util.Map;

import static com.alibaba.xingchen.constant.AcaConstants.API_VERSION;

/**
 * @author zhiyong.fzy@alibaba-inc.com
 * @date 2023/9/14 11:25 AM
 * API 描述
 */
public enum AcaOpenApiEnum {
    CHAT_SYNC("chat_sync", "aca-chat-send", "example", API_VERSION + "/api/chat/send"),

    CHAT_ASYNC("chat_async", "aca-chat-send-sse", "example", API_VERSION + "/api/chat/send"),

    CHAT_GENERATE("chat_generate", "aca-chat-regenerate", "example", API_VERSION +"/api/chat/generate"),

    CHAT_REMINDER("chat_reminder", "aca-chat-reminder", "example", API_VERSION +"/api/chat/reminder"),

    CHAT_MESSAGE_HISTORIES("chat_message_histories", "aca-message-history", "chat-history", API_VERSION +"/api/chat/message/histories"),

    CHAT_MESSAGE_RATING("chat_message_rating", "aca-message-rating", "chat-message-rating", API_VERSION + "/api/chat/rating"),

    CHAT_RATING("chat_rating", "aca-message-rating", "message-rating", API_VERSION +"/api/chat/rating"),

    CHARACTER_CREATE("character_create","aca-character-create","character",API_VERSION +"/api/character/create"),

    CHARACTER_UPDATE("character_update","aca-character-update","character",API_VERSION +"/api/character/update"),

    CHARACTER_CREATE_OR_UPDATE_VERSION("character_create_or_update_version","aca-character-version-mgmt","character",API_VERSION +"/api/character/createOrUpdateVersion"),
    CHARACTER_VERSION_RECOMMEND("character_version_recommend","aca-character-version-recommend","character",API_VERSION +"/api/character/newversion/recommend"),

    CHARACTER_DETAILS("character_details","aca-character-details","character",API_VERSION +"/api/character/details"),

    CHARACTER_DELETE("character_delete","aca-character-delete","character",API_VERSION +"/api/character/delete"),

    CHARACTER_SEARCH("character_search","aca-character-search","character",API_VERSION +"/api/character/search"),

    CHARACTER_VERSIONS("character_versions","aca-character-versions","character",API_VERSION +"/api/character/versions");

    private String key;

    private String gatewayRoute;

    private String category;

    private String path;

    public String getKey() {
        return key;
    }

    public String getGatewayRoute() {
        return gatewayRoute;
    }

    public String getPath() {
        return path;
    }

    private static Map<String, String> PATH_ROUTE_MAP = new HashMap<>();
    static {
        for (AcaOpenApiEnum api : values()) {
            PATH_ROUTE_MAP.put(api.getPath(), api.getGatewayRoute());
        }
    }

    AcaOpenApiEnum(String key, String gatewayRoute, String category, String path) {
        this.key = key;
        this.gatewayRoute = gatewayRoute;
        this.category = category;
        this.path = path;
    }

    public static String getApiRouterByPath(String path) {
        return PATH_ROUTE_MAP.get(path);
    }

}

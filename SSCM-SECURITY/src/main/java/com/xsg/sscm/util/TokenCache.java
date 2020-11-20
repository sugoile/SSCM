package com.xsg.sscm.util;


import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

/**
 * @des: token管理缓存(可以整合redis存储)
 * @package: com.xsg.sscm.compoent
 * @author: xsg
 * @date: 2020/9/14
 **/
public class TokenCache {
    private static final String TOKENKEY = "token_";
    private static Cache<String, String> cache = CacheBuilder.newBuilder().build();

    public static void setToken(String username, String token) {
        cache.put(TOKENKEY + username, token);
    }

    public static String getTokenFromCache(String username) {
        return cache.getIfPresent(TOKENKEY + username);
    }
}

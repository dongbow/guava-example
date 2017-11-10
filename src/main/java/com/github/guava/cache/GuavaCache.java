package com.github.guava.cache;

import com.google.common.cache.LoadingCache;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by wangdongbo on 2017/11/10.
 */
public class GuavaCache {

    private Map<String, LoadingCache<String, Object>> cacheMap = Maps.newConcurrentMap();


}

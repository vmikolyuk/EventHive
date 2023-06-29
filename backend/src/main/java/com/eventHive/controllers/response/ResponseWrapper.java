package com.eventHive.controllers.response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.eventHive.models.dto.AbstractDto;

/**
 * @author vmikolyuk
 * @since 27.06.2023
 */
public class ResponseWrapper<T>
{
    public Map<Object, Object> wrap(T entities, Class<T> clazz)
    {
        AbstractDto entity = new AbstractDto();
        List<Long> allIds = new ArrayList<>();

        Map<Object, Object> map2 = new HashMap<>();
        map2.put("id", entity);

        Map<Object, Object> map1 = new HashMap<>();
        map1.put("byId", map2);
        map1.put("allIds", allIds);

        Map<Object, Object> map = new HashMap<>();
        map.put(clazz.getName(), map1);
        return map;
    }

}

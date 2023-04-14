package com.eindopdracht.eindopdracht.helper;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.springframework.beans.BeanUtils;

public class Helper {
    public static <T, D> D mapToDto(T object, Class<D> dtoClass) {
        try {
            Constructor<D> constructor = dtoClass.getDeclaredConstructor();
            D dto = constructor.newInstance();
            BeanUtils.copyProperties(object, dto);
            return dto;
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }
}


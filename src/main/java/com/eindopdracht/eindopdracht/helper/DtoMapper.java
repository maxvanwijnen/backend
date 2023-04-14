package com.eindopdracht.eindopdracht.helper;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DtoMapper {
    public static <T, U> T mapEntityToDto(T dto, U entity) {
        for (Field dtoField : dto.getClass().getDeclaredFields()) {
            try {
                String fieldName = dtoField.getName();
                Method getter = entity.getClass().getMethod("get" + capitalize(fieldName));
                Object value = getter.invoke(entity);
                dtoField.setAccessible(true);
                dtoField.set(dto, value);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                // Handle exception
            }
        }
        return dto;
    }

    public static <T, U> U mapDtoToEntity(T dto, U entity) {
        for (Field dtoField : dto.getClass().getDeclaredFields()) {
            try {
                String fieldName = dtoField.getName();
                Method setter = entity.getClass().getMethod("set" + capitalize(fieldName), dtoField.getType());
                dtoField.setAccessible(true);
                Object value = dtoField.get(dto);
                setter.invoke(entity, value);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
// Handle exception
            }
        }
        return entity;
    }
    private static String capitalize(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
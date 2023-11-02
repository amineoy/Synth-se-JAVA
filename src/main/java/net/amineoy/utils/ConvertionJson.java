package net.amineoy.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertionJson {
    public static String convertToJson(Object o)  {
        ObjectMapper objectMapper=new ObjectMapper();

        String json= null;
        try {
            json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(o);
            return  json;
        } catch (JsonProcessingException e) {
           return ("{}");
        }

    }
}

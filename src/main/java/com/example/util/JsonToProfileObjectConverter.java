package com.example.util;

import com.example.model.Facebook;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonToProfileObjectConverter {

    private ObjectMapper mapper = new ObjectMapper();

    public Facebook convert(String pathname)
    {
        try {
            return mapper.readValue(getClass().getResourceAsStream(pathname), Facebook.class);

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
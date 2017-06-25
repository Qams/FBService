package com.example.dao;

import com.example.model.Facebook;
import com.example.util.JsonToProfileObjectConverter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProfilesDao {
    private Map<String, Facebook> profiles;
    private static volatile ProfilesDao instance = null;
    private static final List<String> PROFILE_NAME_LIST = Arrays.asList("f1", "f2", "f3", "f4", "f5");
    private static final String DIR_NAME  = "/profiles/";
    private static final String POSTFIX_JSON = ".json";

    public static ProfilesDao getInstance() {
        if (instance == null) {
            synchronized (ProfilesDao.class) {
                if (instance == null) {
                    instance = new ProfilesDao();
                }
            }
        }
        return instance;
    }

    private ProfilesDao() {
        JsonToProfileObjectConverter jsonToProfileObjectConverter = new JsonToProfileObjectConverter();
        profiles = new HashMap<>();
        for(String profileName : PROFILE_NAME_LIST)
        {
            Facebook facebook = jsonToProfileObjectConverter.convert(String.format("%s%s%s", DIR_NAME, profileName, POSTFIX_JSON));
            profiles.put(facebook.getId(), facebook);
        }
    }

    public Map<String, Facebook> getProfiles() {
        return profiles;
    }
}

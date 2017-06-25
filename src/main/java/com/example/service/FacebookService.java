package com.example.service;

import com.example.exception.NotFoundException;
import com.example.model.Facebook;

import java.util.Map;
import java.util.Set;

public interface FacebookService {
    Facebook findById(String id) throws NotFoundException;
    Map<String, Long> findMostCommonWords();
    Set<String> findPostIdsByKeyword(String word);
    Set<Facebook> findAll();
}

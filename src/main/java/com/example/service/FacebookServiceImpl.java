package com.example.service;

import com.example.dao.ProfilesDao;
import com.example.exception.NotFoundException;
import com.example.model.Facebook;

import java.util.*;
import java.util.function.Function;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class FacebookServiceImpl implements FacebookService{

    private ProfilesDao profilesDao = ProfilesDao.getInstance();

    public Facebook findById(String id) throws NotFoundException {
        Facebook facebook = profilesDao.getProfiles().get(id);
        if(facebook == null)
        {
            throw new NotFoundException(String.format("Cannot find profile with id %s", id));
        }
        else
        {
            return facebook;
        }
    }

    public Map<String, Long> findMostCommonWords() {
        return splitPostsIntoWords().stream().collect(groupingBy(Function.identity(), counting()));
    }

    public Set<String> findPostIdsByKeyword(String word) {
        Set<String> messages = new HashSet<>();
        Map<String, Facebook> profiles = profilesDao.getProfiles();
        profiles.forEach((k,v) ->
                v.getPosts()
                        .stream()
                        .filter(p -> Arrays.asList(p.getMessage().toLowerCase().split("\\W+")).contains(word.toLowerCase()))
                        .forEach(e -> messages.add(e.getId())));
        return messages;
    }

    public Set<Facebook> findAll() {
        TreeSet<Facebook> treeSet = new TreeSet<>(Comparator.comparing(Facebook::getFirstname).thenComparing(Facebook::getLastname));
        treeSet.addAll(profilesDao.getProfiles().values());
        return treeSet;
    }

    private List<String> splitPostsIntoWords()
    {
        List<String> wordsList = new ArrayList<>();
        profilesDao.getProfiles()
                .forEach((k,v) -> v.getPosts().forEach(p -> wordsList.addAll(Arrays.asList(p.getMessage().toLowerCase().split("\\W+")))));
        return wordsList;
    }
}

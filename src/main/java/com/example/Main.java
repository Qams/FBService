package com.example;

import com.example.exception.NotFoundException;
import com.example.model.Facebook;
import com.example.service.FacebookServiceImpl;

public class Main {
    private static final String USER_ID = "3";
    private static final String KEYWORD = "picture";

    public static void main(String[] args) throws NotFoundException {
        Main obj = new Main();
        obj.run();
    }

    private void run() throws NotFoundException {
        System.out.println("Example usage of Facebook Service");
        FacebookServiceImpl facebookService = new FacebookServiceImpl();
        System.out.println(String.format("\nFind user with id %s", USER_ID));
        System.out.println(facebookService.findById(USER_ID));
        System.out.println("\nFind most common words");
        System.out.println(facebookService.findMostCommonWords());
        System.out.println(String.format("\nFind post ids by keyword %s", KEYWORD));
        System.out.println(facebookService.findPostIdsByKeyword(KEYWORD));
        System.out.println("\nFind all sorted by first name and last name");
        System.out.println("First name and last name: ");
        for(Facebook f : facebookService.findAll())
        {
            System.out.println(f.getFirstname() + " " + f.getLastname());
        }
    }
}

package com.practice.Utility;


import org.apache.commons.lang3.RandomStringUtils;

public class TestUtilis {

    public static final long Wait=10;

    public static String getUserEmailId(){

       String emailid = RandomStringUtils.randomAlphabetic(5);
       return emailid;

    }
}

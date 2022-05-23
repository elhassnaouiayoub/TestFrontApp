package com.AppMovies.actiondriver;

import java.io.*;
import java.util.Properties;

public class ConfigProperties {

    Properties properties = new Properties();
    static String dir = System.getProperty("user.dir");
    private static final String PATH = dir + "\\Configuration\\config.properties";

    public ConfigProperties(){
        try {
            System.out.println(PATH);
            OutputStream outputStream = new FileOutputStream(PATH);
            properties.setProperty("url", "http://localhost:4200/login");
            properties.store(outputStream, null);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    public String getPropertyURL(){
        try {
            InputStream inputStream = new FileInputStream(PATH);
            properties.load(inputStream);
            return properties.getProperty("url");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public String getPropertyUsername() {
        try {
            InputStream inputStream = new FileInputStream(PATH);
            properties.load(inputStream);
            return properties.getProperty("username");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public String getPropertyPassword() {
        try {
            InputStream inputStream = new FileInputStream(PATH);
            properties.load(inputStream);
            return properties.getProperty("password");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    public void setPropertyUsername(String username) {
        try {
            OutputStream outputStream = new FileOutputStream(PATH);
            properties.setProperty("username", username);
            properties.store(outputStream, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setPropertyPassword(String password) {
        try {
            OutputStream outputStream = new FileOutputStream(PATH);
            properties.setProperty("password", password);
            properties.store(outputStream, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}

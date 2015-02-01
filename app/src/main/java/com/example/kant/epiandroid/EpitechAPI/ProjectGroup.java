package com.example.kant.epiandroid.EpitechAPI;

import java.io.Serializable;

/**
 * Created by Quentin on 29/01/2015.
 * EpiAndroid Project.
 */

public class ProjectGroup implements Serializable {
    public String code;
    public String title;
    public String url_repository;
    public User[] members;

}

package com.example.kant.epiandroid.EpitechAPI;

import java.util.ArrayList;
import java.util.List;

public class Infos {

    public String id;
    public String login;
    public String title;
    public String internal_email;
    public String lastname;
    public String firstname;
    public Object userinfo;
    public boolean referent_used;
    public String picture;
    public String picture_fun;
    public int promo;
    public int semester;
    public int uid;
    public int gid;
    public String location;
    public String documents;
    public String userdocs;
    public String shell;
    public Boolean close;
    public String ctime;
    public String mtime;
    public String id_promo;
    public String id_history;
    public String course_code;
    public String school_code;
    public String school_title;
    public String old_id_promo;
    public String old_id_location;
    public Object rights;
    public boolean invited;
    public int studentyear;
    public boolean admin;
    public boolean editable;
    public List<Group> groups = new ArrayList<Group>();
    public List<Event> events = new ArrayList<Event>();
    public int credits;
    public List<Gpa> gpa = new ArrayList<Gpa>();
    public List<AverageGPA> averageGPA = new ArrayList<AverageGPA>();
    public Object spice;
    public Nsstat nsstat;
    public int decoded;

}

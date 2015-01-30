package com.example.kant.epiandroid.EpitechAPI;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Quentin on 29/01/2015.
 * EpiAndroid Project.
 */
public class ActivityEvent {

    public String code;
    public String num_event;
    public String seats;
    public Object title;
    public Object description;
    public String nb_inscrits;
    public String begin;
    public String end;
    public String id_activite;
    public String location;
    public Object nb_max_students_projet;
    public String already_register;
    public String user_status;
    public String allow_token;
    public List<Object> assistants = new ArrayList<Object>();

}

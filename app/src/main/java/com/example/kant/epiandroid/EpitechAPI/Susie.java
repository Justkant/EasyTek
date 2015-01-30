package com.example.kant.epiandroid.EpitechAPI;

import android.util.Log;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.List;

/**
 * Created by Quentin on 29/01/2015.
 * EpiAndroid Project.
 */

public class Susie implements Serializable {

    public String color;
    public int id_maker;
    public int weeks_left;
    public User maker;
    public String end;
    public String description;
    public String title;
    public int registered;
    public String duration;
    public int nb_rated;
    public String calendar_type;
    public Rights rights;
    public String location;
    public int id_owner;
    public int nb_place;
    public Boolean event_registered;
    public String start;
    public Object type_room;
    public int id_calendar;
    public int id;
    public float rating_event;
    public boolean confirm_owner;
    public boolean confirm_maker;
    public String type;
    public boolean has_to_rate;
    public User owner;
    public Logins [] logins;
}

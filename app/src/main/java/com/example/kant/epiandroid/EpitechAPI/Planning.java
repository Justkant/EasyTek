package com.example.kant.epiandroid.EpitechAPI;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Quentin on 29/01/2015.
 * EpiAndroid Project.
 */

public class Planning implements Serializable {
    public int nb_group;
    public Object rdv_indiv_registered;
    public String acti_title;
    public boolean module_available;
    public boolean past;
    public String codeacti;
    public String type_code;
    public int total_students_registered;
    public boolean allow_register;
    public String is_rdv;
    public Object dates;
    public String allowed_planning_end;
    public String nb_hours;
    public Object nb_max_students_projet;
    public String scolaryear;
    public String instance_location;
    public String end;
    public boolean module_registered;
    public Room room;
    public Boolean event_registered;
    public String titlemodule;
    public boolean register_student;
    public List<User> prof_inst = new ArrayList<>();
    public boolean project;
    public Object rdv_group_registered;
    public String type_title;
    public String start;
    public Object rights;
    public boolean register_month;
    public String codeinstance;
    public String allowed_planning_start;
    public int semester;
    public int num_event;
    public String codemodule;
    public Object title;
    public boolean in_more_than_one_month;
    public boolean allow_token;
    public String codeevent;
    public boolean register_prof;
    public Object status_manager;
}

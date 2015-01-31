package com.example.kant.epiandroid.EpitechAPI;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Quentin on 29/01/2015.
 * EpiAndroid Project.
 */
public class Activite {
    public String codeacti;
    public String call_ihk;
    public Object slug;
    public String instance_location;
    public String module_title;
    public String title;
    public String description;
    public String type_title;
    public String type_code;
    public String begin;
    public String start;
    public Object end_register;
    public Object deadline;
    public String end;
    public String nb_hours;
    public int nb_group;
    public int num;
    public String register;
    public Object register_by_bloc;
    public String register_prof;
    public String title_location_type;
    public boolean is_projet;
    public Object id_projet;
    public Object project_title;
    public boolean is_note;
    public int nb_notes;
    public boolean is_blocins;
    public String rdv_status;
    public Object id_bareme;
    public Object title_bareme;
    public String archive;
    public Object hash_elearning;
    public Object ged_node_adm;
    public int nb_planified;
    public int note;
    public Object project;
    public List<ActivityEvent> events = new ArrayList<>();
}

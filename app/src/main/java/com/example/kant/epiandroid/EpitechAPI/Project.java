package com.example.kant.epiandroid.EpitechAPI;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Quentin on 29/01/2015.
 * EpiAndroid Project.
 */
public class Project implements Serializable {
    public String codeacti;
    public String project;
    public String acti_title;
    public String begin_event;
    public String title_module;
    public String seats;
    public int registered;
    public String end_event;
    public String num_event;
    public Object info_creneau;
    public String type_acti_code;
    public String code_location;
    public String type_acti;
    public String begin_acti;
    public String end_acti;
    public String num;
    public String codeinstance;
    public String codemodule;
    public String scolaryear;
    public List<String> rights = new ArrayList<String>();
}

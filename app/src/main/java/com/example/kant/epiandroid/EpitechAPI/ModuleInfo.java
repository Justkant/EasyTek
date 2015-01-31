package com.example.kant.epiandroid.EpitechAPI;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Quentin on 29/01/2015.
 * EpiAndroid Project.
 */
public class ModuleInfo {

    public String scolaryear;
    public String codemodule;
    public String codeinstance;
    public int semester;
    public String title;
    public String begin;
    public String end_register;
    public String end;
    public String past;
    public String closed;
    public String opened;
    public String user_credits;
    public int credits;
    public String description;
    public String competence;
    public String flags;
    public String instance_flags;
    public Object max_ins;
    public String instance_location;
    public String hidden;
    public String old_acl_backup;
    public List<ModuleUser> resp = new ArrayList<>();
    public List<ModuleUser> assistant = new ArrayList<>();
    public List<String> rights = new ArrayList<>();
    public List<ModuleUser> templateResp = new ArrayList<>();
    public Boolean allow_register;
    public int student_registered;
    public String student_grade;
    public int student_credits;
    public String color;
    public String student_flags;
    public Boolean current_resp;
    public List<Activite> activites = new ArrayList<>();
}

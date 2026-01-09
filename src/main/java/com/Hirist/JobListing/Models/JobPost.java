package com.Hirist.JobListing.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;

@Document(collection = "JobPost")
public class JobPost {

    private String profile;
    private String desc;
    private int exp;
    @Id
    private String id;
    private String techs[];

    public JobPost() {
    }

    public JobPost(String profile, String desc, int exp, String id, String[] techs) {
        this.profile = profile;
        this.desc = desc;
        this.exp = exp;
        this.id = id;
        this.techs = techs;
    }

    @Override
    public String toString() {
        return "JobPost{" +
                "profile='" + profile + '\'' +
                ", desc='" + desc + '\'' +
                ", exp=" + exp +
                ", id=" + id +
                ", techs=" + Arrays.toString(techs) +
                '}';
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String[] getTechs() {
        return techs;
    }

    public void setTechs(String[] techs) {
        this.techs = techs;
    }
}

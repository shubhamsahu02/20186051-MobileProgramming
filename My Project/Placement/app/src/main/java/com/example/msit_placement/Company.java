package com.example.msit_placement;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.Serializable;

public class Company implements Serializable {
    String name,website, headq, size, found, indus, revenue, location, benefits, type;

    public Company(String name, String website, String t, String headq, String size, String found, String indus, String revenue, String location, String benefits) {
        this.name = name;
        this.website = website;
        this.headq = headq;
        this.size = size;
        this.found = found;
        this.type=t;
        this.indus = indus;
        this.revenue = revenue;
        this.location = location;
        this.benefits = benefits;
    }

    public Company() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getHeadq() {
        return headq;
    }

    public void setHeadq(String headq) {
        this.headq = headq;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFound() {
        return found;
    }

    public void setFound(String found) {
        this.found = found;
    }

    public String getIndus() {
        return indus;
    }

    public void setIndus(String indus) {
        this.indus = indus;
    }

    public String getRevenue() {
        return revenue;
    }

    public void setRevenue(String revenue) {
        this.revenue = revenue;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }

    public  String toString() {
        return  this.headq + " " + this.found;
    }

}

package org.techtown.myapplication;

import android.location.Geocoder;

import androidx.annotation.NonNull;

import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapReverseGeoCoder;

import java.io.Serializable;

public class Cafe implements Serializable {

    int id;
    String  name;
    String tel;
    double lat;
    double lon;
    String etc;
    String link;

    public Cafe(int id, String name, String tel, double lat, double lon, String etc, String link) {
        this.id = id;
        this.name = name;
        this.tel = tel;
        this.lat = lat;
        this.lon = lon;
        this.etc = etc;
        this.link = link;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getEtc() {
        return etc;
    }

    public void setEtc(String etc) {
        this.etc = etc;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @NonNull
    @Override
    public String toString() {
        return id +", "+name+", "+lat+", "+lon+", "+etc+", "+link ;
    }

}

package com.home;

public class Student {
    public Student(String id,String name,String height,String weight,String isTodayDinner,String zayuu) {
        this.id = Integer.parseInt(id);
        this.name = name;
        this.height = Float.parseFloat(height);
        this.weight = Float.parseFloat(weight);
        this.isTodayDinner = Boolean.parseBoolean(isTodayDinner);
        this.zayuu = zayuu;
    }
    public int id;
    public String name;
    public float height;
    public float weight;
    public boolean isTodayDinner;
    public String zayuu;
}

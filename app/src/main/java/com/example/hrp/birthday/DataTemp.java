package com.example.hrp.birthday;

/**
 * Created by hrp on 11/25/2017.
 */

public class DataTemp {

    private int id;
    private String name;
    private String birthday;


    public DataTemp(String n , String d){
        name = n;
        birthday = d;

    }

    public void setId(int id){
    this.id= id;
    }
    public int getId(){
        return id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setBirthday(String birthday){
        this.birthday = birthday;
    }
    public String getBirthday(){
        return birthday;
    }
}

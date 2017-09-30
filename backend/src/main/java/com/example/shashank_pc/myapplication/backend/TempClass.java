package com.example.shashank_pc.myapplication.backend;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

/**
 * Created by shashank-pc on 9/30/2017.
 */

@Entity
public class TempClass {

    @Id
    String ID;
    int a;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }


}

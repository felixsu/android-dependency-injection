package com.felixsu.dagger2.model;

/**
 * Created on 1/9/17.
 *
 * @author felixsoewito
 */

public class MyDate {

    private String currentDate;

    public MyDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }
}

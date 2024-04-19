package com.ripadbaisor.restaurants;

public class Restaurant implements Comparable<Restaurant> {

    private String name;
    private String localization;
    private String schedule;
    private float punctuation;

    public Restaurant(String name, String localization, String schedule, float punctuation) {
        this.name = name;
        this.localization = localization;
        this.schedule = schedule;
        this.punctuation = punctuation;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocalization() {
        return this.localization;
    }

    public void setLocalization(String localization) {
        this.localization = localization;
    }

    public String getSchedule() {
        return this.schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public float getPunctuation() {
        return this.punctuation;
    }

    public void setPunctuation(float punctuation) {
        this.punctuation = punctuation;
    }

    @Override
    public String toString() {
        return "******************\nNombre: " + this.name + "\nLocalizacion: " + this.localization + "\nHorarios: " + this.schedule + "\nPuntuación: " + this.punctuation + "\n******************";
    }

    public int compareTo(Restaurant e) {
        if (e.getPunctuation() < punctuation) {
            return -1;
        } else if (e.getPunctuation() < punctuation) {
            return 0;
        } else {
            return 1;
        }
    }

}

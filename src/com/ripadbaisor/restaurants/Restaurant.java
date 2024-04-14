package com.ripadbaisor.restaurants;

public class Restaurant {

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
        return "Restaurante [nombre=" + name + ", loacalizacion=" + localization + ", horario=" + schedule
                + ", puntuacion=" + punctuation + "]";
    }

}

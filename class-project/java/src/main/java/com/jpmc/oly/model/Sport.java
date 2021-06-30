package com.jpmc.oly.model;

import java.util.Objects;

public class Sport {

    private String name;

    private String worldRecord;

    public Sport(){}

    public Sport(String name) {
        this.name = name;
    }

    public Sport(String name, String worldRecord) {
        this.name = name;
        this.worldRecord = worldRecord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWorldRecord() {
        return worldRecord;
    }

    public void setWorldRecord(String worldRecord) {
        this.worldRecord = worldRecord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sport sport = (Sport) o;
        return Objects.equals(name, sport.name) && Objects.equals(worldRecord, sport.worldRecord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, worldRecord);
    } // creates an int based on some calculation - we want unique values for objects with different state

    @Override
    public String toString() {
        return "Sport{" +
                "name='" + name + '\'' +
                ", worldRecord='" + worldRecord + '\'' +
                '}';
    }
}

package com.jpmc.oly.model;

import java.util.Objects;

public class Player extends Person {

    private int number;

    private Sport sport; // aggregate relationship "has a"

    public Player(){

    }

    public Player(String name, int number, Sport sport){
        super(name); // find a constructor in my super class with matching arguments
        this.number = number;
        this.sport = sport;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Player player = (Player) o;
        return number == player.number && Objects.equals(sport, player.sport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), number, sport);
    }

    @Override
    public String toString() {
        return "Player{" +
                " " + super.toString() +
                "name=" + getName() +
                ", number=" + number +
                ", sport=" + sport +
                '}';
    }
}

package com.techelevator;

abstract class Wall {
    private String name;
    private String color;
    private int areaTotal;

    public Wall(String name, String color) {
        this.name = name;
        this.color = color;
    }

    abstract public int getArea();

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }
}

package com.techelevator;

public class RectangleWall extends Wall {
private int length;
private int height;

    public RectangleWall(String name, String color, int length, int height) {
        super(name, color); //use super when you need to inherit attributes
        this.length = length;
        this.height = height;
    }

    public RectangleWall(String name, String color) { //had to add this constructor so that squareWall could use
        super(name, color); //gets name and color from wall.java
    }

    @Override //use override to use getArea in a different way than u use in wall
    public int getArea() {
        return length*height;
    }

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return getName() + " (" + getLength() + "x" + getHeight() +")" + " rectangle";
    }
}

package com.techelevator;

public class SquareWall extends RectangleWall{

    private int sideLength;

    public SquareWall(String name, String color, int sideLength) {
        super(name, color);
        this.sideLength = sideLength;
    }

    public int getSideLength() {
        return sideLength;
    }
public int getArea(){
        return getSideLength()*getSideLength();
}
    @Override
    public String toString() {
        return getName() + " (" + getSideLength() + "x" + getSideLength() +")" + " square";
    }
}

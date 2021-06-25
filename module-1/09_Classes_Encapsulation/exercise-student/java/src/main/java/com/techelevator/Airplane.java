package com.techelevator;

public class Airplane {
    private String planeNumber;
    private int totalFirstClassSeats;
    private int bookedFirstClassSeats;
    private int totalCoachSeats;
    private int bookedCoachSeats;

    public Airplane(String planeNumber, int totalFirstClassSeats, int totalCoachSeats) {
        this.planeNumber = planeNumber;
        this.totalFirstClassSeats = totalFirstClassSeats;
        this.totalCoachSeats = totalCoachSeats;
    }

    public String getPlaneNumber() {
        return planeNumber;
    }

    public int getTotalFirstClassSeats() {
        return totalFirstClassSeats;
    }

    public int getBookedFirstClassSeats() {
        return bookedFirstClassSeats;
    }

    public int getAvailableFirstClassSeats() {
       int availableFirstClassSeats = totalFirstClassSeats - bookedFirstClassSeats;

        return availableFirstClassSeats;
    }

    public int getTotalCoachSeats() {
        return totalCoachSeats;
    }

    public int getBookedCoachSeats() {
        return bookedCoachSeats;
    }

    public int getAvailableCoachSeats() {
      int  availableCoachSeats = totalCoachSeats - bookedCoachSeats;
        return availableCoachSeats;
    }

    public boolean reserveSeats(boolean forFirstClass, int totalNumberOfSeats) {
        if (forFirstClass ) { //totalnumberof
            if(totalNumberOfSeats <= getAvailableFirstClassSeats()) {
                bookedFirstClassSeats = bookedFirstClassSeats + totalNumberOfSeats;
                return true;
            }
        }
        else if(!forFirstClass){
            if(totalNumberOfSeats <= getAvailableCoachSeats()) {
                bookedCoachSeats = bookedCoachSeats + totalNumberOfSeats;
                return true;
            }
        }
            return false;

    }
}

package model;

import java.util.Objects;
import java.util.Scanner;


public class Flat {

    public int square;
    public int residents;
    public int countRooms;
    public int number;
    public int floor;
    public int houseNumber;

    public Flat() {
    }

    public Flat(int square, int residents, int countRooms, int number, int floor) {
        this.number = number;
        this.floor = floor;
        this.square = square;
        this.countRooms = countRooms;
        this.residents = residents;
        System.out.println("Flat added successfully with options");
        System.out.println("number              " + this.number);
        System.out.println("floor               " + this.floor);
        System.out.println("square              " + this.square);
        System.out.println("count of rooms      " + this.countRooms);
        System.out.println("residents           " + this.residents);
    }

    public int getSquare() {
        return this.square;
    }

    public void setSquare(int square) {
        this.square = square;
    }

    public int getResidents() {
        return this.residents;
    }

    public void setResidents(int roomer) {
        this.residents = roomer;
    }

    public int getCountRooms() {
        return this.countRooms;
    }

    public int getHouseNumber(House house) {
        houseNumber = house.getNumber();
        return houseNumber;
    }

    public void setCountRooms(int countRooms) {
        this.countRooms = countRooms;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getFloor() {
        return this.floor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            model.Flat flat = (model.Flat) o;
            return this.square == flat.square && this.residents == flat.residents && this.countRooms == flat.countRooms;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.square, this.residents, this.countRooms);
    }

}

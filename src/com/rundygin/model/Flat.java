package model;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.Scanner;

public class Flat {

    public int square;
    public int residents;
    public int countRooms;
    public int number;
    public int floor;

    public Flat() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter flat number,please :)");
        this.number = input.nextInt();
        System.out.println("Enter floor number,please :)");
        this.floor = input.nextInt();
        System.out.println("Enter square,please :)");
        this.square = input.nextInt();
        System.out.println("Enter count of rooms,please :)");
        this.countRooms = input.nextInt();
        System.out.println("Enter count of residents,please :)");
        this.residents = input.nextInt();
        System.out.println("Flat added successfully with options");
        System.out.println("number              " + this.number);
        System.out.println("floor               " + this.floor);
        System.out.println("square              " + this.square);
        System.out.println("count of rooms      " + this.countRooms);
        System.out.println("residents           " + this.residents);
    }

    public Flat(House house) {
        this.number = (int) (1 + Math.random() * 100);
        this.floor = (int) (1 + Math.random() * house.floorCount);
        this.square = (int) (1 + Math.random() * 30);
        this.countRooms = (int) (1 + Math.random() * 5);
        this.residents = (int) (1 + Math.random() * 5);

        System.out.println("Flat added successfully with options");
        System.out.println("number            " + this.number);
        System.out.println("floor             " + this.floor);
        System.out.println("square            " + this.square);
        System.out.println("count of rooms    " + this.countRooms);
        System.out.println("residents         " + this.residents);

    }

    public Flat(String empty) {
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

package builders;

import model.Flat;
import model.House;

import java.util.Scanner;

public class FlatBuilder {

    public int square;
    public int residents;
    public int countRooms;
    public int number;
    public int floor;

    public void setSquare(int square) {
        this.square = square;
    }

    public void setResidents(int roomer) {
        this.residents = roomer;
    }

    public void setCountRooms(int countRooms) {
        this.countRooms = countRooms;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public static Flat flatEmpty(){
        return new Flat();
    }

    public static Flat flatDefault(int square, int residents, int countRooms, int number, int floor) {
        return new Flat(square, residents, countRooms, number, floor);
    }

    public static Flat flatAuto(House house) {
        int number = (int) (1 + Math.random() * 100);
        int floor = (int) (1 + Math.random() * house.floorCount);
        int square = (int) (1 + Math.random() * 30);
        int countRooms = (int) (1 + Math.random() * 5);
        int residents = (int) (1 + Math.random() * 5);
        return new Flat(square, residents, countRooms, number, floor);
    }
}

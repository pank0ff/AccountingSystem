package model;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import static builders.FlatBuilder.*;

import static builders.HouseBuilder.*;

public class House {

    public int number;
    public int flatCount;
    public int floorCount;
    protected int square;
    protected  int residents;
    protected ArrayList<Flat> flats = new ArrayList<>();

    public House(){
     }
    public House(int number, int flatCount, int floorCount) {
        this.number = number;
        this.flatCount = flatCount;
        this.floorCount = floorCount;
        System.out.println("House added successfully with options");
        System.out.println("number              " + this.number);
        System.out.println("flat count          " + this.flatCount);
        System.out.println("floor count         " + this.floorCount);
    }

    public Flat getFlat(int number) {
        for (Flat i : flats) {
            if (i.getNumber() == number) {
                return i;
            }
        }
        Flat temp = flatEmpty();
        temp.setNumber(-1);
        return temp;
    }

    public void removeFlat(Flat temp) {
        flats.remove(temp);
    }

    public void addFlat(Flat newFlat) {
        flats.add(newFlat);
    }

    public int getResidents() {
        return residents;
    }

    public void setResidents(int residents) {
        this.residents = residents;
    }

    public int getSquare() {
        return square;
    }

    public void setSquare(int square) {
        this.square = square;
    }

    public int getNumber() {
        return number;
    }

    public int getFlatCount() {
        return flatCount;
    }

    public void setFlatCount(int flatCount) {
        this.flatCount = flatCount;
    }

    public int getFloorCount() {
        return floorCount;
    }

    public void setFloorCount(int floorCount) {
        this.floorCount = floorCount;
    }

    public ArrayList<Flat> getFlat() {
        return flats;
    }

    public void setFlat(ArrayList<Flat> flat) {
        this.flats = flat;
    }

    public static int countSquare(@NotNull House house) {
        int result = 0;
        for (Flat i : house.getFlat()) {
            result += i.getSquare();
        }
        return result;
    }
    public int calcSquareOfHouse(ArrayList<House> houses, int numberOfHouse){
        double square = 0;
        House house = null;
        for (House i: houses){
            if (i.getNumber() ==numberOfHouse){ house = i;}
        }
        for(int i = 0; i < Objects.requireNonNull(house).flatCount; ++i){
            square += flats.get(i).getSquare();
        }
        return (int) square;
    }
    public int calcNumberOfResidents(ArrayList<House> houses, int numberOfHouse){
        double residents = 0;
        House house = null;
        for (House i: houses){
            if (i.getNumber() ==numberOfHouse){ house = i;}
        }
        for(int i = 0; i < Objects.requireNonNull(house).flatCount; ++i){
            residents += flats.get(i).getResidents();
        }
        return (int) residents;
    }

}

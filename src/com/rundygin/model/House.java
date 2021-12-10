package model;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class House {

    public int number;
    public int flatCount;
    public int floorCount;
    public ArrayList<House> house;
    protected int square;
    protected  int residents;
    protected ArrayList<Flat> flats = new ArrayList<>();

    public House() {
        System.out.println("Enter house number, number of flats, number of floors,please :)");
        Scanner input = new Scanner(System.in);
        this.number = input.nextInt();
        this.flatCount = input.nextInt();
        this.floorCount = input.nextInt();
        System.out.println("House added successfully with options");
        System.out.println("number              " + this.number);
        System.out.println("flat count          " + this.flatCount);
        System.out.println("floor count         " + this.floorCount);

    }

    public House(char q, int number) {
        this.number = number;
        this.flatCount = (int)(1+Math.random()*5);
        this.floorCount = (int)(1+Math.random()*24);
        System.out.println("House added successfully with options");
        System.out.println("number             " + this.number);
        System.out.println("flat count         " + this.flatCount);
        System.out.println("floor count        " + this.floorCount);

    }

    public House(String s) {

    }

    public House(int number) {
        System.out.println("Enter the number of house,please :)");
        this.number = number;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter count of flats,please :)");
        this.flatCount = input.nextInt();
        System.out.println("Enter count of floor,please :)");
        this.floorCount = input.nextInt();
    }

    public Flat getFlat(int number) {
        for (Flat i : flats) {
            if (i.getNumber() == number) {
                return i;
            }
        }
        Flat temp = new Flat("empty");
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

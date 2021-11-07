import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Scanner;

public class House {

    protected int number;
    protected int flatCount;
    protected int floorCount;
    public ArrayList<Flat> flats = new ArrayList<>();

    public House() {
        System.out.println("Enter house number, number of flats, number of floors");
        Scanner input = new Scanner(System.in);
        this.number = input.nextInt();
        this.flatCount = input.nextInt();
        this.floorCount = input.nextInt();
        System.out.println("House added successfully with options");
        System.out.println("number -              " + this.number);
        System.out.println("flat count -          " + this.flatCount);
        System.out.println("floor count -         " + this.floorCount);

    }

    public House(char q, int number) {
        this.number = number;
        this.flatCount = (int)(1+Math.random()*5);
        this.floorCount = (int)(1+Math.random()*24);
        System.out.println("House added successfully with options");
        System.out.println("number -              " + this.number);
        System.out.println("flat count -          " + this.flatCount);
        System.out.println("floor count -         " + this.floorCount);

    }

    public House(String s) {

     }

    public House(int number) {
        System.out.println("Enter the number of flats, number of floors");
        this.number = number;
        Scanner input = new Scanner(System.in);
        this.flatCount = input.nextInt();
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

    public static int countSquare(@NotNull House house) {
        int result = 0;
        for (Flat i : house.getFlat()) {
            result += i.getSquare();
        }
        return result;
    }

    public String getComparison(int x, int y) {
        switch (Integer.compare(x,y)) {
            case 1 -> {
                return ">";
            }
            case 0 -> {
                return "=";
            }
            case -1 -> {
                return "<";
            }
        }
        return "";
    }

    public void compareBy(@NotNull House house) {
        System.out.println("House№1      House№2");
        String sign = new String("");

        System.out.println("Number");
        sign = getComparison(this.number, house.number);
        System.out.println("     " + sign);

        System.out.println("Number of flats");
        sign = getComparison(this.flatCount, house.flatCount);
        System.out.println("     " + sign);

        System.out.println("Number of floors");
        sign = getComparison(this.floorCount, house.floorCount);
        System.out.println("     " + sign);

        int sqareOne = countSquare(this);
        int sqareTwo = countSquare(house);
        System.out.println("Total area");
        sign = getComparison(sqareOne,sqareTwo);
        System.out.println("     " + sign);
    }

    public void removeFlat(Flat temp) {
        flats.remove(temp);
    }

    public void addFlat(Flat newFlat) {
        flats.add(newFlat);
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
}
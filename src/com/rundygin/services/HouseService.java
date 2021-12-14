package services;

import model.House;
import org.jetbrains.annotations.NotNull;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class HouseService extends House {


    public static String getComparison(int x, int y) {
        switch (Integer.compare(x, y)) {
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

    public static boolean compareBy(@NotNull House house1, House house2) {
        System.out.println("House№1      House№2");
        String sign = new String("");

        System.out.println("Number");
        sign = getComparison(house1.number, house2.number);
        System.out.println("     " + sign);

        System.out.println("Number of flats");
        sign = getComparison(house1.flatCount, house2.flatCount);
        System.out.println("     " + sign);

        System.out.println("Number of floors");
        sign = getComparison(house1.floorCount, house2.floorCount);
        System.out.println("     " + sign);

        int squareOne = countSquare(house1);
        int squareTwo = countSquare(house2);
        System.out.println("Total area");
        sign = getComparison(squareOne, squareTwo);
        System.out.println("     " + sign);
        try {
            FileWriter fileWriter = new FileWriter("log.txt",true);
            Date date = new Date();
            fileWriter.write(date+"\n"+"comparison of houses numbered " + house1.getNumber() +" and " + house2.getNumber()+" was successful\n");
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public int calcSquareOfHouse(ArrayList<House> houses, int numberOfHouse) {
        double square = 0;
        House house = null;
        for (House i : houses) {
            if (i.getNumber() == numberOfHouse) {
                house = i;
            }
        }
        for (int i = 0; i < Objects.requireNonNull(house).flatCount; ++i) {
            square += flats.get(i).getSquare();
        }
        return (int) square;
    }

    public int calcNumberOfResidents(ArrayList<House> houses, int numberOfHouse) {
        double residents = 0;
        House house = null;
        for (House i : houses) {
            if (i.getNumber() == numberOfHouse) {
                house = i;
            }
        }
        for (int i = 0; i < Objects.requireNonNull(house).flatCount; ++i) {
            residents += flats.get(i).getResidents();
        }
        return (int) residents;
    }


}

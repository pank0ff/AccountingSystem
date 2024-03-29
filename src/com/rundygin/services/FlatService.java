package services;

import model.Flat;
import org.jetbrains.annotations.NotNull;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class FlatService extends model.Flat {

    public static String getSign(int x, int y) {
        return switch (Integer.compare(x, y)) {
            case -1 -> "<";
            case 0 -> "=";
            case 1 -> ">";
            default -> "";
        };
    }

    public static void printCompareResult(String sign, Flat flat1, int flatNumber) {
        System.out.println("flat" + flat1.number + sign + "flat" + flatNumber);
    }

    public static boolean compareBy( Flat flat1, Flat flat2) {
        new String("");
        System.out.println("Square :");
        String sign = getSign(flat1.square, flat2.square);
        printCompareResult(sign, flat1, flat2.number);
        System.out.println("Number of residents:");
        sign = getSign(flat1.residents, flat2.residents);
        printCompareResult(sign, flat1, flat2.number);
        System.out.println("Number of rooms:");
        sign = getSign(flat1.countRooms, flat2.countRooms);
        printCompareResult(sign, flat1, flat2.number);
        System.out.println("Flat number:");
        sign = getSign(flat1.number, flat2.number);
        printCompareResult(sign, flat1, flat2.number);
        System.out.println("Floor:");
        sign = getSign(flat1.floor, flat2.floor);
        printCompareResult(sign, flat1, flat2.number);
        try {
            FileWriter fileWriter = new FileWriter("log.txt",true);
            Date date = new Date();
            fileWriter.write("\n"+date+"\n"+"comparison of flats numbered " + flat1.getNumber() +" and " + flat2.getNumber()+" was successful\n");
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static void printInfo(Flat flat) {
        System.out.println("Information about the flat:");
        System.out.println("room                 " + flat.getNumber());
        System.out.println("square               " + flat.getSquare());
        System.out.println("number of residents  " + flat.getResidents());
        System.out.println("number of rooms      " + flat.getCountRooms());
        System.out.println("floor                " + flat.getFloor());
    }

}

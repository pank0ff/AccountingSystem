import java.util.Objects;
import java.util.Scanner;

public class Flat {
    private int square;  // площадь
    private int residents; // количество жильцов
    private int countRooms; // количество комнат
    private int number; // номер квартиры
    private int floor; // этаж

    public Flat() {
        Scanner input = new Scanner(System.in);
        System.out.println("enter flat number, floor, area, number of rooms, number of residents, \n");
        this.number = input.nextInt();
        this.floor = input.nextInt();
        this.square = input.nextInt();
        this.countRooms = input.nextInt();
        this.residents = input.nextInt();
    }

    Flat(String empty) {
    }

    public String getSign(int x, int y) {

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

    public void printCompareResult(String sign, int flatNumber) {
        System.out.println("flat" + this.number + sign + "flat" + flatNumber);
    }

    public void compareBy(@org.jetbrains.annotations.NotNull Flat flat) {

        String sign = new String("");

        System.out.println("Square :");
        sign = getSign(this.square, flat.square);
        printCompareResult(sign, flat.number);

        System.out.println("Number of residents");
        sign = getSign(this.residents, flat.residents);
        printCompareResult(sign, flat.number);

        System.out.println("Number of rooms");
        sign = getSign(this.countRooms, flat.countRooms);
        printCompareResult(sign, flat.number);

        System.out.println("Flat number");
        sign = getSign(this.number, flat.number);
        printCompareResult(sign, flat.number);

        System.out.println("Floor");
        sign = getSign(this.floor, flat.floor);
        printCompareResult(sign, flat.number);

    }

    public void printInfo() {
        System.out.println("Information about the flat:");
        System.out.println("room              - " + this.getNumber());
        System.out.println("square            - " + this.getSquare());
        System.out.println("number of residents - " + this.getResidents());
        System.out.println("number of rooms  - " + this.getCountRooms());
        System.out.println("floor               - " + this.getFloor());
    }

    public int getSquare() {
        return square;
    }

    public void setSquare(int square) {
        this.square = square;
    }

    public int getResidents() {
        return residents;
    }

    public void setResidents(int roomer) {
        this.residents = roomer;
    }

    public int getCountRooms() {
        return countRooms;
    }

    public void setCountRooms(int countRooms) {
        this.countRooms = countRooms;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getFloor() {
        return floor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flat flat = (Flat) o;
        return square == flat.square && residents == flat.residents && countRooms == flat.countRooms;
    }

    @Override
    public int hashCode() {
        return Objects.hash(square, residents, countRooms);
    }
}
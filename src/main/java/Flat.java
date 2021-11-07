import java.util.Objects;
import java.util.Scanner;
import org.jetbrains.annotations.NotNull;

public class Flat {
    private int square;
    private int residents;
    private int countRooms;
    private int number;
    private int floor;

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
        return switch (Integer.compare(x, y)) {
            case -1 -> "<";
            case 0 -> "=";
            case 1 -> ">";
            default -> "";
        };
    }

    public void printCompareResult(String sign, int flatNumber) {
        System.out.println("flat" + this.number + sign + "flat" + flatNumber);
    }

    public void compareBy(@NotNull Flat flat) {
        new String("");
        System.out.println("Square :");
        String sign = this.getSign(this.square, flat.square);
        this.printCompareResult(sign, flat.number);
        System.out.println("Number of residents:");
        sign = this.getSign(this.residents, flat.residents);
        this.printCompareResult(sign, flat.number);
        System.out.println("Number of rooms:");
        sign = this.getSign(this.countRooms, flat.countRooms);
        this.printCompareResult(sign, flat.number);
        System.out.println("Flat number:");
        sign = this.getSign(this.number, flat.number);
        this.printCompareResult(sign, flat.number);
        System.out.println("Floor:");
        sign = this.getSign(this.floor, flat.floor);
        this.printCompareResult(sign, flat.number);
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
            Flat flat = (Flat)o;
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

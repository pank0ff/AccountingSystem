package builders;

import model.Flat;
import model.House;

import java.util.ArrayList;

public class HouseBuilder {
    public int number;
    public int flatCount;
    public int floorCount;
    protected int square;
    protected  int residents;
    protected ArrayList<Flat> flats = new ArrayList<>();

    public void getNumber(int number){this.number =number;}

    public void setResidents(int residents) {
        this.residents = residents;
    }

    public void setSquare(int square) {
        this.square = square;
    }

    public void setFlatCount(int flatCount) {
        this.flatCount = flatCount;
    }

    public void setFloorCount(int floorCount) {
        this.floorCount = floorCount;
    }

    public void setFlat(ArrayList<Flat> flat) {
        this.flats = flat;
    }

    public static House houseDefault(int number, int flatCount, int floorCount ){
        return new House(number,flatCount,floorCount);
    }

    public static House houseAuto(int number1) {
        int flatCount = (int)(1+Math.random()*5);
        int floorCount = (int)(1+Math.random()*24);
        return  new House(number1,flatCount,floorCount);
    }
    public static House houseEmpty(){
        return new House();
    }
}

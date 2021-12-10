package accountingSystem;
import builders.HouseBuilder;
import model.Flat;
import model.House;
import org.jetbrains.annotations.NotNull;
import services.FlatService;
import services.HouseService;

import java.util.Scanner;
import java.util.*;

import static builders.FlatBuilder.*;
import static builders.HouseBuilder.*;

public class AccountingSystem {
    public final ArrayList<House> house = new ArrayList<>();

    Scanner input = new Scanner(System.in);
    public House findHouseByNumber(int number) {
        for (House i : house) {
            if (i.getNumber() == number) {
                return  i;
            }
        }
        HouseBuilder.houseEmpty().setFlatCount(-1);
        return  HouseBuilder.houseEmpty();
    }

    public void addEmptyHouse(int numberOfHouse,int flatCount,int floorCount) {
        for (House i : this.house) {
            if (i.getNumber() == numberOfHouse) {
                System.out.println("A house with this number exists :(");
                return;
            }
        }
        House house = houseDefault(numberOfHouse,flatCount,floorCount);
        this.house.add(house);
        System.out.println("House added successfully :)");
    }

    public void addHouseAutomatically() {
        int numberOfHouse = (int) (1 + Math.random() * 10+Math.random()*10+Math.random()*5);
        for (House i : this.house) {
            if (i.getNumber() == numberOfHouse) {
                System.out.println("A house with this number exists :(");
                return;
            }
        }
        House house = houseAuto(numberOfHouse);
        this.house.add(house);
        for (int i = 0; i <house.flatCount; i++) {
            addFlatAutomatically(numberOfHouse);
        }
    }

    public void addFlat(int numberOfHouse,int square,int residents,int countRooms,int number,int floor) {
        House temp = findHouseByNumber(numberOfHouse);
        if (temp.getFlatCount() == -1) {
            System.out.println("There is no house with this number. :(");
        } else {
            Flat tempFlat = flatDefault(square, residents, countRooms, number, floor);
            temp.addFlat(tempFlat);
            System.out.println("in " + numberOfHouse + " house");
        }
    }

    public void addFlatAutomatically(int numberOfHouse) {
        House temp = findHouseByNumber(numberOfHouse);
        int number = 0;
        for (House i : this.house) {
            if (i.getNumber() == numberOfHouse) {
                break;
            }
            number++;
        }
        House house = this.house.get(number);

        if (temp.getFlatCount() == -1) {
            System.out.println("There is no house with this number. :(");
        } else {
            Flat tempFlat = flatAuto(house);
            temp.addFlat(tempFlat);
            System.out.println("Flat added successfully :)");
        }
    }

    public void removeHouse(int numberOfHouse) {
        House temp = findHouseByNumber(numberOfHouse);
        if (temp.getFlatCount() == -1) {
            System.out.println("There is no such house :(");
            return;
        }
        house.remove(temp);
    }

    public void removeFlat(int numberOfHouse, int numberOfFlat) {
        House temp = findHouseByNumber(numberOfHouse);
        if (temp.getFlatCount() == -1) {
            System.out.println("There is no such house :(");
            return;
        }
        Flat temp1 = findFlatByNumber(temp, numberOfFlat);
        if (temp1.getNumber() == -1) {
            System.out.println("There is no such flat :(");
            return;
        }
        temp.removeFlat(temp1);
    }

    public void compareFlat(int numberOfHouse1, int numberOfHouse2, int numberOfFlat1, int numberOfFlat2) {

        House house1 = findHouseByNumber(numberOfHouse1);
        if (house1.getFlatCount() == -1) {
            System.out.println("There is no such house :(");
            return;
        }
        Flat flat1 = findFlatByNumber(house1, numberOfFlat1);
        if (flat1.getNumber() == -1) {
            System.out.println("There is no such flat :(");
            return;
        }
        House house2 = findHouseByNumber(numberOfHouse2);
        if (house2.getFlatCount() == -1) {
            System.out.println("There is no such house :(");
            return;
        }
        Flat flat2 =  findFlatByNumber(house2, numberOfFlat2);
        if (flat2.getNumber() == -1) {
            System.out.println("There is no such flat :(");
            return;
        }
        FlatService.compareBy(flat1,flat2);
    }

    public void compareHouse(int numberOfHouseOne, int numberOfHouseTwo) {
        House houseOne =  findHouseByNumber(numberOfHouseOne);
        if (houseOne.getFlatCount() == -1) {
            System.out.println("This house does not exist :(");
            return;
        }
        House houseTwo = findHouseByNumber(numberOfHouseTwo);
        if (houseTwo.getFlatCount() == -1) {
            System.out.println("This house does not exist :(");
            return;
        }
        HouseService.compareBy(houseOne,houseTwo);
    }

    public Flat findFlatByNumber(@NotNull House house, int number) {
        for (Flat i : house.getFlat()) {
            if (i.getNumber() == number) {
                return  i;
            }
        }
        Flat temp = new Flat();
        temp.setNumber(-1);
        return temp;
    }

    public void getFlatInformation(int numberOfHome, int numberOfApartment) {
        House temp = findHouseByNumber(numberOfHome);
        if (temp.getFlatCount() == -1) {
            System.out.println("There is no such house :(");
            return;
        }
        Flat temp2 =  temp.getFlat(numberOfApartment);
        if (temp.getNumber() == -1) {
            System.out.println("Such an flat does not exist :(");
            return;
        }
        FlatService.printInfo(temp2);
    }

    public void getHouseInformation(int number) {
        House temp =  findHouseByNumber(number);
        if (temp.getFlatCount() == -1) {
            System.out.println("There is no such house :(");
            return;
        }
        for (Flat i : temp.getFlat()) {
            FlatService.printInfo(i);
        }
        int square = temp.calcSquareOfHouse(house, number);
        int numberOfResidents = temp.calcNumberOfResidents(house, number);
        int countFloor = temp.floorCount;
        System.out.println("Total area of the house    " + square);
        System.out.println("Total number of residents  " + numberOfResidents);
        System.out.println("Number of floors           " + countFloor);
        if (temp.getFlat().size() == 0) {
            System.out.println("There are no flats in the house :(");
        }
    }

    public void changeFlat() {
        if(house.size()!=0) {
            int index1 = 0;
            int index2 = 0;
            int index3 = 0;
            int index0 = 0;
            System.out.print("Enter the house number, please :) ");
            int index11 = input.nextInt();;
            while (index11 <= 0) {
                System.out.print("There are no such ");
                index11 = input.nextInt();
            }

            for (House i : house){
                if (i.getNumber() == index11){
                    break;
                }
                index0++;
            }
            System.out.print("\nEnter the apartment , please :) ");
            index1 =  input.nextInt();


            System.out.print("\nEnter a new area, please :) ");
            index2 =  input.nextInt();
            System.out.print("\nEnter the number of new residents , please :)");
            index3 =  input.nextInt();

            house.get(index0).getFlat(index1).setSquare(index2);
            house.get(index0).getFlat(index1).setResidents(index3);

            house.get(index0).setSquare(house.get(index0).calcSquareOfHouse(house,index11));
            house.get(index0).setResidents(house.get(index0 ).calcNumberOfResidents(house,index11));
        }
        else  System.out.println("empty :(\n");
    }
}


package accountingSystem;

import builders.HouseBuilder;
import model.Flat;
import model.House;
import org.jetbrains.annotations.NotNull;
import services.FlatService;
import services.HouseService;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.*;

import static builders.FlatBuilder.*;
import static builders.HouseBuilder.*;

public class AccountingSystem {
    public static final ArrayList<House> house = new ArrayList<>();

    Scanner input = new Scanner(System.in);

    public static House findHouseByNumber(int number) {
        for (House i : house) {
            if (i.getNumber() == number) {
                try {
                    FileWriter fileWriter = new FileWriter("log.txt",true);
                    Date date = new Date();
                    fileWriter.write("\n"+date+"\n"+"The house with the number " + number + " was found.\n");
                    fileWriter.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return i;
            }
        }
        HouseBuilder.houseEmpty().setFlatCount(-1);
        try {
            FileWriter fileWriter = new FileWriter("log.txt",true);
            Date date = new Date();
            fileWriter.write("\n"+date+"\n"+"The house with the number " + number + " was not found. An empty house with a number "+HouseBuilder.houseEmpty().getNumber()+" has been created.\n");
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return HouseBuilder.houseEmpty();
    }

    public void addEmptyHouse(int numberOfHouse, int flatCount, int floorCount) {
        for (House i : house) {
            if (i.getNumber() == numberOfHouse) {
                System.out.println("A house with this number exists :(");
                try {
                    FileWriter fileWriter = new FileWriter("log.txt",true);
                    Date date = new Date();
                    fileWriter.write("\n"+date+"\n"+"An attempt to create an empty house, but with number "+numberOfHouse+ " is already there\n");
                    fileWriter.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return;
            }
        }
        House house = houseDefault(numberOfHouse, flatCount, floorCount);
        AccountingSystem.house.add(house);
        try {
            FileWriter fileWriter = new FileWriter("log.txt",true);
            Date date = new Date();
            fileWriter.write("\n"+date+"\n"+"Added empty house with parameters:number - "+numberOfHouse+",flat number - "+flatCount+",floor number - "+floorCount+"\n");
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("House added successfully :)");
    }

    public void addHouseAutomatically() {
        int numberOfHouse = (int) (1 + Math.random() * 10 + Math.random() * 10 + Math.random() * 5);
        for (House i : house) {
            if (i.getNumber() == numberOfHouse) {
                System.out.println("try again :(");
                return;
            }
        }
        House house = houseAuto(numberOfHouse);
        this.house.add(house);
        for (int i = 0; i < house.flatCount; i++) {
            addFlatAutomatically(numberOfHouse);
        }
        try {
            FileWriter fileWriter = new FileWriter("log.txt",true);
            Date date = new Date();
            fileWriter.write("\n"+date+"\n"+"Added auto house with parameters:number - "+numberOfHouse+",flat number - "+house.getFlatCount()+",floor number - "+house.getFloorCount()+"\n");
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addFlat(int numberOfHouse, int square, int residents, int countRooms, int number, int floor) {
        House temp = findHouseByNumber(numberOfHouse);
        if (temp.getFlatCount() == -1) {
            System.out.println("There is no house with this number. :(");
            try {
                FileWriter fileWriter = new FileWriter("log.txt",true);
                Date date = new Date();
                fileWriter.write("\n"+date+"\n"+"An attempt was made to add an apartment, but house number "+numberOfHouse+" does not exist\n");
                fileWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Flat tempFlat = flatDefault(square, residents, countRooms, number, floor);
            temp.addFlat(tempFlat);
            System.out.println("in " + numberOfHouse + " house");
            try {
                FileWriter fileWriter = new FileWriter("log.txt",true);
                Date date = new Date();
                fileWriter.write("\n"+date+"\n"+"Added apartment to house number "+numberOfHouse+" with the following parameters:number of flat - " + tempFlat.getNumber()+",floor - " + tempFlat.getFloor()+",square - "+tempFlat.square+",number of rooms - "+tempFlat.getCountRooms()+",number of residents - " + tempFlat.getResidents()+"\n");
                fileWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void addFlatAutomatically(int numberOfHouse) {
        House temp = findHouseByNumber(numberOfHouse);
        int number = 0;
        for (House i : house) {
            if (i.getNumber() == numberOfHouse) {
                break;
            }
            number++;
        }
        House house = this.house.get(number);

        if (temp.getFlatCount() == -1) {
            System.out.println("There is no house with this number. :(");
            try {
                FileWriter fileWriter = new FileWriter("log.txt",true);
                Date date = new Date();
                fileWriter.write("\n"+date+"\n"+"An attempt to create an auto flat, but with number "+numberOfHouse+ " is not exist\n");
                fileWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Flat tempFlat = flatAuto(house);
            temp.addFlat(tempFlat);
            System.out.println("Flat added successfully :)");
            try {
                FileWriter fileWriter = new FileWriter("log.txt",true);
                Date date = new Date();
                fileWriter.write("\n"+date+"\n"+"Added apartment to house number "+numberOfHouse+" with the following parameters:number of flat - " + tempFlat.getNumber()+",floor - " + tempFlat.getFloor()+",square - "+tempFlat.square+",number of rooms - "+tempFlat.getCountRooms()+",number of residents - " + tempFlat.getResidents()+"\n");
                fileWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void removeHouse(int numberOfHouse) {
        House temp = findHouseByNumber(numberOfHouse);
        if (temp.getFlatCount() == -1) {
            System.out.println("There is no such house :(");
            try {
                FileWriter fileWriter = new FileWriter("log.txt",true);
                Date date = new Date();
                fileWriter.write("\n"+date+"\n"+"An attempt to remove an house, but with number "+numberOfHouse+ " is not exist\n");
                fileWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }
        house.remove(temp);
        try {
            FileWriter fileWriter = new FileWriter("log.txt",true);
            Date date = new Date();
            fileWriter.write("\n"+date+"\n"+"Remove house with number "+numberOfHouse+ "\n");
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void removeFlat(int numberOfHouse, int numberOfFlat) {
        House temp = findHouseByNumber(numberOfHouse);
        if (temp.getFlatCount() == -1) {
            System.out.println("There is no such house :(");
            try {
                FileWriter fileWriter = new FileWriter("log.txt",true);
                Date date = new Date();
                fileWriter.write("\n"+date+"\n"+"An attempt to remove an flat, but with number "+numberOfHouse+ " is not exist\n");
                fileWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }
        Flat temp1 = findFlatByNumber(temp, numberOfFlat);
        if (temp1.getNumber() == -1) {
            System.out.println("There is no such flat :(");
            try {
                FileWriter fileWriter = new FileWriter("log.txt",true);
                Date date = new Date();
                fileWriter.write("\n"+date+"\n"+"An attempt to remove an flat, but flat with number "+numberOfFlat+ " is not exist\n");
                fileWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }
        temp.removeFlat(temp1);
        try {
            FileWriter fileWriter = new FileWriter("log.txt",true);
            Date date = new Date();
            fileWriter.write("\n"+date+"\n"+"Remove flat with number "+temp1.getNumber()+ " in house with number "+numberOfHouse+" \n");
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        Flat flat2 = findFlatByNumber(house2, numberOfFlat2);
        if (flat2.getNumber() == -1) {
            System.out.println("There is no such flat :(");
            return;
        }
        FlatService.compareBy(flat1, flat2);
    }

    public void compareHouse(int numberOfHouseOne, int numberOfHouseTwo) {
        House houseOne = findHouseByNumber(numberOfHouseOne);
        if (houseOne.getFlatCount() == -1) {
            System.out.println("This house does not exist :(");
            return;
        }
        House houseTwo = findHouseByNumber(numberOfHouseTwo);
        if (houseTwo.getFlatCount() == -1) {
            System.out.println("This house does not exist :(");
            return;
        }
        HouseService.compareBy(houseOne, houseTwo);
    }

    public static Flat findFlatByNumber(@NotNull House house, int number) {
        for (Flat i : house.getFlat()) {
            if (i.getNumber() == number) {
                try {
                    FileWriter fileWriter = new FileWriter("log.txt",true);
                    Date date = new Date();
                    fileWriter.write("\n"+date+"\n"+"The flat with the number " + number + " was found.\n");
                    fileWriter.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return i;
            }
        }
        Flat temp = new Flat();
        temp.setNumber(-1);
        try {
            FileWriter fileWriter = new FileWriter("log.txt",true);
            Date date = new Date();
            fileWriter.write("\n"+date+"\n"+"The flat with the number " + number + " was not found. An flat with a number "+temp.getNumber()+" has been created.\n");
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return temp;
    }

    public void getFlatInformation(int numberOfHome, int numberOfApartment) {
        House temp = findHouseByNumber(numberOfHome);
        if (temp.getFlatCount() == -1) {
            System.out.println("There is no such house :(");
            return;
        }
        Flat temp2 = temp.getFlat(numberOfApartment);
        if (temp.getNumber() == -1) {
            System.out.println("Such an flat does not exist :(");
            return;
        }
        FlatService.printInfo(temp2);
    }

    public void getHouseInformation(int number) {
        House temp = findHouseByNumber(number);
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

    public void changeFlat(int houseNumber, int flatNumber, int square, int residentsCount) {
        if (house.size() != 0) {
            int index1 = flatNumber;
            int index2 = square;
            int index3 = residentsCount;
            int index0 = 0;
            int index11 = houseNumber;


            while (index11 <= 0) {
                System.out.print("There are no such ");
                index11 = input.nextInt();
            }
            for (House i : house) {
                if (i.getNumber() == index11) {
                    break;
                }
                index0++;
            }
            int oldSquare = house.get(index0).getFlat(index1).getSquare();
            int oldNumberResidents = house.get(index0).getFlat(index1).getResidents();

            house.get(index0).getFlat(index1).setSquare(index2);
            house.get(index0).getFlat(index1).setResidents(index3);

            house.get(index0).setSquare(house.get(index0).calcSquareOfHouse(house, index11));
            house.get(index0).setResidents(house.get(index0).calcNumberOfResidents(house, index11));
            int areaDifference = Math.abs(index2 - oldSquare);
            int differenceOfResidents = Math.abs(index3 - oldNumberResidents);
            System.out.println("Changes applied");
            System.out.println("New square: " + index2 + ".Square changed to " + areaDifference);
            System.out.println("New number of residents: " + index3 + ".Number of residents changed to " + differenceOfResidents);
            try {
                FileWriter fileWriter = new FileWriter("log.txt",true);
                Date date = new Date();
                fileWriter.write("\n"+date+"\n"+"Flat number "+ index1 +" in house "+index11+" has been changed. Parameters have changed:square - it was: "+oldSquare+",became: "+index2+",number of residents - it was: "+oldNumberResidents+",became: "+index3+"\n");
                fileWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else System.out.println("empty :(\n");
    }
}


import org.jetbrains.annotations.NotNull;

import java.net.HttpURLConnection;
import java.util.*;

public class AccountingSystem {
    public final ArrayList<House> houses = new ArrayList<>();

    public House findHouseByNumber(int number) {
        for (House i : houses) {
            if (i.getNumber() == number) {
                return i;
            }
        }
        House temp = new House("empty");
        temp.setFlatCount(-1);
        return temp;
    }

    public Flat findFlatByNumber(@NotNull House house, int number) {
        for (Flat i : house.getFlat()) {
            if (i.getNumber() == number) {
                return i;
            }
        }
        Flat temp = new Flat("empty");
        temp.setNumber(-1);
        return temp;
    }

    public void addHouse(int number) {
        for (House i : houses) {
            if (i.getNumber() == number) {
                System.out.println("A house with this number exists");
                return;
            }
        }
        House house = new House(number);
        houses.add(house);
        System.out.println("House added successfully");
    }

    public void addFlat(int numberOfHouse) {
        House temp = findHouseByNumber(numberOfHouse);
        if (temp.getFlatCount() == -1) {
            System.out.println("There is no house with this number.");
        } else {
            Flat tempFlat = new Flat();
            temp.addFlat(tempFlat);
            System.out.println("in " + numberOfHouse + " house");
        }
    }

    public void addFlatAutomatically(int numberOfHouse) {
        House temp = findHouseByNumber(numberOfHouse);
        int number = 0;
        for (House i : houses) {
            if (i.getNumber() == numberOfHouse) {
                 break;
            }
            number++;
        }
        House house = houses.get(number); ;
        if (temp.getFlatCount() == -1) {
            System.out.println("There is no house with this number.");
        } else {
            Flat tempFlat = new Flat(house);
            temp.addFlat(tempFlat);
            System.out.println("Flat added successfully");
        }
    }

    public void getFlatInformation(int numberOfHome, int numberOfApartment) {
        House temp = findHouseByNumber(numberOfHome);
        if (temp.getFlatCount() == -1) {
            System.out.println("There is no such house");
            return;
        }
        Flat temp2 = temp.getFlat(numberOfApartment);
        if (temp.getNumber() == -1) {
            System.out.println("Such an flat does not exist");
            return;
        }
        temp2.printInfo();
    }

    public void getHouseInformation(int number) {
        House temp = findHouseByNumber(number);
        if (temp.getFlatCount() == -1) {
            System.out.println("There is no such house");
            return;
        }
        for (Flat i : temp.getFlat()) {
            i.printInfo();
        }
        if (temp.getFlat().size() == 0) {
            System.out.println("There are no flats in the house");
        }
    }

    public void removeHouse(int number) {
        House temp = findHouseByNumber(number);
        if (temp.getFlatCount() == -1) {
            System.out.println("There is no such house");
            return;
        }
        houses.remove(temp);
    }

    public void removeFlat(int numberOfHome, int numberOfApartment) {
        House temp = findHouseByNumber(numberOfHome);
        if (temp.getFlatCount() == -1) {
            System.out.println("There is no such house");
            return;
        }
        Flat temp1 = findFlatByNumber(temp, numberOfApartment);
        if (temp1.getNumber() == -1) {
                System.out.println("There is no such flat");
            return;
        }
        temp.removeFlat(temp1);
    }


    public void compareFlat(int numberOfHouse1, int numberOfHouse2, int numberOfFlat1, int numberOfFlat2) {

        House house1 = findHouseByNumber(numberOfHouse1);
        if (house1.getFlatCount() == -1) {
            System.out.println("There is no such house");
            return;
        }
        Flat flat1 = findFlatByNumber(house1, numberOfFlat1);
        if (flat1.getNumber() == -1) {
            System.out.println("There is no such flat");
            return;
        }
        House house2 = findHouseByNumber(numberOfHouse2);
        if (house2.getFlatCount() == -1) {
            System.out.println("There is no such house");
            return;
        }
        Flat flat2 = findFlatByNumber(house2, numberOfFlat2);
        if (flat2.getNumber() == -1) {
            System.out.println("There is no such flat");
            return;
        }
        flat1.compareBy(flat2);
    }

    public void compareHouse(int numberOfHouseOne, int numberOfHouseTwo) {
        House houseOne = findHouseByNumber(numberOfHouseOne);
        if (houseOne.getFlatCount() == -1) {
            System.out.println("This house does not exist");
            return;
        }
        House houseTwo = findHouseByNumber(numberOfHouseTwo);
        if (houseTwo.getFlatCount() == -1) {
            System.out.println("This house does not exist");
            return;
        }
        houseOne.compareBy(houseTwo);
    }
}
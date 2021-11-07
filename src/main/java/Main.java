import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Choose an action");
        System.out.println("1 - add house");
        System.out.println("2 - add flat");
        System.out.println("3 - add flat automatically");
        System.out.println("4 - add house with flats automatically");
        System.out.println("5 - change flat options");
        System.out.println("6 - delete house");
        System.out.println("7 - delete flat");
        System.out.println("8 - compare houses");
        System.out.println("9 - compare flats");
        System.out.println("10 - get information about the house");
        System.out.println("11 - get information about the flat");
        System.out.println("12 - exit the program");


        boolean isAllGood = true;
        AccountingSystem accountingSystem = new AccountingSystem();
        Scanner input = new Scanner(System.in);
        while (isAllGood) {
            System.out.println("Choose an action");
            int numberOfYourChoice = input.nextInt();
            switch (numberOfYourChoice) {
                case 1 -> {
                    System.out.println("enter house number");
                    int number = input.nextInt();
                    accountingSystem.addHouse(number);

                }
                case 2 -> {
                    System.out.println("Enter the house number to which you want to add the flat");
                    int number = input.nextInt();
                    accountingSystem.addFlat(number);
                }

                case 3 -> {
                    System.out.println("Enter the house number to which you want to add the flat");
                    int number = input.nextInt();
                    accountingSystem.addFlatAutomatically(number);
                }

                case 4 -> {
                    accountingSystem.addHouseAutomatically();
                }
                case 5 -> {
                    accountingSystem.changeFlat();
                }
                case 6 -> {
                    System.out.println("Enter house number");
                    accountingSystem.removeHouse(input.nextInt());
                }
                case 7 -> {
                    System.out.println("Enter the house and flat number");
                accountingSystem.removeFlat(input.nextInt(),input.nextInt());
                }
                case 8 -> {
                    System.out.println("Enter the house number of the first house ");
                    int numberOfHouseOne = input.nextInt();
                    System.out.println("Enter the house number of the second house");
                    int numberOfHouseTwo = input.nextInt();
                    accountingSystem.compareHouse(numberOfHouseOne,numberOfHouseTwo);
                }
                case 9 -> {
                    System.out.println("Enter the house and flat number");
                    int numberOfHouse1 = input.nextInt();
                    int numberOfFlat1 = input.nextInt();
                    System.out.println("Enter the house and flat number");
                    int numberOfHouse2 = input.nextInt();
                    int numberOfFlat2 = input.nextInt();
                    accountingSystem.compareFlat(numberOfHouse1,numberOfHouse2,numberOfFlat1,numberOfFlat2);
                }
                case 10 -> {
                    System.out.println("Enter house number");
                    accountingSystem.getHouseInformation(input.nextInt());
                }
                case 11 -> {
                    System.out.println("Enter the house and flat number");
                    accountingSystem.getFlatInformation(input.nextInt(), input.nextInt());
                }
                case 12 -> {
                    isAllGood = false;
                }
            }
        }
    }
}
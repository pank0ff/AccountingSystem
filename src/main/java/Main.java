import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hey! Press 1 if you want to see the functionality. Press 0 if you want to close the program.");
        boolean isAllGood = true;
        AccountingSystem accountingSystem = new AccountingSystem();
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        switch (choice)
        {
            case  0 -> {System.out.println("Bye,Bye!");}
            case  1 -> { while (isAllGood) {
                System.out.println("Press 1 if you want to add a house");
                System.out.println("Press 2 if you want to create an flat");
                System.out.println("Press 3 if you want to create an flat automatically (all parameters will be entered randomly)");
                System.out.println("Press 4 if you want to create a house automatically (all parameters will be entered randomly, flats will also be randomly added)");
                System.out.println("Press 5 if you want to change flat options");
                System.out.println("Press 6 if you want to delete the house");
                System.out.println("Press 7 if you want to delete an flat");
                System.out.println("Press 8 if you want to compare houses (by number, by the number of flats, by the number of floors, by the total area)");
                System.out.println("Press 9 if you want to compare flats (by area, number of residents, number of rooms, apartment number, floor number)");
                System.out.println("Press 10 if you want to get information on the desired house");
                System.out.println("Press 11 if you want to get information on the desired flat");
                System.out.println("Press 12 if you want to leave us :((((");
                System.out.println("Choose an action");
                int numberOfYourChoice = input.nextInt();
                switch (numberOfYourChoice) {
                    case 1 -> {
                        System.out.println("enter house number,please :)");
                        int number = input.nextInt();
                        accountingSystem.addHouse(number);

                    }
                    case 2 -> {
                        System.out.println("Enter the house number to which you want to add the flat,please :)");
                        int number = input.nextInt();
                        accountingSystem.addFlat(number);
                    }

                    case 3 -> {
                        System.out.println("Enter the house number to which you want to add the flat,please :)");
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
                        System.out.println("Enter house number,please :)");
                        accountingSystem.removeHouse(input.nextInt());
                    }
                    case 7 -> {
                        System.out.println("Enter the house and flat number,please :)");
                        accountingSystem.removeFlat(input.nextInt(),input.nextInt());
                    }
                    case 8 -> {
                        System.out.println("Enter the house number of the first house ,please :)");
                        int numberOfHouseOne = input.nextInt();
                        System.out.println("Enter the house number of the second house,please :)");
                        int numberOfHouseTwo = input.nextInt();
                        accountingSystem.compareHouse(numberOfHouseOne,numberOfHouseTwo);
                    }
                    case 9 -> {
                        System.out.println("Enter the house and flat number,please :)");
                        int numberOfHouse1 = input.nextInt();
                        int numberOfFlat1 = input.nextInt();
                        System.out.println("Enter the house and flat number,please :)");
                        int numberOfHouse2 = input.nextInt();
                        int numberOfFlat2 = input.nextInt();
                        accountingSystem.compareFlat(numberOfHouse1,numberOfHouse2,numberOfFlat1,numberOfFlat2);
                    }
                    case 10 -> {
                        System.out.println("Enter house number,please :)");
                        accountingSystem.getHouseInformation(input.nextInt());
                    }
                    case 11 -> {
                        System.out.println("Enter the house and flat number,please :)");
                        accountingSystem.getFlatInformation(input.nextInt(), input.nextInt());
                    }
                    case 12 -> {
                        isAllGood = false;
                    }
                    default -> System.out.println("You entered a non-existent command, unfortunately, we cannot help you in any way :((((");
                }
            }
            }
            default -> System.out.println("You entered a non-existent command, unfortunately, we cannot help you in any way :((((");
        }

    }
}
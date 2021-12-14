package interfaces;

import accountingSystem.AccountingSystem;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class UserInterface {

    private static final String USER_MENU = """
               Press 1 if you want to add a house
               Press 2 if you want to create an flat
               Press 3 if you want to create an flat automatically (all parameters will be entered randomly)
               Press 4 if you want to create a house automatically (all parameters will be entered randomly, flats will also be randomly added)
               Press 5 if you want to change flat options
               Press 6 if you want to delete the house
               Press 7 if you want to delete an flat
               Press 8 if you want to compare houses (by number, by the number of flats, by the number of floors, by the total area)
               Press 9 if you want to compare flats (by area, number of residents, number of rooms, apartment number, floor number)
               Press 10 if you want to get information on the desired house
               Press 11 if you want to get information on the desired flat
               Press 12 if you want to see the menu
               Press 13 if you want to leave us :((((
            """;

    public void showMenu() {
        System.out.println(USER_MENU);
    }

    public void handleQuery() {
        System.out.println("Hey! Press 1 if you want to see the functionality. Press 0 if you want to close the program.");
        boolean isAllGood = true;
        AccountingSystem accountingSystem = new AccountingSystem();
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        switch (choice) {
            case 0 -> {
                System.out.println("Bye,Bye!");
            }
            case 1 -> {
                showMenu();
                while (isAllGood) {
                    int numberOfYourChoice = input.nextInt();
                    switch (numberOfYourChoice) {
                        case 1 -> {
                            System.out.println("enter house number,please :)");
                            int number = input.nextInt();
                            System.out.println("Enter number of flats, number of floors,please :)");
                            int flatCount = input.nextInt();
                            int floorCount = input.nextInt();
                            accountingSystem.addEmptyHouse(number, flatCount, floorCount);

                        }
                        case 2 -> {
                            System.out.println("Enter the house number to which you want to add the flat,please :)");
                            int number = input.nextInt();
                            System.out.println("Enter flat number,please :)");
                            int flatNumber = input.nextInt();
                            System.out.println("Enter floor number,please :)");
                            int floor = input.nextInt();
                            System.out.println("Enter square,please :)");
                            int square = input.nextInt();
                            System.out.println("Enter count of rooms,please :)");
                            int countRooms = input.nextInt();
                            System.out.println("Enter count of residents,please :)");
                            int residents = input.nextInt();
                            accountingSystem.addFlat(number, square, residents, countRooms, flatNumber, floor);
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
                            System.out.print("Enter the house number, please :) ");
                            int houseNumber = input.nextInt();
                            System.out.print("\nEnter the flat , please :) ");
                            int flatNumber = input.nextInt();
                            System.out.print("\nEnter a new square, please :) ");
                            int square = input.nextInt();
                            System.out.print("\nEnter the number of new residents , please :)");
                            int residentsCount = input.nextInt();
                            accountingSystem.changeFlat(houseNumber,flatNumber,square,residentsCount);
                        }
                        case 6 -> {
                            System.out.println("Enter house number,please :)");
                            accountingSystem.removeHouse(input.nextInt());
                        }
                        case 7 -> {
                            System.out.println("Enter the house and flat number,please :)");
                            accountingSystem.removeFlat(input.nextInt(), input.nextInt());
                        }
                        case 8 -> {
                            System.out.println("Enter the house number of the first house ,please :)");
                            int numberOfHouseOne = input.nextInt();
                            System.out.println("Enter the house number of the second house,please :)");
                            int numberOfHouseTwo = input.nextInt();
                            accountingSystem.compareHouse(numberOfHouseOne, numberOfHouseTwo);
                        }
                        case 9 -> {
                            System.out.println("Enter the house and flat number,please :)");
                            int numberOfHouse1 = input.nextInt();
                            int numberOfFlat1 = input.nextInt();
                            System.out.println("Enter the house and flat number,please :)");
                            int numberOfHouse2 = input.nextInt();
                            int numberOfFlat2 = input.nextInt();
                            accountingSystem.compareFlat(numberOfHouse1, numberOfHouse2, numberOfFlat1, numberOfFlat2);
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
                            showMenu();
                        }
                        case 13 -> {
                            try {
                                FileWriter fileWriter = new FileWriter("log.txt",true);
                                Date date = new Date();
                                fileWriter.write(date+"\n"+"EXIT THE APPLICATION \n\n");
                                fileWriter.flush();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
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

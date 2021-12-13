import accountingSystem.AccountingSystem;
import model.Flat;
import model.House;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.rules.ExpectedException;
import services.HouseService;

import java.util.ArrayList;

import static model.House.countSquare;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static services.FlatService.compareBy;

public class HouseServiceTest {
   @Test
    public void calcSquareOfHouse(){
       House house = new House(1,1,1);
       Flat flat = new Flat(1,1,1,1,1);
       house.addFlat(flat);
       int square = countSquare(house);
       assertEquals(1,square);
   }

    @Test
    public  void compare(){
        House house1 = new House(1,1,1);
        Flat flat1 = new Flat(1,1,1,1,1);
        house1.addFlat(flat1);
        House house2 = new House(1,1,1);
        Flat flat2 = new Flat(1,1,1,1,1);
        house2.addFlat(flat2);
        boolean actualCompare = HouseService.compareBy(house1, house2);
        Assertions.assertTrue(actualCompare);
    }

    @Test
    public  void addEmptyHouse(){
        AccountingSystem accountingSystem = new AccountingSystem();
        accountingSystem.addEmptyHouse(1,1,1);
        assertEquals(1,accountingSystem.house.size());
    }

    @Test
    public  void addHouseAutomatically(){
        AccountingSystem accountingSystem = new AccountingSystem();
        accountingSystem.addHouseAutomatically();
        assertEquals(1,accountingSystem.house.size());
    }

    @Test
    public  void addFlat(){
        House house = new House();
        Flat flat = new Flat();
        house.addFlat(flat);
        assertEquals(1,house.flats.size());
    }

    @Test
    public  void removeHouseTest(){
        AccountingSystem accountingSystem = new AccountingSystem();
        accountingSystem.addEmptyHouse(1,1,1);
        accountingSystem.removeHouse(1);
        assertEquals(0,accountingSystem.house.size());
    }

}

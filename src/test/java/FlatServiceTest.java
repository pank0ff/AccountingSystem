import accountingSystem.AccountingSystem;
import model.Flat;
import model.House;
import org.junit.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import services.FlatService;

import static builders.FlatBuilder.flatAuto;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static services.FlatService.compareBy;

public class FlatServiceTest  {


    @Test
    public void compare() {
        House house = new House();
        Flat actualFlat = new Flat(1,1,1,1,1);
        Flat expectedFlat = new Flat(2,2,2,1,1);
        boolean actualCompare = compareBy(expectedFlat, actualFlat);
        Assertions.assertTrue(actualCompare);
    }

    @Test
    public void addFlat(){
        House house = new House(1,1,1);
        Flat flat = new Flat();
        house.addFlat(flat);
        int num = house.flats.size();
        assertEquals(1,num);
    }

    @Test
    public void addFlatAuto(){
        House house = new House(1,1,1);
        Flat flat = flatAuto(house);
        house.addFlat(flat);
        int num = house.flats.size();
        assertEquals(1,num);
    }

    @Test
    public void removeFlat(){
        House house = new House(1,2,1);
        Flat flat = new Flat();
        house.addFlat(flat);
        house.removeFlat(flat);
        int num = house.flats.size();
        assertEquals(0,num);
    }

    @Test
    public void findFlatByNumber(){
        House house = new House(1,2,1);
        Flat flat = new Flat(1,1,1,1,1);
        house.addFlat(flat);
        house.addFlat(AccountingSystem.findFlatByNumber(house,1));
        int num = house.flats.size();
        assertEquals(2,num);
    }

}

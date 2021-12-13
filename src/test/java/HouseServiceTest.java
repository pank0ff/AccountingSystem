import accountingSystem.AccountingSystem;
import model.Flat;
import model.House;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.rules.ExpectedException;
import services.HouseService;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HouseServiceTest {
    private HouseServiceTest houseServiceTest;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    HouseService houseService = new HouseService();
    static ArrayList<House> houseList = new ArrayList<>();
    static House house1 = new House(1, 5, 5);
    static House house2 = new House(2, 3, 3);


    @BeforeAll
    static void beforeAll() {
        for (int i = 0; i < 5; i++) {
            house1.getFlat().add(new Flat(i + 1, i + 1, i + 1, i + 1, i + 1));
        }
        for (int i = 0; i < 3; i++) {
            house2.getFlat().add(new Flat(i + 1, i + 1, i + 1, i + 1, i + 1));
        }
        houseList.add(house1);
        houseList.add(house2);
    }

    @Test
    public void isCalcSquareOfHouseRightTest() {
        assertEquals(15, house1.calcSquareOfHouse(houseList, 1));
    }

    @Test
    public void isCalcNumberOfResidentsRightTest() {
        assertEquals(15, house1.calcNumberOfResidents(houseList, 1));
    }

    @Test
    public void isRemoveHouseRightTest() {
        AccountingSystem.removeHouse(1);
        assertEquals(1, houseList.size());
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("Tests finished");
    }

    @After
    public void afterMethod() {
        System.out.println("Code executes after each test method");
    }
}

import org.junit.Before;
import org.junit.Test;
import java.awt.*;
import static org.junit.Assert.assertTrue;

public class TestCarRepairShop {

    private CarRepairShop<Saab95> carRepairShopSaab;
    private CarRepairShop<Vehicle> carRepairShopVehicle;
    private Saab95 saab;
    private Volvo240 volvo;
    private Scania scania;

    @Before
    public void init() {
        saab = new Saab95(2, 125.0, 0.0, Color.red, "Saab95", 90, 0.9, 0.9, 5000);
        volvo = new Volvo240();
        scania = new Scania();
        carRepairShopSaab = new CarRepairShop<>();
        carRepairShopVehicle = new CarRepairShop<>();
    }

    @Test
    public void testLoadCarRepairShop() {
        carRepairShopSaab.load(saab);
        assertTrue(carRepairShopSaab.getCargoQuantity() == 1);

    }

    @Test
    public void testUnloadCarRepairShop() {
        carRepairShopSaab.load(saab);
        carRepairShopSaab.load(saab);
        carRepairShopSaab.unload();
        assertTrue(carRepairShopSaab.getCargoQuantity() == 1);
    }

    @Test
    public void testCarRepairShopSynchronizeCargo() {
        carRepairShopSaab.load(saab);
        assertTrue(carRepairShopSaab.getxPosition() == saab.getxPosition()
                && carRepairShopSaab.getyPosition() == saab.getyPosition()
                && carRepairShopSaab.getDirection() == saab.getDirection());
    }

    @Test
    public void testMaxLimitCarRepairShop() {
        for (int i = 0; i < 10; i++) {
            carRepairShopSaab.load(saab);
        }
        carRepairShopSaab.load(saab);
        // Loader is full.
        assertTrue(carRepairShopSaab.getCargoQuantity() == 10);
    }

    @Test
    public void testMinLimitCarRepairShop() {
        carRepairShopSaab.unload();
        // Nothing to unload.
        // Loader is empty.
        assertTrue(carRepairShopSaab.getCargoQuantity() == 0);

    }
    @Test
    public void testVehicleRepairShopDifferentTypes(){
        carRepairShopVehicle.load(saab);
        carRepairShopVehicle.load(volvo);
        carRepairShopVehicle.load(scania);

        assertTrue(carRepairShopVehicle.getCargoQuantity() == 3);


    }
}
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class TestLoader {
    private List<Vehicle> VehicleLoad;
    private Loader<Vehicle> loader;
    private Scania scania;
    private CarTransport transporter;

     @Before
     public void init(){
         VehicleLoad = new ArrayList<Vehicle>();
         loader = new Loader<>(VehicleLoad , 5);
         scania = new Scania();
         transporter = new CarTransport();
     }

     @Test
    public void TestLoad(){
         loader.load(scania);
         assertTrue(VehicleLoad.get(0)==scania);
     }

     @Test
     public void TestLoadMax(){
         for (int i =0 ; i<6 ;i++ ){
             loader.load(scania);
         }
         assertTrue(VehicleLoad.size()==5);
     }


     @Test
    public void TestUnloaded(){
         loader.load(scania);
         loader.unload();
         assertTrue(VehicleLoad.size()==0);
     }

    @Test
    public void TestUnloadedEmpty(){
        assertTrue(loader.unload()==null);
    }
}

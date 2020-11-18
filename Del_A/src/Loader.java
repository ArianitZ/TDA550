import java.util.ArrayList;
import java.util.List;

// TODO fundera en gång till över designen på listan (stack/lista)
public class Loader<C> implements Loadable<C>{

    private final int maxCapacity;
    private List<C> list;

    public Loader(List<C> list, int maxCapacity){
        this.list = list;
        this.maxCapacity = maxCapacity;
    }

    @Override
    public void load(C c){
        if(list.size() < maxCapacity) {
            list.add(c);
        }
        else{
            System.out.println("Loader is full.");
        }

    }

    @Override
    public void unload(){
        if(list.size() >= 1) {
            list.remove(list.size() - 1);
        }
        else {
            System.out.println("Loader is empty.");
        }
    }



    public static void main(String[]args){

        List<Vehicle> listOfVehicles = new ArrayList<>();
        Loader<Vehicle> tmp = new Loader<>(listOfVehicles, 5);

        Saab95 saab = new Saab95();
        tmp.load(saab);
        System.out.println(listOfVehicles);
        //tmp.load(new CarTransport());
        System.out.println(listOfVehicles);

//        Volvo240 volvo = new Volvo240();
//        tmp.load(volvo);
//        tmp.load(new Volvo240());
//        tmp.load(new Volvo240());
//        tmp.load(new Volvo240());
//
//        System.out.println(listOfVehicles);
//        tmp.load(new Volvo240());
//
//        tmp.unload();
//        System.out.println(listOfVehicles);
//        tmp.unload();
//        System.out.println(listOfVehicles);
//        tmp.unload();
//        //tmp.load(listOfVehicles, new CarTransport());
//        System.out.println(listOfVehicles);
//        tmp.unload();
//        System.out.println(listOfVehicles);

    }
}
import java.util.ArrayList;
import java.util.List;

public class Loader<C> implements Loadable<C>{

    private int maxCapacity;
    private List<C> list;

    public Loader(){

    }

    @Override
    public void load(List<C> list, C c){
        list.add(c);
    }

    @Override
    public void unload(List<C> list){
        list.remove(list.size()-1);
    }


    /*
    public static void main(String[]args){
        Loader<Car> tmp = new Loader<>();
        List<Car> listOfCars = new ArrayList<>();

        Saab95 saab = new Saab95();
        tmp.load(listOfCars, saab);
        System.out.println(listOfCars);
        Volvo240 volvo = new Volvo240();
        tmp.load(listOfCars, volvo);
        tmp.load(listOfCars, new Volvo240());
        System.out.println(listOfCars);
        tmp.unload(listOfCars);
        System.out.println(listOfCars);
        tmp.unload(listOfCars);
        System.out.println(listOfCars);
        tmp.unload(listOfCars);
        //tmp.load(listOfCars, new CarsTransport());
        System.out.println(listOfCars);
    }*/

}

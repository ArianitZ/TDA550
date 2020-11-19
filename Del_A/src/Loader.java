import java.util.List;

 /**
  *  A class that represents the loading of cargo. It's an extension of Cargo and implements Loadable.
  *
  *  @param <C> the cargo, of type C, to be added
  *
  *  @author Arianit Zeqiri, Jakob Stråhle, Veronica Segerlind
  *  @version 1.0
  */
public class Loader<C extends Cargo> implements Loadable<C>{

     /**
      * the maximum capacity of the loader
      */
    private final int maxCapacity;

     /**
      * a list that stores the cargo
      */
    private List<C> list;

     /**
      * Implementation of the loader
      * @param list cargo list
      * @param maxCapacity the maximum capacity of the loader
      */
    public Loader(List<C> list, int maxCapacity){
        this.list = list;
        this.maxCapacity = maxCapacity;
    }

     /**
      * Override of the load function from the loadable. Loads cargo in sequential order.
      * @param c the cargo to be added
      */
    @Override
    public void load(C c){
        if(list.size() < maxCapacity) {
            list.add(c);
        }
        else{
            System.out.println("Loader is full.");
        }

    }

     /**
      * Override of the synchronizeCargo function from the loadable.
      * Synchronizes the cargo's position and direction with the transporter
      * @param transporter the transporter object
      */
    @Override
    public void synchronizeCargo(Transporter transporter){
        for(C cargo : list){
            cargo.setxPosition(transporter.getxPosition());
            cargo.setyPosition(transporter.getyPosition());
            cargo.setDirection(transporter.getDirection());
        }
    }

     /**
      * Override of the unload function from the loadable.
      * Unloads the cargo as first in, last out.
      * @return the unloaded cargo or null if the list is empty.
      */
    @Override
    public C unload(){
        if(list.size() >= 1) {
            C cargo = list.get(list.size()-1);
            list.remove(list.size() - 1);
            return cargo;
        }
        else {
            System.out.println("Loader is empty.");
            return null;

        }
    }

}

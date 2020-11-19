import java.util.List;

 /**
  *  A class that represents the Loading of cargo. It's an extension of Cargo and implements Loadabel.
  *
  *  @param <C> Is a list of cargo
  *
  *  @author Arianit Zeqiri, Jakob Stråhle, Veronica Segerlind
  *  @version 1.0
  */
public class Loader<C extends Cargo> implements Loadable<C>{

     /**
      * the maximum cargo weight capacity
      */
    private final int maxCapacity;

     /**
      * cargo list
      */
    private List<C> list;

     /**
      * Implementation of the loader
      * @param list cargo list
      * @param maxCapacity the maximum cargo weight capacity
      */
    public Loader(List<C> list, int maxCapacity){
        this.list = list;
        this.maxCapacity = maxCapacity;
    }

     /**
      * Override of the load function from the loadable
      * @param c
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
      * Override of the synchronizeCargo function from the loadable
      * @param transporter
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
      * Override of the unload function from the loadable
      * @return
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

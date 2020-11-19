import java.util.List;

/**
 * @param <C>
 */
public class Loader<C extends Cargo> implements Loadable<C>{

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
    public void synchronizeCargo(Transporter transporter){
        for(C cargo : list){
            cargo.setxPosition(transporter.getxPosition());
            cargo.setyPosition(transporter.getyPosition());
            cargo.setDirection(transporter.getDirection());
        }
    }

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

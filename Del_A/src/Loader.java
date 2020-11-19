import java.util.ArrayList;
import java.util.List;

// C = transportable
// T = Transporter
public class Loader<C extends Cargo,T extends Transporter> implements Loadable<C,T>{

    private final int maxCapacity;
    private List<C> list;

    public Loader(List<C> list, int maxCapacity){
        this.list = list;
        this.maxCapacity = maxCapacity;
    }

    @Override
    public void load(C c, T transporter){
        if(list.size() < maxCapacity) {
            list.add(c);
            c.setxPosition(transporter.getxPosition());
            c.setyPosition(transporter.getyPosition());
            c.setDirection(transporter.getDirection());
        }
        else{
            System.out.println("Loader is full.");
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

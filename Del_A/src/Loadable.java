import java.util.List;

public interface Loadable <C extends Cargo>{

    void load(C c);
    C unload();
    void synchronizeCargo(Transporter t);

}

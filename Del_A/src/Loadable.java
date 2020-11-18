import java.util.List;

public interface Loadable <C extends Cargo, T extends Transporter>{

    void load(C c, T t);
    void unload();

}

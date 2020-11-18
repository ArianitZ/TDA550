import java.util.List;

public interface Loadable <C>{

    void load(C c);
    void unload();

}

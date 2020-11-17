import java.util.List;

public interface Loadable <C>{

    void load(List<C> list, C c);
    void unload(List<C> list);

}

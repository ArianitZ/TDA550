import java.util.List;

/**
 * Interface loading loadable objects on to cargo.
 * @param <C>
 */
public interface Loadable <C extends Cargo>{
    /**
     * loads objects to the cargo.
     * @param c
     */
    void load(C c);

    /**
     *  unloads objects to the cargo.
     */
    C unload();

    /**
     * synchronizes the cargo position to the transporter position.
     */
    void synchronizeCargo(Transporter t);

}

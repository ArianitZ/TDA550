/**
 * Interface for objects that are loadable with cargo.
 * @param <C> the cargo to be loaded
 */
public interface Loadable <C extends Cargo>{
    /**
     * loads cargo to the loader.
     * @param c
     */
    void load(C c);

    /**
     *  unloads cargo from the loader.
     */
    C unload();

    /**
     * synchronizes the cargo position to the transporter position.
     */
    void synchronizeCargo(Transporter t);

}

/**
 *  Interface for objects that are movable with the following methods.
 *
 * @author Arianit Zeqiri, Jakob Stråhle, Veronica Segerlind
 * @version 1.0
 */
public interface Movable {
    /**
     * moves the object.
     */
    void move();

    /**
     * turns the object to the left.
     */
    void turnLeft();

    /**
     * turns the object to the right.
     */
    void turnRight();
}

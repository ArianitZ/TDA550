/**
 * Interface for changing cargo direction and position.
 *
 * @author Arianit Zeqiri, Jakob Stråhle, Veronica Segerlind
 * @version 1.0
 */
public interface Cargo {
    /**
     * moves cargo to the new x position.
     * @param newxPosition
     */
    void setxPosition(double newxPosition);

    /**
     * moves cargo to the new y position.
     * @param newyPosition
     */
    void setyPosition(double newyPosition);

    /**
     *  changes the cargos direction.
     * @param direction
     */
    void setDirection(int direction);
}

/**
 * Interface for retrieving a transporters positions and direction.
 *
 * @author Arianit Zeqiri, Jakob Stråhle, Veronica Segerlind
 * @version 1.0
 */
public interface Transporter {
    /**
     *  gets x position.
     */
    double getxPosition();

    /**
     *  gets y position.
     */
    double getyPosition();

    /**
     *  gets the direction.
     */
    int getDirection();
}
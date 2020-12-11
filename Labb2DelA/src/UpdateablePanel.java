import java.awt.*;
/**
 *  An interface for panels that are updateable.
 *
 * @author Arianit Zeqiri, Jakob Stråhle, Veronica Segerlind
 * @version 1.0
 */
public interface UpdateablePanel {

    Point getViewDimensions();
    void move(Vehicle car);
    void paint();

}

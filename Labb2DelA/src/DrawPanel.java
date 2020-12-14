import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.*;
import java.util.List;

/**
 *  A class that represents the animated part of the view with the car images.
 *  Is controlled by CarController.
 *
 * @author Arianit Zeqiri, Jakob Stråhle, Veronica Segerlind
 * @version 1.0
 */
public class DrawPanel extends JPanel{

    private Map<String, BufferedImage> vehicleImages;
    private List<Tuple<String, Point>> listOfVehiclePositions;


    public DrawPanel(int xDim, int yDim) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(xDim, yDim));
        this.setBackground(Color.green);

        this.listOfVehiclePositions = new Stack<>();

        try {
            vehicleImages = new HashMap<>();
            vehicleImages.put("Volvo240", ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg")));
            vehicleImages.put("Saab95", ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg")));
            vehicleImages.put("Scania", ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg")));

        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }


    protected void move(Vehicle car) {
        Point vehiclePoint = new Point((int)car.getxPosition(), (int)car.getyPosition());
        String vehicleType = car.getModelName();

        this.listOfVehiclePositions.add(new Tuple(vehicleType, vehiclePoint));
    }


    protected void paint(){
        this.repaint();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int size = listOfVehiclePositions.size();

        for (int i = 0; i < size; i++){
            Tuple<String, Point> vehicle = ((Stack<Tuple<String, Point>>)listOfVehiclePositions).pop();
            g.drawImage(vehicleImages.get(vehicle.getFirstMember()), vehicle.getSecondMember().x,
                                          vehicle.getSecondMember().y, null);
        }
    }

}

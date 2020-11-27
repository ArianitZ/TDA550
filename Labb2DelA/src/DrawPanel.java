import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // TODO: use a list of images instead of hårdkodning
    //private List<BufferedImage> images;
    // Just a single image, TODO: map<String, BufferdImage>
    Map<String, BufferedImage> vehicleImages;

    // TODO: Change to a list of points instead of hårdkodning
    // To keep track of a singel cars position
    Point vehiclePoint = new Point();
    String vehicleType;

    // TODO: Make this genereal for all cars
    void moveit(Vehicle car){
        vehiclePoint.x = (int)car.getxPosition();
        vehiclePoint.y = (int)car.getyPosition();
        //vehiclePoint.setLocation(car.getxPosition(), car.getyPosition());
        vehicleType = car.getModelName();
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.vehicleImages = new HashMap<>();
        // Print an error message in case file is not found with a try/catch block
        try {
            vehicleImages.put("Volvo240", ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg")));
            vehicleImages.put("Saab95", ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg")));
            vehicleImages.put("Scania", ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg")));

        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        BufferedImage vehicleImage = vehicleImages.get(vehicleType);
        g.drawImage(vehicleImage, vehiclePoint.x, vehiclePoint.y, null);
    }
}

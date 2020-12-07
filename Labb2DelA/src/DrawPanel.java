import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.*;
import java.util.List;

// This panel represent the animated part of the view with the car images.
public class DrawPanel extends JPanel implements Updateable{

    Map<String, BufferedImage> vehicleImages;
    List<Tuple<String, Point>> listOfVehiclePositions;


//    void moveit(Vehicle car){
//        Point vehiclePoint = new Point((int)car.getxPosition(), (int)car.getyPosition());
//        String vehicleType = car.getModelName();
//
//        this.listOfVehiclePositions.add(new Tuple(vehicleType, vehiclePoint));
//    }


    @Override
    public void move(Vehicle car) {
        Point vehiclePoint = new Point((int)car.getxPosition(), (int)car.getyPosition());
        String vehicleType = car.getModelName();

        this.listOfVehiclePositions.add(new Tuple(vehicleType, vehiclePoint));
    }

    @Override
    public void paint(){
        this.repaint();
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);

        this.listOfVehiclePositions = new ArrayList<>();

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


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int size = listOfVehiclePositions.size();

        for (int i = 0; i < size; i++){
            Tuple<String, Point> vehicle = listOfVehiclePositions.remove(0);

            g.drawImage(vehicleImages.get(vehicle.getFirstMember()), vehicle.getSecondMember().x,
                                          vehicle.getSecondMember().y, null);
        }
    }

}

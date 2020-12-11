import java.util.Random;
/**
 *  A class that uses the factory design pattern and creates cars for the user.
 *
 * @author Arianit Zeqiri, Jakob Stråhle, Veronica Segerlind
 * @version 1.0
 */
public class CarFactory {

    private static final int numberOfDifferentVehicles = 3;


    public static Vehicle createSaab95(double xPosition, double yPosition){
        Saab95 saab = new Saab95();

        saab.setDirection(0);
        saab.setxPosition(xPosition);
        saab.setyPosition(yPosition);

        return saab;
    }


    public static Vehicle createVolvo240(double xPosition, double yPosition){
        Volvo240 volvo = new Volvo240();

        volvo.setDirection(0);
        volvo.setxPosition(xPosition);
        volvo.setyPosition(yPosition);

        return volvo;
    }


    public static Vehicle createScania(double xPosition, double yPosition){
        Scania scania = new Scania();

        scania.setDirection(0);
        scania.setxPosition(xPosition);
        scania.setyPosition(yPosition);

        return scania;
    }


    public static Vehicle createRandomVehicle(double xPosition, double yPosition){
        Random randomNmrGenerator = new Random();
        int randomNmbr = randomNmrGenerator.nextInt(numberOfDifferentVehicles) + 1;

        Vehicle vehicle;
        
        switch(randomNmbr){
            case 1:
                vehicle = createSaab95(xPosition, yPosition);
                break;
            case 2:
                vehicle = createVolvo240(xPosition, yPosition);
                break;
            case 3:
                vehicle = createScania(xPosition, yPosition);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + randomNmbr);
        }
        
        return vehicle;
    }


}

public class CarFactory {


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
}

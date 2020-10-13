
public class BodyMassIndex {
    private double height;
    private double weight;
    private double bmi;

    public BodyMassIndex(double height, double weight) {

        bmi = 703 * weight /(height*height);

    }

    public double getBmi() {
        return bmi;
    }
}




/*703 * weight /(height*height)*/
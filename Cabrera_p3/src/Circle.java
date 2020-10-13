public class Circle extends Shape2D {

    public Circle(double radi) {
        super("circle", radi*radi* Math.PI);
            }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public double getVolume() {
        return 0;
    }
}

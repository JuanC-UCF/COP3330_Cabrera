public class Square extends Shape2D {

    public Square(double length) {
        super("square",length*length);
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

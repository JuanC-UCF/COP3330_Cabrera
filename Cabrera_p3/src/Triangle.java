public class Triangle extends Shape2D {

    public Triangle(double length, double lengthbase) {
        super("triangle",length*lengthbase*.5 );

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

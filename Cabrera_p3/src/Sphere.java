public class Sphere extends Shape3D{


    public Sphere(double radi) {

        super("sphere",(4*Math.PI*radi*radi),(4*Math.PI*radi*radi*radi/3));

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
        return volume;
    }
}


public class Cube extends Shape3D{


    public Cube(double length) {

        super("cube",length*length*6,length*length*length);

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


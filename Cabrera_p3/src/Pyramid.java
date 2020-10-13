public class Pyramid extends Shape3D{


    public Pyramid(double length,double height,double lengththree) {

        super("pyramid",((height + Math.sqrt(lengththree*lengththree + 4*length*length))*height),(length*height*lengththree/3));

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


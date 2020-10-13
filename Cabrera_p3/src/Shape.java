public abstract class Shape {
  //  protected double length;
    protected String name;
    protected double area;
    protected double volume;

    public Shape(String name, double area, double volume) {
        this.name = name;
        this.area = area;
        this.volume = volume;
    }

    public abstract String getName();

    public abstract double getArea();

    public  abstract double getVolume();
}

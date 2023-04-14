package seleniumTestProject;

public class Point {

    public double x;
    public double y;

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }


    public double pointDistance(Point p2){
        double distance = Math.sqrt((p2.x - this.x)*(p2.x - this.x)+(p2.y - this.y)*(p2.y - this.y));
        System.out.println("Расстояние между двумя  точками равно " + distance);
        return distance;
    }
}

package seleniumTestProject;

public class Point {

    public double x;
    public double y;

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }


    public  double pointDistance(){
        double distance = Math.sqrt((p2.x - p1.x)*(p2.x - p1.x)+(p2.y - p1.y)*(p2.y - p1.y));
        System.out.println("Расстояние между двумя  точками равно " + distance);
        return distance;
    }
}

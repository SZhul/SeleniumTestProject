package seleniumTestProject;

public class Point {
    double point1X;
    double point2X;
    double point1Y;
    double point2Y;



    public Point(double x1, double y1, double x2, double y2){
        this.point1X = x1;
        this.point2X = x2;
        this.point1Y = y1;
        this.point2Y = y2;
    }

    public static double distance(double x1, double y1, double x2, double y2){
        double result = Math.sqrt((x2 - x1)*(x2 - x1)+(y2 - y1)*(y2 - y1));
        System.out.println(result);
        return result;
    }

    public double distance(){
        double result = Math.sqrt((point2X - point1X)*(point2X - point1X)+(point2Y-point1Y)*(point2Y-point1Y));
        System.out.println(result);
        return result;
    }
}



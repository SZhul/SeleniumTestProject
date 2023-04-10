package seleniumTestProject;

public class Distance {
    public static void main(String[] args) {
        Point p1 = new Point(4,9);
        Point p2 = new Point(16, 25);
        p1.pointDistance(p2);

        pointDistance(p1, p2);
    }

    public static double pointDistance(Point p1, Point p2){
        double distance = Math.sqrt((p2.x - p1.x)*(p2.x - p1.x)+(p2.y - p1.y)*(p2.y - p1.y));
        System.out.println("Расстояние между двумя  точками равно " + distance);
        return distance;
    }
}

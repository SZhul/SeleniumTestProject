package seleniumTestProject;

public class MyFirstProgram {

    public static void main(String[] args) {

        String somebody = "world!";

        System.out.println("Hello, " +  somebody);

        int l = 5;
        int s = l*l;

        System.out.println("Площадь квадрата со стороной " + l + " = " + s);

        Point point = new Point(4,9, 16, 25);
        point.distance();
        Point.distance(4, 9, 16, 25);
    }
}
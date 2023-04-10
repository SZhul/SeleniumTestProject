package seleniumTestProject;

public class MyFirstProgram {

    public static void main(String[] args) {

        hello("world");





        Square s = new Square();
        s.l = 5;
        System.out.println("Площадь квадрата со стороной " + s.l + " равна " + area(s));

        Rectangle r = new Rectangle();
        r.a = 4;
        r.b = 6;
        System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " равна " + area(r));


    }

    public static void hello(){
        System.out.println("Hello world!");
    }

    public static void hello(String something){
        System.out.println("Hello " + something + " !");
    }

    public static double area(double l){
        return l*l;
    }

    public static double area(double a, double b){
        return a*b;
    }

    public static double area(Square s){
        return s.l * s.l;
    }

    public static double area(Rectangle a){
        return a.a * a.b;
    }

    public static double distance(Point p1, Point p2){
        double distance = Math.sqrt((p2.x - p1.x)*(p2.x - p1.x)+(p2.y - p1.y)*(p2.y - p1.y));
        System.out.println("Расстояние между двумя  точками равно " + distance);
        return distance;
    }

    Point p1 = new Point(9,4);
    Point p2 = new Point(16, 25);
    distance(p1, p2);

}
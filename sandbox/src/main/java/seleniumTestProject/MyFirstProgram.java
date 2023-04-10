package seleniumTestProject;

public class MyFirstProgram {

    public static void main(String[] args) {

        hello("world");


//        Point p1 = new Point(9,4);
//        Point p2 = new Point(16, 25);
//        pointDistance(p1, p2);


        Square s = new Square(5);

        System.out.println("Площадь квадрата со стороной " + s.l + " равна " + s.area());

        Rectangle r = new Rectangle(4, 6);

        System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " равна " + r.area());


    }

    public static void hello(){
        System.out.println("Hello world!");
    }

    public static void hello(String something){
        System.out.println("Hello " + something + " !");
    }






    public static double pointDistance(Point p1, Point p2){
        double distance = Math.sqrt((p2.x - p1.x)*(p2.x - p1.x)+(p2.y - p1.y)*(p2.y - p1.y));
        System.out.println("Расстояние между двумя  точками равно " + distance);
        return distance;
    }



}
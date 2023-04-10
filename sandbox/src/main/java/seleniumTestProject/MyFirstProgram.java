package seleniumTestProject;

public class MyFirstProgram {

    public static void main(String[] args) {

        hello("world");


        Point p1 = new Point(9,4);
        Point p2 = new Point(16, 25);
        p1.pointDistance(p1,p2);



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










}
package seleniumTestProject;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

    @Test
    public void calculationTest(){
        Point p1 = new Point(4, 9);
        Point p2 = new Point(16, 25);
        Assert.assertEquals(p1.pointDistance(p2), 20);
    }

    @Test
    public void xTest(){
        Point p1 = new Point(4,9);
        double res = p1.x;
        Assert.assertEquals(p1.x, res);
    }
}

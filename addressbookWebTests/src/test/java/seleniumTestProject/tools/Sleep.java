package seleniumTestProject.tools;

public class Sleep {

        public static void sleep() {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public static void sleep(int sec) {
            try {
                Thread.sleep((sec * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


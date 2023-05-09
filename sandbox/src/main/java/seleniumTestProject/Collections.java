package seleniumTestProject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {
    public static void main(String[] args) {
        String[] langs = {"Java", "C#", "Python", "PHP"};


        for (int i = 0; i < langs.length; i++){
            System.out.println("Я хочу выучить " + langs[i]);
        }

        for (String l : langs){
            System.out.println(l);
        }

        for (String l : langs){
            System.out.println("Я хочу выучить " + l);
        }

        List<String> languages = new ArrayList<>();
        languages.add("Java");
        languages.add("C#");
        languages.add("Python");
        languages.add("PHP");

        for (String l : languages){
            System.out.println(l);
        }

        List<String> languages2 = Arrays.asList("Java", "C#", "Python", "PHP");
        for (String l : languages2){
            System.out.println(l);
        }


    }
}

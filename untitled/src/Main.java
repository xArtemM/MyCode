import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        /*TreeSet<Treeclass> set = new TreeSet<>();

        System.out.println(set.add(new Treeclass("v1" , 1)));
        System.out.println(set.add(new Treeclass("v2" , 2)));
        System.out.println(set.add(new Treeclass("v3" , 1)));

        System.out.println(set);*/

        File file = new File(".testPath");

        if (file.mkdir()) System.out.println("Директория создана");

        file = new File(".testPath", "newTestFile.txt");

        try {
            if (file.createNewFile()) System.out.println("Фаил создан");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Treeclass.comppareTo();

    }
}
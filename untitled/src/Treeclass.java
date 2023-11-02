public class Treeclass  {

    public String name;
    public Integer age;

    public Treeclass(String name, Integer age) {
        this.name = name;
        this.age = age;
    }


    public static int comppareTo() {
        return 0;
    }

    @Override
    public String toString() {
        return name + " " + age;
    }
}

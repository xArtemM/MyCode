public class Treeclass implements Comparable<Treeclass> {

    public String name;
    public Integer age;

    public Treeclass(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Treeclass o) {
        return age.compareTo(o.age);
    }

    @Override
    public String toString() {
        return name + " " + age;
    }
}

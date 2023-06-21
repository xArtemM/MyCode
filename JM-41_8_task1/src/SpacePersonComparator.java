import java.util.Comparator;

public class SpacePersonComparator implements Comparator<Person> {

    private int getChasS (String name) {
        int sCount = 0;
        for (int i = 0; i < name.length() ; i++) {
            if (name.charAt(i) == 's' || name.charAt(i) == 'S') {
                sCount++;
            }
        }
        return sCount;
    }

    @Override
    public int compare(Person o1, Person o2) {
        if (o1.getExperience() != o2.getExperience()) {
            return o2.getExperience() - o1.getExperience();
        } else if (getChasS(o2.getName()) != getChasS(o1.getName())) {
            return getChasS(o2.getName()) - getChasS(o1.getName());
        } else {
            return o1.getName().length() - o2.getName().length();
        }
    }
}

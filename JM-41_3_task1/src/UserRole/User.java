package UserRole;
public abstract class User {

    private String name;

    public User(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

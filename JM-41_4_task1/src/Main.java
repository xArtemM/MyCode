import java.util.Scanner;

public class Main {

    public static User[] getUsers() {
        User user1 = new User("anya", "123", "anya@gmail.com", 24);
        User user2 = new User("tolya", "345", "tolya@yandex.ru", 17);
        User user3 = new User("katya", "567", "katya@gmail.com", 33);
        return new User[]{user1, user2, user3};
    }

    public static User getUserByLoginAndPassword(String login, String password) throws UserNotFoundException {
        User[] users = getUsers();
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return user;
            }
        }
        throw new UserNotFoundException("User not found");
    }

    public static void validateUser(User user) throws AccessDeniedException {
        if (user.getAge() < 18) {
            throw new AccessDeniedException("AccessDenied");
        }
    }

    public static void main(String[] args) throws UserNotFoundException, AccessDeniedException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите логин");
        String login = scanner.nextLine();
        System.out.println("Введите пароль");
        String password = scanner.nextLine();

        User authorizedUser = getUserByLoginAndPassword(login, password);
        validateUser(authorizedUser);

        System.out.println("Доступ предоставлен");

    }
}
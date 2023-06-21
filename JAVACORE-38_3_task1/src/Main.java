import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void createDirectory(String path, StringBuilder log) {
        File file = new File(path);
        if (file.mkdir()) {
            log.append("Директория '" + path + "' успешно создана\n");
        } else {
            log.append("Ошибка создания каталога '" + path + "' \n");
        }
    }

    public static void createFile(String path, String fileName, StringBuilder log) {
        File file = new File(path + "/" + fileName);
        try {
            if (file.createNewFile()) {
                log.append("Фаил " + fileName + " создан в директории '" + path + "'\n");
            } else {
                log.append("Ошибка создания файла " + fileName + " в директории '" + path + "'\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

        StringBuilder log = new StringBuilder();

        createDirectory("C://Games/src", log);
        createDirectory("C://Games/res", log);
        createDirectory("C://Games/savegames", log);
        createDirectory("C://Games/temp", log);

        createDirectory("C://Games/src/main", log);
        createDirectory("C://Games/src/test", log);

        createFile("C://Games/src/main", "Main.java", log);
        createFile("C://Games/src/main", "Utils.java", log);

        createDirectory("C://Games/res/drawables", log);
        createDirectory("C://Games/res/vectors", log);
        createDirectory("C://Games/res/icons", log);

        createFile("C://Games/temp", "temp.txt", log);

        try (FileWriter writer = new FileWriter("C://Games/temp/temp.txt", false)) {
            writer.write(log.toString());
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println(log);

    }
}
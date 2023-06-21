import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Main {

    public static void saveGame(String path, GameProgress progress) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(progress);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static GameProgress restoreGame(String path) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            return (GameProgress) ois.readObject();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public static void zipFiles(String outPath, String[] inPath) {
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(outPath))) {
            for (String s : inPath) {
                try (FileInputStream fis = new FileInputStream(s)) {
                    ZipEntry entry = new ZipEntry(s.substring(s.lastIndexOf("/") + 1));
                    zos.putNextEntry(entry);
                    byte[] buffer = new byte[fis.available()];
                    fis.read(buffer);
                    zos.write(buffer);
                    zos.closeEntry();
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void unZipFiles(String inPath, String outDirectory) {
        String newDirPath = outDirectory + inPath.substring(inPath.lastIndexOf("/"));
        newDirPath = newDirPath.replace(".", "_");
        File file = new File(newDirPath);
        if (!file.mkdir()) {
            System.out.println("Ошибка при создании папки");
            return;
        }
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(inPath))) {
            ZipEntry entry;
            String name;
            while ((entry = zis.getNextEntry()) != null) {
                name = entry.getName();
                try (FileOutputStream fout = new FileOutputStream(newDirPath + "/" + name)) {
                    for (int c = zis.read(); c != -1; c = zis.read()) {
                        fout.write(c);
                    }
                    fout.flush();
                    zis.closeEntry();
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


    public static void clearDir (String path) {
        File file = new File(path);
        for (File f :file.listFiles()) {
            if (f.isFile() && (!f.getName().contains(".zip"))) {
                f.delete();
            }
        }
    }

    public static void main(String[] args) {

        GameProgress gameProgress1 = new GameProgress(12, 25, 2, 262.1);
        GameProgress gameProgress2 = new GameProgress(57, 21, 54, 2.234);
        GameProgress gameProgress3 = new GameProgress(3, 34, 31, 342.3);

        System.out.println("Перед сериализацией:");
        System.out.println(gameProgress1);
        System.out.println(gameProgress2);
        System.out.println(gameProgress3 + "\n");

        saveGame("C://Games/savegames/save1.dat", gameProgress1);
        saveGame("C://Games/savegames/save2.dat", gameProgress2);
        saveGame("C://Games/savegames/save3.dat", gameProgress3);

        gameProgress1 = null;
        gameProgress2 = null;
        gameProgress3 = null;

        zipFiles("C://Games/savegames/save.zip", new String[]{
                "C://Games/savegames/save1.dat",
                "C://Games/savegames/save2.dat",
                "C://Games/savegames/save3.dat"});

        clearDir("C://Games/savegames");

        unZipFiles("C://Games/savegames/save.zip", "C://Games/savegames");

        gameProgress1 = restoreGame("C://Games/savegames/save_zip/save1.dat");
        gameProgress2 = restoreGame("C://Games/savegames/save_zip/save2.dat");
        gameProgress3 = restoreGame("C://Games/savegames/save_zip/save3.dat");

        System.out.println("После десериализации:");
        System.out.println(gameProgress1);
        System.out.println(gameProgress2);
        System.out.println(gameProgress3);

    }
}
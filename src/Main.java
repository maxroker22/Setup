import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    private static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        createDirectory("D://Games/src");
        createDirectory("D://Games/res");
        createDirectory("D://Games/savegames");
        createDirectory("D://Games/temp");
        createDirectory("D://Games/src/main");
        createDirectory("D://Games/src/test");
        createFile("D://Games/src/main/Main.java");
        createFile("D://Games/src/main/Utils.java");
        createDirectory("D://Games/res/drawables");
        createDirectory("D://Games/res/vectors");
        createDirectory("D://Games/res/icons");
        createFile("D://Games/temp/temp.txt");
        System.out.println(stringBuilder);

        try (FileWriter writer = new FileWriter("D://Games/temp/temp.txt", false)){
            writer.write(String.valueOf(stringBuilder));
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void createDirectory(String path) {
        File file = new File(path);
        if (file.mkdir()) {
            stringBuilder.append("Создан каталог " + path + " " + "\n");
        } else {
            stringBuilder.append("Каталог " + path + " не создан" + "\n");
        }
    }

    private static void createFile(String path) {
        File file = new File(path);
        try {
            if (file.createNewFile()) {
                stringBuilder.append("Файл " + file + " был создан " + "\n");
            }
        } catch (IOException e) {
            stringBuilder.append("Файл " + file + " не был создан " + "\n");
        }
    }

}
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        StringBuilder log = new StringBuilder();

        File[] directories = {new File("C://Games"),
                new File("C://Games/src"),
                new File("C://Games/src/main"),
                new File("C://Games/src/test"),
                new File("C://Games/res"),
                new File("C://Games/res/drawables"),
                new File("C://Games/res/vectors"),
                new File("C://Games/res/icons"),
                new File("C://Games/savegames"),
                new File("C://Games/temp")
        };

        File[] files = {new File("C://Games/src/main/Main.java"),
                new File("C://Games/src/main/Utils.java"),
                new File("C://Games/temp/temp.txt")
        };

        for (File directory : directories) {
            if (directory.mkdir()) {
                log.append("directory create sucessfull: ").append(directory.getName()).append("\n");
            } else {
                log.append("directory create failed: ").append(directory.getName()).append("\n");
            }
        }

        for (File file : files) {
            try {
                if (file.createNewFile()) {
                    log.append("file create sucessfull: ").append(file.getName()).append("\n");
                } else {
                    log.append("file create failed: ").append(file.getName()).append("\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (FileWriter writer = new FileWriter("C://Games/temp/temp.txt", false)) {
            writer.write(String.valueOf(log));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class ImagesRename {
    public static void main(String[] args) {
        String filePathCSV = "pet-profiles.csv";
        String line;

        renameFiles(filePathCSV);
    }

    public static void renameFiles(String csvPath) {
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(csvPath))) {
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                /* cols: id,type,name,age,sex */

                File oldJpgFile = new File("images-copy/pets/" + row[2] + ".jpg");
                File newJpgFile = new File("images-copy-renamed/pets/" + row[0] + ".jpg");

                try {
                    Path sourcePath = oldJpgFile.toPath();
                    Path destinationPath = newJpgFile.toPath();

                    Files.createDirectories(destinationPath.getParent());
                    Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);

                    System.out.println(row[2] + " Successfully renamed!");
                } catch (IOException e) {
                    System.out.println("An error occurred: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

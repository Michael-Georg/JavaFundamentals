package JavaSE05_2;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.*;
import java.util.Properties;

class PropertyReader {
    private Path filePath;

    PropertyReader(String path) {
        this.filePath = Paths.get(path);
    }

    private boolean isPropertyFile(Path path) {
        return path.getFileName().toString().endsWith(".properties");
    }

    String findKeyInPropertyFile(String key) throws KeyNotFoundException{
        String result = null;
        if (!Files.isDirectory(filePath) && isPropertyFile(filePath)) {
            return findValueInFile(key, filePath);
        } else if (Files.isDirectory(filePath)) {
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(filePath)) {
                for (Path file : stream) {
                    if (isPropertyFile(file)) {
                        result = findValueInFile(key, file);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (result == null) throw new KeyNotFoundException();
        return result;
    }


    private String findValueInFile(String key, Path path) {
        try (FileInputStream fileInput = new FileInputStream(path.toFile())) {
            Properties properties = new Properties();
            properties.load(fileInput);
            return properties.getProperty(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}

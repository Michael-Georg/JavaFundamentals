package JavaSE05_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

class FileSystem {

    private Path path = null;

    FileSystem(String path) {
        this.path = Paths.get(path);
    }

    FileSystem changePath(String newPath) {
        path = Paths.get(path.toString() + "\\" + newPath);
        return this;
    }

    void printCurrentDirectory() {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
            for (Path file : stream) {
                System.out.println(file.getFileName());
            }
        } catch (NoSuchFileException e) {
            System.out.println("wrong path");

        } catch (NotDirectoryException e) {
            System.out.println("Need to choose directory, not a file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void createFile() {
        try {
            Files.createFile(path);
        } catch (FileAlreadyExistsException e) {
            System.out.println("File already exist");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void reWriteFile(String text) {
        try (BufferedWriter fout = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            fout.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void appendToFile(String text) {
        try (BufferedWriter fout = Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.APPEND)) {
            fout.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    String readFile() {
        String result = "";

        try (BufferedReader fin = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String str;
            while ((str = fin.readLine()) != null) {
                result += str;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    void deleteFile() {
        try {
            Files.delete(path);
        } catch (NoSuchFileException e) {
            System.out.println("File not found");
        } catch (DirectoryNotEmptyException e) {
            System.out.println("Direction isn't empty");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package client.utils;

import entity.Config;

import java.io.*;
import java.util.function.Consumer;

public class FileUtils {
    public static void appendToFile(String fileName, byte[] data) {
        try (FileOutputStream fos = new FileOutputStream(Config.clientDownloadFolder + fileName, true)) {
            fos.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void touchFile(String filename) {
        var file = new File(Config.clientDownloadFolder + filename);
        if (file.exists()) {
            file.delete();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
        }
    }

    public static void createIfNotExistFolder(String path) {
        File theDir = new File(path);
        if (!theDir.exists()) {
            theDir.mkdirs();
        }
    }
}

package server.utils;

import entity.Config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.function.Consumer;

public class FileUtils {
    public static void appendToFile(String fileName, byte[] data) {
        try (FileOutputStream fos = new FileOutputStream(Config.serverDownloadFolder + fileName, true)) {
            fos.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void touchFile(String filename) {
        var file = new File(Config.serverDownloadFolder + filename);
        if (file.exists()) {
            file.delete();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
        }
    }

    public static void StreamFile(String filename, int bufferSize, Consumer<byte[]> fn) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(Config.serverDownloadFolder + filename);
            var buffer = new byte[bufferSize];
            int retSize;
            while ((retSize = fis.read(buffer)) > 0) {
                var realBuffer = new byte[retSize];
                System.arraycopy(buffer, 0, realBuffer, 0, retSize);
                fn.accept(realBuffer);
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                }
            }
        }
    }

    public static void createIfNotExistFolder(String path) {
        File theDir = new File(path);
        if (!theDir.exists()) {
            theDir.mkdirs();
        }
    }
}

package server.utils;

import entity.Config;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtils {
    public static void appendToFile(String fileName, byte[] data, int i){
        try (FileOutputStream fos = new FileOutputStream(Config.serverDownloadFolder+fileName,true)) {
            fos.write(data,i,data.length-i);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void createIfNotExistFolder(String path){
        File theDir = new File(path);
        if (!theDir.exists()) {
            theDir.mkdirs();
        }
    }
}

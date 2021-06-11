package server.service;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Logger {
    private static final BufferedWriter bw;

    static {
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }
    synchronized public static void write(String str){
        try {
            bw.write(str);
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeln(String str){
        write(str+"\n");
    }

}

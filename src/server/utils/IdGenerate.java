package server.utils;

public class IdGenerate {
    private final static Object lock;
    private static Long uniqueId;

    static {
        uniqueId=0L;
        lock=new Object();
    }

    public static long generate(){
        synchronized(lock){
            uniqueId+=1L;
        }
        return uniqueId;
    }
}

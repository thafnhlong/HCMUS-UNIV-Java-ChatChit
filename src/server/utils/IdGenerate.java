package server.utils;

public class IdGenerate {
    private static Long uniqueId;

    static {
        uniqueId=0L;
    }

    public static long generate(){
        synchronized(uniqueId){
            uniqueId+=1L;
        }
        return uniqueId;
    }
}

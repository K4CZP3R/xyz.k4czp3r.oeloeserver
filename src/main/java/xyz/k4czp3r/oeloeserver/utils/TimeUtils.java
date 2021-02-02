package xyz.k4czp3r.oeloeserver.utils;

public class TimeUtils {
    public static long getCurrentUnix(){
        return System.currentTimeMillis() / 1000L;
    }
}

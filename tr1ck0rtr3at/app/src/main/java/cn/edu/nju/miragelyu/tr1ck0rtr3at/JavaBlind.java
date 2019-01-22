package cn.edu.nju.miragelyu.tr1ck0rtr3at;

public class JavaBlind {
    static {
        System.loadLibrary("native-lib");
    }

    private static native String CanYouSeeMe();

    public static String getKeyKey(){
        return CanYouSeeMe();
    }
}

package cn.edu.nju.miragelyu.tr1ck0rtr3at;

import java.util.HashMap;
import java.util.Map;

public class ReflectionMap {
    private static byte[][] encrytedStrings = new byte[][]{
            // "cn.edu.nju.miragelyu.tr1ck0rtr3at.Encryption"
            new byte[] {-58 , -123 , -92 , 101 , 59 , 72 , -17 , -51 , 89 , 61 , -95 , 30 , 56 , 52 , -66 , -72 , 81 , -45 , 103 , -65 , -112 , -60 , 114 , 42 , -120 , -100 , 41 , -18 , -9 , 63 , -29 , -73 , -12 , 81 , -122 , -11 , -29 , 63 , -112 , 94 , 33 , 61 , 102 , -98 , 69 , 1 , -6 , -45},
            // "android.os.Debug"
            new byte[] {15 , 78 , -94 , -9 , -13 , -63 , -61 , 1 , -20 , -100 , -38 , -84 , 62 , 52 , -84 , -108 , -11 , 46 , 49 , 68 , -67 , 64 , 59 , -5},
            // "isDebuggerConnected"
            new byte[] {113 , 67 , 0 , -112 , 104 , 42 , -48 , 28 , -108 , -92 , -60 , 51 , 105 , -128 , -24 , -53 , 58 , -77 , -59 , 21 , 30 , 68 , 16 , -36},
            // "Neon"
            new byte[] {0 , 122 , 96 , -62 , 17 , -58 , -39 , 49},
            // "Mars"
            new byte[] {-94, -76, -63, 74, -107, -80, 64, 121},
            // "Luna"
            new byte[] {51, 94, 60, 5, 19, 54, 32, -25}
    };

    static Map<Integer, String> map = new HashMap<>(encrytedStrings.length);

    public static String get(int index,String key){
        if(index >= encrytedStrings.length)
            return null;
        if(!map.containsKey(index)){
            map.put(index, Decrypt.decrypt(encrytedStrings[index], key));
        }
        return map.get(index);
    }
}

package cn.edu.nju.miragelyu.tr1ck0rtr3at;

import java.lang.reflect.Method;

public class Encryption {

    @Reflection
    public static void Oxygen(byte[] bytes, String key) throws Exception{
        //Anti-Debugger
        Class clazz = Class.forName(ReflectionMap.get(1, key));
        Method method = clazz.getDeclaredMethod(ReflectionMap.get(2, key));
        if((boolean)method.invoke(null))
            System.exit(0);
    }

    public static void Neon(byte[] bytes){
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] += 0x3a;
            if (i != 0)
                bytes[i] += bytes[i-1];
            else
                bytes[i] += bytes[bytes.length-1];
        }
    }

    public  static void Mars(byte[] bytes){
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] ^= 0x96;
            if (i != 0) {
                bytes[i] ^= bytes[i-1];
            }else {
                bytes[i] ^= bytes[bytes.length-1];
            }
        }
    }

    public static void Luna(byte[] bytes){
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (((bytes[i] >> 4) & 0xf) + ((bytes[i] & 0xf) << 4));
        }
    }

    @Reflection
    public static void Kepler(byte[] bytes, String key) throws Exception{
        Class clazz = Class.forName(ReflectionMap.get(0, key));
        Method method = clazz.getDeclaredMethod(ReflectionMap.get(3, key), byte[].class);
        Object object = clazz.newInstance();
        method.invoke(object, bytes);
    }

    @Reflection
    public static void Juno(byte[] bytes, String key) throws Exception{
        Class clazz = Class.forName(ReflectionMap.get(0, key));
        Method method = clazz.getDeclaredMethod(ReflectionMap.get(4, key), byte[].class);
        Object object = clazz.newInstance();
        method.invoke(object, bytes);
    }

    @Reflection
    public static void Indigo(byte[] bytes, String key) throws Exception{
        Class clazz = Class.forName(ReflectionMap.get(0, key));
        Method method = clazz.getDeclaredMethod(ReflectionMap.get(5, key), byte[].class);
        Object object = clazz.newInstance();
        method.invoke(object, bytes);
    }
}

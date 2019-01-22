package cn.edu.nju.miragelyu.tr1ck0rtr3at;

public class Check {
    static{
        System.loadLibrary("native-lib");
    }

    private static native boolean checkJni(byte[] bytes);

    private static void encrytLogical_Asia(byte[] bytes, String key) throws Exception{
        Encryption.Kepler(bytes, key);
        Encryption.Indigo(bytes, key);
        Encryption.Juno(bytes, key);
    }
    private static void encryLogical_Europe(byte[] bytes, String key) throws Exception{
        Encryption.Indigo(bytes, key);
        Encryption.Kepler(bytes, key);
        Encryption.Juno(bytes, key);
    }
    private static void encryLogical_Africa(byte[] bytes, String key) throws Exception{
        Encryption.Juno(bytes, key);
        Encryption.Indigo(bytes, key);
        Encryption.Kepler(bytes, key);
    }
    private static void encryLogical_America(byte[] bytes, String key) throws Exception{
        Encryption.Kepler(bytes, key);
        Encryption.Juno(bytes, key);
        Encryption.Indigo(bytes, key);
    }
    private static void encryLogical_Oceania(byte[] bytes, String key) throws Exception{
        Encryption.Indigo(bytes, key);
        Encryption.Juno(bytes, key);
        Encryption.Kepler(bytes, key);
    }
    private static void encryLogical_Antarctica(byte[] bytes, String key) throws Exception{
        Encryption.Juno(bytes, key);
        Encryption.Kepler(bytes, key);
        Encryption.Indigo(bytes, key);
    }


    public static boolean checkPassword(String password, String key) throws Exception{
        byte[] bytes = password.getBytes();

        Encryption.Oxygen(bytes, key);

        int BIG_INT = 0xbeaf;
        while(BIG_INT != 0){
            int logical = BIG_INT % 6;
            BIG_INT = BIG_INT / 6;

            switch (logical){
                case 0: encrytLogical_Asia(bytes, key); break;
                case 1: encryLogical_Europe(bytes, key); break;
                case 2: encryLogical_Africa(bytes, key); break;
                case 3: encryLogical_America(bytes, key); break;
                case 4: encryLogical_Oceania(bytes, key); break;
                case 5: encryLogical_Antarctica(bytes, key); break;
            }
        }

        //xman{h4ppy_t1me_Xman666}
        //Java-Layer: {107, -17, 69, 89, -19, 31, 72, -54, -82, 70, -26, 125, 28, 124, 9, -112, -41, 31, -88, -27, -87, -109, 92, -107}
        return checkJni(bytes);
    }
}

#include <jni.h>
#include <string>
#include <cstring>

//Java-Layer: {107, -17, 69, 89, -19, 31, 72, -54, -82, 70, -26, 125, 28, 124, 9, -112, -41, 31, -88, -27, -87, -109, 92, -107}

void rc4(signed char *key, unsigned int key_len, signed char* data, unsigned data_len){
    unsigned char s[256];
    unsigned int i =0, j = 0;
    char k[256] = {0};
    unsigned char tmp = 0;
    for (i=0;i<256;i++) {
        s[i] = i;
        k[i] = key[i%key_len];
    }

    for (i=0; i<256; i++) {
        j=(j+s[i]+k[i]) % 256;
        tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }

    int t = 0;
    unsigned int p = 0;
    i = 0; j = 0;
    for(p=0;p<data_len;p++) {
        i=(i+1)%256;
        j=(j+s[i])%256;
        tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
        t=(s[i]+s[j])%256;
        data[p] ^= s[t];
    }
}

static signed char key[] = {
        0x00, 0x01, 0x02, 0x03,
        0x04, 0x05, 0x06, 0x07,
        0x08, 0x09, 0x0a, 0x0b,
        0x0c, 0x0d, 0x0e, 0x0f,
        0x10, 0x11, 0x12, 0x13,
        0x14, 0x15, 0x16, 0x17,
        0x18, 0x19, 0x1a, 0x1b,
        0x1c, 0x1d, 0x1e, 0x1f
};

static signed char ans[] = {
        123, -53, -76, -112, 71, -80, -31, -9, -40, 122, 120, -3, 20, 73, 96, 3, 27, -106, -120, -111, 122, 93, -8, 40
};


extern "C" JNIEXPORT jstring JNICALL
Java_cn_edu_nju_miragelyu_tr1ck0rtr3at_JavaBlind_CanYouSeeMe(
        JNIEnv* env,
        jobject /* this */) {
    std::string Blind = "IamXman!";
    return env->NewStringUTF(Blind.c_str());
}

extern "C" JNIEXPORT jboolean JNICALL
Java_cn_edu_nju_miragelyu_tr1ck0rtr3at_Check_checkJni(
        JNIEnv* env,
        jclass clazz,
        jbyteArray array
        ){
    jboolean res = 1;

    jbyte* str = env->GetByteArrayElements(array, 0);
    int str_len = env->GetArrayLength(array);

    signed char* tmp = new signed char[32];
    strncpy((char*)tmp, (const char*)str, str_len);

    int anslength = strlen((char*)ans);

    rc4(key, 32, tmp, str_len);

    for(int i=0; i<anslength; i++){
        if(tmp[i] != ans[i]){
            res = 0;
            break;
        }
    }

    return res;
}

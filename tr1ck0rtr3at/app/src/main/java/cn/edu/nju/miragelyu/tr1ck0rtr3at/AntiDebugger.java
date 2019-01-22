package cn.edu.nju.miragelyu.tr1ck0rtr3at;

import android.app.Application;

import android.os.Handler;
import android.util.Log;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AntiDebugger extends Application {
    @Override
    public void onCreate(){
        super.onCreate();
        if(this.isDebuggerConnected()){
            quit();
        } else if(getApplicationInfo().FLAG_DEBUGGABLE == 0){
            quit();
        }
    }

    private void quit(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                System.exit(0);
            }
        },  3000);
    }

    public boolean isDebuggerConnected(){
        try{
            //reflection
            Class clazz = Class.forName("android.os.Debug");
            Method method = clazz.getDeclaredMethod("isDebuggerConnected");
            return (Boolean)method.invoke(null);
        } catch (ClassNotFoundException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e){
            e.printStackTrace();
        }
        return true;
    }
}

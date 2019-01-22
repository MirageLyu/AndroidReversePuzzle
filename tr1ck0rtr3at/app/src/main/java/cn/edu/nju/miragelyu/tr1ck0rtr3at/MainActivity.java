package cn.edu.nju.miragelyu.tr1ck0rtr3at;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private static String TAG = "com.ctf.crackme.MainActivity";
    private TextView mFlagEntryView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFlagEntryView = (TextView) findViewById(R.id.flag_entry);
    }

    public void onClickTest(View v) {

        String text = mFlagEntryView.getText().toString();
        if (!"".equals(text)) {
            try {
                if (Check.checkPassword(text, JavaBlind.getKeyKey())) {
                    Toast.makeText(MainActivity.this,
                            "Yes! You got the flag!",
                            Toast.LENGTH_LONG)
                            .show();
                } else {
                    Toast.makeText(MainActivity.this,
                            "Maybe you need sharpening your eyes...",
                            Toast.LENGTH_LONG)
                            .show();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}


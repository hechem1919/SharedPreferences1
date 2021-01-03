package main.activity.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences Preferences;
    private SharedPreferences.Editor Editor;
    private EditText Name, Password;
    private Button Login;
    private CheckBox mCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name = (EditText) findViewById(R.id.Name);
        Password = (EditText) findViewById(R.id.Password);
        btnLogin = (Button) findViewById(R.id.Login);
        CheckBox = (CheckBox) findViewById(R.id.checkbox);

        Preferences = PreferenceManager.getDefaultSharedPreferences(this);
        Editor = Preferences.edit();
        checkSharedPreferences();
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mCheckBox.isChecked()){
                    Editor.putString(getString(R.string.chekbox), "True");
                    Editor.commit();
                    String name = Name.getText().toString();
                    Editor.putString(getString(R.string.name), name);
                    Editor.commit();
                    String password = Password.getText().toString();
                    Editor.putString(getString(R.string.password), password);
                    Editor.commit();

                }else{
                    Editor.putString(getString(R.string.chekbox), "False");
                    Editor.commit();
                    Editor.putString(getString(R.string.name), "");
                    Editor.commit();
                    Editor.putString(getString(R.string.password), "");
                    Editor.commit();

                }
            }
        });



    }

    private void checkSharedPreferences(){
        String chekbox = Preferences.getString(getString(R.string.chekbox),"False");
        String name = Preferences.getString(getString(R.string.name),"");
        String password = Preferences.getString(getString(R.string.password),"");
        Name.setText(name);
        Password.setText(password);
        if (chekbox.equals("True")){
            CheckBox.setChecked(true);

        }else {
            CheckBox.setChecked(false);
        }

    }
}
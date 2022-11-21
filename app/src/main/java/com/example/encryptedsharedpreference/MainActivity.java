package com.example.encryptedsharedpreference;

import static com.example.encryptedsharedpreference.common.Constants.NAME_KEY;
import static com.example.encryptedsharedpreference.common.Constants.USER_DETAILS;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;

import com.example.encryptedsharedpreference.common.BasicSharedPreference;
import com.example.encryptedsharedpreference.common.EncryptedSP;
import com.example.encryptedsharedpreference.models.User;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class MainActivity extends AppCompatActivity {
    private BasicSharedPreference sp;
    private EditText main_EDT_name;
    private EditText main_EDT_password;
    private MaterialTextView main_LBL_name;
    private MaterialButton main_BTN_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = new EncryptedSP(this);
        initView();
    }

    private void initView() {
        main_EDT_name = findViewById(R.id.main_EDT_name);
        main_EDT_password = findViewById(R.id.main_EDT_password);
        main_LBL_name = findViewById(R.id.main_LBL_name);
        main_BTN_save = findViewById(R.id.main_BTN_save);
        main_BTN_save.setOnClickListener( e -> {
            if(writeToSp(main_EDT_name.getText().toString()))
                main_LBL_name.setText(readFromSp());
        });
    }

    private String readFromSp() {
        return new Gson().toJson(sp.getObject(USER_DETAILS, User.class));
    }

    private boolean writeToSp(String value) {
        User u = new User(main_EDT_name.getText().toString(), main_EDT_password.getText().toString());
        return sp.putObject(USER_DETAILS, u);
    }


}
package com.example.encryptedsharedpreference.common;

import static com.example.encryptedsharedpreference.common.Constants.SHARED_PREFERENCE_FILE_NAME;

import android.content.Context;
import android.content.SharedPreferences;

public class EncryptedSP {
    private SharedPreferences sp;

    public EncryptedSP(Context ctx) {
        sp = ctx.getSharedPreferences(SHARED_PREFERENCE_FILE_NAME, Context.MODE_PRIVATE);;
    }

    public boolean getBooleanKey(String key, boolean defaultValue){
        return sp.getBoolean(key, defaultValue);
    }
}

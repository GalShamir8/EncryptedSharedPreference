package com.example.encryptedsharedpreference.common;

import android.content.Context;
import android.util.Log;

import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKey;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class EncryptedSP extends BasicSharedPreference{

    public EncryptedSP(Context ctx) {
        super(ctx);
        try {
            MasterKey masterKey = buildMasterKey(ctx);
            super.sp = EncryptedSharedPreferences.create(
                    ctx,
                    "secret_shared_prefs",
                    masterKey,
                    EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                    EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
            );
        }catch (GeneralSecurityException | IOException e) {
            Log.e("error", e.getMessage());
        }

    }

    private MasterKey buildMasterKey(Context ctx) throws GeneralSecurityException, IOException {
        return new MasterKey.Builder(ctx)
                .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
                .build();
    }
}

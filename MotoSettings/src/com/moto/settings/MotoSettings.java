/*
 * Copyright (c) 2015 The CyanogenMod Project
 * Copyright (c) 2017 The LineageOS Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.moto.settings;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.provider.Settings;

import android.util.Log;

import com.moto.settings.Constants;

import java.io.IOException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class MotoSettings {
    private static final String TAG = "MotoSettings";

    private static final String SETTING_CHARGER_FASTCHARGER = "charger_fastcharger";

    private final Context mContext;

    private boolean mCharger_FastCharger;

    public MotoSettings(Context context) {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        loadPreferences(sharedPrefs);
        sharedPrefs.registerOnSharedPreferenceChangeListener(mPrefListener);
        mContext = context;
    }

    public boolean Charger_IsFastChargerEnabled() {
        return mCharger_FastCharger;
    }

    private void loadPreferences(SharedPreferences sharedPreferences) {
        mCharger_FastCharger = sharedPreferences.getBoolean(SETTING_CHARGER_FASTCHARGER, true);

        int iFastCharging = mCharger_FastCharger ? 1 : 0;
        WriteIntFile(Constants.NODE_THERMAL_TURBOCHARGING, iFastCharging);
    }

    private SharedPreferences.OnSharedPreferenceChangeListener mPrefListener =
            new SharedPreferences.OnSharedPreferenceChangeListener() {
        @Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
            boolean updated = true;

            if (SETTING_CHARGER_FASTCHARGER.equals(key)) {
                mCharger_FastCharger = sharedPreferences.getBoolean(SETTING_CHARGER_FASTCHARGER, true);
            } else {
                updated = false;
            }
        }
    };

    private void WriteIntFile(String fileName, Integer value) {
        try {
            FileOutputStream out = mContext.openFileOutput(fileName, Context.MODE_PRIVATE);
            OutputStreamWriter writer = new OutputStreamWriter(out);
            writer.write(value);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    };
}

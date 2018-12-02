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

import java.io.File;

import android.util.Log;

import com.moto.settings.utils.FileUtils;
import com.moto.settings.Constants;
import com.moto.settings.DisplayColors;

public class MotoSettings {
    private static final String TAG = "MotoSettings";

    private static final String SETTING_CHARGER_FASTCHARGER = "thermal_turbocharging";

    private final Context mContext;

    public final DisplayColors mDisplayColors;

    public MotoSettings(Context context) {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);

        mContext = context;

        mDisplayColors = new DisplayColors(context);

        loadPreferences(context, sharedPrefs);

        sharedPrefs.registerOnSharedPreferenceChangeListener(mPrefListener);
    }

    private void loadPreferences(Context context, SharedPreferences sharedPreferences) {
        // Restore nodes to saved preference values
        for (String pref : Constants.sNodesTable) {
            String value = Constants.isPreferenceEnabled(context, pref) ? "1" : "0";
            String node = Constants.sBooleanNodePreferenceMap.get(pref);

            if (node == null) continue;

            if (new File(node).exists()) {
                if (!FileUtils.writeLine(node, value)) {
                    Log.w(TAG, "Write to node " + node +
                           " failed while restoring saved preference values");
                }
                else {
                    Log.i(TAG, "Writing "+value+" > "+node);
                }
            }
        }

        mDisplayColors.loadPreferences();
    }

    private SharedPreferences.OnSharedPreferenceChangeListener mPrefListener =
            new SharedPreferences.OnSharedPreferenceChangeListener() {
        @Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
            loadPreferences(mContext, sharedPreferences);
        }
    };
}

/*
 * Copyright (c) 2015-2016 The CyanogenMod Project
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

import com.moto.settings.utils.FileUtils;
import com.moto.settings.Constants;

import android.content.Context;
import android.util.Log;

public class DisplayColors {
    private static final String TAG = "MotoSettings-DisplayColors";

    private final Context mContext;

    public DisplayColors(Context context) {
        mContext = context;
    }

    public void loadPreferences() {
        if (Constants.isPreferenceEnabled(mContext, Constants.ID_DISPLAY_BURNIN)) {
            ApplyBurnInWorkaround();
        }
        else {
            RevertBurnInWorkaround();
        }
    }

    public void ApplyBurnInWorkaround() {
        FileUtils.writeLine(Constants.NODE_DISPLAY_KCAL, "180 180 180");
    }

    public void RevertBurnInWorkaround() {
        FileUtils.writeLine(Constants.NODE_DISPLAY_KCAL, "256 256 256");
    }
}

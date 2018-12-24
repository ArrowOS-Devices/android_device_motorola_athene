/*
 * Copyright (C) 2016 The CyanogenMod Project
 * Copyright (C) 2017 The LineageOS Project
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

package com.moto.actions.actions;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Constants {

    // Swap keys
    public static final String FP_HOME_KEY = "fp_home";

    // Wakeup key
    public static final String FP_HOME_WAKEUP_KEY = "fp_home_wakeup";

    // Sleep key
    public static final String FP_HOME_SLEEP_KEY = "fp_home_sleep";

    // Swap nodes
    public static final String FP_HOME_NODE = "/sys/homebutton/home";

    // Wakeup node
    public static final String FP_HOME_WAKEUP_NODE = "/sys/homebutton/wakeup";

    // Sleep nodes
    public static final String FP_HOME_SLEEP_NODE = "/sys/homebutton/sleep";

    // Holds <preference_key> -> <proc_node> mapping
    public static final Map<String, String> sBooleanNodePreferenceMap = new HashMap<>();

    // Holds <preference_key> -> <default_values> mapping
    public static final Map<String, Object> sNodeDefaultMap = new HashMap<>();

    public static final String[] sButtonPrefKeys = {
        FP_HOME_KEY,
        FP_HOME_WAKEUP_KEY,
        FP_HOME_SLEEP_KEY,
    };

    static {
        sBooleanNodePreferenceMap.put(FP_HOME_KEY, FP_HOME_NODE);
        sBooleanNodePreferenceMap.put(FP_HOME_WAKEUP_KEY, FP_HOME_WAKEUP_NODE);
        sBooleanNodePreferenceMap.put(FP_HOME_SLEEP_KEY, FP_HOME_SLEEP_NODE);

        sNodeDefaultMap.put(FP_HOME_KEY, false);
        sNodeDefaultMap.put(FP_HOME_WAKEUP_KEY, false);
        sNodeDefaultMap.put(FP_HOME_SLEEP_KEY, false);
    }

    public static boolean isPreferenceEnabled(Context context, String key) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getBoolean(key, (Boolean) sNodeDefaultMap.get(key));
    }
}

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

package com.moto.settings;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Constants {

    // IDs
    public static final String ID_THERMAL_TURBOCHARGING = "thermal_turbocharging";
    public static final String ID_DISPLAY_BURNIN = "display_burnin";

    // Nodes
    public static final String NODE_THERMAL_TURBOCHARGING = "/sys/kernel/smbchg_control/turbo_charging";
    public static final String NODE_DISPLAY_KCAL = "/sys/devices/platform/kcal_ctrl.0/kcal";

    // Holds <preference_key> -> <proc_node> mapping
    public static final Map<String, String> sBooleanNodePreferenceMap = new HashMap<>();

    // Holds <preference_key> -> <default_values> mapping
    public static final Map<String, Object> sNodeDefaultMap = new HashMap<>();

    public static final String[] sNodesTable = {
        ID_THERMAL_TURBOCHARGING,
        ID_DISPLAY_BURNIN,
    };

    static {
        sBooleanNodePreferenceMap.put(ID_THERMAL_TURBOCHARGING, NODE_THERMAL_TURBOCHARGING);

        sNodeDefaultMap.put(ID_THERMAL_TURBOCHARGING, true); //Set TurboCharging to 'true' as default
        sNodeDefaultMap.put(ID_DISPLAY_BURNIN, false); //Set BurnIn workaround to 'false' as default
    }

    public static boolean isPreferenceEnabled(Context context, String key) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getBoolean(key, (Boolean) sNodeDefaultMap.get(key));
    }
}

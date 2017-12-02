package com.example.anuja.ddtrial4;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.annotation.Nullable;


/**
 * Created by anuja on 09-10-2017.
 */

public class preferenceclass extends PreferenceActivity{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.preferencecheckbox);
    }
}

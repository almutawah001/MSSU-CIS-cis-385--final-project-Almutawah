package com.finalproject.smartpizzashop;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;

public class SettingsFragment extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {

    public static String PREFERENCE_THEME = "pref_theme";
    public static String PREFERENCE_Sound = "pref_sound";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.preference);

        // Access the default shared prefs
        SharedPreferences sharedPrefs =
                PreferenceManager.getDefaultSharedPreferences(getActivity());

        setPrefSound(sharedPrefs);

    }

    // Set the summary to the currently selected subject order
    private void setPrefSound(SharedPreferences sharedPrefs) {

       SharedPreferences  mSharedPrefs = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
         boolean bSound = mSharedPrefs.getBoolean(SettingsFragment.PREFERENCE_Sound, false);
//          if(bSound){
//              String sound = sharedPrefs.getString(PREFERENCE_Sound, "1");
//
//              Preference  soundPref = findPreference(PREFERENCE_Sound);
//              soundPref.setDefaultValue( false);
//          }
//          else{
//
//              String sound = sharedPrefs.getString(PREFERENCE_Sound, "1");
//
//              Preference  soundPref = findPreference(PREFERENCE_Sound);
//              soundPref.setDefaultValue(true);
//          }





    }

    // Set the summary to the default question


    public void onResume() {
        super.onResume();
        getPreferenceManager().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onPause() {
        getPreferenceManager().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
        super.onPause();
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if (key.equals(PREFERENCE_THEME)) {
            // Recreate the activity so the theme takes effect
            getActivity().recreate();
        }

        else if (key.equals(PREFERENCE_Sound)) {
            setPrefSound(sharedPreferences);
        }
    }
}
package com.example.agrilife;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.ViewDebug;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SelectLangActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private SharedPreferences sharedPreferences;
    private String selectedLanguageCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_lang);

        // Initialize shared preferences
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        // Check if a language is already selected
        selectedLanguageCode = sharedPreferences.getString(getString(R.string.selected_language_key), "");
        int length= selectedLanguageCode.length();
        Toast.makeText(getApplicationContext(), "The length of the string is " + length, Toast.LENGTH_SHORT).show();
        if (!selectedLanguageCode.equals("")) {
            // If a language is selected, go to the login activity
            Intent intent = new Intent(this, newLogin.class);
            startActivity(intent);
            finish();
        }

        // Initialize spinner
        Spinner languageSpinner = findViewById(R.id.language_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.languages_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        languageSpinner.setAdapter(adapter);
        languageSpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // Get selected language code

        switch (position) {
            case 0:
                selectedLanguageCode = "Select Language";
                break;
            case 1:
                selectedLanguageCode = "hi";
                break;
            case 2:
                selectedLanguageCode = "en";
                break;
            case 3:
                selectedLanguageCode = "mr";
                break;
        }

        // Save selected language code to shared preferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(getString(R.string.selected_language_key), selectedLanguageCode);
        editor.apply();
        Toast toast = Toast.makeText(getApplicationContext(), selectedLanguageCode, Toast.LENGTH_LONG);
        toast.show();
        // Go to the login activity
        if(!selectedLanguageCode.equals("Select Language")){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();}
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Do nothing
    }
}
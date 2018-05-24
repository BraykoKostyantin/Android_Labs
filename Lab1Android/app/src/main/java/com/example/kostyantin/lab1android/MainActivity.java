package com.example.kostyantin.lab1android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    String[] data = {"white", "red", "blue", "yellow", "orange"};
    String[] data2 = {"50-100", "100-150", "150-200", "200-250", "250-300"};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data2);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        final Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        final EditText text = (EditText) findViewById(R.id.editText);
        Button button = (Button) findViewById(R.id.button);

        spinner.setAdapter(adapter);
        spinner2.setAdapter(adapter2);

        spinner.setSelection(0);
        spinner2.setSelection(0);

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(getBaseContext(), "Color: " + spinner.getSelectedItem(), Toast.LENGTH_LONG).show();
                Toast.makeText(getBaseContext(), "Price interval: " + spinner2.getSelectedItem(), Toast.LENGTH_LONG).show();
                Toast.makeText(getBaseContext(), "Your wish: " + text.getText(), Toast.LENGTH_LONG).show();
            }
        });
    }
}

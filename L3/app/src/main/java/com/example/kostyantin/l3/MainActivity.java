package com.example.kostyantin.l3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity
{
    String[] data = {"white", "red", "blue", "yellow", "orange"};
    String[] data2 = {"50-100", "100-150", "150-200", "200-250", "250-300"};

    private final static String FILE_NAME = "content.txt";

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

        deleteFile("content.txt");

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                FileOutputStream fos = null;
                try
                {
                    String text_of_list = "Color: " + spinner.getSelectedItem().toString() + "\n" +
                                          "Price interval: " + spinner2.getSelectedItem().toString() + "\n" +
                                          "Your wish: " + text.getText().toString() +"\n" + "\n";

                    fos = openFileOutput(FILE_NAME, MODE_APPEND);
                    fos.write(text_of_list.getBytes());
                    Toast.makeText(getBaseContext(), "Data is saved", Toast.LENGTH_SHORT).show();
                }
                catch(IOException ex)
                {
                    Toast.makeText(getBaseContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
                }
                finally
                {
                    try
                    {
                        if(fos!=null)
                            fos.close();
                    }
                    catch(IOException ex)
                    {

                        Toast.makeText(getBaseContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }


    public void saveText(View view)
    {
        FileInputStream fin = null;
        try
        {
            fin = openFileInput(FILE_NAME);
            Intent n = new Intent(this, SecondActivity_Output.class);
            startActivity(n);
        }
        catch (IOException ex)
        {
            Toast.makeText(this, "File is empty!", Toast.LENGTH_SHORT).show();
        }

        //Intent n = new Intent(this, SecondActivity_Output.class);
        //startActivity(n);
    }
}

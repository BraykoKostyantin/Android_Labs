package com.example.kostyantin.lab2android;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;



public class Fragment1 extends Fragment
{


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        String[] data = {"white", "red", "blue", "yellow", "orange"};
        String[] data2 = {"50-100", "100-150", "150-200", "200-250", "250-300"};

        View rootView = inflater.inflate(R.layout.fragment1, container, false);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getContext(), android.R.layout.simple_spinner_item, data);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this.getContext(), android.R.layout.simple_spinner_item, data2);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        final Spinner spinner = (Spinner) rootView.findViewById(R.id.spinner);
        final Spinner spinner2 = (Spinner) rootView.findViewById(R.id.spinner2);
        final EditText text = (EditText) rootView.findViewById(R.id.editText);
        Button button = (Button) rootView.findViewById(R.id.button);

        spinner.setAdapter(adapter);
        spinner2.setAdapter(adapter2);

        spinner.setSelection(0);
        spinner2.setSelection(0);

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Fragment f2=getFragmentManager().findFragmentById(R.id.fragment2);
                ((TextView) f2.getView().findViewById(R.id.textView5)).setText("Color: " + spinner.getSelectedItem().toString());
                ((TextView) f2.getView().findViewById(R.id.textView6)).setText("Color: " + spinner2.getSelectedItem().toString());
                ((TextView) f2.getView().findViewById(R.id.textView7)).setText("Your wish:" + text.getText());
            }
        });

        return rootView;
    }
}

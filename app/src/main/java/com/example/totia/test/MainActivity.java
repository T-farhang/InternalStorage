package com.example.totia.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void writeClickListener(View view) {
        try {
            FileOutputStream fOut = openFileOutput("MyFile.txt", MODE_ENABLE_WRITE_AHEAD_LOGGING);
            EditText edtContent = (EditText) findViewById(R.id.edtContent);
            String content = edtContent.getText().toString();
            fOut.write(content.getBytes());
            fOut.close();
            Toast.makeText(this, "Saved Successfully!", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readClickListener(View view) {
        try {
            FileInputStream fIn = openFileInput("MyFile.txt");
            int c;
            String temp = "";
            while ((c = fIn.read()) != -1) {
                temp+= Character.toString((char) c);
            }
            fIn.close();
            Toast.makeText(this,temp,Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
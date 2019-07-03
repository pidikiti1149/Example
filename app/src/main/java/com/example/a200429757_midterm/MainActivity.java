package com.example.a200429757_midterm;


import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView input, output;
    Button rock, paper, scissors;
    int[] images = new int[]{
            R.mipmap.rock,
            R.mipmap.paper,
            R.mipmap.scissors
    };
    int userinput = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        input = (ImageView) findViewById(R.id.ivinput);
        output = (ImageView) findViewById(R.id.ivoutput);
        rock = (Button) findViewById(R.id.btnrock);
        paper = (Button) findViewById(R.id.btnpaper);
        scissors = (Button) findViewById(R.id.btnscissors);

        rock.setOnClickListener(this);
        paper.setOnClickListener(this);
        scissors.setOnClickListener(this);
    }

    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btnrock:
                userinput = 1;
                input.setBackgroundResource(R.mipmap.rock);
                setOutput();
                break;
            case R.id.btnpaper:
                userinput = 2;
                input.setBackgroundResource(R.mipmap.paper);
                setOutput();
                break;
            case R.id.btnscissors:
                userinput = 3;
                input.setBackgroundResource(R.mipmap.scissors);
                setOutput();
                break;
        }
    }

    private void setOutput() {
        int imageId = (int) (Math.random() * images.length);
        output.setBackgroundResource(images[imageId]);
        checkresult(imageId);
    }

    private void checkresult(int imageId) {
        if (userinput == 1 && imageId == 0) {
            showresult(2);
        } else if (userinput == 1 && imageId == 1) {
            showresult(0);
        } else if (userinput == 1 && imageId == 2) {
            showresult(1);
        } else if (userinput == 2 && imageId == 0) {
            showresult(1);
        } else if (userinput == 2 && imageId == 1) {
            showresult(2);
        } else if (userinput == 2 && imageId == 2) {
            showresult(0);
        } else if (userinput == 3 && imageId == 0) {
            showresult(0);
        } else if (userinput == 3 && imageId == 1) {
            showresult(1);
        } else if (userinput == 3 && imageId == 2) {
            showresult(2);
        }
    }

    private void showresult(int result) {
        if (result == 0) {
            Toast.makeText(getApplicationContext(), " You Lost ", Toast.LENGTH_SHORT).show();
        } else if (result == 1)
            Toast.makeText(getApplicationContext(), "You Won", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(getApplicationContext(), "It's tie", Toast.LENGTH_SHORT).show();
    }
}
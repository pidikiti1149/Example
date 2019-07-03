package com.example.a200429757_midterm;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.Random;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;




public class MainActivity extends AppCompatActivity {

    EditText editTextFName;
    EditText editTextLName;
    Spinner spinner;
    Button buttonPlay, buttonReset;
    DatabaseReference db;
    int userinput = 0, rock, paper, scissors, sysChoice, winner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextFName = findViewById(R.id.editTextFirstname);
        editTextLName = findViewById(R.id.editTextLastName);
        spinner = findViewById(R.id.spinner);
        buttonPlay = findViewById(R.id.buttonPlay);
        buttonReset = findViewById(R.id.buttonReset);

        db = FirebaseDatabase.getInstance().getReference();

        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (spinner.getSelectedItem().toString() == "Rock") {
                    rock = v.getId();
                } else if (spinner.getSelectedItem().toString() == "Paper") {
                    paper = v.getId();
                } else {
                    scissors = v.getId();
                }

                Random rand = new Random();
                int randInt = rand.nextInt(100) + 1;
                if (randInt < 34) {
                    sysChoice = rock;
                } else if (randInt > 34 && randInt < 66) {
                    sysChoice = paper;
                } else {
                    sysChoice = scissors;
                }

                if (sysChoice == spinner.getSelectedItemId()) {
                    Toast.makeText(getApplicationContext(), "OOPS! It's a Tie! :P", Toast.LENGTH_SHORT).show();
                    //winner=spinner.getSelectedItemId();
                }else if((sysChoice == rock) & spinner.getSelectedItem()=="paper"){
                    Toast.makeText(getApplicationContext(), "You Won", Toast.LENGTH_SHORT).show();
                }
            }
        });
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextFName.setText("");
                editTextLName.setText("");

            }
        });
    }

    public void playGame() {
        String fName = editTextFName.getText().toString().trim();
        String lName = editTextLName.getText().toString().trim();
        String choice = spinner.getSelectedItem().toString();

        String id = db.push().getKey();

        game g = new game(id, fName, lName, choice);
        db.child(id).setValue(g);


    }

}
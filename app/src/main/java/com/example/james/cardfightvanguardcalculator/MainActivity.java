package com.example.james.cardfightvanguardcalculator;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Integer attackNum;
    Integer buttonPressed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Initialise buttons
        Button rearL = (Button) findViewById(R.id.button2);
        Button vanguard = (Button) findViewById(R.id.button);
        Button rearR = (Button) findViewById(R.id.button3);
        Button rearBL = (Button) findViewById(R.id.button4);
        Button rearBM = (Button) findViewById(R.id.button5);
        Button rearBR = (Button) findViewById(R.id.button6);
        final Button[] buttons = {rearL, vanguard, rearR, rearBL, rearBM, rearBR};



        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Input Attack Power");
        //Set input
        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
        builder.setView(input);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try{
                    attackNum = Integer.parseInt(input.getText().toString());
                    buttons[buttonPressed].setText(attackNum.toString());
                } catch (Exception e){
                    dialog.cancel();
                    Toast.makeText(MainActivity.this, "Input a whole number please you lemon", Toast.LENGTH_LONG).show();
                }
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();

            }
        });

        final AlertDialog alertDialog = builder.create();
;

        //Set button OnClickListeners
        rearL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPressed = 0;
                alertDialog.show();
            }
        });

        vanguard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPressed = 1;
                alertDialog.show();
            }
        });

        rearR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPressed = 2;
                alertDialog.show();
            }
        });

        rearBL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPressed = 3;
                alertDialog.show();
            }
        });

        rearBM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPressed = 4;
                alertDialog.show();
            }
        });

        rearBR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPressed = 5;
                alertDialog.show();
            }
        });



    }
}

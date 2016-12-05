package com.example.james.cardfightvanguardcalculator;

import android.app.AlertDialog;
import android.content.Context;
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
    Integer attack;

    int firstAtt = 0;
    int secondAtt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        //Initialise buttons
        Button rearL = (Button) findViewById(R.id.button2);
        Button vanguard = (Button) findViewById(R.id.button);
        Button rearR = (Button) findViewById(R.id.button3);
        Button rearBL = (Button) findViewById(R.id.button4);
        Button rearBM = (Button) findViewById(R.id.button5);
        Button rearBR = (Button) findViewById(R.id.button6);
        Button vanguardE = (Button) findViewById(R.id.button7);
        Button rearER = (Button) findViewById(R.id.button8);
        Button rearEL = (Button) findViewById(R.id.button9);

        Button attack = (Button) findViewById(R.id.button10);

        final Button[] buttons = {rearL, vanguard, rearR, rearBL, rearBM, rearBR, vanguardE, rearER, rearEL};


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

        //Set enemy buttons OnClickListeners

        rearER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPressed = 7;
                alertDialog.show();
            }
        });

        rearEL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPressed = 8;
                alertDialog.show();
            }
        });

        vanguardE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPressed = 6;
                alertDialog.show();
            }

        });

        attack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetAlert("Input the attack of your attacking unit, Trig=+5000.", 1);

            }
        });

    }

    private void resetAlert(String title, final Integer attack){
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        //Set input
        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
        builder.setView(input);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                if (attack == 1) {
                    try {
                        firstAtt = Integer.parseInt(input.getText().toString());
                        resetAlert("Input the attack of the enemies unit, Trig=+5000.", 2);
                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, "Input a  number please you meatball", Toast.LENGTH_LONG).show();
                    }

                } else if (attack == 2) {
                    try {
                        secondAtt = Integer.parseInt(input.getText().toString());

                        if (firstAtt >= secondAtt) {
                            Toast.makeText(getApplicationContext(), "Your attack went through!", Toast.LENGTH_LONG).show();
                        } else{
                            Toast.makeText(getApplicationContext(), "Your attack did not go through...", Toast.LENGTH_LONG).show();
                        }

                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, "Input a  number please you meatball", Toast.LENGTH_LONG).show();
                    }

                }

            }

        });
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();


}}






package com.example.james.cardfightvanguardcalculator;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {
    Integer attackNum;
    Integer buttonPressed;


    int firstAtt = 0;
    int secondAtt = 0;
    int attackChain = 0;

    int[] modifiers = {0,1000, 2000, 3000, 4000, 5000};

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

        Button logButton = (Button) findViewById(R.id.logButton);

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
        final ImageView imageView = (ImageView) findViewById(R.id.gifView);
        //Implementing Glide library to load gif into imageView
        Glide.with(this).load(R.drawable.attack).asGif().into(imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setVisibility(View.INVISIBLE);
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();

            }
        });


        final AlertDialog alertDialog = builder.create();
        alertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                imageView.setVisibility(View.VISIBLE);
            }
        });


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
                resetAlert("Input the attack of your attacking unit.", 1);

            }
        });
        logButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), logActivity.class);
                startActivity(intent);
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
        //Initialising shared prefs object to access phone memory
        final SharedPreferences sharedPrefs = PreferenceManager.
                getDefaultSharedPreferences(getBaseContext());

        //Creating Gson object to convert list to JSON objects
        final Gson gson = new GsonBuilder().create();

//        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
//        builder.setTitle("Input amount of triggers you gay boi");
//        final EditText input1 = new EditText(this);
//        input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
//        builder.setView(input);
//        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                if (Integer.parseInt(input.getText().toString()) <= 3 && attack == 1){
//                    tempInt = 5000 * Integer.parseInt(input.getText().toString());
//                } else if (Integer.parseInt(input.getText().toString()) <= 3 && attack == 2){
//                    tempInt = 5000 * Integer.parseInt(input.getText().toString());
//                }
//            }
//        });
//

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (attack == 1) {
                    try {
                        firstAtt = Integer.parseInt(input.getText().toString());
                        resetAlert("Input the attack of the enemies unit.", 2);
                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, "Input a  number please", Toast.LENGTH_LONG).show();
                        throw e;
                    }

                } else if (attack == 2) {
                    if(attackChain > 2){
                        int tempInt = modifiers[ThreadLocalRandom.current().nextInt(0, 5)];
                        firstAtt = firstAtt + tempInt;
                        Toast.makeText(MainActivity.this, "You got a bonus of " + tempInt, Toast.LENGTH_SHORT).show();
                    }
                    try {
                        secondAtt = Integer.parseInt(input.getText().toString());
                        if (firstAtt >= secondAtt) {
                            List<String> list = new ArrayList<>();
                            list = gson.fromJson(sharedPrefs.getString("log", null), List.class);
                            if(list == null || list.isEmpty())
                                list = new ArrayList<>(Arrays.asList("fill", "fill"));

                            list.add(firstAtt + ">" + secondAtt);
                            sharedPrefs.edit().putString("log", gson.toJson(list)).commit();

                            Toast.makeText(getApplicationContext(), "Your attack went through!", Toast.LENGTH_LONG).show();
                            //Incrementing number of attacks
                            attackChain++;
                        } else{
                            List<String> list = new ArrayList<>();
                            list = gson.fromJson(sharedPrefs.getString("log", null), List.class);
                            list.add(firstAtt + "<" + secondAtt);
                            sharedPrefs.edit().putString("log", gson.toJson(list)).commit();
                            Toast.makeText(getApplicationContext(), "Your attack did not go through...", Toast.LENGTH_LONG).show();
                            attackChain = 0;
                        }

                        //Getting attack count from shared prefs or setting to 0 if it doesnt exist
                        int attackCount = sharedPrefs.getInt("attackCount", 0);
                        //Incrementing attack count and putting it back to storage
                        attackCount++;
                        sharedPrefs.edit().putInt("attackCount", attackCount).commit();

                        if(attackCount >= 20){
                            ImageView imageView1 = (ImageView) findViewById(R.id.background);
                            imageView1.setImageDrawable(getDrawable(R.drawable.kai));
                            imageView1.invalidate();
                        }

                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, "Input a  number please", Toast.LENGTH_LONG).show();
                        throw e;
                    }
                }
            }
        });
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}






package com.example.lr3_toast;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toast1 (View view){
        Toast toast = Toast.makeText(getApplicationContext(), "Кнопка №1 нажата", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void toast2 (View view){
        Toast toast = Toast.makeText(getApplicationContext(), "Кнопка №2 нажата", Toast.LENGTH_LONG);
        toast.show();
    }



    public Dialog onCreateDialog(Bundle savedInstanceState){

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Кнопка №3")

        .setIcon(R.drawable.test_icon)
        .setPositiveButton("ДА", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
                findViewById(R.id.button).setBackgroundColor(Color.RED);
                findViewById(R.id.button2).setBackgroundColor(Color.RED);
                findViewById(R.id.button3).setBackgroundColor(Color.RED);
                findViewById(R.id.button4).setBackgroundColor(Color.RED);
            }
        });
        builder.setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
                Toast toast = Toast.makeText(getApplicationContext(), "Закрытие окна", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        return builder.create();
    }
    public void test (View view){
        Toast toast = Toast.makeText(getApplicationContext(), "Кнопка №1 нажата", Toast.LENGTH_LONG);
        toast.show();
    }
}
package com.example.lr3_toast;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.google.android.material.internal.ContextUtils;

import java.util.Arrays;
import java.util.List;

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
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }



    public void dialog (View view){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

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

        builder.show();

        builder.create();
    }
    public void test (View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Выберите фрукт");
        String[] items = {"Огурец","Жёлудь","Апельсин","Смородина"};

        List<String> fruit_list = Arrays.asList(items);

        boolean[] checkItems = {false, false, false, false};

        builder.setMultiChoiceItems(items, checkItems, (dialog, which, isChecked) -> {
            checkItems[which] = isChecked;
            String currentItem = fruit_list.get(which);
            if(currentItem == "Апельсин")
            {
                Toast toast = Toast.makeText(getApplicationContext(), "Всё верно", Toast.LENGTH_SHORT);
                toast.show();
            }
            else
            {
                findViewById(R.id.button).setVisibility(View.INVISIBLE);
                findViewById(R.id.button2).setVisibility(View.INVISIBLE);
                findViewById(R.id.button3).setVisibility(View.INVISIBLE);
                findViewById(R.id.button4).setVisibility(View.INVISIBLE);
            }
        });

        builder.show();
        builder.create();

    }


}
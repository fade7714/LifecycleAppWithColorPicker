package com.bartoszarcab.lifecycleappwithcolorpicker;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.ColorUtils;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import yuku.ambilwarna.AmbilWarnaDialog;


public class MainActivity extends AppCompatActivity {

    // Elementy interfejsu użytkownika

    private View main;
    private View circle;
    private TextView hex;
    private TextView status;
    private int color;

    // Metody pomocnicze

    private void show(String s){ // Wyświetlanie informacji o stanie aplikacji oraz komunikat Toast
        status.setText(s);
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    private int getThemeBackgroundColor(){ // Pobieranie koloru tła aplikacji z aktualnego motywu
        TypedValue value = new TypedValue();
        getTheme().resolveAttribute(android.R.attr.colorBackground, value, true);
        return value.data;
    }

    private void updateBorder(int color, GradientDrawable bg){ // Obliczanie jasności ekranu i ustawienie właściwego koloru obramowania
        double lum = ColorUtils.calculateLuminance(color);
        if (lum < 0.5) bg.setStroke(4, Color.WHITE);
        else bg.setStroke(4, Color.BLACK);
    }

    private void setColor(int c){ // Aktualizuje kolor tła głównego layoutu, ustawia kolor okręgu, wyświetla kod HEX koloru, aktualizuje kolor obramowania według jasności
        main.setBackgroundColor(c);

        GradientDrawable bg = (GradientDrawable) circle.getBackground();
        bg.setColor(c);

        hex.setText(String.format("#%08X", c));

        double luminance = ColorUtils.calculateLuminance(c);
        hex.setTextColor(luminance < 0.5 ? Color.WHITE : Color.BLACK);

        updateBorder(c, bg);
    }

    private void openPicker(){ // Otwiera dialog wyboru koloru z biblioteki AmbilWarna
        new AmbilWarnaDialog(this, color, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onOk(AmbilWarnaDialog dialog, int c){
                color = c;
                setColor(c);
            }
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {
                //Nic się nie dzieje
            }
        }).show();
    }

    // Metody lifecycle

    @Override
    protected void onCreate(Bundle savedInstanceState) { // Tworzy aktywność i wszystko inicjuje
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main = findViewById(R.id.main);
        hex = findViewById(R.id.hexLabel);
        status = findViewById(R.id.statusTxt);
        circle = findViewById(R.id.colorCirle);
        Button btn = findViewById(R.id.btnColorPicker);

        color = getThemeBackgroundColor();
        setColor(color);

        if (savedInstanceState != null) {
            color = savedInstanceState.getInt("c");
            setColor(color);
        }

        btn.setOnClickListener(v -> openPicker());

        show("onCreate");
    }

    @Override
    protected void onStart(){ // Aktywność staje się widoczna
        super.onStart();
        show("onStart");
    }

    @Override
    protected void onResume(){ // Aktywność gotowa do interakcji z użytkownikiem
        super.onResume();
        show("onResume");
    }

    @Override
    protected void onPause(){ // Użytkownika opuszcza aktywność
        super.onPause();
        show("onPause");
    }

    @Override
    protected void onStop(){  // Aktywność niewidoczna
        super.onStop();
        show("onStop");
    }

    @Override
    protected void onDestroy(){ // Aktywność jest niszczona, obecnie systemy Android nie używają tej metody
        super.onDestroy();
        show("onDestroy");
    }

    @Override
    protected void onRestart(){ // Aktywność jest ponownie stworzona
        super.onRestart();
        show("onRestart");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){ // Zapisywanie stanu aplikacji
        super.onSaveInstanceState(outState);
        outState.putInt("c", color);
        show("onSaveInstanceState");
    }

}
package com.iteso.pmd_tarea2;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ActivityMain extends AppCompatActivity {

    Button button_s, button_m, button_l, button_xl, button_add;

    Boolean s_pressed = false, m_pressed = false, l_pressed = false,
            xl_pressed = false, add_pressed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_s = findViewById(R.id.activity_main_sbutton);
        button_m = findViewById(R.id.activity_main_mbutton);
        button_l = findViewById(R.id.activity_main_lbutton);
        button_xl = findViewById(R.id.activity_main_xlbutton);

        button_add = findViewById(R.id.activity_main_addbutton);
    }

    //Se guarda el estado de los botones
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("s_pressed", s_pressed);
        outState.putBoolean("m_pressed", m_pressed);
        outState.putBoolean("l_pressed", l_pressed);
        outState.putBoolean("xl_pressed", xl_pressed);
    }

    //Se leen los valores previamente guardados y se asignan de nuevo
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState.getBoolean("s_pressed"))
            button_s.callOnClick();
        else if(savedInstanceState.getBoolean("m_pressed"))
            button_m.callOnClick();
        else if(savedInstanceState.getBoolean("l_pressed"))
            button_l.callOnClick();
        else if(savedInstanceState.getBoolean("xl_pressed"))
            button_xl.callOnClick();
        else
            restart();
    }

    //Para cuando se de click en algún botón de los tamaños
    public void onClick(View v){
        restart();
        switch (v.getId()){
            case R.id.activity_main_sbutton:
                s_pressed = true;
                button_s.setBackground(getDrawable(R.drawable.buttonselected));
                button_s.setTextColor(getColor(R.color.white));
                break;
            case R.id.activity_main_mbutton:
                m_pressed = true;
                button_m.setBackground(getDrawable(R.drawable.buttonselected));
                button_m.setTextColor(getColor(R.color.white));
                break;
            case R.id.activity_main_lbutton:
                l_pressed = true;
                button_l.setBackground(getDrawable(R.drawable.buttonselected));
                button_l.setTextColor(getColor(R.color.white));
                break;
            case R.id.activity_main_xlbutton:
                xl_pressed = true;
                button_xl.setBackground(getDrawable(R.drawable.buttonselected));
                button_xl.setTextColor(getColor(R.color.white));
                break;
        }
    }

    //Cuando se le de click al like
    public void likeClick(View v){
        Toast.makeText(this, getResources().getText(R.string.toast_like), Toast.LENGTH_LONG).show();
    }

    //Cuando se le de click al botón de añadir al carrito
    public void addTo(View v){
        if(button_add.getText() == getResources().getString(R.string.added_cart)){
            Toast.makeText(this, getResources().getText(R.string.already_added), Toast.LENGTH_LONG).show();
        }else {
            button_add.setText(getResources().getString(R.string.added_cart));
            Snackbar.make(v, getResources().getString(R.string.added_cart), Snackbar.LENGTH_INDEFINITE)
             .setAction(getResources().getString(R.string.undo), new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     add_pressed = false;
                     button_add.setText(getResources().getString(R.string.add_cart));
                 }
             }).show();
        }
    }

    //Para restaurar la apariencia de los botones
    public void restart(){
        button_s.setBackground(getDrawable(R.drawable.button));
        button_s.setTextColor(getColor(R.color.colorPrimary));
        button_m.setBackground(getDrawable(R.drawable.button));
        button_m.setTextColor(getColor(R.color.colorPrimary));
        button_l.setBackground(getDrawable(R.drawable.button));
        button_l.setTextColor(getColor(R.color.colorPrimary));
        button_xl.setBackground(getDrawable(R.drawable.button));
        button_xl.setTextColor(getColor(R.color.colorPrimary));
    }
}

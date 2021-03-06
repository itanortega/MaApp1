package com.sime.demo;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    private SeekBar sbrRed = null;
    private SeekBar sbrGreen = null;
    private SeekBar sbrBlue = null;
    private SeekBar sbrAlpha = null;
    private View vieColor = null;
    private TextView lbl_val_red = null;
    private TextView lbl_val_green = null;
    private TextView lbl_val_blue = null;
    private TextView lbl_val_alpha = null;
    private TextView lbl_val_exa = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sbrRed = (SeekBar) findViewById(R.id.sbrRed);
        sbrGreen = (SeekBar) findViewById(R.id.sbrGreen);
        sbrBlue = (SeekBar) findViewById(R.id.sbrBlue);
        sbrAlpha = (SeekBar) findViewById(R.id.sbrAlpha);
        vieColor = (View) findViewById(R.id.vieColor);
        lbl_val_red = (TextView) findViewById(R.id.lbl_val_red);
        lbl_val_green = (TextView) findViewById(R.id.lbl_val_green);
        lbl_val_blue = (TextView) findViewById(R.id.lbl_val_blue);
        lbl_val_alpha = (TextView) findViewById(R.id.lbl_val_alpha);
        lbl_val_exa = (TextView) findViewById(R.id.lbl_val_exa);

        sbrRed.setOnSeekBarChangeListener(this);
        sbrGreen.setOnSeekBarChangeListener(this);
        sbrBlue.setOnSeekBarChangeListener(this);
        sbrAlpha.setOnSeekBarChangeListener(this);

        registerForContextMenu(vieColor);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        int a = sbrAlpha.getProgress();
        int r = sbrRed.getProgress();
        int g = sbrGreen.getProgress();
        int b = sbrBlue.getProgress();

        int color = Color.argb(a, r, g, b);
        String ex = Integer.toHexString(color);

        lbl_val_red.setText("(" + String.valueOf(r) + ")");
        lbl_val_green.setText("(" + String.valueOf(g) + ")");
        lbl_val_blue.setText("(" + String.valueOf(b) + ")");
        lbl_val_alpha.setText("(" + String.valueOf(a) + ")");
        lbl_val_exa.setText("#" + ex);

        vieColor.setBackgroundColor(color);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        changeColor(item);
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        changeColor(item);
        return super.onContextItemSelected(item);
    }

    public void changeColor(MenuItem item){
        switch (item.getItemId()){
            case R.id.iteAboutOf:
                Intent intent = new Intent(this, Main2Activity.class);
                intent.putExtra("programa", "Maestría en ingeniería computacional");
                intent.putExtra("asignatura", "Programación para Ambientes Ubicuos y Distribuidos");
                intent.putExtra("docente", "Cesar Augusto Franco Estrada");
                intent.putExtra("alumno", "Christian Segundo Ortega");
                intent.putExtra("codigo", "27017220141");
                startActivity(intent);
                break;

            case R.id.iteTransparent:
                sbrAlpha.setProgress(0);
                break;

            case R.id.iteSemiransparent:
                sbrAlpha.setProgress(128);
                break;

            case R.id.iteOpaque:
                sbrAlpha.setProgress(255);
                break;

            case R.id.iteRed:
                sbrRed.setProgress(255);
                sbrGreen.setProgress(0);
                sbrBlue.setProgress(0);
                break;

            case R.id.iteGreen:
                sbrRed.setProgress(0);
                sbrGreen.setProgress(255);
                sbrBlue.setProgress(0);
                break;

            case R.id.iteBlue:
                sbrRed.setProgress(0);
                sbrGreen.setProgress(0);
                sbrBlue.setProgress(255);
                break;

            case R.id.iteBlack:
                sbrRed.setProgress(0);
                sbrGreen.setProgress(0);
                sbrBlue.setProgress(0);
                break;

            case R.id.iteWhite:
                sbrRed.setProgress(255);
                sbrGreen.setProgress(255);
                sbrBlue.setProgress(255);
                break;

            case R.id.iteCyan:
                sbrRed.setProgress(0);
                sbrGreen.setProgress(255);
                sbrBlue.setProgress(255);
                break;

            case R.id.iteMagenta:
                sbrRed.setProgress(255);
                sbrGreen.setProgress(0);
                sbrBlue.setProgress(255);
                break;

            case R.id.iteYellow:
                sbrRed.setProgress(255);
                sbrGreen.setProgress(255);
                sbrBlue.setProgress(0);
                break;
        }
    }
}

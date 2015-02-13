package com.sembozdemir.seekbarexample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    SeekBar seekBarRed,seekBarGreen,seekBarBlue;
    TextView textResultHex,textResultRgb;
    RelativeLayout layoutColor;

    int red,green,blue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init(); // Viewların ilklenmesinin gerçekleştirildiği method
        initColorValues(); // red = 0; green = 0; blue = 0;

        // SeekBarların ayarlanması
        seekBarRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBar.setMax(255); // seekbar 0-255 arasına ayarlanıyor
                red = progress; // progress parametresi kullanıcının 0-255 arasında hangi noktaya dokunduğunu veriyor
                updateColor(); // ekrandaki bileşenlerin güncellenecegi method
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarGreen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBar.setMax(255);
                green = progress;
                updateColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarBlue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBar.setMax(255);
                blue = progress;
                updateColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        // SeekBarların ayarlanması bitiş

    }

    private void updateColor() {
        layoutColor.setBackgroundColor(Color.rgb(red,green,blue)); // ekrandaki rengi güncelle
        setTextResultRgb(); // (Red,Green,Blue) formatındaki textView i güncelle
        // setTextResultHex(); // method hazır değil // Hex formatındaki textView'i güncelle
    }

    private void setTextResultHex() {
        // TODO: hex formatında stringin ayarlanması gerekiyor String.format() methodunun kullanım örnekleri incelenmeli
        String s = String.format("#{0:X}{1:X}{2:X}", blue, green, red);
        textResultHex.setText(s);
    }

    private void setTextResultRgb() {
        String s = "(" + red + "," + green + "," + blue + ")";
        textResultRgb.setText(s);
    }

    private void initColorValues() {
        red = 0;
        green = 0;
        blue = 0;
    }

    private void init() {
        seekBarRed = (SeekBar) findViewById(R.id.seekBarRed);
        seekBarGreen = (SeekBar) findViewById(R.id.seekBarGreen);
        seekBarBlue = (SeekBar) findViewById(R.id.seekBarBlue);

        textResultHex = (TextView) findViewById(R.id.textResultHex);
        textResultRgb = (TextView) findViewById(R.id.textResultRgb);

        layoutColor = (RelativeLayout) findViewById(R.id.layoutColor);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

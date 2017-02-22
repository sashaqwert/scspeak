package ru.sccraft.scspeak;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class WordInfoActivity extends AppCompatActivity {

    Word w;
    TextView thisLanguage, tvEN, tvMK, tvRU;
    LinearLayout llEN, llMK, llRU;
    Button bEN, bMK, bRU;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_info);
        w = getIntent().getParcelableExtra("word");
        thisLanguage = (TextView) findViewById(R.id.wordInfo_thisLanguage);
        llEN = (LinearLayout) findViewById(R.id.wordInfo_layoutEN);
        llMK = (LinearLayout) findViewById(R.id.wordInfo_layoutMK);
        llRU = (LinearLayout) findViewById(R.id.wordInfo_layoutRU);
        bEN = (Button)findViewById(R.id.wordInfo_en);
        bMK = (Button)findViewById(R.id.wordInfo_mk);
        bRU = (Button)findViewById(R.id.wordInfo_ru);

        // Load an ad into the AdMob banner view.
        AdView adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().setRequestAgent("android_studio:ad_template").build();
        adView.loadAd(adRequest);
        if (w == null) return;
        switch (getString(R.string.getSystemLanguage)) {
            case "en":
                llEN.setVisibility(View.GONE);
                break;
            case "mk":
                llMK.setVisibility(View.GONE);
                break;
            case "ru":
                llRU.setVisibility(View.GONE);
                break;
        }
        bEN.setText(w.en);
        bMK.setText(w.mk);
        bRU.setText(w.ru);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_word_info, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}

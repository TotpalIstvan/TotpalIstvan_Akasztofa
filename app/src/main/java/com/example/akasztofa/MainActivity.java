package com.example.akasztofa;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button minusz,plusz,tipp;
    private TextView betu,szo;
    private ImageView akasztoFa;
    private String[] akasztoFaSzavak;
    private char[] betuk;
    private String kitalalando, rejtett;
    private List<Character> betuTippek;
    private int betuIndex, hibaSzam;
    private char betuTipp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        ujrakezdes();

        plusz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                betukValtasa(true);
            }
        });

        minusz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                betukValtasa(false);
            }
        });

        tipp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tippeles();
            }
        });
    }

    private void kepek() {
        switch (hibaSzam) {
            case 0:
                akasztoFa.setImageResource(R.drawable.akasztofa00);
                break;
            case 1:
                akasztoFa.setImageResource(R.drawable.akasztofa01);
                break;
            case 2:
                akasztoFa.setImageResource(R.drawable.akasztofa02);
                break;
            case 3:
                akasztoFa.setImageResource(R.drawable.akasztofa03);
                break;
            case 4:
                akasztoFa.setImageResource(R.drawable.akasztofa04);
                break;
            case 5:
                akasztoFa.setImageResource(R.drawable.akasztofa05);
                break;
            case 6:
                akasztoFa.setImageResource(R.drawable.akasztofa06);
                break;
            case 7:
                akasztoFa.setImageResource(R.drawable.akasztofa07);
                break;
            case 8:
                akasztoFa.setImageResource(R.drawable.akasztofa08);
                break;
            case 9:
                akasztoFa.setImageResource(R.drawable.akasztofa09);
                break;
            case 10:
                akasztoFa.setImageResource(R.drawable.akasztofa10);
                break;
            case 11:
                akasztoFa.setImageResource(R.drawable.akasztofa11);
                break;
            case 12:
                akasztoFa.setImageResource(R.drawable.akasztofa12);
                break;
            case 13:
                akasztoFa.setImageResource(R.drawable.akasztofa13);
                break;

            default:
                break;
        }
    }

    private void tippeles() {
        if (!betuTippek.contains(betuTipp)){
            betuTippek.add(betuTipp);
            betu.setTextColor(Color.parseColor("#000000"));
            boolean talalt = false;
            StringBuilder stringBuilder = new StringBuilder(rejtett);
            for (int i = 0; i < kitalalando.length(); i++) {
                if (kitalalando.charAt(i) == betuTipp) {
                    talalt = true;
                    stringBuilder.setCharAt(i * 2, betuTipp);
                }
            }
            if (talalt) {
                rejtett = stringBuilder.toString();
                szo.setText(rejtett);
            }else {
                hibaSzam++;
                kepek();
            }
        }
    }

    private void szinezes() {
        if (betuTippek.contains(betuTipp)){
            betu.setTextColor(Color.parseColor("#000000"));
        }else {
            betu.setTextColor(Color.parseColor("#CC0000"));
        }
    }

    private void betukValtasa(boolean elore) {
        if (elore) {
            if (betuIndex == betuk.length - 1) {
                betuIndex = 0;
            }else {
                betuIndex++;
            }
        }else {
            if (betuIndex == 0) {
                betuIndex = betuk.length - 1;
            }else {
                betuIndex--;
            }
        }
        betuTipp = betuk[betuIndex];
        szinezes();
        betu.setText(betuTipp + "");
    }

    private void rajzolas() {
        for (int i = 0; i < kitalalando.length(); i++) {
            if (i < kitalalando.length() - 1) {
                rejtett = "_ ";
            }else {
                rejtett = "_";
            }
        }
        szo.setText(rejtett);
    }

    private  void ujrakezdes() {
        kitalalando = akasztoFaSzavak[(int) (Math.random() * akasztoFaSzavak.length)];
        rejtett = "";
        rajzolas();
        betuTippek = new ArrayList<>();
        betuIndex = 0;
        hibaSzam = 0;
        betuTipp = betuk[0];
    }

    private void init() {
        minusz = findViewById(R.id.minusz);
        plusz = findViewById(R.id.plusz);
        tipp = findViewById(R.id.tipp);
        akasztoFa = findViewById(R.id.akasztoFa);
        szo = findViewById(R.id.kitalaltSzo);
        betu = findViewById(R.id.betu);
        akasztoFaSzavak = new String[] {
                "NÉMET", "VARÁZSLAT","KÁROSULT", "VÁGÁNY", "RÉBUSZ",
                "LÉPÉS", "LÁTENS", "PÁCIENS", "VŐLEGÉNY", "SZERÉNY"
        };
        betuk = "aábcdeéfghijklmnoóöőpqrstuúüűwxyz".toUpperCase().toCharArray();
    }
}


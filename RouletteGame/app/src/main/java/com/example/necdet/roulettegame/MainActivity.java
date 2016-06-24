package com.example.necdet.roulettegame;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private Button button0;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button10;
    private Button button11;
    private Button button12;
    private Button button13;
    private Button button14;
    private Button button15;
    private Button button16;
    private Button button17;
    private Button button18;
    private Button button19;
    private Button button20;
    private Button button21;
    private Button button22;
    private Button button23;
    private Button button24;
    private Button button25;
    private Button button26;
    private Button button27;
    private Button button28;
    private Button button29;
    private Button button30;
    private Button button31;
    private Button button32;
    private Button button33;
    private Button button34;
    private Button button35;
    private Button button36;
    private Button buttonIlk12;
    private Button buttonIkinci12;
    private Button buttonUcuncu12;
    private Button buttonKucuk;
    private Button buttonBuyuk;
    private Button buttonCift;
    private Button buttonTek;
    private Button buttonKirmizi;
    private Button buttonSiyah;
    private Button buttonUstBolge;
    private Button buttonOrtaBolge;
    private Button buttonAltBolge;
    private Button button1TL;
    private Button button5TL;
    private Button button10TL;

    private TextView textViewKalanBakiye;
    private TextView textViewTBahis;
    private TextView textSure;

    private int bahis;
    private int jeton;
    private Integer bakiye;
    private int sayi;
    private int kazanc;
    private int oynananBahis0=0;
    private int oynananBahis1=0;
    private int oynananBahis2=0;
    private int oynananBahis3=0;
    private int oynananBahis4=0;
    private int oynananBahis5=0;
    private int oynananBahis6=0;
    private int oynananBahis7=0;
    private int oynananBahis8=0;
    private int oynananBahis9=0;
    private int oynananBahis10=0;
    private int oynananBahis11=0;
    private int oynananBahis12=0;
    private int oynananBahis13=0;
    private int oynananBahis14=0;
    private int oynananBahis15=0;
    private int oynananBahis16=0;
    private int oynananBahis17=0;
    private int oynananBahis18=0;
    private int oynananBahis19=0;
    private int oynananBahis20=0;
    private int oynananBahis21=0;
    private int oynananBahis22=0;
    private int oynananBahis23=0;
    private int oynananBahis24=0;
    private int oynananBahis25=0;
    private int oynananBahis26=0;
    private int oynananBahis27=0;
    private int oynananBahis28=0;
    private int oynananBahis29=0;
    private int oynananBahis30=0;
    private int oynananBahis31=0;
    private int oynananBahis32=0;
    private int oynananBahis33=0;
    private int oynananBahis34=0;
    private int oynananBahis35=0;
    private int oynananBahis36=0;
    private int oynananBahisIlk12=0;
    private int oynananBahisIkinci12=0;
    private int oynananBahisUcuncu12=0;
    private int oynananBahisKucuk=0;
    private int oynananBahisBuyuk=0;
    private int oynananBahisCift=0;
    private int oynananBahisTek=0;
    private int oynananBahisKirmizi=0;
    private int oynananBahisSiyah=0;
    private int oynananBahisUstBolge=0;
    private int oynananBahisOrtaBolge=0;
    private int oynananBahisAltBolge=0;

    private static final int ALKIS_SOUND_ID = 0;
    private SoundPool soundPool;
    private Map<Integer, Integer> soundMap;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Bakiye");
        builder.setMessage("Bakiyenizi Giriniz");

        final EditText input = new EditText(MainActivity.this);

        input.setInputType(InputType.TYPE_CLASS_TEXT);

        builder.setView(input);
        builder.setPositiveButton("İptal", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setNegativeButton("Tamam", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

                bakiye = Integer.parseInt(input.getText().toString());
                textViewKalanBakiye.setText("Kalan Bakiye : " + bakiye + " TL");
                bahis = 0;
                textViewTBahis.setText("Bahis : " + bahis + " TL");
                jeton = 1;
                oynananBahis0 = 0;
                timer();
            }
        });
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.show();


        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        soundMap = new HashMap<Integer, Integer>();
        //soundMap.put(ALKIS_SOUND_ID,soundPool.load(context,R.raw.alkis1,1));

        textViewKalanBakiye = (TextView) findViewById(R.id.textViewKalanBakiye);
        textViewTBahis = (TextView) findViewById(R.id.textViewBahis);
        textSure = (TextView) findViewById(R.id.textViewSure);

        button0 = (Button) findViewById(R.id.button0);
        button0.setOnClickListener(button0Listener);
        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(button1Listener);
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(button2Listener);
        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(button3Listener);
        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(button4Listener);
        button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(button5Listener);
        button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(button6Listener);
        button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(button7Listener);
        button8 = (Button) findViewById(R.id.button8);
        button8.setOnClickListener(button8Listener);
        button9 = (Button) findViewById(R.id.button9);
        button9.setOnClickListener(button9Listener);
        button10 = (Button) findViewById(R.id.button10);
        button10.setOnClickListener(button10Listener);
        button11 = (Button) findViewById(R.id.button11);
        button11.setOnClickListener(button11Listener);
        button12 = (Button) findViewById(R.id.button12);
        button12.setOnClickListener(button12Listener);
        button13 = (Button) findViewById(R.id.button13);
        button13.setOnClickListener(button13Listener);
        button14 = (Button) findViewById(R.id.button14);
        button14.setOnClickListener(button14Listener);
        button15 = (Button) findViewById(R.id.button15);
        button15.setOnClickListener(button15Listener);
        button16 = (Button) findViewById(R.id.button16);
        button16.setOnClickListener(button16Listener);
        button17 = (Button) findViewById(R.id.button17);
        button17.setOnClickListener(button17Listener);
        button18 = (Button) findViewById(R.id.button18);
        button18.setOnClickListener(button18Listener);
        button19 = (Button) findViewById(R.id.button19);
        button19.setOnClickListener(button19Listener);
        button20 = (Button) findViewById(R.id.button20);
        button20.setOnClickListener(button20Listener);
        button21 = (Button) findViewById(R.id.button21);
        button21.setOnClickListener(button21Listener);
        button22 = (Button) findViewById(R.id.button22);
        button22.setOnClickListener(button22Listener);
        button23 = (Button) findViewById(R.id.button23);
        button23.setOnClickListener(button23Listener);
        button24 = (Button) findViewById(R.id.button24);
        button24.setOnClickListener(button24Listener);
        button25 = (Button) findViewById(R.id.button25);
        button25.setOnClickListener(button25Listener);
        button26 = (Button) findViewById(R.id.button26);
        button26.setOnClickListener(button26Listener);
        button27 = (Button) findViewById(R.id.button27);
        button27.setOnClickListener(button27Listener);
        button28 = (Button) findViewById(R.id.button28);
        button28.setOnClickListener(button28Listener);
        button29 = (Button) findViewById(R.id.button29);
        button29.setOnClickListener(button29Listener);
        button30 = (Button) findViewById(R.id.button30);
        button30.setOnClickListener(button30Listener);
        button31 = (Button) findViewById(R.id.button31);
        button31.setOnClickListener(button31Listener);
        button32 = (Button) findViewById(R.id.button32);
        button32.setOnClickListener(button32Listener);
        button33 = (Button) findViewById(R.id.button33);
        button33.setOnClickListener(button33Listener);
        button34 = (Button) findViewById(R.id.button34);
        button34.setOnClickListener(button34Listener);
        button35 = (Button) findViewById(R.id.button35);
        button35.setOnClickListener(button35Listener);
        button36 = (Button) findViewById(R.id.button36);
        button36.setOnClickListener(button36Listener);
        buttonIlk12 = (Button) findViewById(R.id.buttonIlk12);
        buttonIlk12.setOnClickListener(buttonIlk12Listener);
        buttonIkinci12 = (Button) findViewById(R.id.buttonIkıci12);
        buttonIkinci12.setOnClickListener(buttonIkinci12Listener);
        buttonUcuncu12 = (Button) findViewById(R.id.buttonUcuncu12);
        buttonUcuncu12.setOnClickListener(buttonUcuncu12Listener);
        buttonKucuk = (Button) findViewById(R.id.buttonKucuk);
        buttonKucuk.setOnClickListener(buttonKucukListener);
        buttonBuyuk = (Button) findViewById(R.id.buttonBuyuk);
        buttonBuyuk.setOnClickListener(buttonBuyukListener);
        buttonTek = (Button) findViewById(R.id.buttonTek);
        buttonTek.setOnClickListener(buttonTekListener);
        buttonCift = (Button) findViewById(R.id.buttonCift);
        buttonCift.setOnClickListener(buttonCiftListener);
        buttonKirmizi = (Button) findViewById(R.id.buttonKırmızı);
        buttonKirmizi.setOnClickListener(buttonKirmiziListener);
        buttonSiyah = (Button) findViewById(R.id.buttonSiyah);
        buttonSiyah.setOnClickListener(buttonSiyahListener);
        buttonUstBolge = (Button) findViewById(R.id.buttonUstBolge);
        buttonUstBolge.setOnClickListener(buttonUstBolgeListener);
        buttonOrtaBolge = (Button) findViewById(R.id.buttonOrtaBolge);
        buttonOrtaBolge.setOnClickListener(buttonOrtaBolgeListener);
        buttonAltBolge = (Button) findViewById(R.id.buttonAltBolge);
        buttonAltBolge.setOnClickListener(buttonAltBolgeListener);
        button1TL = (Button) findViewById(R.id.button1TL);
        button1TL.setOnClickListener(button1TLListener);
        button5TL = (Button) findViewById(R.id.button5TL);
        button5TL.setOnClickListener(button5TLListener);
        button10TL = (Button) findViewById(R.id.button10TL);
        button10TL.setOnClickListener(button10TLListener);
    }

    public View.OnClickListener button1TLListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            jeton=1;
        }
    };

    public View.OnClickListener button5TLListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            jeton=5;
        }
    };

    public View.OnClickListener button10TLListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            jeton=10;
        }
    };

    public View.OnClickListener button0Listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            oynananBahis0 += jeton;
            bahisYap();

        }
    };

    public View.OnClickListener button1Listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            oynananBahis1 += jeton;
            bahisYap();

        }
    };

    public View.OnClickListener button2Listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            oynananBahis2 += jeton;
            bahisYap();

        }
    };

    public View.OnClickListener button3Listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            oynananBahis3 += jeton;
            bahisYap();

        }
    };

    public View.OnClickListener button4Listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            oynananBahis4 += jeton;
            bahisYap();

        }
    };

    public View.OnClickListener button5Listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            oynananBahis5 += jeton;
            bahisYap();

        }
    };

    public View.OnClickListener button6Listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            oynananBahis6 += jeton;
            bahisYap();

        }
    };

    public View.OnClickListener button7Listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            oynananBahis7 += jeton;
            bahisYap();

        }
    };

    public View.OnClickListener button8Listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            oynananBahis8 += jeton;
            bahisYap();

        }
    };

    public View.OnClickListener button9Listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            oynananBahis9 += jeton;
            bahisYap();

        }
    };

    public View.OnClickListener button10Listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            oynananBahis10 += jeton;
            bahisYap();

        }
    };

    public View.OnClickListener button11Listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            oynananBahis11 += jeton;
            bahisYap();

        }
    };

    public View.OnClickListener button12Listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            oynananBahis12 += jeton;
            bahisYap();

        }
    };

    public View.OnClickListener button13Listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            oynananBahis13 += jeton;
            bahisYap();

        }
    };

    public View.OnClickListener button14Listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            oynananBahis14 += jeton;
            bahisYap();

        }
    };

    public View.OnClickListener button15Listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            oynananBahis15 += jeton;
            bahisYap();

        }
    };

    public View.OnClickListener button16Listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            oynananBahis16 += jeton;
            bahisYap();

        }
    };

    public View.OnClickListener button17Listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            oynananBahis17 += jeton;
            bahisYap();

        }
    };

    public View.OnClickListener button18Listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            oynananBahis18 += jeton;
            bahisYap();

        }
    };

    public View.OnClickListener button19Listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            oynananBahis19 += jeton;
            bahisYap();

        }
    };

    public View.OnClickListener button20Listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            oynananBahis20 += jeton;
            bahisYap();

        }
    };

    public View.OnClickListener button21Listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            oynananBahis21 += jeton;
            bahisYap();

        }
    };

    public View.OnClickListener button22Listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            oynananBahis22 += jeton;
            bahisYap();

        }
    };

    public View.OnClickListener button23Listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            oynananBahis23 += jeton;
            bahisYap();

        }
    };

    public View.OnClickListener button24Listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            oynananBahis24 += jeton;
            bahisYap();

        }
    };

    public View.OnClickListener button25Listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            oynananBahis25 += jeton;
            bahisYap();

        }
    };

    public View.OnClickListener button26Listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            oynananBahis26 += jeton;
            bahisYap();

        }
    };

    public View.OnClickListener button27Listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            oynananBahis27 += jeton;
            bahisYap();

        }
    };

    public View.OnClickListener button28Listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            oynananBahis28 += jeton;
            bahisYap();

        }
    };

    public View.OnClickListener button29Listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            oynananBahis29 += jeton;
            bahisYap();

        }
    };

    public View.OnClickListener button30Listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            oynananBahis30 += jeton;
            bahisYap();

        }
    };

    public View.OnClickListener button31Listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            oynananBahis31 += jeton;
            bahisYap();

        }
    };

    public View.OnClickListener button32Listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            oynananBahis32 += jeton;
            bahisYap();

        }
    };

    public View.OnClickListener button33Listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            oynananBahis33 += jeton;
            bahisYap();

        }
    };

    public View.OnClickListener button34Listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            oynananBahis34 += jeton;
            bahisYap();

        }
    };

    public View.OnClickListener button35Listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            oynananBahis35 += jeton;
            bahisYap();

        }
    };

    public View.OnClickListener button36Listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            oynananBahis36 += jeton;
            bahisYap();

        }
    };

    public View.OnClickListener buttonIlk12Listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            oynananBahisIlk12 += jeton;
            bahisYap();

        }
    };

    public View.OnClickListener buttonIkinci12Listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            oynananBahisIkinci12 += jeton;
            bahisYap();

        }
    };

    public View.OnClickListener buttonUcuncu12Listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            oynananBahisUcuncu12 += jeton;
            bahisYap();

        }
    };

    public View.OnClickListener buttonKucukListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            oynananBahisKucuk += jeton;
            bahisYap();
        }
    };

    public View.OnClickListener buttonBuyukListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            oynananBahisBuyuk += jeton;
            bahisYap();
        }
    };

    public View.OnClickListener buttonCiftListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            oynananBahisCift += jeton;
            bahisYap();
        }
    };

    public View.OnClickListener buttonTekListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            oynananBahisTek += jeton;
            bahisYap();
        }
    };

    public View.OnClickListener buttonKirmiziListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            oynananBahisKirmizi += jeton;
            bahisYap();
            soundPool.play(ALKIS_SOUND_ID, 1, 1, 1, 0, 1f);
        }
    };

    public View.OnClickListener buttonSiyahListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            oynananBahisSiyah += jeton;
            bahisYap();
        }
    };

    public View.OnClickListener buttonUstBolgeListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            oynananBahisUstBolge += jeton;
            bahisYap();
        }
    };

    public View.OnClickListener buttonOrtaBolgeListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            oynananBahisOrtaBolge += jeton;
            bahisYap();
        }
    };

    public View.OnClickListener buttonAltBolgeListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            oynananBahisAltBolge += jeton;
            bahisYap();
        }
    };

    private void bahisYap(){

        if (bakiye > 0) {
            if (bakiye >= jeton){
                bahis += jeton;
                textViewTBahis.setText("Bahis : " + bahis + " TL");
                bakiye -= jeton;
                textViewKalanBakiye.setText("Kalan Bakiye : " + bakiye + " TL");

            } else {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("HATA")
                        .setMessage("Bakiyeniz Yetersiz")
                        .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .show();
            }
        }else{
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("HATA")
                    .setMessage("Bakiyeniz Bitmiştir")
                    .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    })
                    .show();
        }
    }

    private void timer() {
        final CountDownTimer timer = new CountDownTimer(10000, 1000) {
            public void onTick(long millisUntilFinished) {
                long millis=millisUntilFinished;
                String hms=String.format("%02d", TimeUnit.MILLISECONDS.toSeconds(millis));
                textSure.setText("Kalan Süre : " + hms);
            }

            public void onFinish() {
                sayi = (int) (37 * Math.random());
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Gelen Sayi")
                        .setMessage("" + sayi)
                        .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                if (oynananBahis0 > 0) {
                                    Sifir();
                                }
                                if (oynananBahis1 > 0) {
                                    bir();
                                }
                                if (oynananBahis2 > 0) {
                                    iki();
                                }
                                if (oynananBahis3 > 0) {
                                    uc();
                                }
                                if (oynananBahis4 > 0) {
                                    dort();
                                }
                                if (oynananBahis5 > 0) {
                                    bes();
                                }
                                if (oynananBahis6 > 0) {
                                    alti();
                                }
                                if (oynananBahis7 > 0) {
                                    yedi();
                                }
                                if (oynananBahis8 > 0) {
                                    sekiz();
                                }
                                if (oynananBahis9 > 0) {
                                    dokuz();
                                }
                                if (oynananBahis10 > 0) {
                                    on();
                                }
                                if (oynananBahis11 > 0) {
                                    onbir();
                                }
                                if (oynananBahis12 > 0) {
                                    oniki();
                                }
                                if (oynananBahis13 > 0) {
                                    onuc();
                                }
                                if (oynananBahis14 > 0) {
                                    ondort();
                                }
                                if (oynananBahis15 > 0) {
                                    onbes();
                                }
                                if (oynananBahis16 > 0) {
                                    onalti();
                                }
                                if (oynananBahis17 > 0) {
                                    onyedi();
                                }
                                if (oynananBahis18 > 0) {
                                    onsekiz();
                                }
                                if (oynananBahis19 > 0) {
                                    ondokuz();
                                }
                                if (oynananBahis20 > 0) {
                                    yirmi();;
                                }
                                if (oynananBahis21 > 0) {
                                    yirmibir();
                                }
                                if (oynananBahis22 > 0) {
                                    yirmiiki();
                                }
                                if (oynananBahis23 > 0) {
                                    yirmiuc();
                                }
                                if (oynananBahis24 > 0) {
                                    yirmidort();
                                }
                                if (oynananBahis25 > 0) {
                                    yirmibes();
                                }
                                if (oynananBahis26 > 0) {
                                    yirmialti();
                                }
                                if (oynananBahis27 > 0) {
                                    yirmiyedi();
                                }
                                if (oynananBahis28 > 0) {
                                    yirmisekiz();
                                }
                                if (oynananBahis29 > 0) {
                                    yirmidokuz();
                                }
                                if (oynananBahis30 > 0) {
                                    otuz();
                                }
                                if (oynananBahis31 > 0) {
                                    otuzbir();
                                }
                                if (oynananBahis32 > 0) {
                                    otuziki();
                                }
                                if (oynananBahis33 > 0) {
                                    otuzuc();
                                }
                                if (oynananBahis34 > 0) {
                                    otuzdort();
                                }
                                if (oynananBahis35 > 0) {
                                    otuzbes();
                                }
                                if (oynananBahis36 > 0) {
                                    otuzalti();
                                }
                                if (oynananBahisUstBolge > 0) {
                                    ustbolge();
                                }
                                if (oynananBahisOrtaBolge > 0) {
                                    ortabolge();
                                }
                                if (oynananBahisAltBolge > 0) {
                                    altbolge();
                                }
                                if (oynananBahisIlk12 > 0) {
                                    ilk12();
                                }
                                if (oynananBahisIkinci12 > 0) {
                                    ikinci12();
                                }
                                if (oynananBahisUcuncu12 > 0) {
                                    ucuncu12();
                                }
                                if (oynananBahisCift > 0) {
                                    cift();
                                }
                                if (oynananBahisTek > 0) {
                                    tek();
                                }
                                if (oynananBahisBuyuk > 0) {
                                    buyuk();
                                }
                                if (oynananBahisKucuk > 0) {
                                    kucuk();
                                }
                                if (oynananBahisKirmizi > 0) {
                                    kirmizi();
                                }
                                if (oynananBahisSiyah > 0) {
                                    siyah();
                                }

                                bahis = 0;
                                textViewTBahis.setText("Bahis : " + bahis + " TL");
                                timer();
                                jeton = 1;
                                oynananBahis0 = 0;
                                oynananBahis1 = 0;
                                oynananBahis2 = 0;
                                oynananBahis3 = 0;
                                oynananBahis4 = 0;
                                oynananBahis5 = 0;
                                oynananBahis6 = 0;
                                oynananBahis7 = 0;
                                oynananBahis8 = 0;
                                oynananBahis9 = 0;
                                oynananBahis10 = 0;
                                oynananBahis11 = 0;
                                oynananBahis12 = 0;
                                oynananBahis13 = 0;
                                oynananBahis14 = 0;
                                oynananBahis15 = 0;
                                oynananBahis16 = 0;
                                oynananBahis17 = 0;
                                oynananBahis18 = 0;
                                oynananBahis19 = 0;
                                oynananBahis20 = 0;
                                oynananBahis21 = 0;
                                oynananBahis22 = 0;
                                oynananBahis23 = 0;
                                oynananBahis24 = 0;
                                oynananBahis25 = 0;
                                oynananBahis26 = 0;
                                oynananBahis27 = 0;
                                oynananBahis28 = 0;
                                oynananBahis29 = 0;
                                oynananBahis30 = 0;
                                oynananBahis31 = 0;
                                oynananBahis32 = 0;
                                oynananBahis33 = 0;
                                oynananBahis34 = 0;
                                oynananBahis35 = 0;
                                oynananBahis36 = 0;
                                oynananBahisIlk12 = 0;
                                oynananBahisIkinci12 = 0;
                                oynananBahisUcuncu12 = 0;
                                oynananBahisKucuk = 0;
                                oynananBahisBuyuk = 0;
                                oynananBahisCift = 0;
                                oynananBahisTek = 0;
                                oynananBahisKirmizi = 0;
                                oynananBahisSiyah = 0;
                                oynananBahisUstBolge = 0;
                                oynananBahisOrtaBolge = 0;
                                oynananBahisAltBolge = 0;
                            }
                        })
                        .show();
            }
        };
        timer.start();
    }

    private  void Sifir(){
        if (sayi == 0) {
            kazanc = 36*oynananBahis0;
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Tebrikler")
                    .setMessage(kazanc + " TL Kazandınız")
                    .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            bakiye += kazanc;
                            textViewKalanBakiye.setText("Kalan Bakiye : " + bakiye + " TL");
                            oynananBahis0=0;
                            bahis = 0;
                            textViewTBahis.setText("Bahis : " + bahis + " TL");
                            jeton = 1;
                        }
                    })
                    .show();
        }
    }

    private  void bir(){
        if (sayi == 1) {
            kazanc = 36*oynananBahis1;
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Tebrikler")
                    .setMessage(kazanc + " TL Kazandınız")
                    .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            bakiye += kazanc;
                            textViewKalanBakiye.setText("Kalan Bakiye : " + bakiye + " TL");
                            oynananBahis1=0;
                            bahis = 0;
                            textViewTBahis.setText("Bahis : " + bahis + " TL");
                            jeton = 1;
                        }
                    })
                    .show();
        }
    }

    private  void iki(){
        if (sayi == 2) {
            kazanc = 36*oynananBahis2;
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Tebrikler")
                    .setMessage(kazanc + " TL Kazandınız")
                    .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            bakiye += kazanc;
                            textViewKalanBakiye.setText("Kalan Bakiye : " + bakiye + " TL");
                            oynananBahis2=0;
                            bahis = 0;
                            textViewTBahis.setText("Bahis : " + bahis + " TL");
                            jeton = 1;
                        }
                    })
                    .show();
        }
    }

    private  void uc(){
        if (sayi == 3) {
            kazanc = 36*oynananBahis3;
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Tebrikler")
                    .setMessage(kazanc + " TL Kazandınız")
                    .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            bakiye += kazanc;
                            textViewKalanBakiye.setText("Kalan Bakiye : " + bakiye + " TL");
                            oynananBahis3=0;
                            bahis = 0;
                            textViewTBahis.setText("Bahis : " + bahis + " TL");
                            jeton = 1;
                        }
                    })
                    .show();
        }
    }

    private  void dort(){
        if (sayi == 4) {
            kazanc = 36*oynananBahis4;
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Tebrikler")
                    .setMessage(kazanc + " TL Kazandınız")
                    .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            bakiye += kazanc;
                            textViewKalanBakiye.setText("Kalan Bakiye : " + bakiye + " TL");
                            oynananBahis4=0;
                            bahis = 0;
                            textViewTBahis.setText("Bahis : " + bahis + " TL");
                            jeton = 1;
                        }
                    })
                    .show();
        }
    }

    private  void bes(){
        if (sayi == 5) {
            kazanc = 36*oynananBahis5;
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Tebrikler")
                    .setMessage(kazanc + " TL Kazandınız")
                    .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            bakiye += kazanc;
                            textViewKalanBakiye.setText("Kalan Bakiye : " + bakiye + " TL");
                            oynananBahis0=0;
                            bahis = 0;
                            textViewTBahis.setText("Bahis : " + bahis + " TL");
                            jeton = 1;
                        }
                    })
                    .show();
        }
    }

    private  void alti(){
        if (sayi == 6) {
            kazanc = 36*oynananBahis6;
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Tebrikler")
                    .setMessage(kazanc + " TL Kazandınız")
                    .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            bakiye += kazanc;
                            textViewKalanBakiye.setText("Kalan Bakiye : " + bakiye + " TL");
                            oynananBahis6=0;
                            bahis = 0;
                            textViewTBahis.setText("Bahis : " + bahis + " TL");
                            jeton = 1;
                        }
                    })
                    .show();
        }
    }

    private  void yedi(){
        if (sayi == 7) {
            kazanc = 36*oynananBahis7;
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Tebrikler")
                    .setMessage(kazanc + " TL Kazandınız")
                    .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            bakiye += kazanc;
                            textViewKalanBakiye.setText("Kalan Bakiye : " + bakiye + " TL");
                            oynananBahis7=0;
                            bahis = 0;
                            textViewTBahis.setText("Bahis : " + bahis + " TL");
                            jeton = 1;
                        }
                    })
                    .show();
        }
    }

    private  void sekiz(){
        if (sayi == 8) {
            kazanc = 36*oynananBahis8;
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Tebrikler")
                    .setMessage(kazanc + " TL Kazandınız")
                    .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            bakiye += kazanc;
                            textViewKalanBakiye.setText("Kalan Bakiye : " + bakiye + " TL");
                            oynananBahis8=0;
                            bahis = 0;
                            textViewTBahis.setText("Bahis : " + bahis + " TL");
                            jeton = 1;
                        }
                    })
                    .show();
        }
    }

    private  void dokuz(){
        if (sayi == 9) {
            kazanc = 36*oynananBahis9;
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Tebrikler")
                    .setMessage(kazanc + " TL Kazandınız")
                    .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            bakiye += kazanc;
                            textViewKalanBakiye.setText("Kalan Bakiye : " + bakiye + " TL");
                            oynananBahis9=0;
                            bahis = 0;
                            textViewTBahis.setText("Bahis : " + bahis + " TL");
                            jeton = 1;
                        }
                    })
                    .show();
        }
    }

    private  void on(){
        if (sayi == 10) {
            kazanc = 36*oynananBahis10;
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Tebrikler")
                    .setMessage(kazanc + " TL Kazandınız")
                    .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            bakiye += kazanc;
                            textViewKalanBakiye.setText("Kalan Bakiye : " + bakiye + " TL");
                            oynananBahis10=0;
                            bahis = 0;
                            textViewTBahis.setText("Bahis : " + bahis + " TL");
                            jeton = 1;
                        }
                    })
                    .show();
        }
    }

    private  void onbir(){
        if (sayi == 11) {
            kazanc = 36*oynananBahis1;
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Tebrikler")
                    .setMessage(kazanc + " TL Kazandınız")
                    .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            bakiye += kazanc;
                            textViewKalanBakiye.setText("Kalan Bakiye : " + bakiye + " TL");
                            oynananBahis11=0;
                            bahis = 0;
                            textViewTBahis.setText("Bahis : " + bahis + " TL");
                            jeton = 1;
                        }
                    })
                    .show();
        }
    }

    private  void oniki(){
        if (sayi == 12) {
            kazanc = 36*oynananBahis12;
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Tebrikler")
                    .setMessage(kazanc + " TL Kazandınız")
                    .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            bakiye += kazanc;
                            textViewKalanBakiye.setText("Kalan Bakiye : " + bakiye + " TL");
                            oynananBahis12=0;
                            bahis = 0;
                            textViewTBahis.setText("Bahis : " + bahis + " TL");
                            jeton = 1;
                        }
                    })
                    .show();
        }
    }

    private  void onuc(){
        if (sayi == 13) {
            kazanc = 36*oynananBahis13;
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Tebrikler")
                    .setMessage(kazanc + " TL Kazandınız")
                    .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            bakiye += kazanc;
                            textViewKalanBakiye.setText("Kalan Bakiye : " + bakiye + " TL");
                            oynananBahis13=0;
                            bahis = 0;
                            textViewTBahis.setText("Bahis : " + bahis + " TL");
                            jeton = 1;
                        }
                    })
                    .show();
        }
    }

    private  void ondort(){
        if (sayi == 14) {
            kazanc = 36*oynananBahis14;
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Tebrikler")
                    .setMessage(kazanc + " TL Kazandınız")
                    .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            bakiye += kazanc;
                            textViewKalanBakiye.setText("Kalan Bakiye : " + bakiye + " TL");
                            oynananBahis14=0;
                            bahis = 0;
                            textViewTBahis.setText("Bahis : " + bahis + " TL");
                            jeton = 1;
                        }
                    })
                    .show();
        }
    }

    private  void onbes(){
        if (sayi == 15) {
            kazanc = 36*oynananBahis15;
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Tebrikler")
                    .setMessage(kazanc + " TL Kazandınız")
                    .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            bakiye += kazanc;
                            textViewKalanBakiye.setText("Kalan Bakiye : " + bakiye + " TL");
                            oynananBahis15=0;
                            bahis = 0;
                            textViewTBahis.setText("Bahis : " + bahis + " TL");
                            jeton = 1;
                        }
                    })
                    .show();
        }
    }

    private  void onalti(){
        if (sayi == 16) {
            kazanc = 36*oynananBahis16;
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Tebrikler")
                    .setMessage(kazanc + " TL Kazandınız")
                    .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            bakiye += kazanc;
                            textViewKalanBakiye.setText("Kalan Bakiye : " + bakiye + " TL");
                            oynananBahis16=0;
                            bahis = 0;
                            textViewTBahis.setText("Bahis : " + bahis + " TL");
                            jeton = 1;
                        }
                    })
                    .show();
        }
    }

    private  void onyedi(){
        if (sayi == 17) {
            kazanc = 36*oynananBahis17;
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Tebrikler")
                    .setMessage(kazanc + " TL Kazandınız")
                    .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            bakiye += kazanc;
                            textViewKalanBakiye.setText("Kalan Bakiye : " + bakiye + " TL");
                            oynananBahis17=0;
                            bahis = 0;
                            textViewTBahis.setText("Bahis : " + bahis + " TL");
                            jeton = 1;
                        }
                    })
                    .show();
        }
    }

    private  void onsekiz(){
        if (sayi == 18) {
            kazanc = 36*oynananBahis18;
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Tebrikler")
                    .setMessage(kazanc + " TL Kazandınız")
                    .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            bakiye += kazanc;
                            textViewKalanBakiye.setText("Kalan Bakiye : " + bakiye + " TL");
                            oynananBahis18=0;
                            bahis = 0;
                            textViewTBahis.setText("Bahis : " + bahis + " TL");
                            jeton = 1;
                        }
                    })
                    .show();
        }
    }

    private  void ondokuz(){
        if (sayi == 19) {
            kazanc = 36*oynananBahis19;
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Tebrikler")
                    .setMessage(kazanc + " TL Kazandınız")
                    .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            bakiye += kazanc;
                            textViewKalanBakiye.setText("Kalan Bakiye : " + bakiye + " TL");
                            oynananBahis19=0;
                            bahis = 0;
                            textViewTBahis.setText("Bahis : " + bahis + " TL");
                            jeton = 1;
                        }
                    })
                    .show();
        }
    }

    private  void yirmi(){
        if (sayi == 20) {
            kazanc = 36*oynananBahis20;
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Tebrikler")
                    .setMessage(kazanc + " TL Kazandınız")
                    .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            bakiye += kazanc;
                            textViewKalanBakiye.setText("Kalan Bakiye : " + bakiye + " TL");
                            oynananBahis20=0;
                            bahis = 0;
                            textViewTBahis.setText("Bahis : " + bahis + " TL");
                            jeton = 1;
                        }
                    })
                    .show();
        }
    }

    private  void yirmibir(){
        if (sayi == 21) {
            kazanc = 36*oynananBahis21;
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Tebrikler")
                    .setMessage(kazanc + " TL Kazandınız")
                    .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            bakiye += kazanc;
                            textViewKalanBakiye.setText("Kalan Bakiye : " + bakiye + " TL");
                            oynananBahis21=0;
                            bahis = 0;
                            textViewTBahis.setText("Bahis : " + bahis + " TL");
                            jeton = 1;
                        }
                    })
                    .show();
        }
    }

    private  void yirmiiki(){
        if (sayi == 22) {
            kazanc = 36*oynananBahis22;
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Tebrikler")
                    .setMessage(kazanc + " TL Kazandınız")
                    .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            bakiye += kazanc;
                            textViewKalanBakiye.setText("Kalan Bakiye : " + bakiye + " TL");
                            oynananBahis22=0;
                            bahis = 0;
                            textViewTBahis.setText("Bahis : " + bahis + " TL");
                            jeton = 1;
                        }
                    })
                    .show();
        }
    }

    private  void yirmiuc(){
        if (sayi == 23) {
            kazanc = 36*oynananBahis23;
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Tebrikler")
                    .setMessage(kazanc + " TL Kazandınız")
                    .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            bakiye += kazanc;
                            textViewKalanBakiye.setText("Kalan Bakiye : " + bakiye + " TL");
                            oynananBahis23=0;
                            bahis = 0;
                            textViewTBahis.setText("Bahis : " + bahis + " TL");
                            jeton = 1;
                        }
                    })
                    .show();
        }
    }

    private  void yirmidort(){
        if (sayi == 24) {
            kazanc = 36*oynananBahis24;
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Tebrikler")
                    .setMessage(kazanc + " TL Kazandınız")
                    .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            bakiye += kazanc;
                            textViewKalanBakiye.setText("Kalan Bakiye : " + bakiye + " TL");
                            oynananBahis24=0;
                            bahis = 0;
                            textViewTBahis.setText("Bahis : " + bahis + " TL");
                            jeton = 1;
                        }
                    })
                    .show();
        }
    }

    private  void yirmibes(){
        if (sayi == 25) {
            kazanc = 36*oynananBahis25;
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Tebrikler")
                    .setMessage(kazanc + " TL Kazandınız")
                    .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            bakiye += kazanc;
                            textViewKalanBakiye.setText("Kalan Bakiye : " + bakiye + " TL");
                            oynananBahis25=0;
                            bahis = 0;
                            textViewTBahis.setText("Bahis : " + bahis + " TL");
                            jeton = 1;
                        }
                    })
                    .show();
        }
    }

    private  void yirmialti(){
        if (sayi == 26) {
            kazanc = 36*oynananBahis26;
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Tebrikler")
                    .setMessage(kazanc + " TL Kazandınız")
                    .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            bakiye += kazanc;
                            textViewKalanBakiye.setText("Kalan Bakiye : " + bakiye + " TL");
                            oynananBahis26=0;
                            bahis = 0;
                            textViewTBahis.setText("Bahis : " + bahis + " TL");
                            jeton = 1;
                        }
                    })
                    .show();
        }
    }

    private  void yirmiyedi(){
        if (sayi == 27) {
            kazanc = 36*oynananBahis27;
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Tebrikler")
                    .setMessage(kazanc + " TL Kazandınız")
                    .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            bakiye += kazanc;
                            textViewKalanBakiye.setText("Kalan Bakiye : " + bakiye + " TL");
                            oynananBahis27=0;
                            bahis = 0;
                            textViewTBahis.setText("Bahis : " + bahis + " TL");
                            jeton = 1;
                        }
                    })
                    .show();
        }
    }

    private  void yirmisekiz(){
        if (sayi == 28) {
            kazanc = 36*oynananBahis28;
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Tebrikler")
                    .setMessage(kazanc + " TL Kazandınız")
                    .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            bakiye += kazanc;
                            textViewKalanBakiye.setText("Kalan Bakiye : " + bakiye + " TL");
                            oynananBahis28=0;
                            bahis = 0;
                            textViewTBahis.setText("Bahis : " + bahis + " TL");
                            jeton = 1;
                        }
                    })
                    .show();
        }
    }

    private  void yirmidokuz(){
        if (sayi == 29) {
            kazanc = 36*oynananBahis29;
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Tebrikler")
                    .setMessage(kazanc + " TL Kazandınız")
                    .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            bakiye += kazanc;
                            textViewKalanBakiye.setText("Kalan Bakiye : " + bakiye + " TL");
                            oynananBahis29=0;
                            bahis = 0;
                            textViewTBahis.setText("Bahis : " + bahis + " TL");
                            jeton = 1;
                        }
                    })
                    .show();
        }
    }

    private  void otuz(){
        if (sayi == 30) {
            kazanc = 36*oynananBahis30;
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Tebrikler")
                    .setMessage(kazanc + " TL Kazandınız")
                    .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            bakiye += kazanc;
                            textViewKalanBakiye.setText("Kalan Bakiye : " + bakiye + " TL");
                            oynananBahis30=0;
                            bahis = 0;
                            textViewTBahis.setText("Bahis : " + bahis + " TL");
                            jeton = 1;
                        }
                    })
                    .show();
        }
    }

    private  void otuzbir(){
        if (sayi == 31) {
            kazanc = 36*oynananBahis31;
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Tebrikler")
                    .setMessage(kazanc + " TL Kazandınız")
                    .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            bakiye += kazanc;
                            textViewKalanBakiye.setText("Kalan Bakiye : " + bakiye + " TL");
                            oynananBahis31=0;
                            bahis = 0;
                            textViewTBahis.setText("Bahis : " + bahis + " TL");
                            jeton = 1;
                        }
                    })
                    .show();
        }
    }

    private  void otuziki(){
        if (sayi == 32) {
            kazanc = 36*oynananBahis32;
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Tebrikler")
                    .setMessage(kazanc + " TL Kazandınız")
                    .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            bakiye += kazanc;
                            textViewKalanBakiye.setText("Kalan Bakiye : " + bakiye + " TL");
                            oynananBahis32=0;
                            bahis = 0;
                            textViewTBahis.setText("Bahis : " + bahis + " TL");
                            jeton = 1;
                        }
                    })
                    .show();
        }
    }

    private  void otuzuc(){
        if (sayi == 33) {
            kazanc = 36*oynananBahis33;
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Tebrikler")
                    .setMessage(kazanc + " TL Kazandınız")
                    .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            bakiye += kazanc;
                            textViewKalanBakiye.setText("Kalan Bakiye : " + bakiye + " TL");
                            oynananBahis33=0;
                            bahis = 0;
                            textViewTBahis.setText("Bahis : " + bahis + " TL");
                            jeton = 1;
                        }
                    })
                    .show();
        }
    }

    private  void otuzdort(){
        if (sayi == 34) {
            kazanc = 36*oynananBahis34;
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Tebrikler")
                    .setMessage(kazanc + " TL Kazandınız")
                    .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            bakiye += kazanc;
                            textViewKalanBakiye.setText("Kalan Bakiye : " + bakiye + " TL");
                            oynananBahis34=0;
                            bahis = 0;
                            textViewTBahis.setText("Bahis : " + bahis + " TL");
                            jeton = 1;
                        }
                    })
                    .show();
        }
    }

    private  void otuzbes(){
        if (sayi == 35) {
            kazanc = 36*oynananBahis35;
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Tebrikler")
                    .setMessage(kazanc + " TL Kazandınız")
                    .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            bakiye += kazanc;
                            textViewKalanBakiye.setText("Kalan Bakiye : " + bakiye + " TL");
                            oynananBahis35=0;
                            bahis = 0;
                            textViewTBahis.setText("Bahis : " + bahis + " TL");
                            jeton = 1;
                        }
                    })
                    .show();
        }
    }

    private  void otuzalti(){
        if (sayi == 36) {
            kazanc = 36*oynananBahis36;
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Tebrikler")
                    .setMessage(kazanc + " TL Kazandınız")
                    .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            bakiye += kazanc;
                            textViewKalanBakiye.setText("Kalan Bakiye : " + bakiye + " TL");
                            oynananBahis36=0;
                            bahis = 0;
                            textViewTBahis.setText("Bahis : " + bahis + " TL");
                            jeton = 1;
                        }
                    })
                    .show();
        }
    }

    private  void ilk12(){
        if ((sayi > 0) && (sayi<13) ) {
            kazanc = 3*oynananBahisIlk12;
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Tebrikler")
                    .setMessage(kazanc + " TL Kazandınız")
                    .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            bakiye += kazanc;
                            textViewKalanBakiye.setText("Kalan Bakiye : " + bakiye + " TL");
                            oynananBahisIlk12=0;
                            bahis = 0;
                            textViewTBahis.setText("Bahis : " + bahis + " TL");
                            jeton = 1;
                        }
                    })
                    .show();
        }
    }

    private  void ikinci12(){
        if ((sayi > 12) && (sayi<25) ) {
            kazanc = 3*oynananBahisIkinci12;
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Tebrikler")
                    .setMessage(kazanc + " TL Kazandınız")
                    .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            bakiye += kazanc;
                            textViewKalanBakiye.setText("Kalan Bakiye : " + bakiye + " TL");
                            oynananBahisIkinci12=0;
                            bahis = 0;
                            textViewTBahis.setText("Bahis : " + bahis + " TL");
                            jeton = 1;
                        }
                    })
                    .show();
        }
    }

    private  void ucuncu12(){
        if ((sayi > 24) && (sayi<37) ) {
            kazanc = 3*oynananBahisUcuncu12;
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Tebrikler")
                    .setMessage(kazanc + " TL Kazandınız")
                    .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            bakiye += kazanc;
                            textViewKalanBakiye.setText("Kalan Bakiye : " + bakiye + " TL");
                            oynananBahisUcuncu12=0;
                            bahis = 0;
                            textViewTBahis.setText("Bahis : " + bahis + " TL");
                            jeton = 1;
                        }
                    })
                    .show();
        }
    }

    private  void kucuk(){
        if ((sayi > 0) && (sayi<19) ) {
            kazanc = 2*oynananBahisKucuk;
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Tebrikler")
                    .setMessage(kazanc + " TL Kazandınız")
                    .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            bakiye += kazanc;
                            textViewKalanBakiye.setText("Kalan Bakiye : " + bakiye + " TL");
                            oynananBahisKucuk=0;
                            bahis = 0;
                            textViewTBahis.setText("Bahis : " + bahis + " TL");
                            jeton = 1;
                        }
                    })
                    .show();
        }
    }

    private  void buyuk(){
        if ((sayi > 18) && (sayi<37) ) {
            kazanc = 2*oynananBahisBuyuk;
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Tebrikler")
                    .setMessage(kazanc + " TL Kazandınız")
                    .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            bakiye += kazanc;
                            textViewKalanBakiye.setText("Kalan Bakiye : " + bakiye + " TL");
                            oynananBahisBuyuk=0;
                            bahis = 0;
                            textViewTBahis.setText("Bahis : " + bahis + " TL");
                            jeton = 1;
                        }
                    })
                    .show();
        }
    }

    private  void cift(){
        if (sayi == 2 || sayi == 4 || sayi == 6 || sayi == 8 || sayi == 10 || sayi == 12 || sayi == 14 || sayi == 16 || sayi == 18 || sayi == 20
                || sayi == 22 || sayi == 24 || sayi == 26 || sayi == 28 || sayi == 30 || sayi == 32 || sayi == 34  || sayi == 36) {
            kazanc = 2*oynananBahisCift;
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Tebrikler")
                    .setMessage(kazanc + " TL Kazandınız")
                    .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            bakiye += kazanc;
                            textViewKalanBakiye.setText("Kalan Bakiye : " + bakiye + " TL");
                            oynananBahisCift=0;
                            bahis = 0;
                            textViewTBahis.setText("Bahis : " + bahis + " TL");
                            jeton = 1;
                        }
                    })
                    .show();
        }
    }

    private  void tek(){
        if (sayi == 1 || sayi == 3 || sayi == 5 || sayi == 7 || sayi == 9 || sayi == 11 || sayi == 13 || sayi == 15 || sayi == 17 || sayi == 19 || sayi == 21
                || sayi == 23 || sayi == 25 || sayi == 27 || sayi == 29 || sayi == 31 || sayi == 33 || sayi == 35 ) {
            kazanc = 2*oynananBahisTek;
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Tebrikler")
                    .setMessage(kazanc + " TL Kazandınız")
                    .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            bakiye += kazanc;
                            textViewKalanBakiye.setText("Kalan Bakiye : " + bakiye + " TL");
                            oynananBahisTek=0;
                            bahis = 0;
                            textViewTBahis.setText("Bahis : " + bahis + " TL");
                            jeton = 1;
                        }
                    })
                    .show();
        }
    }

    private  void kirmizi(){
        if (sayi == 1 || sayi == 3 || sayi == 5 || sayi == 7 || sayi == 9 || sayi == 12 || sayi == 14 || sayi == 16 || sayi == 18 || sayi == 19
                || sayi == 21 || sayi == 23 || sayi == 25 || sayi == 27 || sayi == 30 || sayi == 32 || sayi == 34 || sayi == 36) {
            kazanc = 2*oynananBahisKirmizi;
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Tebrikler")
                    .setMessage(kazanc + " TL Kazandınız")
                    .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            bakiye += kazanc;
                            textViewKalanBakiye.setText("Kalan Bakiye : " + bakiye + " TL");
                            oynananBahisKirmizi=0;
                            bahis = 0;
                            textViewTBahis.setText("Bahis : " + bahis + " TL");
                            jeton = 1;
                        }
                    })
                    .show();
        }
    }

    private  void siyah(){
        if (sayi == 2 || sayi == 4 || sayi == 6 || sayi == 8 || sayi == 10 || sayi == 11 || sayi == 13 || sayi == 15 || sayi == 17
                || sayi == 20 || sayi == 22 || sayi == 24 || sayi == 26 || sayi == 28 || sayi == 29 || sayi == 31 || sayi == 33 || sayi == 35) {
            kazanc = 2*oynananBahisSiyah;
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Tebrikler")
                    .setMessage(kazanc + " TL Kazandınız")
                    .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            bakiye += kazanc;
                            textViewKalanBakiye.setText("Kalan Bakiye : " + bakiye + " TL");
                            oynananBahisSiyah=0;
                            bahis = 0;
                            textViewTBahis.setText("Bahis : " + bahis + " TL");
                            jeton = 1;
                        }
                    })
                    .show();
        }
    }

    private  void ustbolge(){
        if (sayi == 3 || sayi == 6 || sayi == 9 || sayi == 12 || sayi == 15 || sayi == 18 || sayi == 21 || sayi == 24 || sayi == 27 || sayi == 30 || sayi == 33 || sayi == 36) {
            kazanc = 3*oynananBahisUstBolge;
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Tebrikler")
                    .setMessage(kazanc + " TL Kazandınız")
                    .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            bakiye += kazanc;
                            textViewKalanBakiye.setText("Kalan Bakiye : " + bakiye + " TL");
                            oynananBahisUstBolge=0;
                            bahis = 0;
                            textViewTBahis.setText("Bahis : " + bahis + " TL");
                            jeton = 1;
                        }
                    })
                    .show();
        }
    }

    private  void ortabolge(){
        if (sayi == 2 || sayi == 5 || sayi == 8 || sayi == 11 || sayi == 14 || sayi == 17 || sayi == 20 || sayi == 23 || sayi == 26 || sayi == 29 || sayi == 32 || sayi == 35) {
            kazanc = 3*oynananBahisOrtaBolge;
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Tebrikler")
                    .setMessage(kazanc + " TL Kazandınız")
                    .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            bakiye += kazanc;
                            textViewKalanBakiye.setText("Kalan Bakiye : " + bakiye + " TL");
                            oynananBahisOrtaBolge=0;
                            bahis = 0;
                            textViewTBahis.setText("Bahis : " + bahis + " TL");
                            jeton = 1;
                        }
                    })
                    .show();
        }
    }

    private  void altbolge(){
        if (sayi == 1 || sayi == 4 || sayi == 7 || sayi == 10 || sayi == 13 || sayi == 16 || sayi == 19 || sayi == 22 || sayi == 25 || sayi == 28 || sayi == 31 || sayi == 34) {
            kazanc = 3*oynananBahisAltBolge;
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Tebrikler")
                    .setMessage(kazanc + " TL Kazandınız")
                    .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            bakiye += kazanc;
                            textViewKalanBakiye.setText("Kalan Bakiye : " + bakiye + " TL");
                            oynananBahisAltBolge=0;
                            bahis = 0;
                            textViewTBahis.setText("Bahis : " + bahis + " TL");
                            jeton = 1;
                        }
                    })
                    .show();
        }
    }

}

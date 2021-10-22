package com.example.kopapirollo2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView gepTippKep, sajatTippKep, gepHP1,gepHP2,gepHP3,sajatHP1,sajatHP2,sajatHP3;
    private Button gombKo, gombPapir, gombOllo;
    private TextView dontetlen;
    private int sajatTipp, gepTipp;
    private int sajatPont, gepPont, dontetlenSzam;
    int randomKPO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        gombKo.setOnClickListener((view) -> {
            if (sajatPont != 3 || gepPont != 3) {
                sajatTipp = 0;
                sajatTippKep.setImageResource(R.drawable.rock);
                gepTippje();
                tippekHarca(gepTipp,sajatTipp);
            }
        });
        gombPapir.setOnClickListener((view) -> {
            if (sajatPont != 3 || gepPont != 3) {
                sajatTipp = 1;
                sajatTippKep.setImageResource(R.drawable.paper);
                gepTippje();
                tippekHarca(gepTipp,sajatTipp);
            }
        });
        gombOllo.setOnClickListener((view) -> {
            if (sajatPont != 3 || gepPont != 3) {
                sajatTipp = 2;
                sajatTippKep.setImageResource(R.drawable.scissors);
                gepTippje();
                tippekHarca(gepTipp,sajatTipp);
            }
        });
    }

    public void gepTippje(){
        randomKPO =(int)(Math.random()*3);
        gepTipp=randomKPO;
        if (gepTipp==0){
            gepTippKep.setImageResource(R.drawable.rock);
        }
        else if (gepTipp == 1) {
            gepTippKep.setImageResource(R.drawable.paper);
        }else{
            gepTippKep.setImageResource(R.drawable.scissors);
        }
    }

    public void tippekHarca(int gepTipp, int sajatTipp){
        if (gepTipp==0 && sajatTipp==1) {
            sajatPont++;
            Toast.makeText(MainActivity.this, "A kör nyertese: TE", Toast.LENGTH_SHORT).show();
        }else if (gepTipp == 2 && sajatTipp==0) {
            sajatPont++;
            Toast.makeText(MainActivity.this, "A kör nyertese: TE", Toast.LENGTH_SHORT).show();
        }else if (gepTipp == 1 && sajatTipp==2) {
            sajatPont++;
            Toast.makeText(MainActivity.this, "A kör nyertese: TE", Toast.LENGTH_SHORT).show();
        }else if (gepTipp == 1 && sajatTipp==0) {
            gepPont++;
            Toast.makeText(MainActivity.this, "A kör nyertese: A GÉP", Toast.LENGTH_SHORT).show();
        }else if (gepTipp == 2 && sajatTipp==1) {
            gepPont++;
            Toast.makeText(MainActivity.this, "A kör nyertese: A GÉP", Toast.LENGTH_SHORT).show();
        }else if (gepTipp == 0 && sajatTipp==2) {
            gepPont++;
            Toast.makeText(MainActivity.this, "A kör nyertese: A GÉP", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(MainActivity.this,"Döntetlen",Toast.LENGTH_SHORT).show();
            dontetlenSzam++;
            dontetlen.setText("Döntetlenek száma: "+dontetlenSzam);
        }

        if (gepPont == 1) {
            sajatHP1.setImageResource(R.drawable.heart1);
        }else if (gepPont == 2) {
            sajatHP2.setImageResource(R.drawable.heart1);
        }else if (gepPont == 3) {
            sajatHP3.setImageResource(R.drawable.heart1);
        }
        if (sajatPont == 1) {
            gepHP3.setImageResource(R.drawable.heart1);
        }else if (sajatPont == 2) {
            gepHP2.setImageResource(R.drawable.heart1);
        }else if (sajatPont == 3) {
            gepHP1.setImageResource(R.drawable.heart1);
        }


        if (gepPont == 3 || sajatPont==3) {
            jatekVege();
        }


    }

    public void jatekVege() {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        alertBuilder.setCancelable(false);
        if (sajatPont == 3 ) {
            alertBuilder.setTitle("Győzelem");
        } else {
            alertBuilder.setTitle("Vereség");
        }
        alertBuilder.setMessage("Szeretnél új játékot játszani?");

        alertBuilder.setPositiveButton("Igen", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ujJatek();
            }
        });

        alertBuilder.setNegativeButton("Nem", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alertBuilder.create().show();
    }

    public void ujJatek() {
        sajatPont = 0;
        gepPont = 0;
        dontetlenSzam=0;
        sajatTippKep.setImageResource(R.drawable.rock);
        gepTippKep.setImageResource(R.drawable.rock);
        gepHP1.setImageResource(R.drawable.heart2);
        gepHP2.setImageResource(R.drawable.heart2);
        gepHP3.setImageResource(R.drawable.heart2);
        sajatHP1.setImageResource(R.drawable.heart2);
        sajatHP2.setImageResource(R.drawable.heart2);
        sajatHP3.setImageResource(R.drawable.heart2);
        dontetlen.setText("Döntetlenek száma: 0");

    }

    private void init() {
        gepPont=0;
        sajatPont=0;
        dontetlenSzam=0;
        gepTippKep=findViewById(R.id.img_gep);
        sajatTippKep=findViewById(R.id.img_sajat);
        gombKo=findViewById(R.id.btn_ko);
        gombPapir=findViewById(R.id.btn_papir);
        gombOllo=findViewById(R.id.btn_ollo);
        dontetlen=findViewById(R.id.textView_dontetlen);
        gepHP1=findViewById(R.id.gephp1);
        gepHP2=findViewById(R.id.gephp2);
        gepHP3=findViewById(R.id.gephp3);
        sajatHP1=findViewById(R.id.jatekoshp1);
        sajatHP2=findViewById(R.id.jatekoshp2);
        sajatHP3=findViewById(R.id.jatekoshp3);
    }
}
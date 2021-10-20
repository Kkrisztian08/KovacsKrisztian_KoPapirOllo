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
    private ImageView gepTippKep, sajatTippKep;
    private Button gombKo, gombPapir, gombOllo;
    private TextView eredmeny , dontetlen;
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
            eredmeny.setText("Eredmeny: Ember: " + sajatPont +" Computer: "+ gepPont);
        }else if (gepTipp == 0 && sajatTipp==2) {
            sajatPont++;
            Toast.makeText(MainActivity.this, "A kör nyertese: TE", Toast.LENGTH_SHORT).show();
            eredmeny.setText("Eredmeny: Ember: " + sajatPont +" Computer: "+ gepPont);
        }else if (gepTipp == 1 && sajatTipp==2) {
            sajatPont++;
            Toast.makeText(MainActivity.this, "A kör nyertese: TE", Toast.LENGTH_SHORT).show();
            eredmeny.setText("Eredmeny: Ember: " + sajatPont +" Computer: "+ gepPont);
        }else if (gepTipp == 1 && sajatTipp==0) {
            gepPont++;
            Toast.makeText(MainActivity.this, "A kör nyertese: A GÉP", Toast.LENGTH_SHORT).show();
            eredmeny.setText("Eredmeny: Ember: " + sajatPont +" Computer: "+ gepPont);
        }else if (gepTipp == 2 && sajatTipp==1) {
            gepPont++;
            Toast.makeText(MainActivity.this, "A kör nyertese: A GÉP", Toast.LENGTH_SHORT).show();
            eredmeny.setText("Eredmeny: Ember: " + sajatPont +" Computer: "+ gepPont);
        }else if (gepTipp == 2 && sajatTipp==0) {
            gepPont++;
            Toast.makeText(MainActivity.this, "A kör nyertese: A GÉP", Toast.LENGTH_SHORT).show();
            eredmeny.setText("Eredmeny: Ember: " + sajatPont +" Computer: "+ gepPont);
        }else{
            Toast.makeText(MainActivity.this,"Döntetlen",Toast.LENGTH_SHORT).show();
            dontetlenSzam++;
            dontetlen.setText("Döntetlenek számar: "+dontetlenSzam);
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
        eredmeny.setText("Eredmeny: Ember: 0 Computer: 0");
        dontetlen.setText("Döntetlenek számar: 0");
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
        eredmeny=findViewById(R.id.textView_eredmeny);
        dontetlen=findViewById(R.id.textView_dontetlen);
    }
}
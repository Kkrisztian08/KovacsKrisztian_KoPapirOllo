package com.example.kopapirollo2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView gepTippKep, sajatTippKep;
    private Button gombKo, gombPapir, gombOllo;
    private TextView eredmeny;
    private String sajatTipp, gepTipp;
    private int emberPont, gepPont;
    private Random rnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        gombKo.setOnClickListener((view) -> {
            if (emberPont != 3 || gepPont != 3) {
                sajatTipp = "kő";
                sajatTippKep.setImageResource(R.drawable.rock);
            }
        });
        gombPapir.setOnClickListener((view) -> {
            if (emberPont != 3 || gepPont != 3) {
                sajatTipp = "papír";
                sajatTippKep.setImageResource(R.drawable.paper);
            }
        });
        gombOllo.setOnClickListener((view) -> {
            if (emberPont != 3 || gepPont != 3) {
                sajatTipp = "olló";
                sajatTippKep.setImageResource(R.drawable.scissors);
            }
        });
    }
    public void jatek(){
        int random = rnd.nextInt((3) + 1) + 1;
        if (random==1){
            gepTippKep.setImageResource(R.drawable.rock);
            gepTipp="kő";
        }
        else if (random == 2) {
            gepTippKep.setImageResource(R.drawable.paper);
            gepTipp="papír";
        }else{
            gepTippKep.setImageResource(R.drawable.scissors);
            gepTipp="olló";
        }

    }

    public void jatekVege() {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        alertBuilder.setCancelable(false);
        if (emberPont == 3 ) {
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
        emberPont = 0;
        gepPont = 0;
        eredmeny.setText("Eredmeny: Ember: 0 Computer: 0");
    }


    private void init() {
        gepPont=0;
        emberPont=0;
        gepTippKep=findViewById(R.id.img_gep);
        sajatTippKep=findViewById(R.id.img_sajat);
        gombKo=findViewById(R.id.btn_ko);
        gombPapir=findViewById(R.id.btn_papir);
        gombOllo=findViewById(R.id.btn_ollo);
        eredmeny=findViewById(R.id.textView_eredmeny);

    }
}
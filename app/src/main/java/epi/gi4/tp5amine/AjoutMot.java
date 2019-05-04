package epi.gi4.tp5amine;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import epi.gi4.tp5amine.classes.Mot;
import epi.gi4.tp5amine.classes.MotsManager;

public class AjoutMot extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_mot);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        final  MotsManager mm = new MotsManager(this);
        mm.open();
       final  EditText mot = (EditText) findViewById(R.id.leMotInput);
        final  EditText type = (EditText) findViewById(R.id.typeInput);
        final   EditText genre = (EditText) findViewById(R.id.genreInput);
        final  TextView okText = (TextView) findViewById(R.id.okText);
        Button ajoutButton = (Button) findViewById(R.id.ajoutButton);

        ajoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String leMot = mot.getText().toString();
                int taille = leMot.length();
                String letype = type.getText().toString();
                String legenre = genre.getText().toString();

                Mot lemot = new Mot(leMot,taille,letype,legenre);
                long i = mm.insertWord(lemot);

                if(i !=-1)  {
                    okText.setText("ok ");
                } else{
                    okText.setText("not ok ");
                }
            }
        });



    }

}

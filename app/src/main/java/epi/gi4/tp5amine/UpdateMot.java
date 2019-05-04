package epi.gi4.tp5amine;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import epi.gi4.tp5amine.classes.Mot;
import epi.gi4.tp5amine.classes.MotsManager;

public class UpdateMot extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_mot);
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
        final MotsManager mm = new MotsManager(this);
        mm.open();
        final EditText newMot = (EditText) findViewById(R.id.updatewNewInput);
        final EditText oldMot = (EditText) findViewById(R.id.updateOldInput2);
        final TextView ok = (TextView) findViewById(R.id.okUpdate);
        final  EditText type = (EditText) findViewById(R.id.updatewNewInputType);
        final   EditText genre = (EditText) findViewById(R.id.updatewNewInputGenre);
        Button updateButton =(Button) findViewById(R.id.updateButton);
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newM = newMot.getText().toString();

                String oldM = oldMot.getText().toString();
                int taille = newM.length();
                String letype = type.getText().toString();
                String legenre = genre.getText().toString();
                Mot lemot = new Mot(newM,taille,letype,legenre);
                long i = mm.updateWorld(oldM , lemot);
                if(i !=-1)  {
                    ok.setText("ok ");
                } else{
                    ok.setText("not ok ");
                }

            }
        });
    }

}

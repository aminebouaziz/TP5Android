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

import epi.gi4.tp5amine.classes.MotsManager;

public class DeleteMot extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_mot);
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
        final EditText Mot = (EditText) findViewById(R.id.SupprimerInput);

        final TextView ok = (TextView) findViewById(R.id.okDelete);
        Button deleteButton = (Button) findViewById(R.id.buttonDelete);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               String leMot = Mot.getText().toString();

                long i = mm.removeContactByMot(leMot);
                if(i !=-1)  {
                    ok.setText("ok ");
                } else{
                    ok.setText("not ok ");
                }
            }
        });
    }

}

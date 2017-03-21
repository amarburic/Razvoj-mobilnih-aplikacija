package ba.unsa.etf.rma.amar_buric.rma17_17401;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import ba.unsa.etf.rma.amar_buric.rma17_17401.Kontroler.MojArrayAdapter;
import ba.unsa.etf.rma.amar_buric.rma17_17401.Model.Muzicar;

public class Pocetni extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pocetni);

        Button dugme = (Button)findViewById(R.id.button);
        final TextView tekstPolje = (TextView)findViewById(R.id.editText);
        ListView lista = (ListView)findViewById(R.id.listView);

        final ArrayList<Muzicar> unosi = new ArrayList<Muzicar>();

        //Hardkodirani unosi

        unosi.add(new Muzicar("Maso", "Karavdic", "grunge"));
        unosi.add(new Muzicar("Rasim", "Sabanovic", "punk rock"));
        unosi.add(new Muzicar("Amer", "Hrnjic", "folk rock"));
        unosi.add(new Muzicar("Haris", "Osmanbegovic", "heavy metal"));
        unosi.add(new Muzicar("Elvir", "Crncevic", "rap"));

        final MojArrayAdapter adapter;
        adapter = new MojArrayAdapter(this, R.layout.element_liste, unosi);

        lista.setAdapter(adapter);

        dugme.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //unosi.add(0,tekstPolje.getText().toString());
                adapter.notifyDataSetChanged();
                tekstPolje.setText("");
            }
        });



    }
}
package com.example.nop_had.animalanatomyalpha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class tela_index extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_index);

        ListView timeline = (ListView) findViewById(R.id.timelinelist);
        ArrayAdapter adapter = new timeline_adapter(this, adicionartimeline());
        timeline.setAdapter(adapter);
    }

    private ArrayList<timeline> adicionartimeline(){

        ArrayList<timeline> timelines = new ArrayList<timeline>();
        timeline t = new timeline("Teste de Feed","eoadmaquipoha","só to testando mesmo :B", R.drawable.icon_anonimo, R.drawable.icon_interesse, R.drawable.icon_comentar, R.drawable.icon_share);
        timelines.add(t);

        t = new timeline("Mais um tste de Feed","eoadmaquipoha","olha eu aqui dnv", R.drawable.icon_anonimo2, R.drawable.icon_interesse, R.drawable.icon_comentar, R.drawable.icon_share);
        timelines.add(t);

        t = new timeline("MDS DO CÉU DA CERTO PELO AMOR","eoadmaquipoha","porque eu ainda tento", R.drawable.icon_anonimo3, R.drawable.icon_interesse, R.drawable.icon_comentar, R.drawable.icon_share);
        timelines.add(t);

        t = new timeline("blz esse é o último","eoadmaquipoha","fatality", R.drawable.icon_anonimo4, R.drawable.icon_interesse, R.drawable.icon_comentar, R.drawable.icon_share);
        timelines.add(t);

        t = new timeline("Vamo ver se esse scroll funciona","eoadmaquipoha","ih ala", R.drawable.icon_anonimo, R.drawable.icon_interesse, R.drawable.icon_comentar, R.drawable.icon_share);
        timelines.add(t);

        t = new timeline("funcionou?","eoadmaquipoha","uhull", R.drawable.icon_anonimo2, R.drawable.icon_interesse, R.drawable.icon_comentar, R.drawable.icon_share);
        timelines.add(t);


        return timelines;

    }
}

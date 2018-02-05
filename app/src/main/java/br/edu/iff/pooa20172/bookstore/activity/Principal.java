package br.edu.iff.pooa20172.bookstore.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import br.edu.iff.pooa20172.bookstore.R;

public class Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        setContentView(R.layout.activity_principal);
        Button livroBT = (Button) findViewById(R.id.btTelaLivros);

        livroBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), LivroActivity.class);
                startActivity(intent);

            }
        });


    }
    private Context getContext(){
        return this;
    }
}

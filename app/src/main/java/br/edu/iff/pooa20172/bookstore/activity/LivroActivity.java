package br.edu.iff.pooa20172.bookstore.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.List;

import br.edu.iff.pooa20172.bookstore.R;
import br.edu.iff.pooa20172.bookstore.adapter.ClickRecyclerViewListener;
import br.edu.iff.pooa20172.bookstore.adapter.LivroAdapter;
import br.edu.iff.pooa20172.bookstore.model.Livro;
import io.realm.Realm;

public class LivroActivity extends AppCompatActivity implements ClickRecyclerViewListener {

    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livro);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        realm = Realm.getDefaultInstance();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LivroActivity.this,LivroDetalheActivity.class);
                intent.putExtra("id",0);
                startActivity(intent);
            }
        });
    }
    private List<Livro> getLivros() {
        return (List)realm.where(Livro.class).findAll();

    }

    @Override
    public void onClick(Object object) {
        Livro livro = (Livro) object;
        Intent intent = new Intent(LivroActivity.this,LivroDetalheActivity.class);
        intent.putExtra("id",livro.getId());
        startActivity(intent);

    }

    protected void onResume() {
        super.onResume();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_Livro);

        recyclerView.setAdapter(new LivroAdapter(getLivros(),this,this));
        RecyclerView.LayoutManager layout = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layout);


    }

    @Override
    public void finish(){
        realm.close();

    }
}

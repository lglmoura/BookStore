package br.edu.iff.pooa20172.bookstore.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import br.edu.iff.pooa20172.bookstore.R;
import br.edu.iff.pooa20172.bookstore.adapter.ClickRecyclerViewListener;
import br.edu.iff.pooa20172.bookstore.adapter.LivroAdapter;
import br.edu.iff.pooa20172.bookstore.model.Livro;

public class LivroActivity extends AppCompatActivity implements ClickRecyclerViewListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livro);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    private List<Livro> getLivros() {
        List<Livro> livros = new ArrayList<Livro>();
        int i = 0;
        for (i = 0; i <= 20; i++) {
            String iv = String.valueOf(i);
            Livro livro = new Livro(i, "Nome".concat(iv),"Autor".concat(iv), "Descricao".concat(iv));
            livros.add(livro);
        }
        return livros;
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
    public void onClick(Object object) {

    }
}

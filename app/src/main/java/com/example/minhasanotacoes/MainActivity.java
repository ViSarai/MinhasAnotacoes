package com.example.minhasanotacoes;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.minhasanotacoes.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private AnotacoesSalvas anotacoesSalvas;
    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private EditText editAnotacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        editAnotacao = findViewById(R.id.editAnotacao);
        anotacoesSalvas = new AnotacoesSalvas(getApplication());


        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String textoRecuperado = editAnotacao.getText().toString();
                if(textoRecuperado.equals("")){

                    Snackbar.make(view, "Escreva um anotação antes de salva-la.", Snackbar.LENGTH_LONG).show();

                } else {
                    anotacoesSalvas.salvarAnotacao(textoRecuperado);
                    Snackbar.make(view, "Salva com sucesso", Snackbar.LENGTH_LONG).show();
                }



            }
        });

        String anotacao= anotacoesSalvas.recuperarAnotacoes();
        if(!anotacao.equals("")){
            editAnotacao.setText(anotacao);
        }

    }

}
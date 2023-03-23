package com.example.minhasanotacoes;

import android.content.Context;
import android.content.SharedPreferences;

public class AnotacoesSalvas{

    private SharedPreferences preferences;
    private Context context;
    private final String NOME_ARQUIVO = "anotacoes.salavas";
    private final String CHAVE_NOME = "nome";
    private  SharedPreferences.Editor editor;

    public AnotacoesSalvas(Context c) {
        this.context = c;
        preferences = context.getSharedPreferences(NOME_ARQUIVO,0);
        editor = preferences.edit();
    }

    public void salvarAnotacao(String anotacao){

        editor.putString(CHAVE_NOME,anotacao);
        editor.commit();

    }
    public String recuperarAnotacoes(){

        return preferences.getString(CHAVE_NOME,"");
    }
}

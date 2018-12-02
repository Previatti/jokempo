package com.example.previ.jokemp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionarPedra(View view){
        this.opcaoSelecionada("Pedra");
    }

    public void selecionarPapel(View view){
        this.opcaoSelecionada("Papel");
    }

    public void selecionarTesoura(View view){
        this.opcaoSelecionada("Tesoura");
    }

    public void opcaoSelecionada(String escolhaUsuario){
        ImageView imageResultado = findViewById(R.id.imgResultado);

        String[] opcoes = {"Pedra", "Papel", "Tesoura"};
        int numero = new Random().nextInt(3);

        String escolhaApp = opcoes[numero];

        switch (escolhaApp) {
            case "Pedra" :
                imageResultado.setImageResource(R.drawable.pedra);
                break;
            case "Papel" :
                imageResultado.setImageResource(R.drawable.papel);
                break;
            case "Tesoura" :
                imageResultado.setImageResource(R.drawable.tesoura);
                break;

        }

        TextView textoResultado = findViewById(R.id.txtResultado);

        if (
                (escolhaApp == "Pedra" && escolhaUsuario == "Tesoura") ||
                (escolhaApp == "Papel" && escolhaUsuario == "Pedra")||
                (escolhaApp == "Tesoura" && escolhaUsuario == "Papel")
            ){
            textoResultado.setText("APP GANHADOR");

        }else if
                (
                (escolhaUsuario == "Pedra" && escolhaApp == "Tesoura") ||
                (escolhaUsuario == "Papel" && escolhaApp == "Pedra")||
                (escolhaUsuario == "Tesoura" && escolhaApp == "Papel")
                ){
            textoResultado.setText("USUÁRIO GANHADOR");
        }else{
            textoResultado.setText("EMPATAMOS");
        }

    }
}

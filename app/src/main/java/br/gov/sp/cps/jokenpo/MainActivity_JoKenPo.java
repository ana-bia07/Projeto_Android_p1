package br.gov.sp.cps.jokenpo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

import br.gov.sp.cps.projeto_p1.R;

public class MainActivity_JoKenPo extends AppCompatActivity {
    //variaveis fora pois dentro do metodo opcaoSelecionada elas reicião toda vez que o metodo é chamado
    //sempre que usuario escolhe uam opção

    private int pointPC;
    private int pointYou;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_jokenpo);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void selectPedra(View view){
        this.opcaoSelecionada("pedra");
    }

    public void selectPapel(View view){
        this.opcaoSelecionada("papel");
    }

    public void selectTesoura(View view){
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String opcSelect){
        ImageView imgResult = findViewById(R.id.imgPadrao);
        TextView txtResult = findViewById(R.id.txtResultado);
        TextView txtPlacar = findViewById(R.id.txtPlacar);
        var layout = findViewById(R.id.main);


        int n = new Random().nextInt(3);
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String opPC = opcoes[n];

        switch (opPC){
            case "pedra":
                imgResult.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imgResult.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imgResult.setImageResource(R.drawable.tesoura);
                break;
        }

        if((opPC == "tesoura" && opcSelect == "papel") ||
                (opPC == "papel" && opcSelect == "pedra") ||
                (opPC == "pedra" && opcSelect == "tesoura")){
            txtResult.setText("PC WIN - Azarado da peste");
            layout.setBackgroundColor(getResources().getColor(R.color.red_fraco));
            pointPC ++;
            txtPlacar.setText(pointPC + " X " + pointYou);
        } else if ((opcSelect == "tesoura" && opPC == "papel") ||
                (opcSelect == "papel" && opPC == "pedra") ||
                (opcSelect == "pedra" && opPC == "tesoura")){
            txtResult.setText("YOU WIN - Sorte da porra boy");
            layout.setBackgroundColor(getResources().getColor(R.color.green_fraco));
            pointYou ++;
            txtPlacar.setText(pointPC + " X " + pointYou);
        }else{
            txtResult.setText("Empatou :(");
            txtPlacar.setText(pointPC + " X " + pointYou);
        }

        if(pointPC == 5 || pointYou == 5){
            Intent intent = new Intent(this, Resultado.class);
            intent.putExtra("pointPC", pointPC);
            intent.putExtra("pointYou", pointYou);
            pointPC = 0;
            pointYou = 0;
            startActivity(intent);

        }

    }


}
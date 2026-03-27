package br.gov.sp.cps.imc;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import br.gov.sp.cps.jokenpo.Resultado;
import br.gov.sp.cps.projeto_p1.MainActivity_P1;
import br.gov.sp.cps.projeto_p1.R;

public class Activity_Normal extends AppCompatActivity {

    private Button btnChamaT1;
    private TextView textValores;
    private Button btnMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("Ciclo Vida", "T2-onCreate");

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_normal);

        btnChamaT1 = findViewById(R.id.btnChamaT1);
        textValores = findViewById(R.id.textValores);

        // Recebe o IMC da MainActivity1
        double imc = getIntent().getDoubleExtra("imc", 0);

        // Mostra o valor do IMC
        textValores.setText("IMC: " + String.format("%.2f", imc));

        // Botão voltar
        btnChamaT1.setOnClickListener(view -> { finish();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnMenu = findViewById(R.id.btnMenu);
        btnMenu.setOnClickListener(view -> {
            Intent intent = new Intent(Activity_Normal.this, MainActivity_P1.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
            finish();
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i("Ciclo Vida", "T2-onStart");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i("Ciclo Vida", "T2-onResume");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i("Ciclo Vida", "T2-onPause");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i("Ciclo Vida", "T2-onStop");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i("Ciclo Vida", "T2-onRestart");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i("Ciclo Vida", "T2-onDestroy");
    }
}
package br.gov.sp.cps.projeto_p1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import br.gov.sp.cps.jokenpo.MainActivity_JoKenPo;
import br.gov.sp.cps.loteria.MainActivity_Buttontext;

public class MainActivity_P1 extends AppCompatActivity {
    private Button btnLoteria;
    private Button btnImc;
    private Button btnJokenpo;
    private Button btnFeliz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_p1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnLoteria = findViewById(R.id.btnLoteria);
        btnImc = findViewById(R.id.btnImc);
        btnJokenpo = findViewById(R.id.btnJokenpo);
        btnFeliz = findViewById(R.id.btnFeliz);

        btnLoteria.setOnClickListener(view ->{
            Intent intent = new Intent(this, MainActivity_Buttontext.class);
            startActivity(intent);
        });

        btnImc.setOnClickListener(view ->{
            Intent intent = new Intent(this, br.gov.sp.cps.imc.MainActivity_IMC.class);
            startActivity(intent);
        });

        btnJokenpo.setOnClickListener(view ->{
            Intent intent = new Intent(this, MainActivity_JoKenPo.class);
            startActivity(intent);
        });

        btnFeliz.setOnClickListener(view->{
            Intent intent = new Intent(this, Felizometro.class);
            startActivity(intent);
        });
    }
}
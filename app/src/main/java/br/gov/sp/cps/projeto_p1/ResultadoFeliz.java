package br.gov.sp.cps.projeto_p1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.badge.BadgeUtils;

import br.gov.sp.cps.jokenpo.Resultado;

public class ResultadoFeliz extends AppCompatActivity {
    private TextView txtMensagem;
    private TextView txtFeliz;
    private Button btnMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resultado_feliz);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtFeliz = findViewById(R.id.txtFeliz);
        txtMensagem = findViewById(R.id.txtMensagem);

        btnMenu = findViewById(R.id.btnMenu);
        btnMenu.setOnClickListener(view ->{
            Intent intent = new Intent(ResultadoFeliz.this, MainActivity_P1.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
            finish();
        });

        Intent intent = getIntent();
        int feliz = intent.getIntExtra("feliz", 0);

        txtFeliz.setText(String.valueOf(feliz));

        if(feliz >= 8){
            txtMensagem.setText("Muito bem, ta saudavel");
        }else if(feliz < 8 && feliz >= 4){
            txtMensagem.setText("Precisa melhorar");
        }else{
            txtMensagem.setText("Muito ruim, va se cuidar");
        }
    }
}
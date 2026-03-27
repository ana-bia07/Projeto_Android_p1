package br.gov.sp.cps.jokenpo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import br.gov.sp.cps.projeto_p1.MainActivity_P1;
import br.gov.sp.cps.projeto_p1.R;

public class Resultado extends AppCompatActivity {
    private Button btnVoltar;
    private Button btnMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resultado);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnMenu = findViewById(R.id.btnMenu);
        btnMenu.setOnClickListener(view -> {
            Intent intent = new Intent(Resultado.this, MainActivity_P1.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
            finish();
        });

        TextView txtVencedor= findViewById(R.id.txtVencedor);
        ImageView imgVitoria = findViewById(R.id.imgVitoria);

        btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(view -> finish());

        var layout = findViewById(R.id.main);
        int pointPC = getIntent().getIntExtra("pointPC", 0);
        int pointYou = getIntent().getIntExtra("pointYou", 0);

        if(pointPC > pointYou){
            txtVencedor.setText("PC WIN");
            imgVitoria.setImageResource(R.drawable.triste);
            layout.setBackgroundColor(getResources().getColor(R.color.red_fraco));
        } else {
            txtVencedor.setText("YOU WIN");
            imgVitoria.setImageResource(R.drawable.parabens);
            layout.setBackgroundColor(getResources().getColor(R.color.green_fraco));
        }
    }
}
package br.gov.sp.cps.projeto_p1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Felizometro extends AppCompatActivity {
    private CheckBox cTrampo, cEstudo, cVaga;
    private Button btnCalcular;
    private RadioGroup rgSono, rgStress;
    private RadioButton rbSRuim, rbSIdeal, rbSOtimo;
    private RadioButton rbEBom, rbENormal, rbERuim;
    private int sono, stress, afazer, feliz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_felizometro);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        rgSono = findViewById(R.id.rgSono);
        rbSOtimo = findViewById(R.id.rbSOtimo);
        rbSIdeal = findViewById(R.id.rbSIdeal);
        rbSRuim = findViewById(R.id.rbSRuim);

        rgStress = findViewById(R.id.rgStress);
        rbERuim = findViewById(R.id.rbERuim);
        rbENormal = findViewById(R.id.rbENormal);
        rbEBom = findViewById(R.id.rbEBom);

        btnCalcular = findViewById(R.id.btnCalcular);

        cTrampo = findViewById(R.id.checkTrampo);
        cVaga = findViewById(R.id.checkVaga);
        cEstudo = findViewById(R.id.checkEstudo);

        calculaSono();
        calculaStress();


        btnCalcular.setOnClickListener(view -> {
            calculaAfazer();
            Log.i("notas", "esta em E:" + stress + " A:" + afazer + " S:" + sono);

            feliz = (afazer + sono + stress) / 3;
            Log.i("Felizometro", "esta em:" + feliz);
            Intent intent = new Intent(this, ResultadoFeliz.class);
            intent.putExtra("feliz", feliz);
            startActivity(intent);
        });
    }

    public void calculaSono() {
        rgSono.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull RadioGroup group, int i) {
                if (i == R.id.rbSRuim) {
                    sono = 3;
                } else if (i == R.id.rbSIdeal) {
                    sono = 10;
                } else if (i == R.id.rbSOtimo) {
                    sono = 5;
                }

                Log.i("sono", "esta em " + sono);
            }
        });
    }

    public void calculaStress(){
        rgStress.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull RadioGroup group, int i){
                if(i == R.id.rbERuim){
                    stress = 3;
                } else if (i == R.id.rbENormal) {
                    stress = 6;
                } else if (i == R.id.rbEBom) {
                    stress = 10;
                }
                Log.i("stress", "esta em " + stress);
            }
        });
    }

    public void calculaAfazer(){
        afazer=0;
        if(cTrampo.isChecked()){
            afazer +=3;
        }if (cEstudo.isChecked()){
            afazer +=5;
        }if (cVaga.isChecked()) {
            afazer +=10;
        }
        Log.i("Afazer", "esta em " + afazer);
    }
}
package br.gov.sp.cps.imc;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import br.gov.sp.cps.projeto_p1.R;

public class MainActivity_IMC extends AppCompatActivity {

    private EditText txtPeso;
    private EditText txtAltura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_imc);

        txtAltura = findViewById(R.id.txtAltura);
        txtPeso = findViewById(R.id.txtPeso);

        Log.i("Ciclo de vida", "T1-onCreate");
    }

    public void calcular(View view) {

        String sPeso = txtPeso.getText().toString();
        String sAltura = txtAltura.getText().toString();

        double peso = Double.parseDouble(sPeso);
        double altura = Double.parseDouble(sAltura);
        double imc = calcularIMC(peso, altura);

        Toast.makeText(this, "IMC = " + imc, Toast.LENGTH_LONG).show();

        Intent intent;
        Log.i("DEBUG_IMC", "IMC calculado: " + imc);

        if (imc < 18.5) {
            intent = new Intent(this, Activity_magreza.class);
            Log.i("DEBUG_IMC", "Entou na magreza: " + imc);
        } else if (imc < 25) {
            intent = new Intent(this, Activity_Normal.class);
            Log.i("DEBUG_IMC", "Entou na normal: " + imc);
        } else {
            intent = new Intent(this, Activity_Sobrepeso.class);
            Log.i("DEBUG_IMC", "Entou na sobrepeso: " + imc);
        }

        intent.putExtra("imc", imc);
        startActivity(intent);
    }

    public double calcularIMC(double peso, double altura) {
        return peso / (altura * altura);
    }
}
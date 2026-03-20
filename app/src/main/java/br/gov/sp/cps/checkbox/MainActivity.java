package br.gov.sp.cps.checkbox;

import android.os.Bundle;
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

public class MainActivity extends AppCompatActivity {
    private CheckBox cGreen, cRed, cBlue;
    private TextView txtResult;
    private Button btnResult;
    private RadioGroup rgFood;
    private RadioButton rbOp1, rbOp2, rbOp3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        cBlue = findViewById(R.id.checkBlue);
        cGreen = findViewById(R.id.checkGreen);
        cRed = findViewById(R.id.checkRed);

        rgFood = findViewById(R.id.rgFood);
        rbOp1 = findViewById(R.id.rbOp1);
        rbOp2 = findViewById(R.id.rbOp2);
        rbOp3 = findViewById(R.id.rbOp3);

        txtResult = findViewById(R.id.txtResult);
        btnResult = findViewById(R.id.btnResult);
/*
        btnResult.setOnClickListener(View ->{
            String text = " ";
            if(cRed.isChecked()){
                text = text + " Vermelho";
            }
            if(cGreen.isChecked()){
                text = text + " Verde";
            }
            if(cBlue.isChecked()){
                text = text + " Azul";
            }
            txtResult.setText(text);
        });*/
        radioButton();
    }
    //Metodo
    public void radioButton(){
        rgFood.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(@NonNull RadioGroup radioGroup, int i){
                if(i == R.id.rbOp1){
                    txtResult.setText("Selecionou 1");
                } else if (i == R.id.rbOp2) {
                    txtResult.setText("Selecionado 2");
                } else if(i == R.id.rbOp3){
                    txtResult.setText("Selecionou 3");
                }
            }
        });
    }
}
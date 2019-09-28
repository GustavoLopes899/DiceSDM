package br.edu.ifsp.scl.sdm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // Random usado para simular o lançamento do dado
    private Random geradorRandomico;

    // Componentes visuais
    private TextView resultadoTextView;
    private Button jogarDadoButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

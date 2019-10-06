package br.edu.ifsp.scl.sdm;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;
import java.util.TreeSet;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Random usado para simular o lançamento do dado
    private Random geradorRandomico;

    // Lista de números sorteados
    private TreeSet<Integer> numerosSorteados = new TreeSet<>();

    // Componentes visuais
    private TextView resultadoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Após a criação da tela
        geradorRandomico = new Random(System.currentTimeMillis());

        // Recuperando referência para o resultadoTextView do arquivo de layout
        resultadoTextView = findViewById(R.id.resultadoTextView);

        // Recuperando referência para o sortearButton e reiniciarJogoButton do arquivo de layout
        Button sortearNumero = findViewById(R.id.sortearButton);
        sortearNumero.setOnClickListener(this);

        Button reiniciarJogo = findViewById(R.id.reiniciarJogo);
        reiniciarJogo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.sortearButton) {
            String resultadoText = "Números sorteados: ";

            // Quantidade de números do bingo
            int numeros = 60;
            int resultado;
            resultado = geradorRandomico.nextInt(numeros) + 1;
            while (numerosSorteados.contains(resultado) && numerosSorteados.size() != numeros) {
                resultado = geradorRandomico.nextInt(numeros) + 1;
            }
            numerosSorteados.add(resultado);
            resultadoText = resultadoText + "\n"+ numerosSorteados.toString();

            resultadoTextView.setText(resultadoText);
        } else if (view.getId() == R.id.reiniciarJogo) {
            numerosSorteados.clear();
            resultadoTextView.setText(getString(R.string.nenhum_numero_sorteado));
        }
    }

}

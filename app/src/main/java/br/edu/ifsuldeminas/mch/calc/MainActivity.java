package br.edu.ifsuldeminas.mch.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.EmptyStackException;

import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.ExpressionBuilder;
import de.congrace.exp4j.UnknownFunctionException;
import de.congrace.exp4j.UnparsableExpressionException;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "ifsuldeminas.mch.calc";
    private TextView textViewResultado;
    private TextView textViewUltimaExpressao;
    private Button buttonZero;
    private Button buttonUm;
    private Button buttonDois;
    private Button buttonTres;
    private Button buttonQuatro;
    private Button buttonCinco;
    private Button buttonSeis;
    private Button buttonSete;
    private Button buttonOito;
    private Button buttonNove;
    private Button buttonVirgula;
    private Button buttonSoma;
    private Button buttonSubtracao;
    private Button buttonMultiplicacao;
    private Button buttonDivisao;
    private Button buttonPorcento;
    private Button buttonDelete;
    private Button buttonReset;
    private Button buttonBlanck;
    private Button buttonIgual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResultado = findViewById(R.id.textViewResultadoID);
        textViewUltimaExpressao = findViewById(R.id.textViewUltimaExpressaoID);
        buttonZero = findViewById(R.id.buttonZeroID);
        buttonUm = findViewById(R.id.buttonUmID);
        buttonDois = findViewById(R.id.buttonDoisID);
        buttonTres = findViewById(R.id.buttonTresID);
        buttonQuatro = findViewById(R.id.buttonQuatroID);
        buttonCinco = findViewById(R.id.buttonCincoID);
        buttonSeis = findViewById(R.id.buttonSeisID);
        buttonSete = findViewById(R.id.buttonSeteID);
        buttonOito = findViewById(R.id.buttonOitoID);
        buttonNove = findViewById(R.id.buttonNoveID);
        buttonVirgula = findViewById(R.id.buttonVirgulaID);
        buttonSoma = findViewById(R.id.buttonSomaID);
        buttonSubtracao = findViewById(R.id.buttonSubtracaoID);
        buttonMultiplicacao = findViewById(R.id.buttonMultiplicacaoID);
        buttonDivisao = findViewById(R.id.buttonDivisaoID);
        buttonPorcento = findViewById(R.id.buttonPorcentoID);
        buttonDelete = findViewById(R.id.buttonDeleteID);
        buttonReset = findViewById(R.id.buttonResetID);
        buttonBlanck = findViewById(R.id.buttonBlanckID);
        buttonIgual = findViewById(R.id.buttonIgualID);

        buttonZero.setOnClickListener(v -> {
            textViewResultado.setText(textViewResultado.getText()+"0");
        });

        buttonUm.setOnClickListener(v -> {
            textViewResultado.setText(textViewResultado.getText()+"1");
        });

        buttonDois.setOnClickListener(v -> {
            textViewResultado.setText(textViewResultado.getText()+"2");
        });

        buttonTres.setOnClickListener(v -> {
            textViewResultado.setText(textViewResultado.getText()+"3");
        });

        buttonQuatro.setOnClickListener(v -> {
            textViewResultado.setText(textViewResultado.getText()+"4");
        });

        buttonCinco.setOnClickListener(v -> {
            textViewResultado.setText(textViewResultado.getText()+"5");
        });

        buttonSeis.setOnClickListener(v -> {
            textViewResultado.setText(textViewResultado.getText()+"6");
        });

        buttonSete.setOnClickListener(v -> {
            textViewResultado.setText(textViewResultado.getText()+"7");
        });

        buttonOito.setOnClickListener(v -> {
            textViewResultado.setText(textViewResultado.getText()+"8");
        });

        buttonNove.setOnClickListener(v -> {
            textViewResultado.setText(textViewResultado.getText()+"9");
        });

        buttonBlanck.setOnClickListener(v -> {
        });

        buttonDelete.setOnClickListener(v -> {
            try{
                String text = (String) textViewResultado.getText();
                textViewResultado.setText(text.substring(0,textViewResultado.getText().length()-1));;
            }catch (Exception e){
                System.out.println(e);
            }
        });

        buttonDivisao.setOnClickListener(v -> {
            textViewResultado.setText(textViewResultado.getText()+"/");
        });


        buttonIgual.setOnClickListener(v -> {
            String expressao = textViewResultado.getText().toString();
            try {
                Calculable avaliadorExpressao = new ExpressionBuilder(expressao).build();
                String resultado = String.valueOf(avaliadorExpressao.calculate());
                Toast.makeText(MainActivity.this,resultado, Toast.LENGTH_SHORT).show();
                textViewResultado.setText(resultado);
                textViewUltimaExpressao.setText(String.format("%s = %s", expressao, resultado));
            } catch (Exception e) {
                textViewResultado.setText("");
                Toast.makeText(MainActivity.this, "Ocorreu um erro: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        buttonMultiplicacao.setOnClickListener(v -> {
            textViewResultado.setText(textViewResultado.getText()+"*");
        });

        buttonPorcento.setOnClickListener(v -> {
            String expressao = textViewResultado.getText().toString();
            if (!expressao.isEmpty()) {
                double numero = Double.parseDouble(expressao);
                double resultado = numero / 100;
                String resultadoComPonto = String.valueOf(resultado).replace(",", ".");
                textViewResultado.setText(resultadoComPonto);
                textViewUltimaExpressao.setText(String.format("%s%% = %s", expressao, resultadoComPonto));
            }
        });


        buttonReset.setOnClickListener(v -> {
            textViewResultado.setText("");
            textViewUltimaExpressao.setText("");
        });

        buttonSoma.setOnClickListener(v -> {
            textViewResultado.setText(textViewResultado.getText()+"+");
        });

        buttonSubtracao.setOnClickListener(v -> {
            textViewResultado.setText(textViewResultado.getText()+"-");
        });

        buttonVirgula.setOnClickListener(v -> {
            textViewResultado.setText(textViewResultado.getText()+".");
        });


    }
}
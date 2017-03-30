package harlockstudio.com.br.calculadora;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class CalcActivity extends Activity {
    String valorAtual = "";
    TextView textoCalc;
    String valorAdireita = "";
    String valorAesquerda = "";
    Operacao operacaoAtual;
    int resultado = 0;
    public enum Operacao{
        SOMAR, SUBTRAIR, DIVIDIR, MULTIPLICAR, CALCULAR
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        Button btnUm = (Button) findViewById(R.id.btnUm);
        Button btnDois = (Button) findViewById(R.id.btnDois);
        Button btnTres = (Button) findViewById(R.id.btnTres);
        Button btnCuatro = (Button) findViewById(R.id.btnCuatro);
        Button btnCinco = (Button) findViewById(R.id.btnCinco);
        Button btnSeis = (Button) findViewById(R.id.btnSeis);
        Button btnSete = (Button) findViewById(R.id.btnSete);
        Button btnOito = (Button) findViewById(R.id.btnOito);
        Button btnNove = (Button) findViewById(R.id.btnNove);
        Button btnZero = (Button) findViewById(R.id.btnZero);

        ImageButton btnCalcular = (ImageButton) findViewById(R.id.btnCalc);
        ImageButton btnSomar = (ImageButton) findViewById(R.id.btnSoma);
        ImageButton btnSubtrair = (ImageButton) findViewById(R.id.btnSubtracao);
        ImageButton btnDividir = (ImageButton) findViewById(R.id.btnDivisao);
        ImageButton btnMultiplicar = (ImageButton) findViewById(R.id.btnMultiplicacao);

        Button btnLimpar = (Button) findViewById(R.id.btnLimpar);

        textoCalc = (TextView) findViewById(R.id.textoResultado);
        textoCalc.setText("");
        btnUm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                acaoPrecionada(1);
            }
        });
        btnDois.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                acaoPrecionada(2);
            }
        });
        btnTres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                acaoPrecionada(3);
            }
        });
        btnCuatro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                acaoPrecionada(4);
            }
        });
        btnCinco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                acaoPrecionada(5);
            }
        });
        btnSeis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                acaoPrecionada(6);
            }
        });
        btnSete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                acaoPrecionada(7);
            }
        });
        btnOito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                acaoPrecionada(8);
            }
        });
        btnNove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                acaoPrecionada(9);
            }
        });
        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                acaoPrecionada(0);
            }
        });

        // Adiciona as operações a conta atual
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processaoAcao(Operacao.CALCULAR);
            }
        });
        btnSomar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processaoAcao(Operacao.SOMAR);
            }
        });
        btnMultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processaoAcao(Operacao.MULTIPLICAR);
            }
        });
        btnDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processaoAcao(Operacao.DIVIDIR);
                String symbol = "÷";
            }
        });
        btnSubtrair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processaoAcao(Operacao.SUBTRAIR);
            }
        });
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                valorAesquerda = "";
                valorAdireita = "";
                resultado = 0;
                valorAtual = "";
                operacaoAtual = null;
                textoCalc.setText("0");
            }
        });

    }
    void processaoAcao(Operacao operation) {

        if (operacaoAtual != null) {

            if (valorAtual != "") {
                valorAdireita = valorAtual;
                valorAtual = "";

                switch (operacaoAtual) {
                    case SOMAR:
                        resultado = Integer.parseInt(valorAesquerda) + Integer.parseInt(valorAdireita);
                        break;
                    case SUBTRAIR:
                        resultado = Integer.parseInt(valorAesquerda) - Integer.parseInt(valorAdireita);
                        break;
                    case MULTIPLICAR:
                        resultado = Integer.parseInt(valorAesquerda) * Integer.parseInt(valorAdireita);
                        break;
                    case DIVIDIR:
                        resultado = Integer.parseInt(valorAesquerda) / Integer.parseInt(valorAdireita);
                        break;
                }

                valorAesquerda = String.valueOf(resultado);
                textoCalc.setText(valorAesquerda);
            }


        } else {
            valorAesquerda = valorAtual;
            valorAtual = "";
        }

        operacaoAtual = operation;
    }
    void acaoPrecionada(int numero){
        valorAtual += String.valueOf(numero);
        textoCalc.setText(valorAtual);
    }


}

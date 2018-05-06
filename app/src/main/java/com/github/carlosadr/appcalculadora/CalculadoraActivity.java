package com.github.carlosadr.appcalculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculadoraActivity extends AppCompatActivity {

    private TextView txt_Numeros,txt_Valores;
    private  String Numero;

    private double numero1,numero2;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        startObjects();
    }

    private void startObjects() {
        txt_Numeros = findViewById(R.id.txt_Numeros);
        txt_Valores = findViewById(R.id.txt_Valores);
    }

    public void Numericos(View view){
        String num;
        Button btn = (Button)view;
        num = btn.getText().toString();
        Numero = txt_Numeros.getText().toString();
        txt_Numeros.setText(String.format("%s%s", Numero, num));
    }

    public void Operacoes(View view){
        Button btn = (Button)view;

        numero1 = Double.parseDouble(txt_Numeros.getText().toString());

        if (txt_Valores.getText().equals("")){
            if (btn.getText().toString().equals("+") || btn.getText().toString().equals("-")){
                numero2 = 0;
            }else {
                numero2 = 1;
            }
        }
        else {
            numero2 = Double.parseDouble(txt_Valores.getText().toString());
        }

        Operadores operadores = new Operadores(numero1,numero2, btn.getText().toString());

        txt_Valores.setText(operadores.setResultado());
        txt_Numeros.setText("");
    }

    public void Especiais(View view){
        Button btn = (Button)view;
        switch (btn.getText().toString()){
            case "C": //TODO: Fazer um Botao para apagar tudo.;
                break;
            case "CE": //TODO: Fazer um Botao que apague somente oque esta sendo digitado.;
                break;
            case "⌫": //TODO: Fazerum Botao que apague somente um numero por vez.;
                break;
            case ",":
                if (Numero.contains(".")){
                    return;
                }
                Numero = txt_Numeros.getText().toString();
                txt_Numeros.setText(String.format("%s.", Numero));
                break;
        }
    }

    /*private void Operacoes(int operacao) {

        if (!txt_Valores.toString().equals("") && (soma || subtracao || multplicacao || divisao)) {
            numero_A = Double.parseDouble(txt_Valores.getText().toString());
            numero_B = Double.parseDouble(txt_Numeros.getText().toString());
        } else if (txt_Valores.toString().equals("") && (soma || subtracao)) {
            numero_A = 0;
            numero_B = Double.parseDouble(txt_Numeros.getText().toString());
        } else if (txt_Valores.toString().equals("") && (multplicacao || divisao)) {
            numero_A = 1;
            numero_B = Double.parseDouble(txt_Numeros.getText().toString());
        }

        switch (operacao) {
            case 0:
                resultado = numero_A + numero_B;
                soma = !soma;
                break;
            case 1:
                resultado = numero_A - numero_B;
                subtracao = !subtracao;
                break;
            case 2:
                resultado = numero_A * numero_B;
                multplicacao = !multplicacao;
                break;
            case 3:
                resultado = numero_A / numero_B;
                divisao = !divisao;
                break;
            case 4:
                resultado = numero_B * -1;
                txt_Numeros.setText(String.valueOf(resultado));
                break;
        }

        if (operacao >= 0) {
            txt_Valores.setText(String.valueOf(resultado));
            txt_Numeros.setText("");
        } else {
            txt_Valores.setText(String.valueOf(resultado));
            txt_Numeros.setText("");
        }
    }*/
}

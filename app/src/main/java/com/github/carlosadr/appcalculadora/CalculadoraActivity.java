package com.github.carlosadr.appcalculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class CalculadoraActivity extends AppCompatActivity {

    private TextView txt_Numeros,txt_Valores;
    private  String Numero;

    private Operadores op = new Operadores( 0, 0, "");

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
        if (!txt_Numeros.getText().equals("")){
            double numero1 = Double.parseDouble(txt_Numeros.getText().toString());

            double numero2;
            if (txt_Valores.getText().equals("")) {
                if (btn.getText().toString().equals("+") || btn.getText().toString().equals("-")) {
                    numero2 = 0;
                } else if( btn.getText().toString().equals("X") ) {
                    numero2 = 1;//TODO Fazer a Divizão receber numero 1 em numero 2;
                }else {
                    numero2 = numero1;
                    numero1 = 1;
                }
            } else {
                numero2 = Double.parseDouble(txt_Valores.getText().toString());
            }

            op.setValores(numero1, numero2, btn.getText().toString());

            if(btn.getText().toString().equals("=") || btn.getText().toString().equals("±")){
                txt_Valores.setText("");
                txt_Numeros.setText(op.setResultado());
            }else {
                txt_Valores.setText(op.setResultado());
                txt_Numeros.setText("");
            }
        }
    }

    public void Especiais(View view){
        Button btn = (Button)view;
        switch (btn.getText().toString()){
            case "C":
                txt_Valores.setText("");
                txt_Numeros.setText("");
                op.setValores(0,0,"");
                break;
            case "CE":
                txt_Numeros.setText(null);
                break;
            case "⌫": //TODO: Fazerum Botao que apague somente um numero por vez.;
                String num = txt_Numeros.getText().toString();
                StringBuilder numStrings = new StringBuilder(num);
                if (num.length() == 0){
                    break;
                }else{
                    num = String.valueOf(numStrings.deleteCharAt(num.length() -1));
                    txt_Numeros.setText(num);
                    break;
                }
            case ",":
                if (Numero.contains(".")){
                    return;
                }
                Numero = txt_Numeros.getText().toString();
                txt_Numeros.setText(String.format("%s.", Numero));
                break;
        }
    }
}

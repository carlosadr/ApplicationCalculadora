package com.github.carlosadr.appcalculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
            float numero1 = Float.parseFloat(txt_Numeros.getText().toString());

            float numero2;
            if (txt_Valores.getText().equals("")) {
                switch (btn.getText().toString()) {
                    case "+":
                    case "-":
                        numero2 = 0;
                        break;
                    case "X":
                        numero2 = 1;
                        break;
                    default:
                        numero2 = numero1;
                        numero1 = 1;
                        break;
                }
            } else {
                numero2 = Float.parseFloat(txt_Valores.getText().toString());
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
                txt_Valores.setText(null);
                txt_Numeros.setText(null);
                op.setValores(0,0,"");
                break;
            case "CE":
                if (txt_Valores.getText().equals("")) {
                    op.setValores(0, 0, "");
                    op.setResultado(null);
                    op.setOperadorPedente(null);
                    txt_Valores.setText(null);
                }
                txt_Numeros.setText(null);
                break;
            case "⌫":
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

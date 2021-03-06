package com.github.carlosadr.appcalculadora;

public class Operadores {
    private double numero1,numero2;
    private String operador, operadorPedente,resultado;

    Operadores(double numero1, double numero2, String operador){
        this.numero1 = numero1;
        this.numero2 = numero2;
        this.operador = operador;
    }

    public void setValores(double numero1, double numero2, String operador){
        this.numero1 = numero1;
        this.numero2 = numero2;
        this.operador = operador;
    }

    public void setOperadorPedente(String operador) {
        this.operadorPedente = operador;
    }

    private String getOperadorPedente() {
        return operadorPedente;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String setResultado() {
        if (getOperadorPedente() == null || getOperadorPedente().equals("±") || getOperadorPedente().equals("=")){
            return getResultadoPedente(operador);
        }else {
            return getResultadoPedente(getOperadorPedente());
        }
    }

    private String getResultadoPedente(String op) {
        switch (op) {
            case "+":
                resultado = String.valueOf(numero2 + numero1);
                break;
            case "-":
                resultado = String.valueOf(numero2 - numero1);
                break;
            case "X":
                resultado = String.valueOf(numero2 * numero1);
                break;
            case "÷":
                resultado = String.valueOf(numero2 / numero1);
                break;
            case "±":
                resultado = String.valueOf(numero2 * -1);
                break;
        }
        setOperadorPedente(operador);
        return resultado;
    }
}

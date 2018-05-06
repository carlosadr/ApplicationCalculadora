package com.github.carlosadr.appcalculadora;

public class Operadores {
    private double numero1,numero2;
    private String operador, operadorPedente,resultado;

    public Operadores(double numero1, double numero2, String operador){
        this.numero1 = numero1;
        this.numero2 = numero2;
        this.operador = operador;
    }

    private void setOperadorPedente(String operador) {
        this.operadorPedente = operador;
    }

    private String getOperadorPedente() {
        return operadorPedente;
    }

    public String setResultado() {
        if (getOperadorPedente().equals("")){
            return getResultadoPedente(operador);
        }
        return getResultadoPedente(getOperadorPedente());
    }

    private String getResultadoPedente(String op) {
        switch (op) {
            case "+":
                resultado = String.valueOf(numero1 + numero2);
                break;
            case "-":
                resultado = String.valueOf(numero1 - numero2);
                break;
            case "X":
                resultado = String.valueOf(numero1 * numero2);
                break;
            case "÷":
                resultado = String.valueOf(numero1 / numero2);
                break;
        }
        setOperadorPedente(operador);
        return resultado;
    }

}

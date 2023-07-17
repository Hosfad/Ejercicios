package Calculadora;

import java.util.Arrays;
import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {
        while (true){

            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingrese la operacion a realizar (3x3): ");
            String input = scanner.nextLine();
            if (validOperation(input)){
                String[] inputArray = input.split("");
                int a = Integer.parseInt(inputArray[0]);
                int b = Integer.parseInt(inputArray[2]);
                Calculadora calculadora = new Calculadora(a, b);
                String operador = inputArray[1];
                int result = calculadora.calcular(operador);
                System.out.println("El resultado es: " + result);
            }else {
                System.out.println("Porfavor elije una operacion valida (3x3)");
            }

        }
    }

    public int a;
    public int b;

    public Calculadora(int a ,int b){
        this.a = a;
        this.b = b;
    }
    public int sumar(){
        return a + b;
    }
    public int restar(){
        return a - b;
    }
    public int multiplicar(){
        return a * b;
    }
    public int dividir(){
        return a / b;
    }



    public  int calcular(String operador){

        return switch (operador) {
            case "+" -> sumar();
            case "-" -> restar();
            case "x" -> multiplicar();
            case "X" -> multiplicar();
            case "*" -> multiplicar();
            case "/" -> dividir();
            default -> Integer.MAX_VALUE;
        };
    }

    public static boolean validOperation(String input){
        String[] inputArray = input.split("");
        if (inputArray.length != 3){
            return false;
        }
        String operador = inputArray[1];
        return operador.equals("+")  || operador.equals("-") || operador.equalsIgnoreCase("x") || operador.equals("*") || operador.equals("/");

    }


}

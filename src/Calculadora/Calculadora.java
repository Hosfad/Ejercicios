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
                System.out.println(calcular(inputArray[1], Integer.parseInt(inputArray[0]), Integer.parseInt(inputArray[2])));
            }else {
                System.out.println("Porfavor elije una operacion valida (3x3)");
            }

        }
    }



    public static int calcular(String operador , int a , int b){

        return switch (operador) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "x" -> a * b;
            case "X" -> a * b;
            case "*" -> a * b;
            case "/" -> a / b;
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

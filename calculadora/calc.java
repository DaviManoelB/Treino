//package calculadora;

import java.util.Scanner;

public class calc{

    public void soma(Scanner sc){
        float soma = 0, num = 1;   
        System.out.println("Digite os valores. 0 para sair.");
        while(sc.hasNext()){
            num = sc.nextFloat();
            sc.nextLine();
            if(num == 0) break;
            soma += num;
        }
        System.out.println("Soma: " + soma + "\n");
    }

    public void subtracao(Scanner sc){
        float sub = 0, num = 1;
        System.out.println("Digite os valores. 0 para sair");
        sub = sc.nextFloat();
        sc.nextLine();
        while(sc.hasNext()){
            num = sc.nextFloat();
            sc.nextLine();
            if(num == 0) break;
            sub -= num;
        }
        System.out.println("Subtracao: " + sub + "\n");
    }

    public void multiplicacao(Scanner sc){
        float mult = 1, num = 1;
        System.out.println("Digite os valores. 0 para sair");
        while(sc.hasNext()){
            mult = mult * num;
            num = sc.nextFloat();
            sc.nextLine();
            if(num == 0) break;
        }
        System.out.println("Multiplicacao: " + mult + "\n");
    }

    public void divisao(Scanner sc){
        float div = 1, num = 1;
        System.out.println("Digite os valores. 0 para sair");
        div = sc.nextLong();
        sc.nextLine();
        while(sc.hasNext()){
            div = div / num;
            num = sc.nextLong();
            sc.nextLine();
            if(num == 0) break;
        }
        System.out.println("Divisao: " + div + "\n");
    }

    public static void main(String[] args){
        String op = "";
        Scanner sc = new Scanner(System.in);
        calc calculadora = new calc();
            while(!op.equals("0")){
                System.out.println("Digite a operação: ");
                System.out.println("SOMA: + | SUBTRACAO: - | MULTIPLICACAO: * | DIVISAO: / | SAIR: 0");
                op = sc.nextLine();
                switch (op) {
                    case "+":
                        calculadora.soma(sc);
                        break;
                    case "-":
                        calculadora.subtracao(sc);
                        break;
                    case "*":
                        calculadora.multiplicacao(sc);
                        break;
                    case "/":
                        calculadora.divisao(sc);
                        break;
                    case "0":
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Operacao invalida. Tente novamente.\n");
                        break;
                }
            }
        sc.close();
    }
}
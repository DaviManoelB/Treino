package crud;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {

    public static void controleCSV(boolean start) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a operação: ");
        System.out.println("1: Cadastrar cliente | 2: Listar clientes | 3: Buscar cliente | 4: Editar cliente | 5: Deletar cliente | 0: Sair");
        while(start){
            int op;
            op = sc.nextInt();
            sc.nextLine();
            
            switch(op) {
                case 1:
                    ClienteController.criar(sc);
                    break;
                case 2:
                    ClienteController.listar();
                    break;
                case 3:
                    ClienteController.buscar(sc);
                    break;
                case 4:
                    ClienteController.editar(sc);
                    break;
                case 5:
                    ClienteController.excluir(sc);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    sc.close();
                    return;
                default:
                    System.out.println("Opcao Invalida");
                    break;
            }
            System.out.println("Digite a operação: ");
            System.out.println("1: Cadastrar cliente | 2: Listar clientes | 3: Buscar cliente | 4: Editar cliente | 5: Deletar cliente | 0: Sair");
        }
        sc.close();
    }

    public static void main(String[] args) {        
        try(BufferedReader leitor = new BufferedReader(new FileReader("crud/clientes.csv"))){
            
        } catch (Exception e) {
            System.out.println("CSV não encontrado, criando novo arquivo...");
            try (BufferedWriter escritor = new BufferedWriter(new FileWriter("crud/clientes.csv"))){ //Buffered precis estar dentro do try catch
                escritor.write("nome;email;idade");
                escritor.newLine();
                escritor.close();
            } catch (Exception f) {
                System.out.println("Erro ao criar arquivo");
            }
        }
        
        controleCSV(true);
        
    }
}

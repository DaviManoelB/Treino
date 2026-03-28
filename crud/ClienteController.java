package crud;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class ClienteController {
    public static void criar(){
        System.out.println("Chamando criar");

        
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome, email e idade");
        String nome = sc.nextLine(); //recebe nome
        String email = sc.nextLine(); //recebe email
        int idade = sc.nextInt(); //recebe idade
        sc.nextLine();
        System.out.println(nome + ";" + email + ";" + idade);
        Cliente cliente = new Cliente(nome, email, idade);
        try(BufferedWriter escritor = new BufferedWriter(new FileWriter("crud/clientes.csv", true))){ //escreve formatado para o csv
            escritor.write(cliente.getNome() + ";" + cliente.getEmail() + ";" + cliente.getIdade());
            escritor.newLine();
        } catch (Exception e) {
            System.out.println("Erro ao criar cliente");
        }
        sc.next();
        sc.close();
    }

    public static void listar(){
        System.out.println("Chamando listar");
        try(BufferedReader leitor = new BufferedReader(new FileReader("crud/clientes.csv"))){
            leitor.readLine(); //pula o cabeçalho
            String linha; 
            while((linha = leitor.readLine()) != null){ //passa por todos os registros e printa os dados
                System.out.println(linha);
            }
        }catch (Exception e){
            System.out.println("Erro ao listar clientes");
        }
        return;
    }

    public static void buscar(){
        System.out.println("Chamando buscar");
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome completo do cliente");
        String nome = sc.nextLine(); //recebe nome
        try(BufferedReader leitor = new BufferedReader(new FileReader("crud/clientes.csv"))){
            String linha;
            while((linha = leitor.readLine()) != null){
                if (linha.split(";")[0].equals(nome)){ //busca o cliente especifico
                    System.out.println("Nome: " + linha.split(";")[0]);
                    System.out.println("Email: " + linha.split(";")[1]);
                    System.out.println("Idade: " + linha.split(";")[2]);
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar clientes");
        }
        sc.nextLine();
        System.out.println("passou sc");
        sc.close();
    }

    public static void editar(){
        System.out.println("Chamando editar");
        Scanner sc = new Scanner(System.in);
        String nome;
        System.out.println("Digite o nome completo do cliente");
        nome = sc.nextLine();
        try(BufferedReader leitor = new BufferedReader(new FileReader("crud/clientes.csv"));
            BufferedWriter escritor = new BufferedWriter(new FileWriter("/tmp/temp.csv"))){
            String linha;
            while((linha = leitor.readLine()) != null){
                if (linha.split(";")[0].equals(nome)){
                    System.out.println("Digite o nome, email e idade");
                    String nomeN = sc.nextLine();
                    String emailN = sc.nextLine();
                    int idadeN = sc.nextInt();
                    sc.nextLine();
                    escritor.write(nomeN + ";" + emailN + ";" + idadeN);
                } else{
                    escritor.write(linha);
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao escrever tmp.csv");
        }
        try(BufferedReader leitor = new BufferedReader(new FileReader("/tmp/temp.csv"));
            BufferedWriter escritor = new BufferedWriter(new FileWriter("crud/clientes.csv"))){
            String linha;
            while((linha = leitor.readLine()) != null){
                escritor.write(linha);
                escritor.newLine();
            }
        } catch (Exception e) {
            System.out.println("Erro ao reescrever clientes.csv");
        }
        sc.nextLine();
        sc.close();
    }

    public static void excluir(){
        System.out.println("Chamando excluir");
        Scanner sc = new Scanner(System.in);
        String nome;
        System.out.println("Digite o nome completo do cliente");
        nome = sc.nextLine();
        try(BufferedReader leitor = new BufferedReader(new FileReader("crud/clientes.csv"));
            BufferedWriter escritor = new BufferedWriter(new FileWriter("/tmp/temp.csv"))){
            String linha;
            while((linha = leitor.readLine()) != null){
                if (linha.split(";")[0].equals(nome)){
                    leitor.readLine();
                } else{
                    escritor.write(linha);
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao escrever tmp.csv");
        }
        try(BufferedReader leitor = new BufferedReader(new FileReader("/tmp/temp.csv"));
            BufferedWriter escritor = new BufferedWriter(new FileWriter("crud/clientes.csv"))){
            String linha;
            while((linha = leitor.readLine()) != null){
                escritor.write(linha);
                escritor.newLine();
            }
        } catch (Exception e) {
            System.out.println("Erro ao reescrever clientes.csv");
        }
        sc.nextLine();
        sc.close();
    }

}

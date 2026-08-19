package application;

import entities.Pet;
import exceptions.IdadeException;
import entities.Sexo;
import entities.Tipo;
import exceptions.PesoException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int opcao = 0;
        try {
            System.out.println("Menu inicial: ");
            System.out.println("1. Cadastrar um novo pet");
            System.out.println("2. Alterar os dados de um pet cadastrado");
            System.out.println("3. Deletar um pet cadastrado");
            System.out.println("4. Listar todos os pets cadastrados");
            System.out.println("5. Listar os pets por algum critério");
            System.out.println("6. Sair");
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.print("Digite a opção escolhida: ");
            opcao = sc.nextInt();
            sc.nextLine();
            if (opcao <= 0 || opcao > 6) {
                System.out.print("Número invalido, digite novamente: ");
                opcao = sc.nextInt();
            }
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }

        double idade, peso;
        List<String> lista = new ArrayList<>();
        List<Pet> listaPets = new ArrayList<>();
        if (opcao == 1) {
            String resposta;
            try (BufferedReader br = new BufferedReader(new FileReader("src//formulario"))) {

                String linha;
                while ((linha = br.readLine()) != null) {
                    System.out.println(linha);
                    resposta = sc.nextLine();
                    lista.add(resposta);
                }

                Tipo tipo = Tipo.valueOf(lista.get(2).toUpperCase());
                Sexo sexo = Sexo.valueOf(lista.get(3).toUpperCase());
                Integer numCasa = Integer.parseInt(lista.get(4));
                idade = Double.parseDouble(lista.get(7));
                peso = Double.parseDouble(lista.get(8));

                if (idade > 20) {
                    throw new IdadeException();
                }
                if (peso > 60 || peso < 0.5) {
                    throw new PesoException();
                }

                Pet pet = new Pet(lista.get(0), lista.get(1), tipo, sexo, numCasa, lista.get(5), lista.get(6), idade, peso, lista.get(9));
                listaPets.add(pet);
                pet.salvarPet();
            } catch (IdadeException i) {
                System.err.println("Erro: " + i.getMessage());
            } catch (IOException e) {
                System.err.println("Erro: " + e.getMessage());
            } catch (PesoException p) {
                System.err.println("Erro: " + p.getMessage());
            }
        }

        if (opcao == 2) {
            System.out.print("Quantos dados você deseja utilizar na busca (1 ou 2)? ");
            int quantidade = sc.nextInt();
            System.out.println("Selecione os dados que deseja utilizar para a busca (Utilizando o número correspondente): ");
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println("1 - Nome ou Sobrenome");
            System.out.println("2 - Sexo");
            System.out.println("3 - Idade");
            System.out.println("4 - Peso");
            System.out.println("5 - Raça");
            System.out.println("6 - Cidade");
            System.out.println("-------------------------------------------------------------------------------------");
            if (quantidade == 1) {
                System.out.print("Digite o dado escolhido: ");
                int opcaoEscolhida1 = sc.nextInt();
            }
            if (quantidade == 2) {
                System.out.println("Digite os dados escolhidos: ");
                System.out.print("Opção 1: ");
                int opcaoEscolhida1 = sc.nextInt();
                System.out.print("Opção 2: ");
                int opcaoEscolhida2 = sc.nextInt();
            }
        }
    }
}

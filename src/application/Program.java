package application;

import entities.Pet;
import exceptions.IdadeException;
import entities.Sexo;
import entities.Tipo;
import exceptions.PesoException;

import java.io.BufferedReader;
import java.io.File;
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

        //Menu Inicial
        int opcao = 0;
        try {
            System.out.println("Menu inicial: ");
            System.out.println("1. Cadastrar um novo pet");
            System.out.println("2. Buscar dados do pet cadastrado");
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

        //Cadastro de novos Pets (Opção 1 do Menu)
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

        //Busca de Pets por Critério (Opção 2 do menu)
        int tipoAnimal = 0;
        int opcaoEscolhida1 = 0;
        int opcaoEscolhida2 = 0;
        int quantidade = 0;
        String valor1 = null, valor2 = null;
        if (opcao == 2) {

            System.out.println("Selecione o tipo de animal que deseja buscar: ");
            System.out.println("1 - Cachorro");
            System.out.println("2 - Gato");
            System.out.print("Resposta = ");
            tipoAnimal = sc.nextInt();

            System.out.print("Quantos dados você deseja utilizar na busca (1 ou 2)? ");
            quantidade = sc.nextInt();
            sc.nextLine();
            System.out.println("Selecione os dados que deseja utilizar para a busca (Utilizando o número correspondente): ");
            System.out.println("1 - Nome ou Sobrenome");
            System.out.println("2 - Sexo");
            System.out.println("3 - Idade");
            System.out.println("4 - Peso");
            System.out.println("5 - Raça");
            System.out.println("6 - Cidade");
            System.out.println("-------------------------------------------------------------------------------------");
            if (quantidade == 1) {
                System.out.print("Digite o dado escolhido: ");
                opcaoEscolhida1 = sc.nextInt();
                sc.nextLine();

                switch (opcaoEscolhida1) {
                    case 1:
                        System.out.print("Digite o nome ou sobrenome do pet: ");
                        valor1 = sc.nextLine();
                        break;
                    case 2:
                        System.out.print("Digite o sexo do pet: ");
                        valor1 = sc.nextLine();
                        break;
                    case 3:
                        System.out.print("Digite a idade do pet: ");
                        valor1 = sc.nextLine();
                        break;
                    case 4:
                        System.out.print("Digite o peso do pet: ");
                        valor1 = sc.nextLine();
                        break;
                    case 5:
                        System.out.print("Digite a raça do pet: ");
                        valor1 = sc.nextLine();
                        break;
                    case 6:
                        System.out.print("Digite a cidade do pet: ");
                        valor1 = sc.nextLine();
                        break;
                    default:
                        System.out.println("Valor inválido.");
                        break;
                }

            }

            if (quantidade == 2) {
                System.out.println("Digite os dados escolhidos: ");
                System.out.print("Opção 1: ");
                opcaoEscolhida1 = sc.nextInt();
                System.out.print("Opção 2: ");
                opcaoEscolhida2 = sc.nextInt();
                sc.nextLine();

                switch (opcaoEscolhida1) {
                    case 1:
                        System.out.print("Digite o nome ou sobrenome do pet: ");
                        valor1 = sc.nextLine();
                        break;
                    case 2:
                        System.out.print("Digite o sexo do pet: ");
                        valor1 = sc.nextLine();
                        break;
                    case 3:
                        System.out.print("Digite a idade do pet: ");
                        valor1 = sc.nextLine();
                        break;
                    case 4:
                        System.out.print("Digite o peso do pet: ");
                        valor1 = sc.nextLine();
                        break;
                    case 5:
                        System.out.print("Digite a raça do pet: ");
                        valor1 = sc.nextLine();
                        break;
                    case 6:
                        System.out.print("Digite a cidade do pet: ");
                        valor1 = sc.nextLine();
                        break;
                    default:
                        System.out.println("Valor inválido.");
                        break;
                }

                switch (opcaoEscolhida2) {
                    case 1:
                        System.out.print("Digite o nome ou sobrenome do pet: ");
                        valor2 = sc.nextLine();
                        break;
                    case 2:
                        System.out.print("Digite o sexo do pet: ");
                        valor2 = sc.nextLine();
                        break;
                    case 3:
                        System.out.print("Digite a idade do pet: ");
                        valor2 = sc.nextLine();
                        break;
                    case 4:
                        System.out.print("Digite o peso do pet: ");
                        valor2 = sc.nextLine();
                        break;
                    case 5:
                        System.out.print("Digite a raça do pet: ");
                        valor2 = sc.nextLine();
                        break;
                    case 6:
                        System.out.print("Digite a cidade do pet: ");
                        valor2 = sc.nextLine();
                        break;
                    default:
                        System.out.println("Valor inválido.");
                        break;
                }
            }
        }

        File pastaCadastro = new File("petsCadastrados");
        File[] arquivos = pastaCadastro.listFiles();

        for (File arquivo : arquivos) {

            try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
                String nome = br.readLine();
                String tipo = br.readLine();
                String sexo = br.readLine();
                String endereco = br.readLine();
                String idadePet = br.readLine();
                String pesoPet = br.readLine();
                String racaPet = br.readLine();

                if ((tipoAnimal == 1 && "CACHORRO".equalsIgnoreCase(tipo)) || (tipoAnimal == 2 && "GATO".equalsIgnoreCase(tipo))) {
                    boolean criterio1 = false;
                    boolean criterio2 = false;
                    if (quantidade == 1) {
                        switch (opcaoEscolhida1) {
                            case 1:
                                if (nome.toLowerCase().contains(valor1.toLowerCase())) {
                                    criterio1 = true;
                                }
                                break;
                            case 2:
                                if (sexo.toLowerCase().equals(valor1.toLowerCase())) {
                                    criterio1 = true;
                                }
                                break;
                            case 3:
                                if (Double.parseDouble(idadePet) == Double.parseDouble(valor1)) {
                                    criterio1 = true;
                                }
                                break;
                            case 4:
                                if (Double.parseDouble(pesoPet) == Double.parseDouble(valor1)) {
                                    criterio1 = true;
                                }
                                break;
                            case 5:
                                if (racaPet.toLowerCase().contains(valor1.toLowerCase())) {
                                    criterio1 = true;
                                }
                                break;
                            case 6:
                                if (endereco.toLowerCase().contains(valor1.toLowerCase())) {
                                    criterio1 = true;
                                }
                                break;
                            default:
                                System.out.println("Valor inválido.");
                                break;
                        }

                        if (criterio1) {
                            System.out.println("* " + nome + " - " + tipo + " - " + sexo + " - " + endereco + " - " + idadePet + " anos - " + pesoPet + "kg - " + racaPet);
                        }
                    }
                    if (quantidade == 2) {
                        switch (opcaoEscolhida1) {
                            case 1:
                                if (nome.toLowerCase().contains(valor1.toLowerCase())) {
                                    criterio1 = true;
                                }
                                break;
                            case 2:
                                if (sexo.toLowerCase().equals(valor1.toLowerCase())) {
                                    criterio1 = true;
                                }
                                break;
                            case 3:
                                if (Double.parseDouble(idadePet) == Double.parseDouble(valor1)) {
                                    criterio1 = true;
                                }
                                break;
                            case 4:
                                if (Double.parseDouble(pesoPet) == Double.parseDouble(valor1)) {
                                    criterio1 = true;
                                }
                                break;
                            case 5:
                                if (racaPet.toLowerCase().contains(valor1.toLowerCase())) {
                                    criterio1 = true;
                                }
                                break;
                            case 6:
                                if (endereco.toLowerCase().contains(valor1.toLowerCase())) {
                                    criterio1 = true;
                                }
                                break;
                            default:
                                System.out.println("Valor inválido.");
                                break;
                        }

                        switch (opcaoEscolhida2) {
                            case 1:
                                if (nome.toLowerCase().contains(valor2.toLowerCase())) {
                                    criterio2 = true;
                                }
                                break;
                            case 2:
                                if (sexo.toLowerCase().equals(valor2.toLowerCase())) {
                                    criterio2 = true;
                                }
                                break;
                            case 3:
                                if (Double.parseDouble(idadePet) == Double.parseDouble(valor2)) {
                                    criterio2 = true;
                                }
                                break;
                            case 4:
                                if (Double.parseDouble(pesoPet) == Double.parseDouble(valor2)) {
                                    criterio2 = true;
                                }
                                break;
                            case 5:
                                if (racaPet.toLowerCase().contains(valor2.toLowerCase())) {
                                    criterio2 = true;
                                }
                                break;
                            case 6:
                                if (endereco.toLowerCase().contains(valor2.toLowerCase())) {
                                    criterio2 = true;
                                }
                                break;
                            default:
                                System.out.println("Valor inválido.");
                                break;
                        }

                        if (criterio1 && criterio2) {
                            System.out.println("* " + nome + " - " + tipo + " - " + sexo + " - " + endereco + " - " + idadePet + " anos - " + pesoPet + "kg - " + racaPet);
                        }
                    }
                }
            } catch (IOException e) {
                System.err.println("Erro: " + e.getMessage());
            }
        }
        //Fim da opção 2 do menu principal
    }
}

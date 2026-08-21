package application;

import entities.Pet;
import exceptions.IdadeException;
import entities.Sexo;
import entities.Tipo;
import exceptions.PesoException;

import java.io.*;
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
            System.out.println("3. Alterar um pet cadastrado");
            System.out.println("4. Deletar um pet cadastrado");
            System.out.println("5. Sair");
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
            } catch (NullPointerException npe) {
                System.out.println("Erro: " + npe.getMessage());
            }
        }
        //Fim da opção 2 do menu principal

        //Inicio do passo 6 do desafio (Opção 3)
        if (opcao == 3) {
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


            File pastaCadastro3 = new File("petsCadastrados");
            File[] arquivos3 = pastaCadastro3.listFiles();

            List<File> listaEscolha = new ArrayList<>();
            for (File arquivo : arquivos3) {

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
                                listaEscolha.add(arquivo);
                                System.out.println((listaEscolha.indexOf(arquivo) + 1) + ") " + nome + " - " + tipo + " - " + sexo + " - " + endereco + " - " + idadePet + " anos - " + pesoPet + "kg - " + racaPet);
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
                                listaEscolha.add(arquivo);
                                System.out.println((listaEscolha.indexOf(arquivo) + 1) + ") " + nome + " - " + tipo + " - " + sexo + " - " + endereco + " - " + idadePet + " anos - " + pesoPet + "kg - " + racaPet);
                            }

                        }
                    }
                } catch (IOException e) {
                    System.err.println("Erro: " + e.getMessage());
                }
            }
            System.out.print("Digite o pet que deseja alterar (digitando o número correspondente): ");
            int escolhaAlteracao = sc.nextInt();
            while (escolhaAlteracao > listaEscolha.size() || escolhaAlteracao < 1) {
                System.out.print("Digite o pet que deseja alterar (digitando o número correspondente): ");
                escolhaAlteracao = sc.nextInt();
            }

            File arquivoEscolhido = listaEscolha.get(escolhaAlteracao - 1);

            String nome = null;
            String tipo = null;
            String sexo = null;
            String endereco = null;
            String idadePet = null;
            String pesoPet = null;
            String racaPet = null;
            int numeroAlteracao = 0;
            try (BufferedReader br = new BufferedReader(new FileReader(arquivoEscolhido))) {
                nome = br.readLine();
                tipo = br.readLine();
                sexo = br.readLine();
                endereco = br.readLine();
                idadePet = br.readLine();
                pesoPet = br.readLine();
                racaPet = br.readLine();

                System.out.println("O que deseja alterar? (Digite o número correspondente) ");
                System.out.println("1 - Nome/Sobrenome");
                System.out.println("2 - Endereço");
                System.out.println("3 - Idade");
                System.out.println("4 - Peso");
                System.out.println("5 - Raça");

                System.out.println("Número escolhido: ");
                numeroAlteracao = sc.nextInt();
                sc.nextLine();

                switch (numeroAlteracao) {
                    case 1:
                        System.out.print("Novo nome: ");
                        nome = sc.nextLine();
                        break;
                    case 2:
                        System.out.print("Novo endereço: ");
                        endereco = sc.nextLine();
                        break;
                    case 3:
                        System.out.print("Nova idade: ");
                        double novaIdade = sc.nextDouble();
                        idadePet = String.valueOf(novaIdade);
                        break;
                    case 4:
                        System.out.print("Novo peso: ");
                        double novoPeso = sc.nextDouble();
                        pesoPet = String.valueOf(novoPeso);
                        break;
                    case 5:
                        System.out.println("Nova raça: ");
                        racaPet = sc.nextLine();
                        break;
                    default:
                        System.out.println("Valor inválido");
                }
            } catch (IOException e) {
                System.err.println("Erro: " + e.getMessage());
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoEscolhido))) {
                bw.write(nome);
                bw.newLine();
                bw.write(tipo);
                bw.newLine();
                bw.write(sexo);
                bw.newLine();
                bw.write(endereco);
                bw.newLine();
                bw.write(idadePet);
                bw.newLine();
                bw.write(pesoPet);
                bw.newLine();
                bw.write(racaPet);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //Fim da opção 3 do menu (Parte 6 do desafio)

        //Começo da opção 4 do menu (Parte 7 do desafio)
        if (opcao == 4) {
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


            File pastaCadastro4 = new File("petsCadastrados");
            File[] arquivos4 = pastaCadastro4.listFiles();

            List<File> listaEscolha4 = new ArrayList<>();
            for (File arquivo : arquivos4) {

                try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
                    String nome4 = br.readLine();
                    String tipo4 = br.readLine();
                    String sexo4 = br.readLine();
                    String endereco4 = br.readLine();
                    String idadePet4 = br.readLine();
                    String pesoPet4 = br.readLine();
                    String racaPet4 = br.readLine();

                    if ((tipoAnimal == 1 && "CACHORRO".equalsIgnoreCase(tipo4)) || (tipoAnimal == 2 && "GATO".equalsIgnoreCase(tipo4))) {
                        boolean criterio1 = false;
                        boolean criterio2 = false;
                        if (quantidade == 1) {
                            switch (opcaoEscolhida1) {
                                case 1:
                                    if (nome4.toLowerCase().contains(valor1.toLowerCase())) {
                                        criterio1 = true;
                                    }
                                    break;
                                case 2:
                                    if (sexo4.toLowerCase().equals(valor1.toLowerCase())) {
                                        criterio1 = true;
                                    }
                                    break;
                                case 3:
                                    if (Double.parseDouble(idadePet4) == Double.parseDouble(valor1)) {
                                        criterio1 = true;
                                    }
                                    break;
                                case 4:
                                    if (Double.parseDouble(pesoPet4) == Double.parseDouble(valor1)) {
                                        criterio1 = true;
                                    }
                                    break;
                                case 5:
                                    if (racaPet4.toLowerCase().contains(valor1.toLowerCase())) {
                                        criterio1 = true;
                                    }
                                    break;
                                case 6:
                                    if (endereco4.toLowerCase().contains(valor1.toLowerCase())) {
                                        criterio1 = true;
                                    }
                                    break;
                                default:
                                    System.out.println("Valor inválido.");
                                    break;
                            }

                            if (criterio1) {
                                listaEscolha4.add(arquivo);
                                System.out.println((listaEscolha4.indexOf(arquivo) + 1) + ") " + nome4 + " - " + tipo4 + " - " + sexo4 + " - " + endereco4 + " - " + idadePet4 + " anos - " + pesoPet4 + "kg - " + racaPet4);
                            }


                        }
                        if (quantidade == 2) {
                            switch (opcaoEscolhida1) {
                                case 1:
                                    if (nome4.toLowerCase().contains(valor1.toLowerCase())) {
                                        criterio1 = true;
                                    }
                                    break;
                                case 2:
                                    if (sexo4.toLowerCase().equals(valor1.toLowerCase())) {
                                        criterio1 = true;
                                    }
                                    break;
                                case 3:
                                    if (Double.parseDouble(idadePet4) == Double.parseDouble(valor1)) {
                                        criterio1 = true;
                                    }
                                    break;
                                case 4:
                                    if (Double.parseDouble(pesoPet4) == Double.parseDouble(valor1)) {
                                        criterio1 = true;
                                    }
                                    break;
                                case 5:
                                    if (racaPet4.toLowerCase().contains(valor1.toLowerCase())) {
                                        criterio1 = true;
                                    }
                                    break;
                                case 6:
                                    if (endereco4.toLowerCase().contains(valor1.toLowerCase())) {
                                        criterio1 = true;
                                    }
                                    break;
                                default:
                                    System.out.println("Valor inválido.");
                                    break;
                            }

                            switch (opcaoEscolhida2) {
                                case 1:
                                    if (nome4.toLowerCase().contains(valor2.toLowerCase())) {
                                        criterio2 = true;
                                    }
                                    break;
                                case 2:
                                    if (sexo4.toLowerCase().equals(valor2.toLowerCase())) {
                                        criterio2 = true;
                                    }
                                    break;
                                case 3:
                                    if (Double.parseDouble(idadePet4) == Double.parseDouble(valor2)) {
                                        criterio2 = true;
                                    }
                                    break;
                                case 4:
                                    if (Double.parseDouble(pesoPet4) == Double.parseDouble(valor2)) {
                                        criterio2 = true;
                                    }
                                    break;
                                case 5:
                                    if (racaPet4.toLowerCase().contains(valor2.toLowerCase())) {
                                        criterio2 = true;
                                    }
                                    break;
                                case 6:
                                    if (endereco4.toLowerCase().contains(valor2.toLowerCase())) {
                                        criterio2 = true;
                                    }
                                    break;
                                default:
                                    System.out.println("Valor inválido.");
                                    break;
                            }

                            if (criterio1 && criterio2) {
                                listaEscolha4.add(arquivo);
                                System.out.println((listaEscolha4.indexOf(arquivo) + 1) + ") " + nome4 + " - " + tipo4 + " - " + sexo4 + " - " + endereco4 + " - " + idadePet4 + " anos - " + pesoPet4 + "kg - " + racaPet4);
                            }

                        }
                    }
                } catch (IOException e) {
                    System.err.println("Erro: " + e.getMessage());
                }
            }
            System.out.print("Digite o pet que deseja deletar (digitando o número correspondente): ");
            int escolhaDelete = sc.nextInt();
            while (escolhaDelete > listaEscolha4.size() || escolhaDelete < 1) {
                System.out.print("Digite o pet que deseja deletar (digitando o número correspondente): ");
                escolhaDelete = sc.nextInt();
            }

            File arquivoEscolhidoDelete = listaEscolha4.get(escolhaDelete - 1);

            System.out.print("Deseja mesmo excluir o arquivo (SIM/NÃO)? ");
            String respostaDelete = sc.next();

            boolean resultadoDelete = false;
            if (respostaDelete.equalsIgnoreCase("SIM")) {
                resultadoDelete = arquivoEscolhidoDelete.delete();
            } else if (respostaDelete.equalsIgnoreCase("NÃO")) {
                System.out.println("Exclusão cancelada.");
            }

            if (resultadoDelete) {
                System.out.println("Pet deletado com sucesso!");
            } else {
                System.out.println("Não foi possivel deletar o pet.");
            }
        }
        //Fim da opção 4 do menu (Passo 7 do desafio)
    }
}



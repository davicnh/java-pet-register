🐾 Sistema de Cadastro de Pets

Aplicação desenvolvida em Java para gerenciamento de pets através do terminal.

O projeto permite cadastrar, buscar, alterar e excluir pets, utilizando arquivos `.TXT` para persistência dos dados. Foi desenvolvido com o objetivo de praticar conceitos fundamentais da linguagem Java, como orientação a objetos, manipulação de arquivos, coleções, tratamento de exceções e estruturas de controle.

---

📌 Funcionalidades

📝 Cadastro de pets
Permite cadastrar um novo pet informando seus dados através de um formulário.

Os dados são armazenados em arquivos `.TXT` dentro da pasta `petsCadastrados`.

🔎 Busca de pets
É possível buscar pets utilizando um ou dois critérios simultaneamente.

Os critérios disponíveis são:

- Nome ou sobrenome
- Sexo
- Idade
- Peso
- Raça
- Endereço

Também é possível escolher previamente o tipo de animal:

- Cachorro
- Gato

✏️ Alteração de dados
Após realizar uma busca, o usuário pode selecionar um dos pets encontrados e alterar seus dados.

Podem ser alterados:

- Nome/Sobrenome
- Endereço
- Idade
- Peso
- Raça

O tipo do animal e o sexo não podem ser alterados.

🗑️ Exclusão de pets
O usuário pode buscar um pet, selecioná-lo na lista de resultados e solicitar sua exclusão.

Antes da remoção do arquivo, o sistema solicita uma confirmação com SIM ou NÃO, evitando exclusões acidentais.

---

💾 Persistência dos dados

O projeto não utiliza banco de dados.

Cada pet cadastrado é armazenado individualmente em um arquivo `.TXT` dentro da pasta:

```text
petsCadastrados/
```

Os arquivos armazenam as informações do pet linha por linha.

Exemplo:

```text
Rex Silva
CACHORRO
MASCULINO
Rua das Flores, 123 - Blumenau
5.0
12.5
Labrador
```

A aplicação utiliza `BufferedReader`, `BufferedWriter`, `FileReader` e `FileWriter` para leitura e escrita dos dados.

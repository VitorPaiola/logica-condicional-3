# 🚀 Estruturas Condicionais e Manipulação de Dados 3 em Java

![java-9](https://github.com/user-attachments/assets/aa192001-d769-40c1-9689-a3dd0182dfe2)

Este repositório contém diversos programas em Java que exploram o uso de estruturas condicionais e manipulação de dados, abordando operações essenciais para o desenvolvimento eficiente de algoritmos. Entre os principais conceitos abordados, destacam-se:

- Estruturas condicionais, como `if-else`, para controle de fluxo baseado em condições específicas.
- Estruturas de repetição, incluindo `while` e `for`, permitindo a execução iterativa de blocos de código conforme determinado por condições lógicas ou intervalos predefinidos.
- Iteração sobre coleções, facilitando a navegação e manipulação de conjuntos de dados armazenados em arrays, listas (`List`) e mapas (`Map`) & (`Map<Integer, List<Integer>>`).

Além disso, os programas implementam técnicas de modularização, organizando o código em métodos reutilizáveis, promovendo clareza, manutenção e reutilização eficiente do código-fonte.

Os programas utilizam diferentes estruturas de dados para armazenar e processar informações de maneira eficiente:

- **Arrays (`array[]`)**  
  - Utilizados quando é necessário armazenar um conjunto fixo de elementos.  
  - Garantem acesso rápido por índice e são eficientes em termos de memória.  

- **Listas (`List`)**  
  - Oferecem mais flexibilidade do que arrays, permitindo **tamanho dinâmico**.  
  - Permitem **inserção e remoção eficientes**, sendo ideais para cenários em que a quantidade de elementos pode variar.  

- **Mapas (`Map`)**  
  - Estrutura que armazena pares **chave-valor**.  
  - Proporciona uma forma otimizada de **buscar e organizar dados** sem a necessidade de estruturas condicionais extensas, como múltiplos `if-else` ou `switch-case`.

- **Map<Integer, List<Integer>>**  
  - Esta estrutura é uma combinação poderosa que mapeia uma chave inteira para uma lista de inteiros.  
  - Pode ser usada quando precisamos agrupar dados relacionados a uma chave específica, como associar um código a várias notas ou registros, onde cada código pode ter múltiplos valores associados.  
  - O uso de `Map<Integer, List<Integer>>` é essencial quando a estrutura de dados precisa armazenar múltiplos valores para uma chave, facilitando a organização de grandes volumes de dados e otimizando as operações de busca e armazenamento.

## 🔹 Recursos Adicionais

- Implementação de modularização, organizando o código em métodos reutilizáveis.
- Utilização `Scanner` para entrada de dados do usuário.

## 🔹 Benefícios do Uso de Map, List e Arrays

- O uso do `Map` se destaca como uma alternativa eficiente para substituir loops e a estrutura `switch-case`, tornando o código mais limpo, legível e de fácil manutenção.
- A combinação de `List` e `array[]` permite manipular conjuntos de dados de maneira versátil e eficiente, dependendo da necessidade da aplicação.
- O uso de `Map<Integer, List<Integer>>` permite associar de forma eficiente um conjunto de dados à chave específica, sendo uma solução ideal para organizar dados que têm uma relação de múltiplos valores para uma chave.

## 🚀 Tecnologias Utilizadas

- **Java (JDK 8+)** – Linguagem principal utilizada para desenvolvimento dos programas.  
- **Scanner** – Responsável por capturar entradas do usuário no console.  
- **Estruturas de controle** – Implementação de condicionais (`if`, `else if`, `else`) para tomada de decisões no código.  
- **Estruturas de repetição** – Uso de loops (`for`, `while`) para percorrer coleções e executar operações iterativas.  
- **Estruturas de dados** – Manipulação de **arrays**, **listas (`List`)** e **mapas (`Map`)**, garantindo flexibilidade no armazenamento e recuperação de informações.  
- **Map e entrySet** – Utilização do `Map` para armazenar pares **chave-valor** e do `entrySet()` para percorrer elementos de maneira eficiente.  
- **Captura de exceções** – Tratamento de erros utilizando `try-catch` para garantir maior robustez e evitar falhas inesperadas.  
- **Modularização do código** – Organização do código por meio de **métodos reutilizáveis**, tornando a solução mais clara e fácil de manter.

## 📌 Confira meu artigo no DEV.to

Para explorar mais sobre **estruturas condicionais, loops e manipulação de dados em Java**, confira meu artigo no  
[DEV.to](https://dev.to/vitorpaiola/lista-de-exercicios-basicos-em-java-part-6-p8n) 🚀

Neste artigo, compartilho **exemplos práticos e soluções eficientes** para manipulação de **arrays**, **listas** (`List`) e **mapas** (`Map`), além do uso de **estruturas de repetição** (`for`, `while`) e **controle de fluxo** (`if-else`).

O objetivo é demonstrar **boas práticas na escrita de código**, abordando desde a entrada de dados com `Scanner` até técnicas avançadas de organização e modularização para tornar o código mais **eficiente** e **fácil de manter**.

## 📂 Estrutura do Projeto

```estrutura
📦 logica-condicional-3
├── 📁 divisores
│   └── Divisores.java
├── 📁 divisoresV2
│   └── DivisoresV2.java
├── 📁 divisoresV3
│   └── DivisoresV3.java
├── 📁 mdcProgram
│   └── MDCProgram.java
├── 📁 mdcProgramV2
│   └── MDCProgramV2.java
├── 📁 mdcProgramV3
│   └── MDCProgramV3.java
├── 📁 mdcProgramV4
│   └── MDCProgramV4.java
├── 📁 mmcProgram
│   └── MMCProgram.java
├── 📁 mmcProgramV2
│   └── MMCProgramV2.java
├── 📁 mmcProgramV3
│   └── MMCProgramV3.java
├── 📁 mmcProgramV4
│   └── MMCProgramV4.java
├── 📁 validacaoCPF
│   └── ValidacaoCPF.java
├── 📁 validarCPF
│   └── ValidarCPF.java
├── 📁 verificarPalindromo
│   └── VerificarPalindromo.java
├── 📁 verificarPalindromoV2
│   └── VerificarPalindromoV2.java
├── 📁 verificarPalindromoV3
│   └── VerificarPalindromoV3.java
└── 📁 verificarPalindromoV4
    └── VerificarPalindromoV4.java
```

## 🛠️ Como Compilar e Executar

Para compilar e executar qualquer um dos programas, siga os passos abaixo:

### 1️⃣ **Compilar**

Abra o terminal e navegue até a pasta `src` do projeto. Em seguida, execute o seguinte comando para compilar o código:

```sh
javac -d . logica-condicional-3/NomeDaPasta/NomeDoArquivo.java
```

### 2️⃣ **Executar**

Após a compilação, você pode executar o programa com o comando abaixo:

```sh
java logica-condicional-3.NomeDaPasta.NomeDoArquivo
```

Exemplo:

```sh
java logica-condicional-3.divisores.Divisores
```

## 📌 Descrição dos Programas

### 🔢 **divisores**
**Objetivo:** Escreva um programa que solicite ao usuário uma sequência de números e exiba seus divisores. Usando `array`.

### 🧮 **divisores Versão 2**
**Objetivo:** Escreva um programa que solicite ao usuário uma sequência de números e exiba seus divisores. Usando `List<Integer>`.

### 🔄 **divisores Versão 3**
**Objetivo:** Escreva um programa que solicite ao usuário uma sequência de números e exiba seus divisores. Usando `Map<Integer, List<Integer>>`.

---

### ⚙️ **MDC**
**Objetivo:** Escreva um programa que determine o **máximo divisor comum (MDC)** entre dois números informados pelo usuário. Usando `array`.

### 🔬 **MDC Versão 2**
**Objetivo:** Escreva um programa que determine o **máximo divisor comum (MDC)** entre dois números informados pelo usuário. Usando `List<Integer>`.

### 💻 **MDC Versão 3**
**Objetivo:** Faça um programa que determine o **máximo divisor comum (MDC)** entre dois números informados pelo usuário. Usando `Map<Integer, Integer>` e `EntrySet`.

### 💡 **MDC Versão 4**
**Objetivo:** Faça um programa que determine o **máximo divisor comum (MDC)** entre dois números informados pelo usuário. Usando `Map<Integer, List<Integer>>` e `EntrySet`.

---

### 🔧 **MMC**
**Objetivo:** Faça um programa que determine o **menor múltiplo comum (MMC)** entre dois números informados pelo usuário. Usando `array`.

### 🛠️ **MMC Versão 2**
**Objetivo:** Faça um programa que determine o **menor múltiplo comum (MMC)** entre dois números informados pelo usuário. Usando `List<Integer>`.

### ⚙️ **MMC Versão 3**
**Objetivo:** Faça um programa que determine o **menor múltiplo comum (MMC)** entre dois números informados pelo usuário. Usando `Map<Integer, Integer>` e `EntrySet`.

### 🔒 **MMC Versão 4**
**Objetivo:** Faça um programa que determine o **menor múltiplo comum (MMC)** entre uma quantidade de verificações e números informados pelo usuário. Usando `Map<Integer, List<Integer>>` e `EntrySet`.

---

### 🛡️ **Validação de CPF Versão 1**
**Objetivo:** Faça um programa que solicite o **CPF** do usuário e então faça a validação do mesmo.

### 📑 **Validação de CPF Versão 2**
**Objetivo:** Faça um programa que solicite o **CPF** do usuário e então faça a validação do mesmo.

---

### 🔍 **Verificar Palíndromo**
**Objetivo:** Escreva um programa que leia uma sequência de caracteres e indique se a mesma é um **palíndromo** ou não. Usando `array`.

### 🔠 **Verificar Palíndromo Versão 2**
**Objetivo:** Escreva um programa que leia uma sequência de caracteres e indique se a mesma é um **palíndromo** ou não. Usando `List<String>`.

### 💻 **Verificar Palíndromo Versão 3**
**Objetivo:** Escreva um programa que leia uma sequência de caracteres e indique se a mesma é um **palíndromo** ou não. Usando `Map<Integer, String>` e `Streams`.

### 📚 **Verificar Palíndromo Versão 4**
**Objetivo:** Escreva um programa que leia uma sequência de caracteres e indique se a mesma é um **palíndromo** ou não. Usando `Map<Integer, List<String>>` e `Streams`.

## 📌 Quer acompanhar mais dicas e novidades sobre Java?

🔔 Fique por dentro de tudo sobre Java! Me siga no [Twitter](https://x.com/v__souz) para receber dicas, 
novidades e atualizações! 🚀✨

---

### 📜 **Licença**
Este projeto foi desenvolvido por mim e está livre para uso e modificação sem restrições formais.
Fique à vontade para usar e adaptar o código conforme necessário.

### 🤝 **Contribuições**
Contribuições são sempre bem-vindas! Se você tem sugestões ou gostaria de adicionar novos 
programas ou funcionalidades, sinta-se à vontade para abrir um Pull Request. 
Estou ansioso para ver suas melhorias! 😃

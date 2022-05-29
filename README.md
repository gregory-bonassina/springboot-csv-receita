<!-- Sobre o Projeto -->
## Sobre o Projeto
Projeto de simulação de atualização de conta bancária através de um arquivo CSV de entrada.
Após realização da atualização das contas, o programa irá gerar um arquivo CSV de saída com o resultado das atualizações das contas.

Tecnologias usadas:

* Java v18
* OpenJDK V18.0.1.1
* Spring Boot Framework V2.7.0

<!-- Começando -->
## Começando

Para começar, será necessário o download do JDK que você encontra no link a seguir:

[OpenJDK 18](https://openjdk.java.net/projects/jdk/18/)

Colocando o JDK em um local de sua preferência precisamos configurar a variável de ambiente do java para que possamos executar o JAR de simulação.
No link a seguir você encontra de maneira explicada como fazer este procedimento:

[Configurando Variável de Ambiente](https://medium.com/beelabacademy/configurando-vari%C3%A1veis-de-ambiente-java-home-e-maven-home-no-windows-e-unix-d9461f783c26)


<!-- Instalação -->
## Instalação
Com o JDK baixado e a variável de ambiente configurada vamos para o próximo passo que é o download do projeto.
Em um local de sua preferência execute o seguinte comando:
```sh
git clone https://github.com/gregory-bonassina/springboot-csv-receita
```

<!-- Uso -->
## Uso
Com o repositório baixado, entre na pasta e você verá dois arquivos principais:

1 - input.csv ( Arquivo de teste, necessário para a simulação de contas )

2 - sincronizacaoreceita.jar ( Arquivo em que contém nosso programa de simulação )

Abra o terminal de comando no local onde estes arquivos estão localizados e execute o seguinte comando:
```
java -jar sincronizacaoreceita.jar "CAMINHO_DO_ARQUIVO_INPUT_CSV"
```

**OBS**: É obrigatório passar o arquivo input.csv como argumento para funcionamento do programa.

Após a execução, no mesmo local do repositório o programa irá gerar o arquivo CSV de saída com o resultado da atualização das contas.
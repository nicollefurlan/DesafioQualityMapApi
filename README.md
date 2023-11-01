# Automação de Api RestAssured

Projeto foi feito utilizando a Ide eclipse onde foi realizada automação de api da base_url https://serverest.dev/ com RestAssured

### 📋 Pré-requisitos

Instalar eclipse
Intalar MVN para execução do relatório maven-surefire-report (Este item foi implementado porém está com problema no consumo de dados dos casos)

### 🔧 Instalação

Para executar o projeto necessário utilizar a ide eclipse. Posteriormente ao baixar o projeto ir no arquivo porm.xml e aguardar a instalação das dependencias.

## ⚙️ Executando os testes

Para executar os casos de teste necessário executar o run now do junit SuiteTest

### 🔩 Analise da implementação

br.com.nfsb.rest.core = Pacote core responsavél pelas definições de variavés de ambiente e tempo de espera de resposta de requisição. Definição de variaveis Globais de apontamento.
br.com.nfsb.rest.tests = Implementação de casos de teste para login e usuário
br.com.nfsb.suite.test = Suite de casos de teste, definição de ordem de execução
br.com.nfsb.utils =Responsavel por facilitar na geração de dados e melhorias no código.

Para usuário foi utuilizada massas dinâmicas afim de reaproveitar a massa e garantir que toda a massa funcione.
Para criação de e-mail e nome foi criado um metodo que adiciona numeros randomicos afim de nao se repitir
Para ordenação dos casos deteste foi utilizado o FixMethodOrder afim de assegurar a execução em uma sequencia lógica

### ⌨️ Casos de teste

Explique que eles verificam esses testes e porquê.

Caso 01 - Consultar email do primeiro usuário gerado na lista
Dado que execute o endpoint usuarios.get
Quando recebo a resposta da requisição no status '200'
Então verifico que o valor do email do usuário na posição não é vazia

Caso 02 - Consultar senha do primeiro usuário gerado na lista
Dado que execute o endpoint usuarios.get
Quando recebo a resposta da requisição no status '200'
Então verifico que o valor do senha do usuário na posição não é vazia

Caso 03 - Efetuar login com sucesso
Dado que eu possua um cliente válido
Quando executo a requisição login.post
Então verifico se o status code da minha requisição é igual a 200

Caso 04 - Não Efetuar login com sucesso
Dado que eu possua um cliente válido
Quando executo a requisição login.post
Então verifico se o status code da minha requisição é igual a 400

Caso 05 - Cadastrar cliente com sucesso
Dado que eu possua a massa de dados <exemplo1>
Quando executo a requisição usuario.post
Então verifico se o status code da minha requisição é igual a 200

Exemplo1
|nome |"maria"         |
|email|"jsas@gmail.com"|
|senha|teste           |
|administrador|"true"  |  

Caso 06 - Consultar usuário por id
Dado que eu possua um id de cliente válido
Quando executo a requisição usuario.get passando o id de usuário
Então verifico se o status code da minha requisição é igual a 200

Caso 07 - Alterar cliente
Dado que eu altere os dados da minha massa <alterarmassa>
Quando executo a requisição usuario.put 
Então verifico se o status code da minha requisição é igual a 200

alterarmassa
|nome |"maria"         |
|email|"jsas@gmail.com"|
|senha|teste           |
|administrador|"true"  |  

Caso 08 - Excluir usuário por id
Dado que eu possua um id de cliente válido
Quando executo a requisição usuario.delete passando o id de usuário
Então verifico se o status code da minha requisição é igual a 200
E se será retornada a mensagem "Registro excluído com sucesso"



## 🛠️ Construído com

- Maven
- Junit
- Rest Assured
- Gson
- maven-surefire-report ( esta ferramenta foi implementada a dependenci porém está com problema para pegar os dados dos casos de teste). Caro queira executar é necessario ter o maven instalado e executar site mvn




---
⌨️ com ❤️ por [Nicolle Furlan](https://www.linkedin.com/in/nicollefurlan/) 😊

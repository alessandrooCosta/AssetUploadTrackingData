# Documentação

### Resumo do sistema

A API foi desenvolvida para realizar a conexão de entre o EAM e qualquer outra categoria 
de aplicação que consegue utilizar o protocolo HTTP para fazer requisições.

## Pré requisitos

### Java 17 ou posterior

<details><summary><b>Instruções</b></summary>

O Java 17 pode tanto ser instalado através da JDK contida no site
da [Oracle](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
ou no site do [OpenJDK](https://openjdk.java.net/projects/jdk/11/)

Como alternativa é possível utilizar o [SDKMan](https://sdkman.io/)
e instalar o Java através do comando:

```console
foo@bar:~$ sdk install java <version>
```

Para listagem de todas as versões do Java disponíveis, execute o comando:

```console
foo@bar:~$ sdk list java
```

</details>

### Maven

<details><summary><b>Instruções</b></summary>

O projeto foi concebido para que a instalação do Maven fosse opcional,
para tanto, é possível rodar as configurações do projeto após instalação
do Java pelos arquivos **mvnw.cmd** em sistemas Windows e **mvnw**
em sistemas Unix, que interagem com o arquivo **maven-wrapper.jar**
contido na pasta **.mvn/wrapper** na raiz do projeto.

Caso mesmo assim se deseje rodar o projeto pelo Maven na máquina,
o mesmo pode ser instalado através do [site](https://maven.apache.org/).

Como alternativa é possível utilizar o [SDKMan](https://sdkman.io/)
e instalar o Maven através do comando:

```console
foo@bar:~$ sdk install maven
```

Para listagem de todas as versões do Maven disponíveis, execute o comando:

```console
foo@bar:~$ sdk list mavel
```

</details>

## Estrutura

### Pastas principais:
* config
* integration
* internal
* mobile

### Config

Possui as seguintes classes de configuração da Aplicação:

* InterceptorRegistry → Um registrador de interceptadores, sem ele a classe abaixo não funciona.
* IPAddressInterceptor → Um interceptor de IP criado para fazer uma verificação dos IPs que realizam requisições.
* RestartController → Um controller com mapeamento para reiniciar a aplicação através de um endpoint.
* WebSecurityConfig → Uma classe de configuração para aceitar requisições de origens diferentes.


### Integration

Possui 3 subpastas: IG, registration e technip.

A pasta registration possui todas as classes relacionadas ao registro de usuário na API para realização das integrações, para ver um exemplo acesse: [http://localhost:8080/](http://localhost:8080/)

As pastas IG e technip devem possuir tudo que for gerado e não reaproveitado pela API que diz respeito somente a cada cliente, assim, na hora de gerar um executável basta apagar as pastas que não são do cliente escolhido e gerar o executável.

### Internal

Está subdivida em 4 pastas: controllers, core, users e utilities.

* controllers → Tem alguns mapeamentos de testes, nada muito interessante.
* core → Tem todos os objetos criados para servirem como base da API como objetos de transferência de dados.
* users → Contem todos os objetos relacionados aos usuários, repositório e serviço para realizar verificações e salvar dados.
* utilities → Contem todas as utilidades para enviar requisições para o InforEAM, a parte mais importante são os
  requestBuilders.

### Mobile

Tem todas as classes relacionadas com o desenvolvimento mobile, todas as funções para pegar ou atualizar dados no InforEAM é feito por aqui.

## Execução

### Clone o repositório

```console
$ git clone https://github.com/assettec/AssetApi.git
$ cd AssetApi
```

### Execução Linux | Windows

O projeto pode ser executado em ambiente Linux ou Windows, sendo os comandos
diferenciando por duas opções Linux e Windows respectivamente

```console
mvn clean spring-boot:run
```

A aplicação iniciará e irá gerar 2 arquivos na pasta config na base do projeto:

* config.xml → É o arquivo de configuração de conexão com o inforEAM.
* userList → Arquivo onde ficam armazenados os dados de usuários.

#### Após os arquivos serem gerados a API irá desligar e o arquivo config.xml estará vazio como a seguir:

```console
<core>
    <server></server>
    <ports>
        <http></http>
        <https></https>
    </ports>
</core>
```

Basta colocar o endereço do servidor onde está escrito `server`, se utilizar alguma porta HTTP basta excluir a linha `<https></https>` e vice-versa.
Se o endereço não utilizar nenhuma porta basta colocar o endereço do servidor e excluir: 
```console
<ports>
    <http></http>
    <https></https>
</ports>
```

Exemplos:

```console
<core>
    <server>https://eam.inforcloudsuite.com</server>
</core>
```
```console
<core>
    <server>192.168.1.155</server>
    <ports>
        <http>7979</http>
    </ports>
</core>
```
```console
<core>
    <server>45.4.186.4</server>
    <ports>
        <http>7979</http>
    </ports>
</core>
```

Assim que o arquivo config.xml estiver preenchido a aplicação estará rodando na porta **8080** em
[http://localhost:8080/](http://localhost:8080/)
  

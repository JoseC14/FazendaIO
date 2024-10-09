# Fazenda IO
## Sistema de Gestão de Fazenda

Fazenda IO é um projeto que visa facilitar a vida do agropecuarista em que ele tem o controle dos seus lucros e do gerenciamento da fazenda do mesmo

### Como rodar o projeto

Primeiro você irá ter que ter o mysql instalado com o banco `fazendaio` criado
Após isso terá que configurar a senha e o usuário do seu mysql em `src/main/resources/aplication.properties` nos campos *spring.datasource.username=`<seu_usuario>`* e 
*spring.datasource.password=`<sua_senha>`*

Caso sua porta do mysql seja diferente também terá que configurar em *spring.datasource.url=jdbc:mysql://127.0.0.1:`<sua_porta>`/fazendaio*

Agora com tudo do banco configurado rode os seguintes comandos com o maven instalado

`mvn clean install`
isso ira instalar as depedencias do projeto

e finalmente para rodar o spring boot digite o seguinte comando no terminal
`mvn spring-boot:run`

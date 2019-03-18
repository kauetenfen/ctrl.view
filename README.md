# ctrl.view
Projeto de interfaces para a empresa Coontrol

Instruções

<h3>ctrl.api</h3> 
Projeto spring-boot que contém a camada de serviços rest.
Foi utilizado o Spring security com Basic Authentication para controle de segurança
<b>usuario: coontrol - senha: coontrol</b>
porta configurada: 8081

<h3>ctrl.view</h3>
Projeto spring-boot para disponibilizar a camada de interfaces.
Foi utilizado o Spring security com formulário de usuario e senha para controle de segurança
<b>usuario: coontrol - senha: 1234</b>
porta configurada: 8080

<h3>Banco de dados Postgres</h3>
Versão 11
<b>usuario: postgres - senha: potgres</b>
É criado automaticamente um usuário padrão no banco ao iniciar o sistema

Ambos os projetos já contém o servidor tomcat embutido, basta somente subir os dois projetos com o comando
<b>mvn spring-boot:run</b> e acessar a aplicação pelo link <b>http://localhost:8080/index.xhtml</b>

Dúvidas:
kaue.tenfen@gmail.com
whats 48988442828

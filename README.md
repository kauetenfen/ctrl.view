# ctrl.view
Projeto de interfaces para a empresa Coontrol

Instruções

ctrl.api: projeto spring-boot que contém a camada de serviços rest Foi utilizado o Spring security com Basic Authentication para controle de segurança usuario: coontrol - senha: coontrol porta configurada: 8081

ctrl.view: projeto spring-boot para disponibilizar a camada de interfaces Foi utilizado o Spring security com formulário de usuario e senha para controle de segurança usuario: coontrol - senha: coontrol porta configurada: 8080

Banco de dados: Postgres É criado automaticamente um usuário padrão no banco ao iniciar o sistema

Ambos os projetos já contém o servidor tomcat embutido, basta somente subir os dois projetos com o comando mvn spring-boot:run e acessar a aplicação pelo link http://localhost:8080/index.xhtml

Dúvidas: kaue.tenfen@gmail.com whats 48988442828

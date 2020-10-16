# ProjetoHibernate

Projeto Hibernate-JPA-Mvn Simplificado para cadastro de jogos de Videogame.

### Visualização das construções de utilidades CRUD (Create, Read, Update e Drop).


#### Index (Menus = [1] - Banco de Dados | [2] - Cadastro):
<p align="center">
<img src="https://github.com/Reis-Silva/ProjetoHibernate/blob/main/ProjetoHibernate/src/main/java/META-INF/resources/img/index.png">
===========================================================================
</p>

#### Menu Banco de Dados (Funções = [1] - Deletar | [2] - Atualizar):
<p align="center">
<img src="https://github.com/Reis-Silva/ProjetoHibernate/blob/main/ProjetoHibernate/src/main/java/META-INF/resources/img/BancoDeDados.png">
===========================================================================
</p>

#### Função Atualizar:
<p align="center">
<img src="https://github.com/Reis-Silva/ProjetoHibernate/blob/main/ProjetoHibernate/src/main/java/META-INF/resources/img/Atualizar.png">
===========================================================================
</p>

#### Menu Cadastro:
<p align="center">
<img src="https://github.com/Reis-Silva/ProjetoHibernate/blob/main/ProjetoHibernate/src/main/java/META-INF/resources/img/cadastro.png">
</p>

## Dados de construção do projeto:

[1] - JavaSE-14 (jdk-15.0.0.36)

[2] - Servidor Apache Tomcat versão 9.0.39. Link: https://downloads.apache.org/tomcat/tomcat-9/v9.0.39/bin/apache-tomcat-9.0.39-windows-x64.zip

##### [3] - Dados recorrentes de dependencias encontram-se em: https://github.com/Reis-Silva/ProjetoHibernate/blob/main/ProjetoHibernate/pom.xml

[4] - Conexão com Microsoft SQLServer Management Studio (8 - v18.6). Dados recorrentes de conexão com o banco de dados encontram-se no persistence.xml: https://github.com/Reis-Silva/ProjetoHibernate/blob/main/ProjetoHibernate/src/main/java/META-INF/persistence.xml

## Observações:

OBS: No mecanismos de Banco de Dados do SQL Server utiliza-se da "Autenticação do SQL Server".Logon: root e Senha 1234. 

OBS2: Função de criação do banco de dados não está automática (foi estabelecido a criação obrigatória do "genericbd" no servidor, pode ser mudado) apenas para a tabela.

OBS3: Depois de carregar completo os dados, use as funções "Synchronize Class List" para o arquivo persistence.xml e "Update Project" na opção do Maven.

########################################################################################################################################################################################
### []´s

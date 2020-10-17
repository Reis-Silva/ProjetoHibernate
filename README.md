# Projeto Hibernate-JPA-Maven


 Projeto simplificado construído para cadastro de jogos de Videogame através das combinações "Hibernate-JPA-Maven" com o banco de dados Microsoft SQLserver.


## Features

- Suporte no JavaSE-1.8 em diante podendo ser utilizado o jdk nas versões `11.x, 12.x, 13.x, 14.x, 15.x`.

- Suporte no Servidor Apache Tomcat versões `7.x, 8.x, 9.x`, aconselhável a versão `9.x` - Link: https://downloads.apache.org/tomcat/tomcat-9/v9.0.39/bin/apache-tomcat-9.0.39-windows-x64.zip

- Dados recorrentes de dependencias do projeto podem ser utilizadas de acordo como está definido no Link do pom.xml: https://github.com/Reis-Silva/ProjetoHibernate/blob/main/ProjetoHibernate/pom.xml desde de que esteja dentro das versões do JavaSE.

- Conexão com Microsoft SQLServer Management Studio (8 - v18.6) contendo o SQL Server 15, no entanto pode ser utilizado em outras versões. Dados recorrentes de conexão com o banco de dados encontram-se no persistence.xml: https://github.com/Reis-Silva/ProjetoHibernate/blob/main/ProjetoHibernate/src/main/java/META-INF/persistence.xml


## Possíveis Erros

- Nas configurações do Microsoft SQLServer Management Studio em: `SQL Server Configuration Manager/Configurações de Rede do SQL Server/Protocolos para o servidor"`. Verificar se a opção do protocolo está `Habilitada`.
 
<p align="center">
<img src="https://github.com/Reis-Silva/ProjetoHibernate/blob/main/ProjetoHibernate/src/main/java/META-INF/resources/img/ProtocoloHabilitado.png">
</p>
 
- Em caso de erro referente ao bloqueio efetuado pelo Firewall, ir para a aba Endereço IP, selecionar `IP4` e mudar o endereço IP para `194.100.1.100`, em `IPAll` verificar se a porta está como `1433` e as portas dinamicas como 0 ou 55629. Reinicie todas os processos da conexão do SQL server pela aba `serviços/abrir serviços` do Gerenciador de Tarefas. 
 
 <p align="center">
<img src="https://github.com/Reis-Silva/ProjetoHibernate/blob/main/ProjetoHibernate/src/main/java/META-INF/resources/img/IP4_IPAll.png">
</p>
 
 


## Observações:

OBS: No mecanismos de Banco de Dados do SQL Server utiliza-se da "Autenticação do SQL Server".Logon: root e Senha 1234. 

OBS2: Função de criação do banco de dados não está automática (foi estabelecido a criação obrigatória do "genericbd" no servidor, pode ser mudado) apenas para a tabela.

OBS3: Depois de carregar completo os dados, use as funções "Synchronize Class List" para o arquivo persistence.xml e "Update Project" na opção do Maven.

OBS: Utilizou-se o Eclipse EE.

########################################################################################################################################################################################
### []´s

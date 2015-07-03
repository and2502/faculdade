<h4>Informações para instalação em ambiente de desenvolvimento:</h4>

1 - Faça o download do git no site oficial: <a href="https://git-scm.com/downloads"> Download git </a><br/>
2 - Faça a instalação do git.<br/>
3 - Baixe o projeto executando no terminal: <code> git clone https://github.com/adercinho/faculdade.git </code><br/>
4 - Importe no eclipse o como tipo <b>Existing Eclipse projects</b><br/>
5 - Faça download do tomcat 7 no link abaixo:<br/>
<a href="http://mirror.nbtelecom.com.br/apache/tomcat/tomcat-7/v7.0.62/bin/apache-tomcat-7.0.62.zip">Download Tomcat 6</a><br/>
7 - Crie um server no eclipse e associe ele ao tomcat 7 que foi baixado acima.<br/>
8 - Associe o projeto SistemaCadastroTrabalhos ao seu server criado no eclipse.<br/>
9 - Realize o start do server.<br/>

11- Importe o dump do banco que está localizado em <b>/resources/dump.sql</b> no Mysql<br/>
12- Usuario/senha do banco configurado na aplicação:<br/>
usuario: root<br/>
senha: fiap<br/>

13 - URL de acesso:<br/>
<a href="http://localhost:8080/SistemaCadastroTrabalhos">http://localhost:8080/SistemaCadastroTrabalhos</a><br/><br/>


OBS: Ao realizar o primeiro cadastro no sistema, o banco será gerado automaticamente.<br/>

Comandos auxiliares para subir suas alterações:<br/>
<code>git add .</code><br/>
<code>git commit -m "Criado a tela de manter aluno"</code><br/>
<code>git push</code><br/>


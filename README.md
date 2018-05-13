# Spring-Boot Lab

Projeto que simula CRUD simples de cliente apenas pra estudo e familiarização do *`Spring framework`*.

### Descrição

Este projeto usa as seguintes ferramentas:
* Spring `v.2.0.1.RELEASE`:
	* Spring - Boot
	* Spring - Data
	* Spring - Web
* Apache Tomcat 9.0.7 - Externo (o tomcat embutido do Spring-Boot foi omitido);
* JSP (Apenas por questões de gosto, mas possa ser que na frente mude pro `Thymeleaf`);
* PostgreSQL 9.5 (É o que já estava instalado na minha máquinha, mas creio que uma versão posterior como 9.6+ funcione normalmente).

#### Notas

Pra quem não tiver nenhuma familiaridade tenho alguns pontos que pareciam ser bobos - e na verdade são -, mas que eu acho interessante frizar, que são:

1. O caminho do contexto do projeto (*`/lab`*) foi definido no arquivo *`context.xml`* que está dentro da pasta `src/main/webapp/META-INF`. Isso é pro uso do Tomcat externo. O caminho do contexto definido dentro do arquivo *`application.properties`* (*`server.servlet.context-path`*) vai servir apenas pro tomcat embutido que já vem dentro do módulo *`spring-boot-starter-web`* ou pode ser chamado dessa forma, caso queira usar uma versão diferente:

```
<dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-tomcat</artifactId>
        <version>${version}<version>
</dependency>
```

2. É necessário criar o banco de dados manualmente (use qualquer nome que lhe for conveniente) e alterar a senha e a URL de conexão com o banco de dados caso seja necessário. Essas mudanças podem ser feitas no arquivo *`application.properties`* nas propriedades:
* *`spring.datasource.url=jdbc:postgresql://localhost:5432/<nome_banco_de_dados>`*

* *`spring.datasource.password=<password>`*

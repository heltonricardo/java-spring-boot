Esse tipo de projeto não é criado diretamente no Eclipse.
Acesse start.spring.io e insira os dados lá. Preencha os campos conforme a
necessidade. Para esse caso, nas dependências, inserimos: "Spring Boot
DevTools" e "Spring Web". Depois de configurar clique em "Generate" para baixar
o arquivo zip. Descompacte em uma pasta de sua preferência. Abra o Eclipse e
clique com o botão direito em uma parte vazia da barra lateral esquerda (onde
ficam os projetos) > Import... > Maven > Existing Maven Projects. Escolha a
pasta que foi descompactada. Quando finalizar, o Eclipse iniciará o download
das dependências e acrescentará automaticamente ao projeto.

Maven é um gerenciador de projetos que baixa e configura automaticamente as 
dependências e plugins de um projeto. As configurações do Maven estão no
arquivo pom.xml.

Os códigos fonte do Maven não ficam diretamente dentro de "src", como ficam,
normalmente, os de projetos Java. A localização padrão que o Maven usa é:
src/main/java. Já em src/main/resources geralmente ficam os arquivos html, css
e javascript. Esse padrão pode mudar conforme o artefato (o tipo do projeto que
será criado) usado no Maven.

===============================================================================

Crie o esquema "springboot" no Workbench. Para instalar as dependências do JPA
e MySQL basta inserir os códigos abaixo:

-- No arquivo pom.xml:

<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
 
<dependency>
	<groupId>mysql</groupId>
	<artifactId>mysql-connector-java</artifactId>
</dependency>


-- No arquivo application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/springboot?verifyServerCertificate=false&useSSL=true&useTimezone=true&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=12345678
 
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect
# Actividad-2-integracion-de-proyectos-inteligentes


## 📌 Requisitos

- Java 17
- Maven 3.x
- Base de datos: H2 (en memoria)

---

## ▶️ Ejecutar la etapa DAO/JDBC

Desde la raíz del proyecto:

mvn clean install


## Luego ejecutar el módulo JDBC:


cd dao-jdbc
mvn exec:java 

Los comandos realizan lo siguiente: 

- Crea la base de datos H2 en memoria

- Crea la tabla products

- Inserta registros de prueba

- Muestra el listado por consola

## ▶️ Ejecutar la etapa JPA/Hibernate

Desde la raíz del proyecto:

mvn clean install

Ejecutar el módulo JPA: 

cd orm-jpa
mvn exec:java

Los comandos realizan lo siguiente :

- Inicializar Hibernate

- Crear automáticamente la tabla products

- Insertar registros

- Consultar y mostrar los productos

## Tablas:

products

id (BIGINT, PK, autogenerado)

name (VARCHAR)

price (DOUBLE)
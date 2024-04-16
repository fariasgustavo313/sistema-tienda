# Microservicio API con Spring Boot y Spring Cloud

Este proyecto es una API desarrollada en Java utilizando la arquitectura de microservicios con Spring Boot y Spring Cloud. Está optimizada utilizando patrones de diseño como load balancing, circuit breaker, service registry, service discovery, Eureka Server, API Gateway, Config Server y Docker. Utiliza una base de datos MySQL, Hibernate y Spring Data JPA para la persistencia de datos.

## Tecnologías Utilizadas

- Java
- Spring Boot
- Spring Cloud
- MySQL
- Hibernate
- Spring Data JPA
- Docker

## Funcionalidades Principales

- **Load Balancing**: Distribución de la carga entre instancias del servicio para mejorar el rendimiento y la disponibilidad.
- **Circuit Breaker**: Implementación del patrón de circuit breaker para mejorar la resiliencia del sistema.
- **Service Registry**: Registro de servicios para facilitar la comunicación entre microservicios.
- **Service Discovery**: Descubrimiento dinámico de servicios para simplificar la configuración y la escalabilidad.
- **Eureka Server**: Servidor de registro y descubrimiento de servicios de Spring Cloud Netflix.
- **API Gateway**: Punto de entrada único para todas las peticiones a la API, gestionando el enrutamiento y la seguridad.
- **Config Server**: Servidor centralizado para la gestión de la configuración de los microservicios.
- **Docker**: Contenerización de la aplicación para una fácil implementación y administración.

## Instalación y Uso

1. Clona este repositorio en tu máquina local.
2. Asegúrate de tener Docker instalado en tu sistema.
3. Configura las propiedades de la base de datos en el archivo `application.properties`.
4. Ejecuta el comando `docker-compose up` para construir y ejecutar la aplicación en contenedores Docker.
5. La API estará disponible en `http://localhost:8080`.

## Contacto

Si tienes alguna pregunta o sugerencia, no dudes en contactarme:

- Correo electrónico: fariasgustavo313@gmail.com
- LinkedIn: httpsÑ//www.linkedin.com/in/gustavoef

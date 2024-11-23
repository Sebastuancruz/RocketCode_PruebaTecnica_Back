# Sistema de Gestión de Biblioteca 📚

Este proyecto es una prueba técnica para la empresa **RocketCode**, desarrollado utilizando **Java 8** y **Spring Boot 2.7.18**.  
El sistema está diseñado para gestionar bibliotecas, permitiendo el registro de usuarios administradores y estudiantes, así como el control de préstamos de libros.

## Funcionalidades 🚀

### Administrador
El usuario administrador tiene acceso a las siguientes funcionalidades:  
- **Registro de libros**: Agregar nuevos libros al catálogo.  
- **Gestión de inventario**: Verificar la disponibilidad de libros.  
- **Gestión de préstamos**: Registrar el préstamo de libros a estudiantes.

### Alumno
El usuario alumno puede realizar las siguientes acciones:  
- **Consulta de préstamos**: Ver los libros que tiene en préstamo y su fecha de vencimiento.

---

## Tecnologías Utilizadas 🛠️
- **Lenguaje**: Java 8  
- **Framework**: Spring Boot 2.7.18  
- **Base de datos**: PostgreSQL  
- **Contenedores**: Docker (opcional para despliegue)  
- **Gestión de dependencias**: Maven  

---

## Requisitos Previos ✅
Antes de ejecutar el proyecto, asegúrate de tener instalados los siguientes elementos:  
- **Java 8 o superior**  
- **Maven**  
- **Docker (opcional)**  
- **PostgreSQL**  

---

## Instalación y Configuración 🖥️

1. **Clonar el repositorio**  
   ```bash
   git clone https://github.com/tu-usuario/sistema-biblioteca.git
   cd sistema-biblioteca

2. **Configurar la abse de datos**  
   ```
   spring.datasource.url=jdbc:postgresql://localhost:5432/nombre_base_datos
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña

2. **Compilar el proyecto**  
   ```
   mvn clean install

3. **Ejecutar la aplicación**  





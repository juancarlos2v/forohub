# ForoHbu - API REST Challenge

Este proyecto es un desafío diseñado para desarrollar una API REST utilizando Spring Boot, JWT (JSON Web Tokens) para la autenticación, y MariaDB como base de datos. A continuación, se detalla el flujo y funcionalidades principales de la API.

---

## Funcionalidades

### 1. **Autenticación**
La API implementa autenticación mediante JWT. Los usuarios deben autenticarse utilizando un email y contraseña (o login y contraseña).

- **Endpoint:** `/auth`
- **Método:** `POST`
- **Body ejemplo:**
  ```json
  {
      "email": "usuario@example.com",
      "password": "123456"
  }
  ```
- **Respuesta exitosa:** Genera un token JWT del tipo `Bearer`.
- **Status:** `200 OK`

### 2. **Crear Tópicos**
Los usuarios autenticados pueden crear tópicos en el foro. Cada tópico incluye información como ID del usuario, mensaje, curso relacionado y título del tópico.

- **Endpoint:** `/topics`
- **Método:** `POST`
- **Body ejemplo:**
  ```json
  {
      "userId": 1,
      "message": "Este es un nuevo tópico.",
      "course": "Spring Boot",
      "title": "Introducción a JWT"
  }
  ```
- **Requisitos:** Se debe enviar un token JWT válido en la cabecera de la solicitud.
- **Cabecera ejemplo:**
  ```
  Authorization: Bearer <token>
  ```
- **Respuesta exitosa:** Devuelve el ID del tópico creado.
- **Status:** `201 Created`

### 3. **Listar Tópicos**
Lista todos los tópicos disponibles.

- **Endpoint:** `/topics`
- **Método:** `GET`
- **Respuesta exitosa:** Devuelve un listado de tópicos.
- **Status:** `200 OK`

### 4. **Eliminar Tópicos**
Permite eliminar un tópico específico por ID.

- **Endpoint:** `/topics/{id}`
- **Método:** `DELETE`
- **Requisitos:** Se debe enviar un token JWT válido en la cabecera de la solicitud.
- **Cabecera ejemplo:**
  ```
  Authorization: Bearer <token>
  ```
- **Respuesta exitosa:** Confirma la eliminación del tópico.
- **Status:** `200 OK`

---

## Implementación

### Autenticación y Seguridad
La API utiliza **Spring Security** con JWT para garantizar que solo usuarios autenticados puedan interactuar con ciertos endpoints (crear, eliminar, etc.). Si un usuario no autenticado intenta acceder a estas funcionalidades, la API responderá con un código `403 Forbidden`.

### Base de Datos
Se utiliza **MariaDB** como base de datos relacional para almacenar los datos del foro y de los usuarios.

- Tablas principales:
  - `users`: Almacena información de los usuarios registrados.
  - `topics`: Almacena los tópicos creados por los usuarios.

### Códigos de Estado
- `200 OK`: Solicitud exitosa.
- `201 Created`: Recurso creado exitosamente.
- `403 Forbidden`: Acceso denegado por falta de autenticación o permisos.
- `404 Not Found`: Recurso no encontrado.

---

## Cómo Ejecutar

### 1. Clonar el repositorio
```bash
git clone https://github.com/usuario/repo.git
cd repo
```

### 2. Configurar la base de datos
Asegúrate de tener **MariaDB** instalado y configurado. Crea una base de datos y ajusta el archivo `application.properties` o `application.yml` para incluir tus credenciales de conexión.

### 3. Ejecutar la aplicación
Usa el siguiente comando para iniciar la aplicación:
```bash
./mvnw spring-boot:run
```

### 4. Probar la API
Usa una herramienta como **Postman** o **cURL** para interactuar con los endpoints.

---

## Consideraciones Finales

- Asegúrate de manejar correctamente los códigos de estado HTTP para una experiencia más clara y consistente.
- Implementa validaciones tanto en el cliente como en el servidor para garantizar la integridad de los datos.
- Recuerda mantener las dependencias actualizadas y utilizar buenas prácticas de seguridad al trabajar con JWT.

---

## Recursos Adicionales

- [Documentación de Spring Boot](https://spring.io/projects/spring-boot)
- [Guía de JSON Web Tokens](https://jwt.io/)
- [MariaDB Documentation](https://mariadb.com/kb/en/documentation/)


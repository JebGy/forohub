# 📚 Foro Hub - API REST (Desafío Alura Latam)

Este proyecto forma parte del **Challenge Foro Hub** de **Alura Latam**. Es una **API RESTful** construida con **Spring Boot**, diseñada para gestionar un foro de discusión que incluye usuarios, cursos, tópicos y respuestas, con autenticación segura mediante **JWT** y documentación generada con **Swagger**.

---

## 🚀 Características
- CRUD completo para **Tópicos**.
- Gestión de **Usuarios**, **Perfiles** y **Cursos**.
- Gestión de **Respuestas** en cada tópico.
- Autenticación segura con **JWT**.
- Documentación interactiva con **Swagger UI**.

---

## ✅ Tecnologías Utilizadas
- **Java 17**
- **Spring Boot** (Web, Security, Data JPA, Validation)
- **Hibernate**
- **JWT** para autenticación
- **Swagger UI (OpenAPI 3.1)**
- **Base de Datos**: H2 (por defecto) o MySQL
- **Maven**

---

## 📂 Arquitectura
El proyecto sigue el patrón **MVC**:
- **Controller**: Controladores para exponer endpoints REST.
- **Service**: Lógica de negocio.
- **Repository**: Acceso a la base de datos.
- **DTOs**: Transferencia de datos entre capas.

---

## 🔐 Autenticación JWT
La autenticación se implementa con **JSON Web Tokens (JWT)**.

Flujo:
1. Realiza el **login** con credenciales válidas en `/login`.
2. Recibe un token JWT.
3. Incluye el token en el header de las peticiones de los demás endpoints


---

## 🛠 Endpoints Disponibles

### 🔑 **Autenticación**
| Método | Endpoint   | Descripción             |
|--------|-----------|--------------------------|
| POST   | `/login` | Generar token JWT       |

---

### 📌 **Tópicos**
| Método | Endpoint             | Descripción                |
|--------|----------------------|---------------------------|
| GET    | `/topicos`          | Listar todos los tópicos |
| GET    | `/topicos/{id}`     | Obtener un tópico por ID |
| POST   | `/topicos/agregar`  | Crear un nuevo tópico    |
| PUT    | `/topicos/{id}`     | Actualizar un tópico     |
| DELETE | `/topicos/{id}`     | Eliminar un tópico       |

---

### 👤 **Usuarios**
| Método | Endpoint              | Descripción             |
|--------|----------------------|-------------------------|
| POST   | `/usuarios/agregar` | Registrar un usuario   |

---

### 🗨 **Respuestas**
| Método | Endpoint                | Descripción             |
|--------|-------------------------|-------------------------|
| POST   | `/respuestas/agregar`  | Agregar una respuesta  |

---

### 🛡 **Perfiles**
| Método | Endpoint              | Descripción             |
|--------|----------------------|-------------------------|
| POST   | `/perfiles/agregar` | Crear un nuevo perfil  |

---

### 📚 **Cursos**
| Método | Endpoint             | Descripción            |
|--------|---------------------|------------------------|
| POST   | `/cursos/agregar`  | Registrar un curso    |

---

## 📂 Esquemas Principales
Algunos DTOs definidos:
- **TopicoDTO**: id, título, mensaje, cursoId.
- **UsuarioDTO**: id, nombre, correo, perfilId.
- **RespuestaDTO**: id, mensaje, topicoId.
- **CursoDTO**: id, nombre, descripción.

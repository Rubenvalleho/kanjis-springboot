# 🚀 API REST de Usuarios - Tutorial Spring Boot

Esta es una aplicación tutorial que demuestra cómo crear una API REST completa en Spring Boot para gestionar usuarios.

## 📋 Características

- ✅ CRUD completo (Crear, Leer, Actualizar, Eliminar)
- ✅ Búsqueda por nombre y rango de edad
- ✅ Validaciones de negocio
- ✅ Base de datos H2 en memoria
- ✅ Datos de prueba precargados
- ✅ Documentación completa

## 🏗️ Arquitectura

El proyecto sigue el patrón de arquitectura por capas:

```
📁 controllers/     → Endpoints REST (API)
📁 services/        → Lógica de negocio
📁 repositories/    → Acceso a datos (JPA)
📁 entities/        → Modelos de datos
📁 config/          → Configuraciones
```

## 🚀 Cómo ejecutar

1. **Instalar dependencias:**
   ```bash
   ./mvnw clean install
   ```

2. **Ejecutar la aplicación:**
   ```bash
   ./mvnw spring-boot:run
   ```

3. **La aplicación estará disponible en:**
   - API: http://localhost:4000
   - Console H2: http://localhost:4000/h2-console

## 📊 Base de Datos H2

Para ver los datos en la consola H2:
- URL: `http://localhost:4000/h2-console`
- JDBC URL: `jdbc:h2:mem:testdb`
- Usuario: `sa`
- Contraseña: (vacía)

## 🌐 Endpoints de la API

### 📋 Obtener todos los usuarios
```http
GET http://localhost:4000/api/usuarios
```

**Respuesta:**
```json
[
  {
    "id": 1,
    "nombre": "Juan Pérez",
    "email": "juan.perez@email.com",
    "telefono": "123456789",
    "edad": 28
  }
]
```

### 👤 Obtener usuario por ID
```http
GET http://localhost:4000/api/usuarios/1
```

### ➕ Crear nuevo usuario
```http
POST http://localhost:4000/api/usuarios
Content-Type: application/json

{
  "nombre": "Pedro Sánchez",
  "email": "pedro.sanchez@email.com",
  "telefono": "555666777",
  "edad": 30
}
```

### ✏️ Actualizar usuario
```http
PUT http://localhost:4000/api/usuarios/1
Content-Type: application/json

{
  "nombre": "Juan Carlos Pérez",
  "telefono": "999888777"
}
```

### 🗑️ Eliminar usuario
```http
DELETE http://localhost:4000/api/usuarios/1
```

### 🔍 Buscar usuarios por nombre
```http
GET http://localhost:4000/api/usuarios/buscar?nombre=Juan
```

### 📊 Buscar usuarios por edad
```http
GET http://localhost:4000/api/usuarios/edad?min=25&max=40
```

## 🧪 Pruebas con cURL

```bash
# Obtener todos los usuarios
curl -X GET http://localhost:4000/api/usuarios

# Crear un nuevo usuario
curl -X POST http://localhost:4000/api/usuarios \
  -H "Content-Type: application/json" \
  -d '{"nombre":"Test User","email":"test@email.com","edad":25}'

# Buscar por nombre
curl -X GET "http://localhost:4000/api/usuarios/buscar?nombre=Juan"
```

## 📚 Conceptos aprendidos

### 🏷️ Anotaciones principales:
- `@Entity` - Marca una clase como entidad de base de datos
- `@RestController` - Combina @Controller + @ResponseBody
- `@Service` - Marca una clase como servicio (lógica de negocio)
- `@Repository` - Marca una interface como repositorio de datos
- `@Autowired` - Inyección de dependencias automática

### 🔧 Componentes:
1. **Entity (Usuario)** - Modelo de datos con JPA
2. **Repository** - Interface para acceso a datos
3. **Service** - Lógica de negocio y validaciones
4. **Controller** - Endpoints REST

### 📋 Códigos HTTP:
- `200 OK` - Operación exitosa
- `201 Created` - Recurso creado
- `204 No Content` - Eliminación exitosa
- `400 Bad Request` - Error en la petición
- `404 Not Found` - Recurso no encontrado
- `500 Internal Server Error` - Error del servidor

## 🔧 Personalización

Para añadir nuevos campos al usuario:
1. Actualizar la entidad `Usuario`
2. El repositorio se actualiza automáticamente
3. Actualizar validaciones en `UsuarioService`
4. Los endpoints funcionarán automáticamente

## 📝 Notas importantes

- La base de datos H2 es en memoria - los datos se pierden al reiniciar
- Los datos de prueba se cargan automáticamente al iniciar
- CORS está habilitado para desarrollo frontend
- Los logs SQL están activados para aprendizaje

# Kanjis SpringBoot API

Una API REST completa para la gestión de kanjis japoneses construida con Spring Boot, implementando Clean Architecture y patrones de diseño modernos.

## 📋 Descripción

Esta aplicación web permite gestionar una base de datos de kanjis japoneses con información detallada sobre cada carácter, incluyendo lecturas, significados, ejemplos de uso, niveles JLPT, grados escolares y más.

## 🏗️ Arquitectura

El proyecto implementa **Clean Architecture** con las siguientes capas:

### 📁 Estructura del Proyecto

```
src/main/java/com/rubenvj/springboot/kanjis/kanjis_springboot/
├── 📂 entities/                    # Entidades de dominio
│   └── Kanji.java
├── 📂 domain/                      # Lógica de dominio
│   ├── repositories/               # Interfaces de repositorio
│   │   └── KanjiRepositoryInterface.java
│   └── usecases/                   # Casos de uso
│       ├── GetAllKanjisUseCase.java
│       ├── GetKanjiByIdUseCase.java
│       ├── CreateKanjiUseCase.java
│       ├── UpdateKanjiUseCase.java
│       ├── DeleteKanjiUseCase.java
│       ├── SearchKanjisByMeaningUseCase.java
│       ├── SearchKanjisByKunReadingUseCase.java
│       ├── SearchKanjisByOnReadingUseCase.java
│       ├── SearchKanjisByJlptLevelUseCase.java
│       ├── SearchKanjisByGradeUseCase.java
│       ├── SearchKanjisByStrokeCountUseCase.java
│       ├── SearchKanjisByStrokeRangeUseCase.java
│       ├── SearchKanjisByRadicalUseCase.java
│       ├── GetKanjisByFrequencyUseCase.java
│       ├── GetRandomKanjisUseCase.java
│       ├── SearchKanjisByCriteriaUseCase.java
│       └── GetKanjiStatisticsUseCase.java
├── 📂 infrastructure/              # Capa de infraestructura
│   └── repositories/
│       └── KanjiRepositoryImpl.java
├── 📂 repositories/                # Repositorios JPA
│   └── KanjiRepository.java
├── 📂 controllers/                 # Controladores REST
│   ├── KanjiController.java
│   └── PruebaController.java
├── 📂 services/                    # Servicios (legacy)
│   └── KanjiService.java
├── 📂 config/                      # Configuración
│   └── DataInitializer.java
└── KanjisSpringbootApplication.java
```

### 🔄 Flujo de Arquitectura

1. **Controller Layer**: Recibe las peticiones HTTP y delega a los casos de uso
2. **Use Case Layer**: Contiene la lógica de negocio específica
3. **Domain Layer**: Define las interfaces y entidades de dominio
4. **Infrastructure Layer**: Implementa las interfaces de dominio
5. **Repository Layer**: Acceso a datos con JPA

## 🛠️ Tecnologías Utilizadas

- **Java 17+**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **Spring Web**
- **H2 Database** (en memoria para desarrollo)
- **Maven** (gestión de dependencias)
- **Jackson** (serialización JSON)

## 📊 Modelo de Datos

### Entidad Kanji

```java
@Entity
@Table(name = "kanjis")
public class Kanji {
    private Long id;                    // ID único
    private String kanji;               // Carácter kanji
    private String lecturaKun;          // Lectura kun (japonesa)
    private String lecturaOn;           // Lectura on (china)
    private String significadoEspanol;  // Significado en español
    private Integer numeroTrazos;       // Número de trazos
    private String nivelJlpt;          // Nivel JLPT (N5, N4, N3, N2, N1)
    private Integer gradoEscolar;      // Grado escolar japonés
    private Integer frecuenciaUso;     // Frecuencia de uso
    private String ejemplosPalabras;   // Ejemplos de palabras
    private String radicalPrincipal;   // Radical principal
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
}
```

## 🚀 Instalación y Ejecución

### Prerrequisitos

- Java 17 o superior
- Maven 3.6 o superior

### Pasos para ejecutar

1. **Clonar el repositorio**
```bash
git clone [url-del-repositorio]
cd kanjis-springboot
```

2. **Compilar el proyecto**
```bash
mvn clean compile
```

3. **Ejecutar tests**
```bash
mvn test
```

4. **Ejecutar la aplicación**
```bash
mvn spring-boot:run
```

5. **Acceder a la aplicación**
```
http://localhost:8080
```

## 📚 API Endpoints

### 🔍 Endpoints de Consulta

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| `GET` | `/api/kanjis` | Obtener todos los kanjis |
| `GET` | `/api/kanjis/{id}` | Obtener kanji por ID |
| `GET` | `/api/kanjis/caracter/{kanji}` | Obtener kanji por carácter |
| `GET` | `/api/kanjis/estadisticas` | Obtener estadísticas generales |
| `GET` | `/api/kanjis/aleatorios` | Obtener kanjis aleatorios |
| `GET` | `/api/kanjis/frecuencia` | Obtener kanjis por frecuencia |

### 🔎 Endpoints de Búsqueda

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| `GET` | `/api/kanjis/buscar/significado` | Buscar por significado |
| `GET` | `/api/kanjis/buscar/kun` | Buscar por lectura kun |
| `GET` | `/api/kanjis/buscar/on` | Buscar por lectura on |
| `GET` | `/api/kanjis/buscar/jlpt` | Buscar por nivel JLPT |
| `GET` | `/api/kanjis/buscar/grado` | Buscar por grado escolar |
| `GET` | `/api/kanjis/buscar/trazos` | Buscar por número de trazos |
| `GET` | `/api/kanjis/buscar/trazos-rango` | Buscar por rango de trazos |
| `GET` | `/api/kanjis/buscar/radical` | Buscar por radical |
| `GET` | `/api/kanjis/buscar/criterios` | Búsqueda con múltiples criterios |

### ✏️ Endpoints de Gestión

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| `POST` | `/api/kanjis` | Crear nuevo kanji |
| `PUT` | `/api/kanjis/{id}` | Actualizar kanji existente |
| `DELETE` | `/api/kanjis/{id}` | Eliminar kanji |

## 💡 Ejemplos de Uso

### Obtener todos los kanjis
```bash
curl -X GET http://localhost:8080/api/kanjis
```

### Buscar kanjis por significado
```bash
curl -X GET "http://localhost:8080/api/kanjis/buscar/significado?significado=agua"
```

### Buscar kanjis por nivel JLPT
```bash
curl -X GET "http://localhost:8080/api/kanjis/buscar/jlpt?nivel=N5"
```

### Crear un nuevo kanji
```bash
curl -X POST http://localhost:8080/api/kanjis \
  -H "Content-Type: application/json" \
  -d '{
    "kanji": "漢",
    "lecturaKun": "おとこ",
    "lecturaOn": "カン",
    "significadoEspanol": "hombre chino, kanji",
    "numeroTrazos": 13,
    "nivelJlpt": "N3",
    "gradoEscolar": 3
  }'
```

### Búsqueda con múltiples criterios
```bash
curl -X GET "http://localhost:8080/api/kanjis/buscar/criterios?significado=agua&nivelJlpt=N5&gradoEscolar=1"
```

## 🗄️ Base de Datos

### Configuración H2 (Desarrollo)

La aplicación usa H2 como base de datos en memoria por defecto. La configuración se encuentra en `application.properties`:

```properties
# H2 Database Configuration
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# JPA Configuration
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

### Consola H2

Accede a la consola H2 en: `http://localhost:8080/h2-console`

- **JDBC URL**: `jdbc:h2:mem:testdb`
- **User**: `sa`
- **Password**: `password`

## 📦 Datos Iniciales

La aplicación carga automáticamente 20 kanjis de ejemplo al iniciar, distribuidos en diferentes niveles JLPT:

- **N5**: 10 kanjis básicos (水, 火, 木, 金, 土, 日, 月, 人, 大, 小)
- **N4**: 5 kanjis intermedios (食, 飲, 学, 車, 家)
- **N3**: 5 kanjis avanzados (病, 働, 旅, 音, 色)

## 🧪 Testing

### Ejecutar tests
```bash
mvn test
```

### Ejecutar tests con reporte
```bash
mvn test jacoco:report
```

## 🔧 Configuración

### Perfiles de Aplicación

- **development**: Configuración para desarrollo (H2 en memoria)
- **production**: Configuración para producción (configurar base de datos externa)

### Variables de Entorno

```bash
# Puerto de la aplicación
SERVER_PORT=8080

# Base de datos
DATABASE_URL=jdbc:h2:mem:testdb
DATABASE_USERNAME=sa
DATABASE_PASSWORD=password
```

## 🌐 CORS

La API tiene CORS habilitado para todos los orígenes (`*`) para facilitar el desarrollo frontend.

## 📈 Monitoreo

### Actuator Endpoints

Spring Boot Actuator está habilitado para monitoreo:

- `/actuator/health`: Estado de la aplicación
- `/actuator/info`: Información de la aplicación
- `/actuator/metrics`: Métricas de la aplicación

## 🔄 Próximas Mejoras

- [ ] Implementar autenticación JWT
- [ ] Agregar validación de entrada más robusta
- [ ] Implementar cache con Redis
- [ ] Agregar documentación OpenAPI/Swagger
- [ ] Implementar paginación en consultas
- [ ] Agregar logging estructurado
- [ ] Implementar rate limiting
- [ ] Agregar métricas personalizadas
- [ ] Soporte para múltiples idiomas
- [ ] Implementar backup automático

## 🤝 Contribución

1. Fork el proyecto
2. Crea una rama para tu feature (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

## 📝 Licencia

Este proyecto está bajo la Licencia MIT. Ver el archivo `LICENSE` para más detalles.

## 👥 Autor

**Ruben VJ**
- GitHub: [@rubenvj](https://github.com/rubenvj)
- Email: ruben.vallejo.jara@gmail.com

---

⚡ **Hecho con Spring Boot y mucho ❤️**

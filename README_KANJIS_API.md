# 🈲 API de Kanjis - Documentación Completa

Esta API proporciona una interfaz completa para consultar, crear y gestionar kanjis japoneses con sus lecturas, significados y metadatos.

## 🚀 Características

- ✅ **CRUD completo** para kanjis
- ✅ **Búsquedas avanzadas** por múltiples criterios
- ✅ **Filtros por nivel JLPT** (N5-N1)
- ✅ **Filtros por grado escolar** japonés
- ✅ **Búsqueda por número de trazos**
- ✅ **Búsqueda por lecturas** (kun y on)
- ✅ **Búsqueda por significado** en español
- ✅ **Kanjis aleatorios** para práctica
- ✅ **Estadísticas** de la base de datos
- ✅ **20 kanjis de ejemplo** precargados

## 📋 Endpoints Disponibles

### 🔍 **Consultas Básicas**

#### Obtener todos los kanjis
```http
GET /api/kanjis
```

#### Obtener kanji por ID
```http
GET /api/kanjis/{id}
```

#### Obtener kanji por carácter
```http
GET /api/kanjis/caracter/{kanji}
```

**Ejemplo:**
```bash
curl -X GET http://localhost:4000/api/kanjis/caracter/水
```

### 🔍 **Búsquedas Específicas**

#### Buscar por significado
```http
GET /api/kanjis/buscar/significado?q={significado}
```

**Ejemplo:**
```bash
curl -X GET "http://localhost:4000/api/kanjis/buscar/significado?q=agua"
```

#### Buscar por lectura kun
```http
GET /api/kanjis/buscar/kun?q={lectura}
```

**Ejemplo:**
```bash
curl -X GET "http://localhost:4000/api/kanjis/buscar/kun?q=みず"
```

#### Buscar por lectura on
```http
GET /api/kanjis/buscar/on?q={lectura}
```

**Ejemplo:**
```bash
curl -X GET "http://localhost:4000/api/kanjis/buscar/on?q=スイ"
```

### 📚 **Filtros Educativos**

#### Buscar por nivel JLPT
```http
GET /api/kanjis/jlpt/{nivel}
```

**Niveles disponibles:** N5, N4, N3, N2, N1

**Ejemplo:**
```bash
curl -X GET http://localhost:4000/api/kanjis/jlpt/N5
```

#### Buscar por grado escolar
```http
GET /api/kanjis/grado/{grado}
```

**Grados disponibles:** 1, 2, 3, 4, 5, 6

**Ejemplo:**
```bash
curl -X GET http://localhost:4000/api/kanjis/grado/1
```

### ✏️ **Filtros por Trazos**

#### Buscar por número exacto de trazos
```http
GET /api/kanjis/trazos/{numero}
```

**Ejemplo:**
```bash
curl -X GET http://localhost:4000/api/kanjis/trazos/4
```

#### Buscar por rango de trazos
```http
GET /api/kanjis/trazos/rango?min={min}&max={max}
```

**Ejemplo:**
```bash
curl -X GET "http://localhost:4000/api/kanjis/trazos/rango?min=1&max=5"
```

### 🎯 **Funciones Especiales**

#### Búsqueda avanzada (múltiples criterios)
```http
GET /api/kanjis/buscar/avanzado?significado={sig}&jlpt={jlpt}&grado={grado}
```

**Ejemplo:**
```bash
curl -X GET "http://localhost:4000/api/kanjis/buscar/avanzado?significado=agua&jlpt=N5&grado=1"
```

#### Kanjis aleatorios para práctica
```http
GET /api/kanjis/aleatorios?limite={numero}
```

**Ejemplo:**
```bash
curl -X GET "http://localhost:4000/api/kanjis/aleatorios?limite=10"
```

#### Kanjis ordenados por frecuencia de uso
```http
GET /api/kanjis/frecuencia
```

#### Estadísticas de la base de datos
```http
GET /api/kanjis/estadisticas
```

### ➕ **Operaciones CRUD**

#### Crear nuevo kanji
```http
POST /api/kanjis
Content-Type: application/json

{
  "kanji": "愛",
  "lecturaKun": "あい",
  "lecturaOn": "アイ",
  "significadoEspanol": "amor",
  "numeroTrazos": 13,
  "nivelJlpt": "N3",
  "gradoEscolar": 4
}
```

#### Actualizar kanji
```http
PUT /api/kanjis/{id}
Content-Type: application/json

{
  "significadoEspanol": "amor, cariño",
  "ejemplosPalabras": "愛 (あい) - amor, 愛する (あいする) - amar"
}
```

#### Eliminar kanji
```http
DELETE /api/kanjis/{id}
```

## 📊 **Estructura de Datos**

### Modelo Kanji
```json
{
  "id": 1,
  "kanji": "水",
  "lecturaKun": "みず",
  "lecturaOn": "スイ",
  "significadoEspanol": "agua",
  "numeroTrazos": 4,
  "nivelJlpt": "N5",
  "gradoEscolar": 1,
  "frecuenciaUso": 365,
  "ejemplosPalabras": "水 (みず) - agua, 水曜日 (すいようび) - miércoles",
  "radicalPrincipal": "水"
}
```

### Campos Explicados

- **kanji**: El carácter kanji (un solo carácter)
- **lecturaKun**: Lectura japonesa nativa (hiragana)
- **lecturaOn**: Lectura china adaptada (katakana)
- **significadoEspanol**: Significado en español
- **numeroTrazos**: Número de trazos para escribir el kanji
- **nivelJlpt**: Nivel del Japanese Language Proficiency Test (N5-N1)
- **gradoEscolar**: Grado escolar japonés donde se enseña (1-6)
- **frecuenciaUso**: Ranking de frecuencia de uso (1 = más común)
- **ejemplosPalabras**: Ejemplos de palabras que usan este kanji
- **radicalPrincipal**: Radical principal del kanji

## 🧪 **Ejemplos de Uso**

### PowerShell (Windows)
```powershell
# Buscar kanjis de nivel N5
Invoke-RestMethod -Uri "http://localhost:4000/api/kanjis/jlpt/N5" -Method GET

# Crear un nuevo kanji
$kanji = @{
    kanji = "平"
    lecturaKun = "たいら、ひら"
    lecturaOn = "ヘイ"
    significadoEspanol = "plano, paz"
    numeroTrazos = 5
    nivelJlpt = "N3"
    gradoEscolar = 3
} | ConvertTo-Json

Invoke-RestMethod -Uri "http://localhost:4000/api/kanjis" -Method POST -Body $kanji -ContentType "application/json"
```

### JavaScript (Frontend)
```javascript
// Buscar kanjis por significado
async function buscarKanjis() {
    const response = await fetch('/api/kanjis/buscar/significado?q=agua');
    const kanjis = await response.json();
    console.log(kanjis);
}

// Obtener kanji aleatorio
async function kanjiAleatorio() {
    const response = await fetch('/api/kanjis/aleatorios?limite=1');
    const kanji = await response.json();
    return kanji[0];
}
```

## 🎯 **Casos de Uso Típicos**

### 1. **Aplicación de Estudio**
```bash
# Obtener todos los kanjis de N5 para principiantes
curl -X GET http://localhost:4000/api/kanjis/jlpt/N5

# Obtener kanjis con pocos trazos para empezar
curl -X GET "http://localhost:4000/api/kanjis/trazos/rango?min=1&max=5"
```

### 2. **Quiz/Práctica**
```bash
# Obtener 10 kanjis aleatorios
curl -X GET "http://localhost:4000/api/kanjis/aleatorios?limite=10"

# Obtener kanjis por frecuencia de uso
curl -X GET http://localhost:4000/api/kanjis/frecuencia
```

### 3. **Diccionario/Búsqueda**
```bash
# Buscar por significado
curl -X GET "http://localhost:4000/api/kanjis/buscar/significado?q=agua"

# Buscar por lectura
curl -X GET "http://localhost:4000/api/kanjis/buscar/kun?q=みず"
```

## 📈 **Datos de Ejemplo Disponibles**

La API viene con 20 kanjis de ejemplo distribuidos por niveles:

- **N5 (Principiante)**: 10 kanjis básicos (水, 火, 木, 金, 土, 日, 月, 人, 大, 小)
- **N4 (Básico)**: 5 kanjis intermedios (食, 飲, 学, 車, 家)
- **N3 (Intermedio)**: 5 kanjis avanzados (病, 働, 旅, 音, 色)

## 🔧 **Configuración de Desarrollo**

### Puertos y URLs
- **API**: http://localhost:4000/api/kanjis
- **Base de datos H2**: http://localhost:4000/h2-console
- **Actuator**: http://localhost:4000/actuator

### Archivo de Pruebas
- **Interfaz web**: `test-kanjis-api.html`

## 🚀 **Próximos Pasos**

1. **Importar desde Excel**: Reemplazar datos mock con datos reales
2. **Autenticación**: Añadir seguridad para operaciones CRUD
3. **Paginación**: Implementar paginación para consultas grandes
4. **Cache**: Añadir cache para consultas frecuentes
5. **Búsqueda por texto**: Buscar en ejemplos de palabras
6. **Imágenes**: Añadir URLs de imágenes de stroke order

## 🐛 **Códigos de Error**

- **200 OK**: Operación exitosa
- **201 Created**: Kanji creado correctamente
- **400 Bad Request**: Datos inválidos o kanji duplicado
- **404 Not Found**: Kanji no encontrado
- **500 Internal Server Error**: Error del servidor

¡Tu API de kanjis está lista para usar! 🎉

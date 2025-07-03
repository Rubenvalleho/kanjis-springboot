# 🧪 Ejemplos de Pruebas con cURL - API Usuarios

## 📋 Obtener todos los usuarios
```bash
curl -X GET http://localhost:4000/api/usuarios
```

## 👤 Obtener usuario por ID
```bash
curl -X GET http://localhost:4000/api/usuarios/1
```

## ➕ Crear nuevo usuario
```bash
curl -X POST http://localhost:4000/api/usuarios \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Pedro Sánchez",
    "email": "pedro.sanchez@email.com",
    "telefono": "666777888",
    "edad": 35
  }'
```

## ✏️ Actualizar usuario (actualización parcial)
```bash
curl -X PUT http://localhost:4000/api/usuarios/1 \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Juan Carlos Pérez",
    "telefono": "999888777"
  }'
```

## 🗑️ Eliminar usuario
```bash
curl -X DELETE http://localhost:4000/api/usuarios/3
```

## 🔍 Buscar usuarios por nombre
```bash
curl -X GET "http://localhost:4000/api/usuarios/buscar?nombre=Juan"
```

## 📊 Buscar usuarios por rango de edad
```bash
curl -X GET "http://localhost:4000/api/usuarios/edad?min=25&max=40"
```

## 🛠️ Ejemplos con respuestas completas

### Obtener todos los usuarios con información de respuesta
```bash
curl -X GET http://localhost:4000/api/usuarios -w "\nHTTP Status: %{http_code}\n"
```

### Crear usuario con respuesta detallada
```bash
curl -X POST http://localhost:4000/api/usuarios \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Ana García",
    "email": "ana.garcia@email.com",
    "telefono": "555123456",
    "edad": 28
  }' \
  -w "\nHTTP Status: %{http_code}\n" \
  -v
```

### Probar validación de errores
```bash
# Email duplicado
curl -X POST http://localhost:4000/api/usuarios \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Test User",
    "email": "juan.perez@email.com",
    "edad": 25
  }' \
  -w "\nHTTP Status: %{http_code}\n"

# Datos inválidos
curl -X POST http://localhost:4000/api/usuarios \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "",
    "email": "invalid-email",
    "edad": -5
  }' \
  -w "\nHTTP Status: %{http_code}\n"
```

## 🔧 Comandos PowerShell (Windows)

### Obtener todos los usuarios
```powershell
Invoke-RestMethod -Uri "http://localhost:4000/api/usuarios" -Method GET
```

### Crear usuario
```powershell
$usuario = @{
    nombre = "María López"
    email = "maria.lopez@email.com"
    telefono = "777888999"
    edad = 32
} | ConvertTo-Json

Invoke-RestMethod -Uri "http://localhost:4000/api/usuarios" -Method POST -Body $usuario -ContentType "application/json"
```

### Actualizar usuario
```powershell
$datosActualizar = @{
    nombre = "María Elena López"
    edad = 33
} | ConvertTo-Json

Invoke-RestMethod -Uri "http://localhost:4000/api/usuarios/1" -Method PUT -Body $datosActualizar -ContentType "application/json"
```

### Eliminar usuario
```powershell
Invoke-RestMethod -Uri "http://localhost:4000/api/usuarios/5" -Method DELETE
```

## 📊 Scripts de prueba automatizada

### Crear script de prueba completa (test-api.ps1)
```powershell
# Script de prueba completa para PowerShell
Write-Host "🚀 Iniciando pruebas de API..." -ForegroundColor Green

# 1. Obtener todos los usuarios
Write-Host "`n📋 Obteniendo todos los usuarios..." -ForegroundColor Yellow
$usuarios = Invoke-RestMethod -Uri "http://localhost:4000/api/usuarios" -Method GET
Write-Host "Total usuarios: $($usuarios.Count)" -ForegroundColor Cyan

# 2. Crear nuevo usuario
Write-Host "`n➕ Creando nuevo usuario..." -ForegroundColor Yellow
$nuevoUsuario = @{
    nombre = "Usuario de Prueba"
    email = "test.$(Get-Date -Format 'yyyyMMddHHmmss')@email.com"
    telefono = "123456789"
    edad = 25
} | ConvertTo-Json

try {
    $usuarioCreado = Invoke-RestMethod -Uri "http://localhost:4000/api/usuarios" -Method POST -Body $nuevoUsuario -ContentType "application/json"
    Write-Host "✅ Usuario creado con ID: $($usuarioCreado.id)" -ForegroundColor Green
    
    # 3. Actualizar usuario recién creado
    Write-Host "`n✏️ Actualizando usuario..." -ForegroundColor Yellow
    $datosActualizar = @{
        edad = 26
    } | ConvertTo-Json
    
    $usuarioActualizado = Invoke-RestMethod -Uri "http://localhost:4000/api/usuarios/$($usuarioCreado.id)" -Method PUT -Body $datosActualizar -ContentType "application/json"
    Write-Host "✅ Usuario actualizado. Nueva edad: $($usuarioActualizado.edad)" -ForegroundColor Green
    
    # 4. Buscar por nombre
    Write-Host "`n🔍 Buscando usuarios por nombre..." -ForegroundColor Yellow
    $resultadoBusqueda = Invoke-RestMethod -Uri "http://localhost:4000/api/usuarios/buscar?nombre=Juan" -Method GET
    Write-Host "Usuarios encontrados: $($resultadoBusqueda.Count)" -ForegroundColor Cyan
    
    # 5. Eliminar usuario de prueba
    Write-Host "`n🗑️ Eliminando usuario de prueba..." -ForegroundColor Yellow
    Invoke-RestMethod -Uri "http://localhost:4000/api/usuarios/$($usuarioCreado.id)" -Method DELETE
    Write-Host "✅ Usuario eliminado correctamente" -ForegroundColor Green
    
} catch {
    Write-Host "❌ Error: $($_.Exception.Message)" -ForegroundColor Red
}

Write-Host "`n🎉 Pruebas completadas!" -ForegroundColor Green
```

## 🌐 Accesos útiles

- **API Base**: http://localhost:4000/api/usuarios
- **Consola H2**: http://localhost:4000/h2-console
  - JDBC URL: `jdbc:h2:mem:testdb`
  - Usuario: `sa`
  - Contraseña: (vacía)
- **Actuator**: http://localhost:4000/actuator
- **Archivo de pruebas HTML**: file:///c:/Users/ruben/Desktop/Springboot/kanjis-springboot/test-api.html

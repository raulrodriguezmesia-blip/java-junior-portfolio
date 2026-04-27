# Java Junior Portfolio

Proyecto Mínimo Viable para desarrollador Java Junior. Aplicación de consola CRUD con persistencia en archivos y consumo de APIs REST.

---

## 📋 Descripción

Aplicación interactiva en consola que demuestra las competencias técnicas esenciales para un puesto Junior Java:

- **CRUD completo** en memoria con validaciones
- **Persistencia en archivos JSON** (sin base de datos)
- **Consumo de APIs REST** (JSONPlaceholder)
- **Tests unitarios** con JUnit 5 (>70% cobertura)
- **Limpieza de código** y separación de responsabilidades

---

## 🛠️ Tecnologías Utilizadas

| Herramienta | Versión | Propósito |
|-------------|---------|-----------|
| Java | 11+ | Lenguaje principal |
| Maven | 3.8+ | Gestión de dependencias y build |
| Jackson | 2.15.3 | Serialización/Deserialización JSON |
| JUnit 5 | 5.10.0 | Testing unitario |
| Java Util Logging | Built-in | Logging de aplicación |

---

## 📦 Estructura del Proyecto

```
src/main/java/com/raulrodriguez/portfolio/
├── Main.java                    # Punto de entrada (menú consola)
├── model/
│   ├── Usuario.java            # POJO con getters/setters
│   └── Producto.java           # POJO con getters/setters
├── service/
│   ├── UsuarioService.java     # Lógica de negocio CRUD
│   └── ApiService.java         # Consumo API REST externa
└── repository/
    └── ArchivoRepository.java  # Persistencia en JSON

src/test/java/com/raulrodriguez/portfolio/
└── service/
    └── UsuarioServiceTest.java  # Tests unitarios (8 tests)
```

---

## 🚀 Instalación y Ejecución

### Prerrequisitos
- JDK 11 o superior
- Maven 3.8+

### Compilar
```bash
mvn clean compile
```

### Ejecutar aplicación
```bash
mvn exec:java
```

### Ejecutar tests
```bash
mvn test
```

### Generar reporte de cobertura
```bash
mvn test jacoco:report
# Abrir: target/site/jacoco/index.html
```

---

## 📖 Uso de la Aplicación

### Menú principal:
1. **Listar todos** - Muestra todos los usuarios registrados
2. **Buscar por ID** - Recupera un usuario por su identificador
3. **Crear usuario** - Alta nueva con validación de datos
4. **Actualizar usuario** - Modifica campos existentes
5. **Eliminar usuario** - Borrado con confirmación
6. **Importar desde API** - Trae 1 usuario de JSONPlaceholder (ID 1-10)
7. **Importar todos desde API** - Trae los 10 usuarios de la API
8. **Salir** - Cierra la aplicación

### Características:
- ✅ Validación de email (formato básico)
- ✅ Validación de edad (1-120)
- ✅ Manejo de errores con try-catch
- ✅ Logging en consola (java.util.logging)
- ✅ Persistencia automática en `data/usuarios.json`

---

## 📊 Cobertura de Tests

| Clase | Tests | Cobertura Esperada |
|-------|-------|-------------------|
| UsuarioServiceTest | 8 | >80% |
| ArchivoRepositoryTest | (pendiente) | >70% |

Tests implementados:
- ✅ testListarVacio
- ✅ testCrearYBuscar
- ✅ testActualizar
- ✅ testEliminar
- ✅ testBuscarPorNombre
- ✅ testValidarEmailInvalido
- ✅ testValidarEdadNegativa
- ✅ testActualizarNoExistente
- ✅ testEliminarNoExistente

---

## 💾 Estructura de Datos

### Archivo JSON (`data/usuarios.json`)
```json
[
  {
    "id": 1,
    "nombre": "Juan Pérez",
    "email": "juan@email.com",
    "edad": 30
  }
]
```

### API Externa
- **Endpoint**: `https://jsonplaceholder.typicode.com/users/{id}`
- **Mapeo**: Se importan `id`, `name`, `email`. La edad se asigna por defecto (25).

---

## 🧪 Ejecución y Verificación

1. **Primera ejecución**:
   ```bash
   mvn clean compile
   mvn exec:java
   ```

2. **Crear un usuario**:
   - Opción 3
   - Nombre: `Raul Rodriguez`
   - Email: `raul@email.com`
   - Edad: `28`

3. **Verificar persistencia**:
   - Opción 1 (listar)
   - Verificar `data/usuarios.json` en el disco

4. **Importar desde API**:
   - Opción 6
   - ID: `1`
   - Verifica que se cree en la lista

5. **Ejecutar tests**:
   ```bash
   mvn test
   ```

---

## 📁 Archivos Generados

```
data/
└── usuarios.json      # Base de datos en JSON (generado automáticamente)
target/
├── classes/           # .class compilados
├── surefire-reports/  # Reportes de tests
└── site/
    └── jacoco/        # Reporte de cobertura
```

---

## 🎯 Objetivos de Aprendizaje

Este proyecto demuestra dominio de:
- [x] Sintaxis Java Core (variables, control, colecciones)
- [x] POO: encapsulación, herencia (básica), interfaces
- [x] Colecciones: `ArrayList`, `HashMap`, `Optional`
- [x] Manejo de excepciones: `try-catch`, validaciones
- [x] Entrada/Salida: `Scanner`, archivos JSON
- [x] Consumo APIs: `HttpClient`, parsing JSON con Jackson
- [x] Testing: JUnit 5, aserciones, fixtures
- [x] Maven: dependencias, ciclo de vida, plugins
- [x] Git: commits incremental, estructura limpia
- [x] Logging: `java.util.logging.Logger`

---

## 🐛 Problemas Comunes

| Síntoma | Causa | Solución |
|---------|-------|----------|
| `FileNotFoundException` | Directorio `data/` no existe | El código lo crea automáticamente |
| JSON parse error | Clase auxiliar mal definida | Verificar `JsonUsuario` en ApiService |
| Puerto en uso | No aplicable (consola) | N/A |
| Puerto en conflicto | No aplica | N/A |

---

## 🏆 Notas para el Revisor

- **Código limpio**: métodos < 30 líneas, nombres descriptivos
- **Separación de capas**: `model` (datos), `service` (lógica), `repository` (persistencia)
- **Responsabilidad única**: cada clase hace una cosa
- **Inyección de dependencias**: constructor (no `new` dentro de métodos)
- **Documentación**: Javadoc en clases públicas (pendiente por completar según estándar)
- **Commits**: propositivos, grano fino

---

## 📧 Contacto

**Raúl Rodríguez Mesía**
- GitHub: [@raulrodriguezmesia-blip](https://github.com/raulrodriguezmesia-blip)
- LinkedIn: [Raul Rodriguez Mesia](https://www.linkedin.com/in/raul-rodriguez-mesia-bb8178149)

---

*Proyecto desarrollado como parte de portafolio profesional para puesto Java Junior.*

# App Flutter Monorepo

Este es un monorepo que contiene una aplicación Flutter con un backend desarrollado en Java usando Spring Boot.

## Estructura del Proyecto

- `packages/backend/`: Backend de la aplicación desarrollado con Spring Boot, utilizando JPA, Security, Web y Mail. Conecta a una base de datos PostgreSQL.
- `packages/frontend/`: Aplicación frontend desarrollada con Flutter.
- `docker/`: Archivos relacionados con Docker.
- `scripts/`: Scripts de utilidad para el proyecto.
- `docker-compose.yml`: Configuración para ejecutar PostgreSQL en un contenedor Docker.
- `package.json`: Scripts de npm para gestionar el build, run y test de ambos paquetes.

## Prerrequisitos

Antes de comenzar, asegúrate de tener instalados los siguientes componentes:

- **Java 17**: Para el backend.
- **Maven**: Para gestionar dependencias del backend.
- **Flutter SDK**: Para el frontend.
- **Docker y Docker Compose**: Para ejecutar la base de datos PostgreSQL.
- **Node.js y npm**: Para ejecutar los scripts definidos en `package.json`.

## Instalación y Configuración

1. Clona el repositorio:
   ```bash
   git clone <url-del-repositorio>
   cd app_flutter_10_a
   ```

2. Instala las dependencias del backend:
   ```bash
   cd packages/backend
   ./mvnw install
   cd ../..
   ```

3. Instala las dependencias del frontend:
   ```bash
   cd packages/frontend
   flutter pub get
   cd ../..
   ```

4. Instala las dependencias de npm (para los scripts):
   ```bash
   npm install
   ```

5. Configura la base de datos:
   - Asegúrate de que Docker esté corriendo.
   - Ejecuta `docker-compose up -d` para iniciar PostgreSQL.

## Ejecutar la Aplicación

Para ejecutar tanto el backend como el frontend simultáneamente:
```bash
npm run
```

O ejecuta cada uno por separado:

- Backend:
  ```bash
  npm run run:backend
  ```

- Frontend:
  ```bash
  npm run run:frontend
  ```

## Construir la Aplicación

Para construir ambos paquetes:
```bash
npm run build
```

- Construir solo el backend:
  ```bash
  npm run build:backend
  ```

- Construir solo el frontend:
  ```bash
  npm run build:frontend
  ```

## Ejecutar Pruebas

Para ejecutar las pruebas de ambos paquetes:
```bash
npm run test
```

- Pruebas del backend:
  ```bash
  npm run test:backend
  ```

- Pruebas del frontend:
  ```bash
  npm run test:frontend
  ```

## Limpiar el Proyecto

Para limpiar los builds:
```bash
npm run clean
```

## Contribuyendo

1. Crea una rama para tu feature: `git checkout -b feature/nueva-funcionalidad`
2. Realiza tus cambios y commitea: `git commit -m 'Agrega nueva funcionalidad'`
3. Push a la rama: `git push origin feature/nueva-funcionalidad`
4. Abre un Pull Request.

## Licencia

Este proyecto está bajo la licencia [MIT](LICENSE). (Ajusta según corresponda)
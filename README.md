# AulaBot — Sistema de Gestión

Aplicación web de gestión académica de AulaBot construida con React 19, Vite y Tailwind CSS 4.
Consume la API REST del backend de AulaBot (Spring Boot) que corre en `http://localhost:8080`.

## Módulos

| Menú                 | Endpoint del backend | Operaciones                              |
| -------------------- | -------------------- | ---------------------------------------- |
| Dashboard            | (todos)              | Resumen con cifras y promedio de notas   |
| Programas            | `/programs`          | Listar, crear, editar, eliminar          |
| Periodos             | `/periods`           | Listar, crear, editar, eliminar          |
| Asignaturas          | `/subjects`          | Listar, crear, editar, eliminar          |
| Grupos               | `/groups`            | Listar, crear, editar, eliminar          |
| Carga académica      | `/group-subjects`    | Listar, crear, editar, eliminar          |
| Estudiantes          | `/students`          | Listar, crear, editar, eliminar          |
| Docentes             | `/teachers`          | Listar, crear, editar, eliminar          |
| Matrículas           | `/enrollments`       | Listar y crear (el backend no tiene PUT/DELETE) |
| Notas                | `/grades`            | Listar, crear, editar, eliminar          |
| Usuarios             | `/users`             | Listar, crear, editar, eliminar          |
| Roles                | `/roles`             | Listar, crear, editar, eliminar          |
| Asignación de roles  | `/user-roles`        | Listar, asignar y quitar                 |

Los formularios muestran los registros relacionados por nombre (por ejemplo, el
programa de una asignatura se elige de una lista) y los errores de validación del
backend aparecen dentro del mismo formulario.

## Conexión con el backend

El backend no envía cabeceras CORS, así que en desarrollo Vite reenvía las
peticiones de `/api/*` a `http://localhost:8080/*` (ver `vite.config.js`).
Para apuntar a otro servidor se puede definir `VITE_API_URL` en un archivo `.env`.

## Estructura

```
src/
├── App.jsx                     Navegación entre módulos
├── api/cliente.js              Cliente HTTP (fetch) y manejo de errores del backend
├── hooks/useDatos.js           Carga y recarga de las colecciones del backend
├── utils/etiquetas.js          Nombres de registros relacionados, opciones de selects y fechas
├── layout/MainLayout.jsx       Sidebar + header con estado de conexión
├── components/
│   ├── NavMenu.jsx             Menú lateral agrupado por secciones
│   ├── StatCard.jsx            Tarjeta de estadística del Dashboard
│   ├── Badge.jsx               Etiqueta de color para los estados
│   ├── DataTable.jsx           Tabla con búsqueda, botón Nuevo y acciones por fila
│   ├── FormularioModal.jsx     Formulario modal de creación y edición
│   └── ModuloCrud.jsx          Página genérica conectada a un recurso del backend
└── pages/                      Una página por módulo (columnas y campos de cada recurso)
```

## Cómo ejecutarlo

1. Levantar el backend en el puerto 8080.
2. Instalar dependencias y arrancar el frontend:

```bash
npm install
npm run dev
```

Otros comandos:

```bash
npm run build     # compila para producción
npm run lint      # revisa el código con ESLint
npm run preview   # sirve la versión compilada
```

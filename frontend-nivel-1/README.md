# 🔐 Sistema de Inicio de Sesión en JavaScript

Este proyecto es un sistema básico de inicio de sesión desarrollado en JavaScript.
Permite al usuario ingresar un nombre de usuario y contraseña, con un máximo de 3 intentos.

---

## 📌 Credenciales de acceso

* **Usuario:** `sergio`
* **Contraseña:** `1111`

---

## 🚀 ¿Cómo ejecutar el proyecto?

⚠️ Este código funciona únicamente en el navegador, ya que utiliza `prompt()` y `alert()`.

### 1️⃣ Crear un archivo HTML

Crea un archivo llamado `index.html` en la misma carpeta del archivo `login.js` con el siguiente contenido:

```html
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Inicio de Sesión</title>
</head>
<body>

<script src="login.js"></script>

</body>
</html>
```

---

### 2️⃣ Ejecutar el proyecto

No uses:

```
node login.js
```

En su lugar:

* Abre el archivo `index.html` con doble clic
  **o**
* Usa la extensión **Live Server** en VS Code

---

## 🛠️ ¿Cómo funciona el programa?

* El usuario tiene un máximo de **3 intentos**.
* Si las credenciales son correctas:

  * Se muestra un mensaje de bienvenida.
* Si son incorrectas:

  * Se informa cuántos intentos restantes quedan.
* Después de 3 intentos fallidos:

  * El acceso se bloquea.

---

## 📂 Estructura del proyecto

```
/proyecto
│
├── index.html
├── login.js
└── README.md
```

---

## 📚 Tecnologías utilizadas

* HTML5
* JavaScript (Vanilla JS)

---

## 👨‍💻 Autor

Proyecto Integrador - Nivel 1 Frontend

---

## 🔎 Nota importante

Este sistema es únicamente educativo.
No debe usarse en producción ya que las credenciales están visibles en el código.

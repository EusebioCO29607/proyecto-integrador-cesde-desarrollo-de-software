// app.js - NotApp - Tercer Momento
// Se usa fetch() para cargar los usuarios iniciales desde usuarios.json


    const nombre = document.getElementById("nombre").value.trim();
    const email = document.getElementById("emailReg").value.trim().toLowerCase();
    const password = document.getElementById("passwordReg").value;
    const errorMsg = document.getElementById("registroError");
    const exitoMsg = document.getElementById("registroExito");

    const email = document.getElementById("email").value.trim().toLowerCase();
    const password = document.getElementById("password").value;
    const errorMsg = document.getElementById("loginError");

// Variable global donde se guardan los usuarios cargados
const usuarios = [];

// Función que carga los usuarios desde el archivo JSON usando fetch
function cargarUsuarios() {
  fetch("usuarios.json")
    .then(function(respuesta) {
      return respuesta.json();
    })
    .then(function(datos) {
      // Guardamos los datos en la variable global
      usuarios = datos;

      // Si estamos en la landing (index.html), mostramos los usuarios en pantalla
      const lista = document.getElementById("listaUsuarios");
      if (lista) {
        // Quitamos el texto "Cargando..."
        const parrafo = document.querySelector(".landing-users p");
        if (parrafo) {
          parrafo.style.display = "none";
        }

        // Recorremos los usuarios y los mostramos en el DOM
        for (const usuario of usuarios) {
          const li = document.createElement("li");
          li.innerHTML = "<strong>" + usuario.nombre + "</strong> - " + usuario.email + " (" + usuario.rol + ")";
          lista.appendChild(li);
        }
      }
    })
    .catch(function(error) {
      console.log("Error al cargar usuarios.json: " + error);
    });
}

// Llamamos la función al cargar la página
cargarUsuarios();


// =============================================
// LOGICA DE LOGIN
// =============================================
var loginForm = document.getElementById("loginForm");

if (loginForm) {
  var intentosFallidos = 0;
  var MAX_INTENTOS = 3;

  loginForm.addEventListener("submit", function(e) {
    e.preventDefault();

    if (intentosFallidos >= MAX_INTENTOS) return;

    errorMsg.classList.remove("visible");

    // Buscamos el usuario en el arreglo cargado desde JSON
    let usuarioEncontrado = null;
    for (const usuario of usuarios) {
      if (usuario.email === email && usuario.password === password) {
        usuarioEncontrado = usuario;
        break;
      }
    }

    if (usuarioEncontrado) {
      // Guardamos la sesion en localStorage
      localStorage.setItem("notapp_user", JSON.stringify({
        nombre: usuarioEncontrado.nombre,
        email: usuarioEncontrado.email,
        rol: usuarioEncontrado.rol
      }));
      alert("Bienvenido, " + usuarioEncontrado.nombre + "!");
      // En un proyecto real aqui iria: window.location.href = "dashboard.html";
    } else {
      intentosFallidos++;
      const restantes = MAX_INTENTOS - intentosFallidos;

      if (restantes > 0) {
        errorMsg.innerHTML = "Correo o contraseña incorrectos. Le quedan " + restantes + " intento(s).";
      } else {
        errorMsg.innerHTML = "Correo o contraseña incorrectos. Usuario bloqueado.";
      }

      errorMsg.classList.add("visible");
      document.getElementById("password").value = "";
    }
  });
}


// =============================================
// LOGICA DE REGISTRO (CREAR usuario - CRUD)
// =============================================
const registroForm = document.getElementById("registroForm");

if (registroForm) {
  registroForm.addEventListener("submit", function(e) {
    e.preventDefault();



    errorMsg.classList.remove("visible");
    exitoMsg.style.display = "none";

    // Validacion basica
    if (nombre === "" || email === "" || password === "") {
      errorMsg.classList.add("visible");
      return;
    }

    // Verificamos que el correo no exista ya
    for (const usuario of usuarios) {
      if (usuario.email === email) {
        errorMsg.innerHTML = "Ese correo ya está registrado.";
        errorMsg.classList.add("visible");
        return;
      }
    }

    // Creamos el nuevo usuario
    const nuevoUsuario = {
      id: usuarios.length + 1,
      nombre: nombre,
      email: email,
      password: password,
      rol: "estudiante"
    };

    // Lo agregamos al arreglo (CRUD - CREATE)
    usuarios.push(nuevoUsuario);

    // Mostramos mensaje de exito
    exitoMsg.style.display = "block";

    // Limpiamos el formulario
    registroForm.reset();
  });
}

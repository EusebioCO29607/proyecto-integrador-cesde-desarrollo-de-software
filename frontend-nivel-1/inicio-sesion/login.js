//const Usuario_Correcto = "sergio"; //Modelo momento 1
//const Clave_Correcta = "1111"; //Modelo momento 1

const USERS = [
    { email: "sergio@notapp.com", password: "1111", name: "Sergio", role: "admin" }
]
// Selección de elementos del DOM
const loginForm = document.getElementById('loginForm');
const errorMsg  = document.getElementById('loginError');

// Número máximo de intentos permitidos antes de bloquear
const MAX_INTENTOS = 3;

// Contador de intentos fallidos en la sesión actual
let intentosFallidos = 0;

// Escucha el evento submit del formulario
loginForm.addEventListener('submit', function (e) {
  // Previene el comportamiento por defecto del formulario (recargar la página)
  e.preventDefault();

  // Si ya se alcanzó el límite de intentos, no ejecutar nada más
  if (intentosFallidos >= MAX_INTENTOS) return;

  // Captura y normaliza los valores ingresados por el usuario
  const email    = document.getElementById('email').value.trim().toLowerCase();
  const password = document.getElementById('password').value;

  // Oculta el mensaje de error antes de cada intento
  errorMsg.classList.remove('visible');

  // Busca en el arreglo un usuario que coincida con las credenciales ingresadas
  const user = USERS.find(u => u.email === email && u.password === password);

  if (user) {
    // Si las credenciales son correctas, guarda la sesión en localStorage
    localStorage.setItem('notapp_user', JSON.stringify({ name: user.name, email: user.email, role: user.role }));
    // Redirige al dashboard
    window.location.href = 'dashboard.html';
  } else {
    // Incrementa el contador de intentos fallidos
    intentosFallidos++;

    // Calcula cuántos intentos le quedan al usuario
    const restantes = MAX_INTENTOS - intentosFallidos;

    if (restantes > 0) {
      // Muestra el mensaje de error con el conteo de intentos restantes
      // El operador ternario ajusta "intento/intentos" según la cantidad
      errorMsg.innerHTML = `Correo o contraseña incorrectos. Intente de nuevo.<br>(${restantes} intento${restantes > 1 ? 's' : ''} restante${restantes > 1 ? 's' : ''}.)`; 
    } else {
      // Si se agotaron los intentos, muestra el mensaje de bloqueo
      errorMsg.innerHTML = `Correo o contraseña incorrectos. Intente de nuevo.<br>(Usuario bloqueado.)`;

      // Bloqueo del formulario (deshabilitado temporalmente)
    //   document.getElementById('email').disabled    = true;
    //   document.getElementById('password').disabled = true;
    //   document.querySelector('.login-btn').disabled = true;
    //   document.querySelector('.login-btn').style.opacity = '0.5';
    }

    // Hace visible el mensaje de error en pantalla
    errorMsg.classList.add('visible');

    // Referencia al campo de contraseña para resaltarlo
    const pwField = document.getElementById('password');

    // Cambia el borde del campo a rojo para indicar el error
    pwField.style.borderColor = '#cc3333';

    // Limpia el campo de contraseña para que el usuario reintente
    pwField.value = '';

    // Solo enfoca el campo si aún quedan intentos disponibles
    if (restantes > 0) pwField.focus();

    // Restaura el color del borde después de 2 segundos
    setTimeout(() => { pwField.style.borderColor = ''; }, 2000);
  }
});
/*
function iniciarSesion() {
    let intentos = 0;
    const MaximoIntentos = 3;

    while (intentos < MaximoIntentos) {
        
        let user = prompt("Digite su usuario: ");
        let pass = prompt("Digite su contraseña: ");

        alert(`Intento ${intentos + 1}: Usuario digitado: "${user}"`);

        if (user == Usuario_Correcto && pass == Clave_Correcta) {

            alert("Ingreso exitoso. Bienvenido!");
            intentos = 3; 

        } else{

            intentos++;
            let restantes =  MaximoIntentos - intentos;
            
            if (restantes > 0) {
                alert(`Datos incorrectos. Te quedan ${restantes} intentos.`);
            }

            else {
                alert("Has agotado tus intentos. Acceso bloqueado.");
            }

        }

    }

}

iniciarSesion();
*/
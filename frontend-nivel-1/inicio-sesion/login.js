//const Usuario_Correcto = "sergio"; //Modelo momento 1
//const Clave_Correcta = "1111"; //Modelo momento 1

const USERS = [
    { email: "sergio@notapp.com", password: "1111", name: "Sergio", role: "admin" }
]

const loginForm = document.getElementById('loginForm');
const errorMsg  = document.getElementById('loginError');

const MAX_INTENTOS = 3;
let intentosFallidos = 0;

loginForm.addEventListener('submit', function (e) {
  e.preventDefault();

  // Si ya está bloqueado, no hacer nada
  if (intentosFallidos >= MAX_INTENTOS) return;

  const email    = document.getElementById('email').value.trim().toLowerCase();
  const password = document.getElementById('password').value;

  errorMsg.classList.remove('visible');

  const user = USERS.find(u => u.email === email && u.password === password);

  if (user) {
    localStorage.setItem('notapp_user', JSON.stringify({ name: user.name, email: user.email, role: user.role }));
    window.location.href = 'dashboard.html';
  } else {
    intentosFallidos++;
    const restantes = MAX_INTENTOS - intentosFallidos;

    if (restantes > 0) {
      errorMsg.innerHTML = `Correo o contraseña incorrectos. Intente de nuevo.<br>(${restantes} intento${restantes > 1 ? 's' : ''} restante${restantes > 1 ? 's' : ''}.)`; 
    } else {
      errorMsg.innerHTML = `Correo o contraseña incorrectos. Intente de nuevo.<br>(Usuario bloqueado.)`;
      // Deshabilitar el formulario
    //   document.getElementById('email').disabled    = true;
    //   document.getElementById('password').disabled = true;
    //   document.querySelector('.login-btn').disabled = true;
    //   document.querySelector('.login-btn').style.opacity = '0.5';
    }

    errorMsg.classList.add('visible');

    const pwField = document.getElementById('password');
    pwField.style.borderColor = '#cc3333';
    pwField.value = '';
    if (restantes > 0) pwField.focus();
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
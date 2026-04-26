//const Usuario_Correcto = "sergio"; //Modelo momento 1
//const Clave_Correcta = "1111"; //Modelo momento 1

const USERS = [
    { email: "sergio@notapp.com", password: "1111", name: "Sergio", role: "admin" }
]

const loginForm  = document.getElementById('loginForm'); //Usado en el archivo login.html
const errorMsg   = document.getElementById('loginError');

loginForm.addEventListener('submit', function (e) {
    e.preventDefault();
   
    const email    = document.getElementById('email').value.trim().toLowerCase();
    const password = document.getElementById('password').value;
   
    // Ocultar error previo
    errorMsg.classList.remove('visible');
   
    const user = USERS.find(u => u.email === email && u.password === password);
   
    if (user) {
      // Guardar sesión en localStorage
      localStorage.setItem('notapp_user', JSON.stringify({ name: user.name, email: user.email, role: user.role }));
      // Redirigir al dashboard
      window.location.href = 'dashboard.html';
    } else {
      errorMsg.classList.add('visible');
      // Vibrar el campo de contraseña
      const pwField = document.getElementById('password');
      pwField.style.borderColor = '#cc3333';
      pwField.value = '';
      pwField.focus();
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
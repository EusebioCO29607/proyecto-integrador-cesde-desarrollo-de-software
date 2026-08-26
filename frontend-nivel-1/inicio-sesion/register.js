// Elementos del DOM
const registerForm    = document.getElementById('registerForm');
const errorMsg        = document.getElementById('registerError');
const successMsg      = document.getElementById('registerSuccess');

// Carga los usuarios guardados en localStorage
function loadUsers() {
  const raw = localStorage.getItem('notapp_registered_users');
  return raw ? JSON.parse(raw) : [];
}

// Guarda el arreglo de usuarios actualizado
function saveUsers(users) {
  localStorage.setItem('notapp_registered_users', JSON.stringify(users));
}

function showError(msg) {
  errorMsg.textContent = msg;
  errorMsg.style.display = 'block';
  successMsg.style.display = 'none';
}

function showSuccess(msg) {
  successMsg.textContent = msg;
  successMsg.style.display = 'block';
  errorMsg.style.display = 'none';
}

registerForm.addEventListener('submit', function (e) {
  e.preventDefault();

  // Captura los valores del formulario
  const fullName        = document.getElementById('fullName').value.trim();
  const email           = document.getElementById('email').value.trim().toLowerCase();
  const role            = document.getElementById('role').value;
  const password        = document.getElementById('password').value;
  const confirmPassword = document.getElementById('confirmPassword').value;

  // Oculta mensajes previos
  errorMsg.style.display   = 'none';
  successMsg.style.display = 'none';

  // Validaciones
  if (!fullName) {
    showError('El nombre completo es obligatorio.');
    return;
  }

  if (!role) {
    showError('Seleccione un rol.');
    return;
  }

  if (password.length < 4) {
    showError('La contraseña debe tener al menos 4 caracteres.');
    return;
  }

  if (password !== confirmPassword) {
    showError('Las contraseñas no coinciden.');
    document.getElementById('confirmPassword').style.borderColor = '#cc3333';
    setTimeout(() => {
      document.getElementById('confirmPassword').style.borderColor = '';
    }, 2000);
    return;
  }

  // Verifica que el correo no esté ya registrado
  const users = loadUsers();
  const existe = users.find(u => u.email === email);
  if (existe) {
    showError('Ya existe una cuenta con ese correo electrónico.');
    return;
  }

  // Crea y guarda el nuevo usuario
  const nuevoUsuario = { email, password, name: fullName, role };
  users.push(nuevoUsuario);
  saveUsers(users);

  // Confirma en consola
  console.log('Usuarios guardados:', loadUsers());

  // Muestra éxito y redirige
  showSuccess('✅ Cuenta creada correctamente. Redirigiendo al login…');
  registerForm.reset();

  setTimeout(() => {
    window.location.href = 'login.html';
  }, 2000);
});
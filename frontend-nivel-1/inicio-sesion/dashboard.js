// Recupera el usuario de la sesión
const user = requireAuth();

// Solo muestra el botón si el rol es admin
if (user.role === 'admin') {
  const header = document.querySelector('.sidebar-footer');

  const btnUsuarios = document.createElement('a');
  btnUsuarios.className = 'btn-primary';
  btnUsuarios.innerHTML = '<span class = "icon">👥</span>Gestionar usuarios';
  btnUsuarios.addEventListener('click', () => {
    window.location.href = 'usuarios.html';
  });

  header.appendChild(btnUsuarios);
}
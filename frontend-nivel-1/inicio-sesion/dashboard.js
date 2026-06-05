// Recupera el usuario de la sesión
function requireAuth() {
  const user = localStorage.getItem('notapp_user');
  if (!user) {
    window.location.href = 'index.html';
    return null;
  }
  return JSON.parse(user);
}

const user = requireAuth();

// Solo muestra el botón si el rol es admin
if (user.role === 'admin') {
  const header = document.querySelector('.sidebar-footer');

  const btnUsuarios = document.createElement('a');
  btnUsuarios.innerHTML = '<span class = "icon">👥</span>Gestionar usuarios';
  btnUsuarios.addEventListener('click', () => {
    window.location.href = 'users.html';
  });

  header.appendChild(btnUsuarios);
}

document.getElementById('btnLogout').addEventListener('click', function() {
  localStorage.removeItem('notapp_user');
  window.location.href = 'login.html';
});
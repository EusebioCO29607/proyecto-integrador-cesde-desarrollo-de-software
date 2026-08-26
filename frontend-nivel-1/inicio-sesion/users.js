// Elementos del DOM
const tbody      = document.getElementById('usersBody');
const emptyState = document.getElementById('emptyUsers');
const searchInput = document.getElementById('searchInput');

// Clave del localStorage
const USERS_KEY = 'notapp_registered_users';

// Variable para el término de búsqueda
let searchTerm = '';

// Carga los usuarios desde localStorage
function loadUsers() {
  const raw = localStorage.getItem(USERS_KEY);
  return raw ? JSON.parse(raw) : [];
}

// Guarda los usuarios en localStorage
function saveUsers(users) {
  localStorage.setItem(USERS_KEY, JSON.stringify(users));
}

// Traduce el rol a español
function translateRole(role) {
  const roles = {
    admin:   'Administrador',
    teacher: 'Formador',
    student: 'Estudiante'
  };
  return roles[role] || role;
}

// Renderiza la tabla
function render() {
  let users = loadUsers();

  // Filtro de búsqueda
  if (searchTerm) {
    const q = searchTerm.toLowerCase();
    users = users.filter(u =>
      u.name.toLowerCase().includes(q) ||
      u.email.toLowerCase().includes(q)
    );
  }

  // Limpia el tbody
  tbody.innerHTML = '';

  // Muestra estado vacío si no hay usuarios
  if (users.length === 0) {
    emptyState.style.display = 'block';
    return;
  }
  emptyState.style.display = 'none';

  // Crea una fila por cada usuario
  users.forEach((u, idx) => {
    const tr = document.createElement('tr');
    tr.innerHTML = `
      <td>${idx + 1}</td>
      <td class="name-cell">${u.name}</td>
      <td>${u.email}</td>
      <td>
        <span class="badge ${u.role === 'admin' ? 'active' : 'group-b'}">
          ${translateRole(u.role)}
        </span>
      </td>
      <td>
        <button class="btn-icon delete" data-email="${u.email}" title="Eliminar">🗑️</button>
      </td>
    `;
    tbody.appendChild(tr);
  });

  // Evento eliminar por cada botón
  tbody.querySelectorAll('.btn-icon.delete').forEach(btn => {
    btn.addEventListener('click', function () {
      const email = this.dataset.email;

      if (!confirm(`¿Eliminar al usuario ${email}?`)) return;

      let users = loadUsers();
      users = users.filter(u => u.email !== email);
      saveUsers(users);
      render();
    });
  });
}

// Búsqueda en tiempo real
searchInput.addEventListener('input', function () {
  searchTerm = this.value;
  render();
});

// Render inicial
render();
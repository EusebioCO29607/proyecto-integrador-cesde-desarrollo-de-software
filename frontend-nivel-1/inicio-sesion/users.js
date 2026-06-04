(function () {
    // Verifica que haya sesión activa y que sea admin
    const user = requireAuth();
    if (!user) return;
    if (user.role !== 'admin') {
      window.location.href = 'dashboard.html';
      return;
    }
  
    renderSidebar('dashboard');
  
    const USERS_KEY = 'notapp_registered_users';
    const tbody      = document.getElementById('usersBody');
    const emptyState = document.getElementById('emptyUsers');
    let searchTerm   = '';
  
    function loadUsers() {
      return JSON.parse(localStorage.getItem(USERS_KEY)) || [];
    }
  
    function render() {
      let users = loadUsers();
  
      if (searchTerm) {
        const q = searchTerm.toLowerCase();
        users = users.filter(u =>
          u.name.toLowerCase().includes(q) ||
          u.email.toLowerCase().includes(q)
        );
      }
  
      tbody.innerHTML = '';
  
      if (users.length === 0) {
        emptyState.style.display = 'block';
        return;
      }
      emptyState.style.display = 'none';
  
      users.forEach((u, idx) => {
        const tr = document.createElement('tr');
        tr.innerHTML = `
          <td>${idx + 1}</td>
          <td class="name-cell">${u.name}</td>
          <td>${u.email}</td>
          <td>
            <span class="badge ${u.role === 'admin' ? 'active' : 'group-b'}">
              ${u.role === 'admin' ? 'Administrador' : 'Formador'}
            </span>
          </td>
          <td>
            <button class="btn-icon delete" data-email="${u.email}" title="Eliminar">🗑️</button>
          </td>
        `;
        tbody.appendChild(tr);
      });
  
      // Evento eliminar
      tbody.querySelectorAll('.btn-icon.delete').forEach(btn => {
        btn.addEventListener('click', function () {
          const email = this.dataset.email;
  
          // Impedir que el admin se elimine a sí mismo
          if (email === user.email) {
            showToast('No puedes eliminar tu propia cuenta.', 'error');
            return;
          }
  
          if (!confirm(`¿Eliminar al usuario ${email}?`)) return;
  
          let users = loadUsers();
          users = users.filter(u => u.email !== email);
          localStorage.setItem(USERS_KEY, JSON.stringify(users));
          showToast('🗑️ Usuario eliminado', 'error');
          render();
        });
      });
    }
  
    document.getElementById('searchInput').addEventListener('input', function () {
      searchTerm = this.value;
      render();
    });
  
    render();
  })();
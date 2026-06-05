const USERS = JSON.parse(localStorage.getItem('notapp_registered_users')) || [
    { email: 'sergio@notapp.com', password: '1111', name: 'Sergio', role: 'admin' }
  ];
  
  const loginForm = document.getElementById('loginForm');
  const errorMsg  = document.getElementById('loginError');
  
  const MAX_INTENTOS = 3;
  let intentosFallidos = 0;
  
  loginForm.addEventListener('submit', function (e) {
    e.preventDefault();
  
    if (intentosFallidos >= MAX_INTENTOS) return;
  
    const email    = document.getElementById('email').value.trim().toLowerCase();
    const password = document.getElementById('password').value;
    const role     = document.getElementById('role').value;
  
    errorMsg.style.display = 'none';
  
    // Validar que se haya seleccionado un rol
    if (!role) {
      errorMsg.innerHTML = 'Por favor seleccione un tipo de rol.';
      errorMsg.style.display = 'block';
      return;
    }
  
    // Busca usuario que coincida con email, password Y rol
    const user = USERS.find(u =>
      u.email === email &&
      u.password === password &&
      u.role === role
    );
  
    if (user) {
      localStorage.setItem('notapp_user', JSON.stringify({
        name: user.name,
        email: user.email,
        role: user.role
      }));
      // Todos van al dashboard
      window.location.href = 'dashboard.html';

    } else {
      intentosFallidos++;
      const restantes = MAX_INTENTOS - intentosFallidos;
      console.log(restantes);
      if (restantes > 0) {
        errorMsg.innerHTML = `Correo, contraseña o rol incorrectos. Intente de nuevo.<br>
          (${restantes} intento${restantes > 1 ? 's' : ''} restante${restantes > 1 ? 's' : ''}.)`;
      } else {
        errorMsg.innerHTML = `Correo, contraseña o rol incorrectos. Intente de nuevo.<br>
          (Usuario bloqueado.)`;
        document.getElementById('email').disabled    = true;
        document.getElementById('password').disabled = true;
        document.getElementById('role').disabled     = true;
        document.querySelector('.login-btn').disabled = true;
        document.querySelector('.login-btn').style.opacity = '0.5';
      }
  
      errorMsg.style.display = 'block';
  
      const pwField = document.getElementById('password');
      pwField.style.borderColor = '#cc3333';
      pwField.value = '';
      if (restantes > 0) pwField.focus();
      setTimeout(() => { pwField.style.borderColor = ''; }, 2000);
    }
  });

// --- 1. SELECTORES ---
const form = document.querySelector('#form-usuarios');
const inputNombre = document.querySelector('#input-nombre');
const selecRol = document.getElementById('selec-rol');
const contenedor = document.querySelector('#contenedor-lista');

// --- 2. PERSISTENCIA CON LOCALSTORAGE ---
// Intentamos cargar datos previos, si no, empezamos con lista vacía
let usuarios = JSON.parse(localStorage.getItem('usuarios_app')) || [];

// --- 3. FUNCIONES DE MANIPULACIÓN DEL DOM ---

const actualizarInterfaz = () => {
    contenedor.innerHTML = ''; // Limpiamos para redibujar

    usuarios.forEach((user) => {
        // Crear elemento dinámicamente
        const card = document.createElement('div');
        card.style.border = "1px solid #ccc";
        card.style.margin = "10px 0";
        card.style.padding = "10px";

        card.innerHTML = `
            <p><strong>Nombre:</strong> ${user.nombre} | <strong>Rol:</strong> ${user.rol}</p>
            <button onclick="editarUsuario(${user.id})">Editar</button>
            <button onclick="eliminarUsuario(${user.id})">Eliminar</button>
        `;
        contenedor.appendChild(card);
    });

    // Guardar cambios en LocalStorage
    localStorage.setItem('usuarios_app', JSON.stringify(usuarios));
};

// --- 4. OPERACIONES CRUD ---

// Crear (Create)
form.addEventListener('submit', (e) => {
    e.preventDefault();

    if (!inputNombre.value || !selecRol.value) {
        alert("Por favor completa todos los campos");
        return;
    }

    const nuevoUsuario = {
        id: Date.now(),
        nombre: inputNombre.value,
        rol: selecRol.options[selecRol.selectedIndex].value  
    };

    usuarios.push(nuevoUsuario);
    form.reset();
    actualizarInterfaz();
});


// Eliminar (Delete)
window.eliminarUsuario = (id) => {
    usuarios = usuarios.filter(u => u.id !== id);
    actualizarInterfaz();
};

// Editar (Update)
window.editarUsuario = (id) => {
    const user = usuarios.find(u => u.id === id);
    const nuevoNombre = prompt("Nuevo nombre:", user.nombre);
    if (nuevoNombre) {
        user.nombre = nuevoNombre;
        actualizarInterfaz();
    }
};

// --- 5. VALIDACIÓN DE ACCESO (Simulada) ---
// El documento pide validación desde el login inicial
const checkAccess = () => {
    // Aquí podrías verificar si hay un token o usuario logueado en localStorage
    const session = localStorage.getItem('user_session');
    if(!session) {
        console.warn("No hay sesión activa. Redirigiendo...");
        // window.location.href = "login.html"; // Descomenta esto para forzar login
    }
};

// Inicializar
checkAccess();
actualizarInterfaz();
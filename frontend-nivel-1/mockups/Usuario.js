
const form = document.querySelector('#form-usuarios');
const inputNombre = document.querySelector('#input-nombre');
const selecRol = document.getElementById('selec-rol');
const contenedor = document.querySelector('#contenedor-lista');


let usuarios = JSON.parse(localStorage.getItem('usuarios_app')) || [];



const actualizarInterfaz = () => {
    contenedor.innerHTML = ''; 

    usuarios.forEach((user) => {
        
        const stylesx = document.createElement('div');
        stylesx.style.border = "1px solid #ccc";
        stylesx.style.margin = "10px 0";
        stylesx.style.padding = "10px";

        stylesx.innerHTML = `
            <p><strong>Nombre:</strong> ${user.nombre} | <strong>Rol:</strong> ${user.rol}</p>
            <button onclick="editarUsuario(${user.id})">Editar</button>
            <button onclick="eliminarUsuario(${user.id})">Eliminar</button>
        `;
        contenedor.appendChild(stylesx);
    });

    localStorage.setItem('usuarios_app', JSON.stringify(usuarios));
};


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



window.eliminarUsuario = (id) => {
    usuarios = usuarios.filter(u => u.id !== id);
    actualizarInterfaz();
};


window.editarUsuario = (id) => {
    const user = usuarios.find(u => u.id === id);
    const nuevoNombre = prompt("Nuevo nombre:", user.nombre);
    if (nuevoNombre) {
        user.nombre = nuevoNombre;
        actualizarInterfaz();
    }
};

const checkAccess = () => {
   
    const session = localStorage.getItem('user_session');
    if(!session) {
        console.warn("No hay sesión activa. Redirigiendo...");
      
    }
};


checkAccess();
actualizarInterfaz();
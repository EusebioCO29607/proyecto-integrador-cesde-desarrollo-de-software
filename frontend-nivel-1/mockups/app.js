let estudiantes = [
    { id: 1, nombre: "Alejandro Garcia", email: "alejandro.garcia@email.com", grupo: "Grupo A", asistencia: 95, estado: "Activo" },
    { id: 2, nombre: "Carlos Martinez", email: "carlos.martinez@email.com", grupo: "Grupo B", asistencia: 88, estado: "Activo" },
    { id: 3, nombre: "Maria Lopez", email: "maria.lopez@email.com", grupo: "Grupo A", asistencia: 92, estado: "Activo" },
    { id: 4, nombre: "Laura Torres", email: "laura.torres@email.com", grupo: "Grupo A", asistencia: 78, estado: "Activo" },
    { id: 5, nombre: "Sofia Herrera", email: "sofia.herrera@email.com", grupo: "Grupo A", asistencia: 97, estado: "Activo" }
];

let profesores = [
    { id: 1, nombre: "Alejandro Garcia", iniciales: "AG", materia: "Matematicas", email: "a.garcia@notapp.com" },
    { id: 2, nombre: "Carmen Martinez", iniciales: "CM", materia: "Ciencias Naturales", email: "c.martinez@notapp.com" },
    { id: 3, nombre: "Jose Lopez", iniciales: "JL", materia: "Historia", email: "j.lopez@notapp.com" },
    { id: 4, nombre: "Laura Torres", iniciales: "LT", materia: "Literatura", email: "l.torres@notapp.com" },
    { id: 5, nombre: "Roberto Fernandez", iniciales: "RF", materia: "Fisica", email: "r.fernandez@notapp.com" },
    { id: 6, nombre: "Patricia Sanchez", iniciales: "PS", materia: "Ingles", email: "p.sanchez@notapp.com" }
];

let notas = [
    { id: 1, estudianteId: 1, matematicas: 4.5, ciencias: 4.0, historia: 3.8, literatura: 4.2 },
    { id: 2, estudianteId: 2, matematicas: 3.5, ciencias: 4.2, historia: 4.0, literatura: 3.8 },
    { id: 3, estudianteId: 3, matematicas: 4.8, ciencias: 4.5, historia: 4.2, literatura: 4.7 },
    { id: 4, estudianteId: 4, matematicas: 3.2, ciencias: 3.5, historia: 4.0, literatura: 4.5 },
    { id: 5, estudianteId: 5, matematicas: 4.2, ciencias: 4.1, historia: 4.3, literatura: 4.4 }
];


const estudianeTableBody = document.getElementById('students-table-body');
const notesTableBody = document.getElementById('notes-table-body');
const teacherGrid = document.querySelector('.teacher-grid');
const searchInputs = document.querySelectorAll('.search-box input');
const btnPrimary = document.querySelectorAll('.btn-primary');


function calcularPromedio(notasEstudiante) {
    if (!notasEstudiante) return 0;
    const suma = notasEstudiante.matematicas + notasEstudiante.ciencias + 
                 notasEstudiante.historia + notasEstudiante.literatura;
    return (suma / 4).toFixed(1);
}

function obtenerEstudiante(id) {
    return estudiantes.find(e => e.id === id);
}

function generarId(array) {
    return array.length > 0 ? Math.max(...array.map(item => item.id)) + 1 : 1;
}

function agregarEstudiante(nuevoEstudiante) {
    const id = generarId(estudiantes);
    const estudiante = {
        id: id,
        nombre: nuevoEstudiante.nombre || "Nuevo Estudiante",
        email: nuevoEstudiante.email || "nuevo@email.com",
        grupo: nuevoEstudiante.grupo || "Grupo A",
        asistencia: nuevoEstudiante.asistencia || 100,
        estado: nuevoEstudiante.estado || "Activo"
    };
    estudiantes.push(estudiante);
    return estudiante;
}

function mostrarEstudiantes(lista = estudiantes) {
    if (!estudianeTableBody) return; 
    
    
    estudianeTableBody.innerHTML = '';
    
    lista.forEach(est => {
        const tr = document.createElement('tr');
        tr.innerHTML = `
            <td class="name-cell">${est.nombre}</td>
            <td>${est.email}</td>
            <td><span class="badge ${est.grupo === 'Grupo A' ? 'group-a' : 'group-b'}">${est.grupo}</span></td>
            <td>${est.asistencia}%</td>
            <td><span class="badge ${est.estado === 'Activo' ? 'active' : 'inactive'}">${est.estado}</span></td>
            <td style="text-align: center;">
                <button class="btn-edit" onclick="editarEstudiante(${est.id})" title="Editar">✏️</button>
                <button class="btn-delete" onclick="eliminarEstudiante(${est.id})" title="Eliminar">🗑️</button>
            </td>
        `;
        estudianeTableBody.appendChild(tr);
    });
    
    const subtitle = document.querySelector('.page-header .subtitle');
    if (subtitle && subtitle.textContent.includes('estudiante')) {
        subtitle.textContent = `${lista.length} estudiantes inscritos`;
    }
}

function editarEstudiante(id) {
    const estudiante = obtenerEstudiante(id);
    if (!estudiante) return;
    
    const nuevoNombre = prompt('Editar nombre:', estudiante.nombre);
    if (nuevoNombre) {
        estudiante.nombre = nuevoNombre;
        mostrarEstudiantes();
    }
}

function eliminarEstudiante(id) {
    if (confirm('¿Está seguro que desea eliminar este estudiante?')) {
        estudiantes = estudiantes.filter(e => e.id !== id);
        mostrarEstudiantes();
        alert('Estudiante eliminado correctamente');
    }
}

function mostrarProfesores(lista = profesores) {
    if (!teacherGrid) return; 
    

    teacherGrid.innerHTML = '';
    
    lista.forEach(prof => {
        const card = document.createElement('div');
        card.className = 'teacher-card';
        card.innerHTML = `
            <div class="teacher-avatar">${prof.iniciales}</div>
            <div class="teacher-name">${prof.nombre}</div>
            <div class="teacher-subject">${prof.materia}</div>
            <div class="teacher-email">${prof.email}</div>
            <div style="margin-top: 10px; text-align: center;">
                <button class="btn-edit" onclick="editarProfesor(${prof.id})" title="Editar">✏️</button>
                <button class="btn-delete" onclick="eliminarProfesor(${prof.id})" title="Eliminar">🗑️</button>
            </div>
        `;
        teacherGrid.appendChild(card);
    });
    
    const subtitle = document.querySelector('.page-header .subtitle');
    if (subtitle && subtitle.textContent.includes('formador')) {
        subtitle.textContent = `${lista.length} formadores vinculados`;
    }
}

function editarProfesor(id) {
    const profesor = profesores.find(p => p.id === id);
    if (!profesor) return;
    
    const nuevoNombre = prompt('Editar nombre:', profesor.nombre);
    if (nuevoNombre) {
        profesor.nombre = nuevoNombre;
        mostrarProfesores();
    }
}

function eliminarProfesor(id) {
    if (confirm('¿Está seguro que desea eliminar este profesor?')) {
        profesores = profesores.filter(p => p.id !== id);
        mostrarProfesores();
        alert('Profesor eliminado correctamente');
    }
}

function mostrarNotas(lista = notas) {
    if (!notesTableBody) return; 
    
    notesTableBody.innerHTML = '';
    
    lista.forEach(nota => {
        const estudiante = obtenerEstudiante(nota.estudianteId);
        const promedio = calcularPromedio(nota);
        
        const tr = document.createElement('tr');
        tr.innerHTML = `
            <td class="name-cell">${estudiante ? estudiante.nombre : 'Desconocido'}</td>
            <td>${nota.matematicas}</td>
            <td>${nota.ciencias}</td>
            <td>${nota.historia}</td>
            <td>${nota.literatura}</td>
            <td><strong>${promedio}</strong></td>
            <td style="text-align: center;">
                <button class="btn-edit" onclick="editarNota(${nota.id})" title="Editar">✏️</button>
                <button class="btn-delete" onclick="eliminarNota(${nota.id})" title="Eliminar">🗑️</button>
            </td>
        `;
        notesTableBody.appendChild(tr);
    });
}

function editarNota(id) {
    const nota = notas.find(n => n.id === id);
    if (!nota) return;
    
    const nuevaNota = prompt('Ingrese la nueva nota (0-5):', nota.matematicas);
    if (nuevaNota !== null && nuevaNota !== '') {
        nota.matematicas = parseFloat(nuevaNota);
        mostrarNotas();
    }
}

function eliminarNota(id) {
    if (confirm('¿Está seguro que desea eliminar esta calificación?')) {
        notas = notas.filter(n => n.id !== id);
        mostrarNotas();
        alert('Nota eliminada correctamente');
    }
}

function buscarEstudiantes(termino) {
    const terminoLower = termino.toLowerCase();
    const resultados = estudiantes.filter(e => 
        e.nombre.toLowerCase().includes(terminoLower) ||
        e.email.toLowerCase().includes(terminoLower) ||
        e.grupo.toLowerCase().includes(terminoLower)
    );
    mostrarEstudiantes(resultados);
}

function buscarProfesores(termino) {
    const terminoLower = termino.toLowerCase();
    const resultados = profesores.filter(p => 
        p.nombre.toLowerCase().includes(terminoLower) ||
        p.materia.toLowerCase().includes(terminoLower)
    );
    mostrarProfesores(resultados);
}

function buscarNotas(termino) {
    const terminoLower = termino.toLowerCase();
    const resultados = notas.filter(nota => {
        const estudiante = obtenerEstudiante(nota.estudianteId);
        return estudiante && estudiante.nombre.toLowerCase().includes(terminoLower);
    });
    mostrarNotas(resultados);
}

document.addEventListener('DOMContentLoaded', () => {
    console.log('✓ NotApp cargada correctamente');
    
    const pathname = window.location.pathname;
    
    if (pathname.includes('students.html')) {
        mostrarEstudiantes();
        
        const btnAgregar = document.querySelector('#students-page .btn-primary');
        if (btnAgregar) {
            btnAgregar.addEventListener('click', () => {
                const nuevoEst = {
                    nombre: prompt('Nombre del estudiante:') || "Nuevo Estudiante",
                    email: prompt('Email del estudiante:') || "nuevo@email.com",
                    grupo: "Grupo A",
                    asistencia: 100,
                    estado: "Activo"
                };
                agregarEstudiante(nuevoEst);
                mostrarEstudiantes();
                alert('Estudiante agregado correctamente');
            });
        }
        
        const searchInput = document.querySelector('#students-page .search-box input');
        if (searchInput) {
            searchInput.addEventListener('input', (e) => {
                buscarEstudiantes(e.target.value);
            });
        }
        
    } else if (pathname.includes('teacher') || pathname.includes('teachers')) {
        mostrarProfesores();
        
        const btnAgregar = document.querySelector('main .btn-primary');
        if (btnAgregar) {
            btnAgregar.addEventListener('click', () => {
                alert('Funcionalidad de agregar profesor en desarrollo');
            });
        }
        
        const searchInput = document.querySelector('.search-box input');
        if (searchInput) {
            searchInput.addEventListener('input', (e) => {
                buscarProfesores(e.target.value);
            });
        }
        
    } else if (pathname.includes('notes.html')) {
        mostrarNotas();
        
        const searchInput = document.querySelector('#notes-page .search-box input');
        if (searchInput) {
            searchInput.addEventListener('input', (e) => {
                buscarNotas(e.target.value);
            });
        }
    }
    

    const hamburger = document.querySelector('.hamburger');
    const sidebar = document.querySelector('.sidebar');
    if (hamburger && sidebar) {
        hamburger.addEventListener('click', () => {
            sidebar.classList.toggle('collapsed');
        });
    }
});


window.agregarEstudiante = agregarEstudiante;
window.mostrarEstudiantes = mostrarEstudiantes;
window.editarEstudiante = editarEstudiante;
window.eliminarEstudiante = eliminarEstudiante;
window.buscarEstudiantes = buscarEstudiantes;
window.mostrarProfesores = mostrarProfesores;
window.editarProfesor = editarProfesor;
window.eliminarProfesor = eliminarProfesor;
window.buscarProfesores = buscarProfesores;
window.mostrarNotas = mostrarNotas;
window.editarNota = editarNota;
window.eliminarNota = eliminarNota;
window.buscarNotas = buscarNotas;
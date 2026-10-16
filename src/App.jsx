import { useState } from 'react'
import MainLayout from './layout/MainLayout'
import useDatos from './hooks/useDatos'
import Dashboard from './pages/Dashboard'
import Programas from './pages/Programas'
import Periodos from './pages/Periodos'
import Asignaturas from './pages/Asignaturas'
import Grupos from './pages/Grupos'
import CargaAcademica from './pages/CargaAcademica'
import Estudiantes from './pages/Estudiantes'
import Docentes from './pages/Docentes'
import Matriculas from './pages/Matriculas'
import Notas from './pages/Notas'
import Usuarios from './pages/Usuarios'
import Roles from './pages/Roles'
import AsignacionRoles from './pages/AsignacionRoles'

// Página que corresponde a cada ítem del menú.
const PAGINAS = {
    dashboard:       Dashboard,
    programas:       Programas,
    periodos:        Periodos,
    asignaturas:     Asignaturas,
    grupos:          Grupos,
    carga:           CargaAcademica,
    estudiantes:     Estudiantes,
    docentes:        Docentes,
    matriculas:      Matriculas,
    notas:           Notas,
    usuarios:        Usuarios,
    roles:           Roles,
    asignacionRoles: AsignacionRoles,
}

function App() {
    // Qué sección del menú está seleccionada.
    const [seccion, setSeccion] = useState('dashboard')

    // Los datos del backend viven acá para que el Dashboard y los módulos vean lo mismo.
    const { datos, errores, cargando, recargar } = useDatos()

    // Se considera desconectado cuando ninguna colección se pudo cargar.
    const mensajes = Object.values(errores)
    const conectado = cargando || mensajes.length === 0 || mensajes.some((m) => !m)

    const Pagina = PAGINAS[seccion]

    return (
        <MainLayout
            activo={seccion}
            onCambiar={setSeccion}
            conectado={conectado}
            onRecargar={recargar}
        >
            <Pagina datos={datos} errores={errores} cargando={cargando} recargar={recargar} />
        </MainLayout>
    )
}

export default App

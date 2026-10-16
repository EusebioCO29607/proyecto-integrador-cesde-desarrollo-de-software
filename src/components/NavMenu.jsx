// Los ítems del menú, agrupados por sección. Están en un array para no repetir
// el <li>: si mañana agregas "Reportes", solo agregas una línea acá.
const SECCIONES_MENU = [
    {
        titulo: null,
        items: [{ id: 'dashboard', label: 'Dashboard' }],
    },
    {
        titulo: 'Académico',
        items: [
            { id: 'programas',   label: 'Programas' },
            { id: 'periodos',    label: 'Periodos' },
            { id: 'asignaturas', label: 'Asignaturas' },
            { id: 'grupos',      label: 'Grupos' },
            { id: 'carga',       label: 'Carga académica' },
        ],
    },
    {
        titulo: 'Personas',
        items: [
            { id: 'estudiantes', label: 'Estudiantes' },
            { id: 'docentes',    label: 'Docentes' },
        ],
    },
    {
        titulo: 'Gestión',
        items: [
            { id: 'matriculas', label: 'Matrículas' },
            { id: 'notas',      label: 'Notas' },
        ],
    },
    {
        titulo: 'Seguridad',
        items: [
            { id: 'usuarios',        label: 'Usuarios' },
            { id: 'roles',           label: 'Roles' },
            { id: 'asignacionRoles', label: 'Asignación de roles' },
        ],
    },
]

function NavMenu({ activo, onCambiar }) {
    return (
        <nav className="flex-1 space-y-5">
            {SECCIONES_MENU.map((seccion) => (
                <div key={seccion.titulo ?? 'inicio'}>
                    {seccion.titulo && (
                        <p className="px-3 mb-1 text-xs uppercase tracking-wide text-blue-300">
                            {seccion.titulo}
                        </p>
                    )}
                    <ul className="space-y-1">
                        {seccion.items.map((item) => {
                            const esActivo = item.id === activo

                            return (
                                <li key={item.id}>
                                    <button
                                        type="button"
                                        onClick={() => onCambiar(item.id)}
                                        className={
                                            'w-full text-left px-3 py-2 rounded-md text-sm transition-colors cursor-pointer ' +
                                            (esActivo
                                                ? 'bg-blue-600 text-white font-medium'
                                                : 'text-blue-100 hover:bg-blue-900')
                                        }
                                    >
                                        {item.label}
                                    </button>
                                </li>
                            )
                        })}
                    </ul>
                </div>
            ))}
        </nav>
    )
}

export default NavMenu

import StatCard from '../components/StatCard'

// Nombres legibles de las colecciones, para el aviso de errores de carga.
const NOMBRES = {
    Students: 'Estudiantes', docentes: 'Docentes', programas: 'Programas',
    periodos: 'Periodos', asignaturas: 'Asignaturas', grupos: 'Grupos',
    cargas: 'Carga académica', matriculas: 'Matrículas', notas: 'Notas',
    usuarios: 'Usuarios', roles: 'Roles', usuariosRoles: 'Asignación de roles',
}

// El Dashboard calcula sus cifras a partir de los datos que vienen del backend,
// así que se actualiza cuando se crea, edita o elimina un registro.
function Dashboard({ datos, errores, cargando, recargar }) {
    const { estudiantes, docentes, programas, asignaturas, grupos, matriculas, notas } = datos

    const contar = (estado) => matriculas.filter((m) => m.status === estado).length
    const valor = (n) => (cargando ? '…' : n)

    const conNota = notas.filter((n) => typeof n.finalScore === 'number')
    const promedio = conNota.length
        ? (conNota.reduce((suma, n) => suma + n.finalScore, 0) / conNota.length).toFixed(2)
        : '—'
    const aprobadas = conNota.filter((n) => n.finalScore >= 3).length

    const generales = [
        { etiqueta: 'Estudiantes', valor: estudiantes.length, color: 'blue' },
        { etiqueta: 'Docentes',    valor: docentes.length,    color: 'purple' },
        { etiqueta: 'Programas',   valor: programas.length,   color: 'amber' },
        { etiqueta: 'Asignaturas', valor: asignaturas.length, color: 'green' },
        { etiqueta: 'Grupos',      valor: grupos.length,      color: 'blue' },
        { etiqueta: 'Matrículas',  valor: matriculas.length,  color: 'purple' },
    ]

    const academicas = [
        { etiqueta: 'Matrículas activas',     valor: contar('Activa'),     color: 'green' },
        { etiqueta: 'Matrículas completadas', valor: contar('Completada'), color: 'blue' },
        { etiqueta: 'Matrículas canceladas',  valor: contar('Cancelada'),  color: 'red' },
        { etiqueta: 'Promedio de notas',      valor: promedio,             color: 'amber' },
        { etiqueta: 'Notas aprobadas (≥ 3.0)', valor: `${aprobadas} de ${conNota.length}`, color: 'green' },
    ]

    const conError = Object.entries(errores).filter(([, mensaje]) => mensaje)

    return (
        <section>
            <h1 className="text-2xl text-gray-900">Dashboard</h1>
            <p className="text-sm text-gray-500 mt-1">
                Resumen general de AulaBot
            </p>

            {conError.length > 0 && (
                <div className="mt-4 text-sm text-red-700 bg-red-50 border border-red-200 rounded-md px-3 py-2">
                    <div className="flex items-center justify-between gap-3">
                        <span className="font-medium">Algunos módulos no se pudieron cargar desde el backend:</span>
                        <button
                            type="button"
                            onClick={() => recargar()}
                            className="shrink-0 font-medium hover:underline cursor-pointer"
                        >
                            Reintentar
                        </button>
                    </div>
                    <ul className="mt-1 list-disc pl-5">
                        {conError.map(([nombre, mensaje]) => (
                            <li key={nombre}>{NOMBRES[nombre] ?? nombre}: {mensaje}</li>
                        ))}
                    </ul>
                </div>
            )}

            <h2 className="text-sm font-medium text-gray-700 mt-6">Registros</h2>
            <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-4 mt-3">
                {generales.map((s) => (
                    <StatCard key={s.etiqueta} etiqueta={s.etiqueta} valor={valor(s.valor)} color={s.color} />
                ))}
            </div>

            <h2 className="text-sm font-medium text-gray-700 mt-8">Seguimiento académico</h2>
            <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-4 mt-3">
                {academicas.map((s) => (
                    <StatCard key={s.etiqueta} etiqueta={s.etiqueta} valor={valor(s.valor)} color={s.color} />
                ))}
            </div>
        </section>
    )
}

export default Dashboard

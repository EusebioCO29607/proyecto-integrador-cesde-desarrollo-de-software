// Etiqueta de color para los estados (Activo, Inactivo, Completada, Cancelada...).
const estilos = {
    Activo:     'bg-green-50 text-green-700',
    Activa:     'bg-green-50 text-green-700',
    Inactivo:   'bg-gray-100 text-gray-600',
    Inactiva:   'bg-gray-100 text-gray-600',
    Bloqueado:  'bg-amber-50 text-amber-700',
    Retirado:   'bg-amber-50 text-amber-700',
    Graduado:   'bg-blue-50 text-blue-700',
    Completada: 'bg-blue-50 text-blue-700',
    Cancelada:  'bg-red-50 text-red-700',
    ACTIVE:     'bg-green-50 text-green-700',
    INACTIVE:   'bg-gray-100 text-gray-600',
}

function Badge({ valor }) {
    if (valor === null || valor === undefined || valor === '') {
        return <span className="text-gray-400">—</span>
    }

    return (
        <span
            className={
                'inline-block text-xs px-2 py-0.5 rounded ' +
                (estilos[valor] ?? 'bg-gray-100 text-gray-600')
            }
        >
            {valor}
        </span>
    )
}

export default Badge

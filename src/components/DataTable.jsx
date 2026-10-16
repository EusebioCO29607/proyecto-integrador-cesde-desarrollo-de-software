import Badge from './Badge'

// Tabla reutilizable para todos los módulos.
//
// columnas -> [{ clave, titulo, tipo, valor }]
//             tipo 'estado' pinta un Badge; valor(fila) calcula el texto a mostrar
//             (útil para mostrar el nombre de un registro relacionado en vez de su id)
// filas    -> arreglo de objetos; obtenerId(fila) devuelve su llave única
// onNuevo / onEditar / onEliminar -> acciones que maneja la página padre.
//             Si onEditar u onEliminar no llegan, ese botón no se muestra.
function DataTable({
    columnas,
    filas,
    obtenerId,
    totalSinFiltro,
    busqueda,
    onBuscar,
    onNuevo,
    onEditar,
    onEliminar,
    cargando = false,
    textoNuevo = 'Nuevo',
}) {
    const hayAcciones = Boolean(onEditar || onEliminar)
    const totalColumnas = columnas.length + (hayAcciones ? 1 : 0)

    const mostrar = (fila, col) => {
        const valor = col.valor ? col.valor(fila) : fila[col.clave]
        if (col.tipo === 'estado') return <Badge valor={valor} />
        if (valor === null || valor === undefined || valor === '') {
            return <span className="text-gray-400">—</span>
        }
        return valor
    }

    return (
        <div className="bg-white border border-gray-200 rounded-lg overflow-hidden">
            {/* Barra de acciones de la tabla */}
            <div className="flex flex-wrap items-center justify-between gap-3 px-4 py-3 border-b border-gray-200">
                <div className="flex items-center gap-3">
                    <input
                        type="search"
                        value={busqueda}
                        onChange={(e) => onBuscar(e.target.value)}
                        placeholder="Buscar..."
                        className="border border-gray-300 rounded-md px-3 py-1.5 text-sm w-48 focus:outline-none focus:ring-2 focus:ring-blue-500"
                    />
                    <span className="text-sm text-gray-500">
                        {filas.length === totalSinFiltro
                            ? `${filas.length} ${filas.length === 1 ? 'registro' : 'registros'}`
                            : `${filas.length} de ${totalSinFiltro}`}
                    </span>
                </div>

                <button
                    type="button"
                    onClick={onNuevo}
                    className="bg-blue-600 hover:bg-blue-700 text-white text-sm font-medium px-3 py-1.5 rounded-md cursor-pointer transition-colors"
                >
                    + {textoNuevo}
                </button>
            </div>

            {/* La tabla se desplaza horizontalmente en pantallas pequeñas */}
            <div className="overflow-x-auto">
                <table className="w-full text-sm text-left">
                    <thead className="bg-gray-50 text-gray-600">
                        <tr>
                            {columnas.map((col) => (
                                <th key={col.clave} className="px-4 py-2 font-medium whitespace-nowrap">
                                    {col.titulo}
                                </th>
                            ))}
                            {hayAcciones && (
                                <th className="px-4 py-2 font-medium text-right whitespace-nowrap">
                                    Acciones
                                </th>
                            )}
                        </tr>
                    </thead>

                    <tbody className="divide-y divide-gray-100">
                        {filas.length === 0 && (
                            <tr>
                                <td
                                    colSpan={totalColumnas}
                                    className="px-4 py-8 text-center text-gray-500"
                                >
                                    {cargando
                                        ? 'Cargando...'
                                        : busqueda
                                            ? 'Ningún registro coincide con la búsqueda.'
                                            : 'Todavía no hay registros.'}
                                </td>
                            </tr>
                        )}

                        {filas.map((fila) => (
                            <tr key={obtenerId(fila)} className="hover:bg-gray-50">
                                {columnas.map((col) => (
                                    <td key={col.clave} className="px-4 py-2 text-gray-700 whitespace-nowrap">
                                        {mostrar(fila, col)}
                                    </td>
                                ))}

                                {/* Acciones por fila */}
                                {hayAcciones && (
                                    <td className="px-4 py-2 whitespace-nowrap text-right">
                                        {onEditar && (
                                            <button
                                                type="button"
                                                onClick={() => onEditar(fila)}
                                                className="text-blue-600 hover:bg-blue-50 text-sm px-2 py-1 rounded cursor-pointer transition-colors"
                                            >
                                                Editar
                                            </button>
                                        )}
                                        {onEliminar && (
                                            <button
                                                type="button"
                                                onClick={() => onEliminar(fila)}
                                                className="text-red-600 hover:bg-red-50 text-sm px-2 py-1 rounded ml-1 cursor-pointer transition-colors"
                                            >
                                                Eliminar
                                            </button>
                                        )}
                                    </td>
                                )}
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
        </div>
    )
}

export default DataTable

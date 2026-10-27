import { useState } from 'react'
import DataTable from './DataTable'
import FormularioModal from './FormularioModal'

// Convierte lo que devuelve el formulario (todo texto) al formato del backend:
// quita espacios, deja en null los campos vacíos y pasa a número los campos
// numéricos (tipo 'number' o selects de ids marcados con numerico: true).
function limpiar(valores, campos) {
    const resultado = { ...valores }
    campos.forEach((campo) => {
        let valor = resultado[campo.clave]
        if (typeof valor === 'string') valor = valor.trim()
        if (valor === '' || valor === undefined) valor = null
        if (valor !== null && (campo.tipo === 'number' || campo.numerico)) valor = Number(valor)
        resultado[campo.clave] = valor
    })
    return resultado
}


function ModuloCrud({
    titulo,
    descripcion,
    singular,
    tituloNuevo,
    tituloEditar,
    columnas,
    campos,
    filas,
    api,
    idClave,
    obtenerId = (fila) => fila[idClave],
    valoresNuevo = {},
    preparar = (valores) => valores,
    sinEditar = false,
    sinEliminar = false,
    eliminar,
    error,
    cargando,
    onRecargar,
    aviso,
}) {

    const [formulario, setFormulario] = useState(null)
    // Fila que se está por eliminar (para pedir confirmación).
    const [porEliminar, setPorEliminar] = useState(null)
    const [eliminando, setEliminando] = useState(false)
    const [errorEliminar, setErrorEliminar] = useState(null)
    const [busqueda, setBusqueda] = useState('')

    const esEdicion = formulario?.modo === 'editar'

    const guardar = async (valores) => {
        const datos = preparar(limpiar(valores, campos), esEdicion)
        if (esEdicion) {
            await api.actualizar(obtenerId(formulario.fila), datos)
        } else {
            await api.crear(datos)
        }
        setFormulario(null)
        await onRecargar()
    }

    const confirmarEliminar = async () => {
        setEliminando(true)
        setErrorEliminar(null)
        try {
            if (eliminar) await eliminar(porEliminar)
            else await api.eliminar(obtenerId(porEliminar))
            setPorEliminar(null)
            await onRecargar()
        } catch (e) {
           
            const generico = e.message.includes('error inesperado')
            setErrorEliminar(
                generico
                    ? 'No se pudo eliminar. Es posible que tenga otros registros asociados; elimínalos primero.'
                    : e.message
            )
        } finally {
            setEliminando(false)
        }
    }

    const cerrarEliminar = () => {
        setPorEliminar(null)
        setErrorEliminar(null)
    }

  
    const texto = busqueda.trim().toLowerCase()
    const filasFiltradas = texto
        ? filas.filter((fila) =>
            columnas.some((col) => {
                const valor = col.valor ? col.valor(fila) : fila[col.clave]
                return String(valor ?? '').toLowerCase().includes(texto)
            })
        )
        : filas

    return (
        <section>
            <h1 className="text-2xl text-gray-900">{titulo}</h1>
            <p className="text-sm text-gray-500 mt-1">{descripcion}</p>

            {aviso && (
                <p className="mt-4 text-sm text-amber-800 bg-amber-50 border border-amber-200 rounded-md px-3 py-2">
                    {aviso}
                </p>
            )}

            {error && (
                <div className="mt-4 flex items-center justify-between gap-3 text-sm text-red-700 bg-red-50 border border-red-200 rounded-md px-3 py-2">
                    <span>No se pudieron cargar los datos: {error}</span>
                    <button
                        type="button"
                        onClick={() => onRecargar()}
                        className="shrink-0 font-medium hover:underline cursor-pointer"
                    >
                        Reintentar
                    </button>
                </div>
            )}

            <div className="mt-6">
                <DataTable
                    columnas={columnas}
                    filas={filasFiltradas}
                    totalSinFiltro={filas.length}
                    obtenerId={obtenerId}
                    busqueda={busqueda}
                    onBuscar={setBusqueda}
                    cargando={cargando}
                    textoNuevo={singular}
                    onNuevo={() => setFormulario({ modo: 'nuevo', fila: { ...valoresNuevo } })}
                    onEditar={sinEditar ? undefined : (fila) => setFormulario({ modo: 'editar', fila })}
                    onEliminar={sinEliminar ? undefined : setPorEliminar}
                />
            </div>

            {formulario && (
                <FormularioModal
                    key={esEdicion ? obtenerId(formulario.fila) : 'nuevo'}
                    titulo={esEdicion ? tituloEditar : tituloNuevo}
                    campos={campos}
                    valorInicial={formulario.fila}
                    onGuardar={guardar}
                    onCancelar={() => setFormulario(null)}
                />
            )}

            {porEliminar && (
                <div className="fixed inset-0 z-50 bg-black/40 flex items-center justify-center p-4">
                    <div className="bg-white rounded-lg w-full max-w-sm p-5">
                        <h2 className="text-lg text-gray-900">Eliminar registro</h2>
                        <p className="text-sm text-gray-600 mt-2">
                            Esta acción no se puede deshacer. ¿Deseas continuar?
                        </p>

                        {errorEliminar && (
                            <p className="mt-3 text-sm text-red-700 bg-red-50 border border-red-200 rounded-md px-3 py-2">
                                {errorEliminar}
                            </p>
                        )}

                        <div className="flex justify-end gap-2 mt-5">
                            <button
                                type="button"
                                onClick={cerrarEliminar}
                                disabled={eliminando}
                                className="text-sm text-gray-700 px-3 py-2 rounded-md hover:bg-gray-100 cursor-pointer transition-colors disabled:opacity-50"
                            >
                                Cancelar
                            </button>
                            <button
                                type="button"
                                onClick={confirmarEliminar}
                                disabled={eliminando}
                                className="bg-red-600 hover:bg-red-700 text-white text-sm font-medium px-4 py-2 rounded-md cursor-pointer transition-colors disabled:opacity-60"
                            >
                                {eliminando ? 'Eliminando...' : 'Eliminar'}
                            </button>
                        </div>
                    </div>
                </div>
            )}
        </section>
    )
}

export default ModuloCrud

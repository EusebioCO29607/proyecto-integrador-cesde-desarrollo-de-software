import { useState } from 'react'

const claseCampo =
    'w-full border border-gray-300 rounded-md px-3 py-2 text-sm focus:outline-none focus:ring-2 focus:ring-blue-500 disabled:bg-gray-100'

const normalizarOpcion = (opcion) =>
    typeof opcion === 'object' ? opcion : { valor: opcion, texto: opcion }


function FormularioModal({ titulo, campos, valorInicial, onGuardar, onCancelar }) {
    const [valores, setValores] = useState(valorInicial)
    const [guardando, setGuardando] = useState(false)
    const [error, setError] = useState(null)

    const cambiar = (clave, valor) => {
        setValores((anterior) => ({ ...anterior, [clave]: valor }))
    }

    const enviar = async (evento) => {
        evento.preventDefault()
        setGuardando(true)
        setError(null)
        try {
            await onGuardar(valores)
        } catch (e) {
            setError(e.message)
            setGuardando(false)
        }
    }

    const renderCampo = (campo) => {
        const comunes = {
            id: campo.clave,
            required: !campo.opcional,
            disabled: guardando,
            value: valores[campo.clave] ?? '',
            onChange: (e) => cambiar(campo.clave, e.target.value),
            className: claseCampo,
        }

        if (campo.tipo === 'select') {
            const opciones = (campo.opciones ?? []).map(normalizarOpcion)
            return (
                <select {...comunes}>
                    <option value="">
                        {opciones.length === 0 ? 'No hay opciones disponibles' : 'Selecciona una opción'}
                    </option>
                    {opciones.map((opcion) => (
                        <option key={opcion.valor} value={opcion.valor}>
                            {opcion.texto}
                        </option>
                    ))}
                </select>
            )
        }

        if (campo.tipo === 'textarea') {
            return <textarea rows={3} {...comunes} />
        }

        return (
            <input
                type={campo.tipo ?? 'text'}
                min={campo.min}
                max={campo.max}
                step={campo.step}
                autoComplete={campo.tipo === 'password' ? 'new-password' : undefined}
                {...comunes}
            />
        )
    }

    return (
        <div className="fixed inset-0 z-50 bg-black/40 flex items-center justify-center p-4">
            <div className="bg-white rounded-lg w-full max-w-md max-h-full overflow-y-auto">
                <h2 className="text-lg text-gray-900 px-5 py-3 border-b border-gray-200">
                    {titulo}
                </h2>

                <form onSubmit={enviar} className="p-5 space-y-4">
                    {campos.map((campo) => (
                        <div key={campo.clave}>
                            <label
                                htmlFor={campo.clave}
                                className="block text-sm text-gray-700 mb-1"
                            >
                                {campo.titulo}
                                {campo.opcional && <span className="text-gray-400"> (opcional)</span>}
                            </label>

                            {renderCampo(campo)}

                            {campo.ayuda && (
                                <p className="text-xs text-gray-500 mt-1">{campo.ayuda}</p>
                            )}
                        </div>
                    ))}

                    {error && (
                        <p className="text-sm text-red-700 bg-red-50 border border-red-200 rounded-md px-3 py-2">
                            {error}
                        </p>
                    )}

                    <div className="flex justify-end gap-2 pt-2">
                        <button
                            type="button"
                            onClick={onCancelar}
                            disabled={guardando}
                            className="text-sm text-gray-700 px-3 py-2 rounded-md hover:bg-gray-100 cursor-pointer transition-colors disabled:opacity-50"
                        >
                            Cancelar
                        </button>
                        <button
                            type="submit"
                            disabled={guardando}
                            className="bg-blue-600 hover:bg-blue-700 text-white text-sm font-medium px-4 py-2 rounded-md cursor-pointer transition-colors disabled:opacity-60"
                        >
                            {guardando ? 'Guardando...' : 'Guardar'}
                        </button>
                    </div>
                </form>
            </div>
        </div>
    )
}

export default FormularioModal

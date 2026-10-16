import { useCallback, useEffect, useState } from 'react'
import { recurso } from '../api/cliente'

// Colecciones del backend que usa la aplicación: nombre interno -> endpoint.
export const ENDPOINTS = {
    estudiantes:   '/students',
    docentes:      '/teachers',
    programas:     '/programs',
    periodos:      '/periods',
    asignaturas:   '/subjects',
    grupos:        '/groups',
    cargas:        '/group-subjects',
    matriculas:    '/enrollments',
    notas:         '/grades',
    usuarios:      '/users',
    roles:         '/roles',
    usuariosRoles: '/user-roles',
}

const TODAS = Object.keys(ENDPOINTS)
const vacio = Object.fromEntries(TODAS.map((nombre) => [nombre, []]))

// Pide al backend las colecciones indicadas. Si una falla, las demás siguen
// llegando y el mensaje de error queda en `errores[nombre]`.
async function obtener(nombres) {
    const resultados = await Promise.allSettled(
        nombres.map((nombre) => recurso(ENDPOINTS[nombre]).listar())
    )

    const datos = {}
    const errores = {}
    resultados.forEach((resultado, i) => {
        const nombre = nombres[i]
        if (resultado.status === 'fulfilled') {
            datos[nombre] = resultado.value ?? []
            errores[nombre] = null
        } else {
            datos[nombre] = []
            errores[nombre] = resultado.reason.message
        }
    })
    return { datos, errores }
}

// Carga todas las colecciones al iniciar y permite recargarlas después de
// crear, editar o eliminar. Se cargan todas porque los módulos se cruzan entre
// sí (una matrícula muestra el nombre del estudiante y el código del grupo).
function useDatos() {
    const [datos, setDatos] = useState(vacio)
    const [errores, setErrores] = useState({})
    const [cargando, setCargando] = useState(true)

    const aplicar = useCallback((resultado) => {
        setDatos((anterior) => ({ ...anterior, ...resultado.datos }))
        setErrores((anterior) => ({ ...anterior, ...resultado.errores }))
        setCargando(false)
    }, [])

    // recargar() recarga todo; recargar('estudiantes') solo esa colección.
    const recargar = useCallback(async (...nombres) => {
        aplicar(await obtener(nombres.length > 0 ? nombres : TODAS))
    }, [aplicar])

    useEffect(() => {
        let vigente = true
        obtener(TODAS).then((resultado) => {
            if (vigente) aplicar(resultado)
        })
        return () => {
            vigente = false
        }
    }, [aplicar])

    return { datos, errores, cargando, recargar }
}

export default useDatos

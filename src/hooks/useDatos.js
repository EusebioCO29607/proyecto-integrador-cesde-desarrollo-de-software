import { useCallback, useEffect, useState } from 'react'
import { recurso } from '../api/cliente'

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


function useDatos() {
    const [datos, setDatos] = useState(vacio)
    const [errores, setErrores] = useState({})
    const [cargando, setCargando] = useState(true)

    const aplicar = useCallback((resultado) => {
        setDatos((anterior) => ({ ...anterior, ...resultado.datos }))
        setErrores((anterior) => ({ ...anterior, ...resultado.errores }))
        setCargando(false)
    }, [])


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

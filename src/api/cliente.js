
const BASE_URL = import.meta.env.VITE_API_URL ?? '/api'

async function pedir(ruta, { metodo = 'GET', cuerpo } = {}) {
    let respuesta
    try {
        respuesta = await fetch(BASE_URL + ruta, {
            method: metodo,
            headers: cuerpo ? { 'Content-Type': 'application/json' } : undefined,
            body: cuerpo ? JSON.stringify(cuerpo) : undefined,
        })
    } catch {
        throw new Error('No fue posible conectar con el servidor. Verifica que el backend esté en ejecución.')
    }

    const texto = await respuesta.text()
    let datos
    try {
        datos = texto ? JSON.parse(texto) : null
    } catch {
        datos = null
    }

    if (!respuesta.ok) {
        const mensaje = datos?.message ?? `El servidor respondió con el código ${respuesta.status}`
        throw new Error(mensaje)
    }

    return datos
}

export function recurso(endpoint) {
    return {
        listar:     ()           => pedir(endpoint),
        crear:      (datos)      => pedir(endpoint, { metodo: 'POST', cuerpo: datos }),
        actualizar: (id, datos)  => pedir(`${endpoint}/${id}`, { metodo: 'PUT', cuerpo: datos }),
        eliminar:   (id)         => pedir(`${endpoint}/${id}`, { metodo: 'DELETE' }),
    }
}


export function eliminarRolDeUsuario(userId, roleId) {
    return pedir(`/user-roles/user/${userId}/role/${roleId}`, { metodo: 'DELETE' })
}

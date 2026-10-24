// Cliente HTTP para el backend de AulaBot.
//
// En desarrollo las rutas /api pasan por el proxy de Vite (ver vite.config.js).
// Para otro entorno se puede definir VITE_API_URL, por ejemplo en un archivo .env.
const BASE_URL = import.meta.env.VITE_API_URL ?? '/api'

// Hace la petición y devuelve el JSON (o null si la respuesta no trae cuerpo).
// Si el backend responde con error, lanza un Error con el mensaje que envía
// el GlobalExceptionHandler ({ error, message, status, timestamp }).
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

// Operaciones CRUD estándar de un recurso del backend (/students, /teachers...).
export function recurso(endpoint) {
    return {
        listar:     ()           => pedir(endpoint),
        crear:      (datos)      => pedir(endpoint, { metodo: 'POST', cuerpo: datos }),
        actualizar: (id, datos)  => pedir(`${endpoint}/${id}`, { metodo: 'PUT', cuerpo: datos }),
        eliminar:   (id)         => pedir(`${endpoint}/${id}`, { metodo: 'DELETE' }),
    }
}

// La relación usuario-rol tiene llave compuesta, así que se elimina por otra ruta.
export function eliminarRolDeUsuario(userId, roleId) {
    return pedir(`/user-roles/user/${userId}/role/${roleId}`, { metodo: 'DELETE' })
}

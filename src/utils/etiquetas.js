// Funciones para mostrar registros relacionados por su nombre en lugar de su id
// y para armar las opciones de los selects de los formularios.

export const nombreCompleto = (persona) =>
    persona ? `${persona.firstName ?? ''} ${persona.lastName ?? ''}`.trim() : ''

// Busca en una lista el registro cuyo campo `clave` es igual a `id`.
export const buscar = (lista, clave, id) =>
    id === null || id === undefined ? undefined : lista.find((item) => item[clave] === Number(id))

// Si el registro relacionado no está cargado se muestra "#id" para no perder el dato.
const conRespaldo = (registro, id, texto) => {
    if (id === null || id === undefined) return ''
    return registro ? texto(registro) : `#${id}`
}

// Texto con el que se muestra cada tipo de registro. `d` es el objeto `datos` de useDatos.
export const etiqueta = {
    estudiante: (d, id) => conRespaldo(buscar(d.estudiantes, 'studentId', id), id, nombreCompleto),
    docente:    (d, id) => conRespaldo(buscar(d.docentes, 'teacherId', id), id, nombreCompleto),
    programa:   (d, id) => conRespaldo(buscar(d.programas, 'programId', id), id, (p) => p.name),
    periodo:    (d, id) => conRespaldo(buscar(d.periodos, 'periodId', id), id, (p) => p.code),
    asignatura: (d, id) => conRespaldo(buscar(d.asignaturas, 'subjectId', id), id, (a) => a.name),
    grupo:      (d, id) => conRespaldo(buscar(d.grupos, 'groupId', id), id, (g) => g.code),
    usuario:    (d, id) => conRespaldo(buscar(d.usuarios, 'userId', id), id, (u) => u.username),
    rol:        (d, id) => conRespaldo(buscar(d.roles, 'roleId', id), id, (r) => r.name),
    carga: (d, id) =>
        conRespaldo(buscar(d.cargas, 'groupSubjectId', id), id, (c) =>
            `${etiqueta.grupo(d, c.groupId)} · ${etiqueta.asignatura(d, c.subjectId)}`
        ),
}

// Opciones { valor, texto } para un select a partir de una lista del backend.
export const opciones = (lista, idClave, texto) =>
    lista.map((item) => ({ valor: String(item[idClave]), texto: texto(item) }))

// Fecha de hoy en formato YYYY-MM-DD (hora local).
export const hoy = () => {
    const f = new Date()
    const dos = (n) => String(n).padStart(2, '0')
    return `${f.getFullYear()}-${dos(f.getMonth() + 1)}-${dos(f.getDate())}`
}

// Fecha y hora local en formato YYYY-MM-DDTHH:mm:ss.
export const ahora = () => {
    const f = new Date()
    const dos = (n) => String(n).padStart(2, '0')
    return `${hoy()}T${dos(f.getHours())}:${dos(f.getMinutes())}:${dos(f.getSeconds())}`
}

// Muestra "2026-10-14T10:00:00" como "2026-10-14 10:00".
export const fechaHora = (valor) => (valor ? valor.replace('T', ' ').slice(0, 16) : '')

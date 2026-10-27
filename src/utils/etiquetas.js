
export const nombreCompleto = (persona) =>
    persona ? `${persona.firstName ?? ''} ${persona.lastName ?? ''}`.trim() : ''


export const buscar = (lista, clave, id) =>
    id === null || id === undefined ? undefined : lista.find((item) => item[clave] === Number(id))


const conRespaldo = (registro, id, texto) => {
    if (id === null || id === undefined) return ''
    return registro ? texto(registro) : `#${id}`
}


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

export const opciones = (lista, idClave, texto) =>
    lista.map((item) => ({ valor: String(item[idClave]), texto: texto(item) }))

export const hoy = () => {
    const f = new Date()
    const dos = (n) => String(n).padStart(2, '0')
    return `${f.getFullYear()}-${dos(f.getMonth() + 1)}-${dos(f.getDate())}`
}


export const ahora = () => {
    const f = new Date()
    const dos = (n) => String(n).padStart(2, '0')
    return `${hoy()}T${dos(f.getHours())}:${dos(f.getMinutes())}:${dos(f.getSeconds())}`
}


export const fechaHora = (valor) => (valor ? valor.replace('T', ' ').slice(0, 16) : '')

import ModuloCrud from '../components/ModuloCrud'
import { recurso } from '../api/cliente'
import { etiqueta, opciones } from '../utils/etiquetas'

const api = recurso('/subjects')

function Asignaturas({ datos, errores, cargando, recargar }) {
    const columnas = [
        { clave: 'code',      titulo: 'Código' },
        { clave: 'name',      titulo: 'Asignatura' },
        { clave: 'credits',   titulo: 'Créditos' },
        { clave: 'programId', titulo: 'Programa', valor: (f) => etiqueta.programa(datos, f.programId) },
    ]

    const campos = [
        { clave: 'code',    titulo: 'Código' },
        { clave: 'name',    titulo: 'Nombre de la asignatura' },
        { clave: 'credits', titulo: 'Créditos', tipo: 'number', min: 1, step: 1 },
        {
            clave: 'programId', titulo: 'Programa', tipo: 'select', numerico: true,
            opciones: opciones(datos.programas, 'programId', (p) => `${p.code} — ${p.name}`),
        },
    ]

    return (
        <ModuloCrud
            titulo="Asignaturas"
            descripcion="Asignaturas (cursos) que componen cada programa"
            singular="Asignatura"
            tituloNuevo="Nueva asignatura"
            tituloEditar="Editar asignatura"
            columnas={columnas}
            campos={campos}
            filas={datos.asignaturas}
            api={api}
            idClave="subjectId"
            error={errores.asignaturas}
            cargando={cargando}
            onRecargar={() => recargar('asignaturas')}
        />
    )
}

export default Asignaturas

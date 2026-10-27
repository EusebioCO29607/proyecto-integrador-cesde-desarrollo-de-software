import ModuloCrud from '../components/ModuloCrud'
import { recurso } from '../api/cliente'
import { etiqueta, nombreCompleto, opciones } from '../utils/etiquetas'

const api = recurso('/group-subjects')

function CargaAcademica({ datos, errores, cargando, recargar }) {
    const columnas = [
        { clave: 'groupId',   titulo: 'Grupo', valor: (f) => etiqueta.grupo(datos, f.groupId) },
        { clave: 'subjectId', titulo: 'Asignatura', valor: (f) => etiqueta.asignatura(datos, f.subjectId) },
        { clave: 'teacherId', titulo: 'Docente', valor: (f) => etiqueta.docente(datos, f.teacherId) },
    ]

    const campos = [
        {
            clave: 'groupId', titulo: 'Grupo', tipo: 'select', numerico: true,
            opciones: opciones(datos.grupos, 'groupId', (g) => g.code),
        },
        {
            clave: 'subjectId', titulo: 'Asignatura', tipo: 'select', numerico: true,
            opciones: opciones(datos.asignaturas, 'subjectId', (a) => `${a.code} — ${a.name}`),
        },
        {
            clave: 'teacherId', titulo: 'Docente', tipo: 'select', numerico: true,
            opciones: opciones(datos.docentes, 'teacherId', nombreCompleto),
        },
    ]

    return (
        <ModuloCrud
            titulo="Carga académica"
            descripcion="Asignaturas que se dictan en cada grupo y el docente responsable"
            singular="Asignación"
            tituloNuevo="Nueva asignación"
            tituloEditar="Editar asignación"
            columnas={columnas}
            campos={campos}
            filas={datos.cargas}
            api={api}
            idClave="groupSubjectId"
            error={errores.cargas}
            cargando={cargando}
            onRecargar={() => recargar('cargas')}
        />
    )
}

export default CargaAcademica

import ModuloCrud from '../components/ModuloCrud'
import { recurso } from '../api/cliente'
import { buscar, etiqueta, nombreCompleto, opciones } from '../utils/etiquetas'

const api = recurso('/grades')

function Notas({ datos, errores, cargando, recargar }) {
    const docenteDeCarga = (groupSubjectId) =>
        etiqueta.docente(datos, buscar(datos.cargas, 'groupSubjectId', groupSubjectId)?.teacherId)

    const columnas = [
        { clave: 'studentId',      titulo: 'Estudiante', valor: (f) => etiqueta.estudiante(datos, f.studentId) },
        { clave: 'groupSubjectId', titulo: 'Grupo · Asignatura', valor: (f) => etiqueta.carga(datos, f.groupSubjectId) },
        { clave: 'docente',        titulo: 'Docente', valor: (f) => docenteDeCarga(f.groupSubjectId) },
        { clave: 'finalScore',     titulo: 'Nota final', valor: (f) => f.finalScore?.toFixed(1) },
        { clave: 'observation',    titulo: 'Observación' },
    ]

    const campos = [
        {
            clave: 'groupSubjectId', titulo: 'Grupo · Asignatura', tipo: 'select', numerico: true,
            opciones: opciones(datos.cargas, 'groupSubjectId', (c) => etiqueta.carga(datos, c.groupSubjectId)),
        },
        {
            clave: 'studentId', titulo: 'Estudiante', tipo: 'select', numerico: true,
            opciones: opciones(datos.estudiantes, 'studentId', (e) => `${nombreCompleto(e)} (${e.code})`),
        },
        { clave: 'finalScore',  titulo: 'Nota final', tipo: 'number', min: 0, max: 5, step: 0.1, ayuda: 'Entre 0.0 y 5.0' },
        { clave: 'observation', titulo: 'Observación', tipo: 'textarea' },
    ]

    return (
        <ModuloCrud
            titulo="Notas"
            descripcion="Notas finales de los estudiantes por asignatura"
            singular="Nota"
            tituloNuevo="Nueva nota"
            tituloEditar="Editar nota"
            columnas={columnas}
            campos={campos}
            filas={datos.notas}
            api={api}
            idClave="gradeId"
            error={errores.notas}
            cargando={cargando}
            onRecargar={() => recargar('notas')}
        />
    )
}

export default Notas

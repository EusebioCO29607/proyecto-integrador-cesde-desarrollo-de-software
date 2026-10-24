import ModuloCrud from '../components/ModuloCrud'
import { recurso } from '../api/cliente'
import { buscar, etiqueta, hoy, nombreCompleto, opciones } from '../utils/etiquetas'

const api = recurso('/enrollments')

function Matriculas({ datos, errores, cargando, recargar }) {
    const columnas = [
        { clave: 'studentId',  titulo: 'Estudiante', valor: (f) => etiqueta.estudiante(datos, f.studentId) },
        { clave: 'groupId',    titulo: 'Grupo', valor: (f) => etiqueta.grupo(datos, f.groupId) },
        { clave: 'periodId',   titulo: 'Periodo', valor: (f) => etiqueta.periodo(datos, f.periodId) },
        { clave: 'enrolledAt', titulo: 'Fecha' },
        { clave: 'status',     titulo: 'Estado', tipo: 'estado' },
    ]

    const campos = [
        {
            clave: 'studentId', titulo: 'Estudiante', tipo: 'select', numerico: true,
            opciones: opciones(datos.estudiantes, 'studentId', (e) => `${nombreCompleto(e)} (${e.code})`),
        },
        {
            clave: 'groupId', titulo: 'Grupo', tipo: 'select', numerico: true,
            opciones: opciones(datos.grupos, 'groupId', (g) => `${g.code} — ${etiqueta.periodo(datos, g.periodId)}`),
        },
        {
            clave: 'periodId', titulo: 'Periodo', tipo: 'select', numerico: true, opcional: true,
            ayuda: 'Si lo dejas vacío se usa el periodo del grupo seleccionado.',
            opciones: opciones(datos.periodos, 'periodId', (p) => p.code),
        },
        { clave: 'enrolledAt', titulo: 'Fecha de matrícula', tipo: 'date' },
        { clave: 'status',     titulo: 'Estado', tipo: 'select', opciones: ['Activa', 'Completada', 'Cancelada'] },
    ]

    // El periodo de la matrícula normalmente es el mismo del grupo.
    const preparar = (valores) => {
        const periodId = valores.periodId ?? buscar(datos.grupos, 'groupId', valores.groupId)?.periodId ?? null
        if (periodId === null) throw new Error('Selecciona el periodo de la matrícula')
        return { ...valores, periodId }
    }

    return (
        <ModuloCrud
            titulo="Matrículas"
            descripcion="Matrículas registradas por estudiante y grupo"
            aviso="El backend solo permite registrar y consultar matrículas; todavía no ofrece editarlas ni eliminarlas."
            singular="Matrícula"
            tituloNuevo="Nueva matrícula"
            tituloEditar="Editar matrícula"
            columnas={columnas}
            campos={campos}
            filas={datos.matriculas}
            api={api}
            idClave="enrollmentId"
            valoresNuevo={{ status: 'Activa', enrolledAt: hoy() }}
            preparar={preparar}
            sinEditar
            sinEliminar
            error={errores.matriculas}
            cargando={cargando}
            onRecargar={() => recargar('matriculas')}
        />
    )
}

export default Matriculas

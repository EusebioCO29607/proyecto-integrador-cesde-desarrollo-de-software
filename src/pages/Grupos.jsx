import ModuloCrud from '../components/ModuloCrud'
import { recurso } from '../api/cliente'
import { etiqueta, opciones } from '../utils/etiquetas'

const api = recurso('/group')

function Grupos({ datos, errores, cargando, recargar }) {
    const columnas = [
        { clave: 'code',      titulo: 'Código' },
        { clave: 'programId', titulo: 'Programa', valor: (f) => etiqueta.programa(datos, f.programId) },
        { clave: 'periodId',  titulo: 'Periodo', valor: (f) => etiqueta.periodo(datos, f.periodId) },
        { clave: 'shift',     titulo: 'Jornada' },
        {
            clave: 'estudiantes', titulo: 'Matriculados',
            valor: (f) => datos.matriculas.filter((m) => m.groupId === f.groupId).length,
        },
    ]

    const campos = [
        { clave: 'code', titulo: 'Código del grupo' },
        {
            clave: 'programId', titulo: 'Programa', tipo: 'select', numerico: true,
            opciones: opciones(datos.programas, 'programId', (p) => `${p.code} — ${p.name}`),
        },
        {
            clave: 'periodId', titulo: 'Periodo', tipo: 'select', numerico: true,
            opciones: opciones(datos.periodos, 'periodId', (p) => p.code),
        },
        { clave: 'shift', titulo: 'Jornada', tipo: 'select', opciones: ['Mañana', 'Tarde', 'Noche', 'Fin de semana'] },
    ]

    return (
        <ModuloCrud
            titulo="Grupos"
            descripcion="Grupos de cada programa por periodo y jornada"
            singular="Grupo"
            tituloNuevo="Nuevo grupo"
            tituloEditar="Editar grupo"
            columnas={columnas}
            campos={campos}
            filas={datos.grupos}
            api={api}
            idClave="groupId"
            error={errores.grupos}
            cargando={cargando}
            onRecargar={() => recargar('grupos')}
        />
    )
}

export default Grupos

import ModuloCrud from '../components/ModuloCrud'
import { recurso } from '../api/cliente'

const api = recurso('/periods')

const columnas = [
    { clave: 'code',      titulo: 'Código' },
    { clave: 'startDate', titulo: 'Inicio' },
    { clave: 'endDate',   titulo: 'Fin' },
]

const campos = [
    { clave: 'code',      titulo: 'Código', ayuda: 'Por ejemplo 2026-2' },
    { clave: 'startDate', titulo: 'Fecha de inicio', tipo: 'date' },
    { clave: 'endDate',   titulo: 'Fecha de fin', tipo: 'date' },
]

// Valida en el navegador que el periodo no termine antes de empezar.
const preparar = (valores) => {
    if (valores.startDate && valores.endDate && valores.endDate < valores.startDate) {
        throw new Error('La fecha de fin no puede ser anterior a la fecha de inicio')
    }
    return valores
}

function Periodos({ datos, errores, cargando, recargar }) {
    return (
        <ModuloCrud
            titulo="Periodos"
            descripcion="Periodos académicos (semestres) de AulaBot"
            singular="Periodo"
            tituloNuevo="Nuevo periodo"
            tituloEditar="Editar periodo"
            columnas={columnas}
            campos={campos}
            filas={datos.periodos}
            api={api}
            idClave="periodId"
            preparar={preparar}
            error={errores.periodos}
            cargando={cargando}
            onRecargar={() => recargar('periodos')}
        />
    )
}

export default Periodos

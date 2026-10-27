import ModuloCrud from '../components/ModuloCrud'
import { recurso } from '../api/cliente'

const api = recurso('/programs')

const columnas = [
    { clave: 'code', titulo: 'Código' },
    { clave: 'name', titulo: 'Programa' },
    { clave: 'asignaturas', titulo: 'Asignaturas' },
]

const campos = [
    { clave: 'code', titulo: 'Código' },
    { clave: 'name', titulo: 'Nombre del programa' },
]

function Programas({ datos, errores, cargando, recargar }) {

    const filas = datos.programas.map((p) => ({
        ...p,
        asignaturas: datos.asignaturas.filter((a) => a.programId === p.programId).length,
    }))

    return (
        <ModuloCrud
            titulo="Programas"
            descripcion="Programas académicos ofrecidos por AulaBot"
            singular="Programa"
            tituloNuevo="Nuevo programa"
            tituloEditar="Editar programa"
            columnas={columnas}
            campos={campos}
            filas={filas}
            api={api}
            idClave="programId"
            error={errores.programas}
            cargando={cargando}
            onRecargar={() => recargar('programas')}
        />
    )
}

export default Programas

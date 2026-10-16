import ModuloCrud from '../components/ModuloCrud'
import { recurso } from '../api/cliente'
import { etiqueta, nombreCompleto, opciones } from '../utils/etiquetas'

const api = recurso('/teachers')

function Docentes({ datos, errores, cargando, recargar }) {
    const columnas = [
        { clave: 'code',           titulo: 'Código' },
        { clave: 'nombre',         titulo: 'Nombre', valor: nombreCompleto },
        { clave: 'documentNumber', titulo: 'Documento' },
        { clave: 'userId',         titulo: 'Usuario', valor: (f) => etiqueta.usuario(datos, f.userId) },
        { clave: 'status',         titulo: 'Estado', tipo: 'estado' },
    ]

    const campos = [
        { clave: 'code',           titulo: 'Código' },
        { clave: 'firstName',      titulo: 'Nombres' },
        { clave: 'lastName',       titulo: 'Apellidos' },
        { clave: 'documentNumber', titulo: 'Documento' },
        { clave: 'status',         titulo: 'Estado', tipo: 'select', opciones: ['Activo', 'Inactivo'] },
        {
            clave: 'userId', titulo: 'Usuario del sistema', tipo: 'select', numerico: true, opcional: true,
            opciones: opciones(datos.usuarios, 'userId', (u) => u.username),
        },
    ]

    return (
        <ModuloCrud
            titulo="Docentes"
            descripcion="Docentes que dictan las asignaturas de AulaBot"
            singular="Docente"
            tituloNuevo="Nuevo docente"
            tituloEditar="Editar docente"
            columnas={columnas}
            campos={campos}
            filas={datos.docentes}
            api={api}
            idClave="teacherId"
            valoresNuevo={{ status: 'Activo' }}
            error={errores.docentes}
            cargando={cargando}
            onRecargar={() => recargar('docentes')}
        />
    )
}

export default Docentes

import ModuloCrud from '../components/ModuloCrud'
import { recurso } from '../api/cliente'
import { etiqueta, nombreCompleto, opciones } from '../utils/etiquetas'

const api = recurso('/students')

function Estudiantes({ datos, errores, cargando, recargar }) {
    const columnas = [
        { clave: 'code',           titulo: 'Código' },
        { clave: 'nombre',         titulo: 'Nombre', valor: nombreCompleto },
        { clave: 'documentNumber', titulo: 'Documento' },
        { clave: 'email',          titulo: 'Correo' },
        { clave: 'birthDate',      titulo: 'Nacimiento' },
        { clave: 'userId',         titulo: 'Usuario', valor: (f) => etiqueta.usuario(datos, f.userId) },
        { clave: 'status',         titulo: 'Estado', tipo: 'estado' },
    ]

    const campos = [
        { clave: 'code',           titulo: 'Código' },
        { clave: 'firstName',      titulo: 'Nombres' },
        { clave: 'lastName',       titulo: 'Apellidos' },
        { clave: 'documentNumber', titulo: 'Documento' },
        { clave: 'email',          titulo: 'Correo', tipo: 'email', opcional: true },
        { clave: 'birthDate',      titulo: 'Fecha de nacimiento', tipo: 'date' },
        { clave: 'status',         titulo: 'Estado', tipo: 'select', opciones: ['Activo', 'Inactivo', 'Retirado', 'Graduado'] },
        {
            clave: 'userId', titulo: 'Usuario del sistema', tipo: 'select', numerico: true, opcional: true,
            opciones: opciones(datos.usuarios, 'userId', (u) => u.username),
        },
    ]

    return (
        <ModuloCrud
            titulo="Estudiantes"
            descripcion="Listado de estudiantes registrados en AulaBot"
            singular="Estudiante"
            tituloNuevo="Nuevo estudiante"
            tituloEditar="Editar estudiante"
            columnas={columnas}
            campos={campos}
            filas={datos.estudiantes}
            api={api}
            idClave="studentId"
            valoresNuevo={{ status: 'Activo' }}
            error={errores.estudiantes}
            cargando={cargando}
            onRecargar={() => recargar('estudiantes')}
        />
    )
}

export default Estudiantes

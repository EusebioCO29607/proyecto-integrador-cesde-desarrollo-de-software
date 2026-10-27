import ModuloCrud from '../components/ModuloCrud'
import { eliminarRolDeUsuario, recurso } from '../api/cliente'
import { etiqueta, opciones } from '../utils/etiquetas'

const api = recurso('/user-roles')

function AsignacionRoles({ datos, errores, cargando, recargar }) {
    const columnas = [
        { clave: 'userId', titulo: 'Usuario', valor: (f) => etiqueta.usuario(datos, f.userId) },
        { clave: 'roleId', titulo: 'Rol', valor: (f) => etiqueta.rol(datos, f.roleId) },
    ]

    const campos = [
        {
            clave: 'userId', titulo: 'Usuario', tipo: 'select', numerico: true,
            opciones: opciones(datos.usuarios, 'userId', (u) => `${u.username} (${u.email})`),
        },
        {
            clave: 'roleId', titulo: 'Rol', tipo: 'select', numerico: true,
            opciones: opciones(datos.roles, 'roleId', (r) => r.name),
        },
    ]

    return (
        <ModuloCrud
            titulo="Asignación de roles"
            descripcion="Roles asignados a cada usuario del sistema"
            singular="Asignación"
            tituloNuevo="Asignar rol a usuario"
            tituloEditar="Editar asignación"
            columnas={columnas}
            campos={campos}
            filas={datos.usuariosRoles}
            api={api}
            obtenerId={(f) => `${f.userId}-${f.roleId}`}
            sinEditar
            eliminar={(f) => eliminarRolDeUsuario(f.userId, f.roleId)}
            error={errores.usuariosRoles}
            cargando={cargando}
            onRecargar={() => recargar('usuariosRoles')}
        />
    )
}

export default AsignacionRoles

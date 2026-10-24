import ModuloCrud from '../components/ModuloCrud'
import { recurso } from '../api/cliente'

const api = recurso('/roles')

const columnas = [
    { clave: 'name',        titulo: 'Rol' },
    { clave: 'description', titulo: 'Descripción' },
    { clave: 'usuarios',    titulo: 'Usuarios' },
]

const campos = [
    { clave: 'name',        titulo: 'Nombre del rol' },
    { clave: 'description', titulo: 'Descripción', tipo: 'textarea' },
]

function Roles({ datos, errores, cargando, recargar }) {
    const filas = datos.roles.map((r) => ({
        ...r,
        usuarios: datos.usuariosRoles.filter((ur) => ur.roleId === r.roleId).length,
    }))

    return (
        <ModuloCrud
            titulo="Roles"
            descripcion="Roles que definen los permisos de los usuarios"
            singular="Rol"
            tituloNuevo="Nuevo rol"
            tituloEditar="Editar rol"
            columnas={columnas}
            campos={campos}
            filas={filas}
            api={api}
            idClave="roleId"
            error={errores.roles}
            cargando={cargando}
            onRecargar={() => recargar('roles')}
        />
    )
}

export default Roles

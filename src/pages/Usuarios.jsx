import ModuloCrud from '../components/ModuloCrud'
import { recurso } from '../api/cliente'
import { ahora, fechaHora } from '../utils/etiquetas'

const api = recurso('/users')

function Usuarios({ datos, errores, cargando, recargar }) {

    const rolesDe = (userId) =>
        datos.usuariosRoles
            .filter((ur) => ur.userId === userId)
            .map((ur) => datos.roles.find((r) => r.roleId === ur.roleId)?.name ?? `#${ur.roleId}`)
            .join(', ')

    const columnas = [
        { clave: 'username',  titulo: 'Usuario' },
        { clave: 'email',     titulo: 'Correo' },
        { clave: 'roles',     titulo: 'Roles', valor: (f) => rolesDe(f.userId) },
        { clave: 'createdAt', titulo: 'Creado', valor: (f) => fechaHora(f.createdAt) },
        { clave: 'status',    titulo: 'Estado', tipo: 'estado' },
    ]

    const campos = [
        { clave: 'username',     titulo: 'Nombre de usuario' },
        { clave: 'email',        titulo: 'Correo', tipo: 'email' },
        {
            clave: 'passwordHash', titulo: 'Contraseña', tipo: 'password',
            ayuda: 'El backend la pide también al editar; escribe la actual o una nueva.',
        },
        { clave: 'status',       titulo: 'Estado', tipo: 'select', opciones: ['Activo', 'Inactivo', 'Bloqueado'] },
    ]


    const preparar = (valores) => ({ ...valores, createdAt: valores.createdAt ?? ahora() })

    return (
        <ModuloCrud
            titulo="Usuarios"
            descripcion="Cuentas de acceso al sistema"
            singular="Usuario"
            tituloNuevo="Nuevo usuario"
            tituloEditar="Editar usuario"
            columnas={columnas}
            campos={campos}
            filas={datos.usuarios}
            api={api}
            idClave="userId"
            valoresNuevo={{ status: 'Activo' }}
            preparar={preparar}
            error={errores.usuarios}
            cargando={cargando}
            onRecargar={() => recargar('usuarios')}
        />
    )
}

export default Usuarios

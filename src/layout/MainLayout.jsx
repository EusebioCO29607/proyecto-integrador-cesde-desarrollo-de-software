import NavMenu from '../components/NavMenu'

function MainLayout({ children, activo, onCambiar, conectado, onRecargar }) {
    return (
        <div className="main-layout flex min-h-screen">
            {/* Sidebar */}
            <aside className="bg-blue-950 p-4 w-56 shrink-0 flex flex-col">
                <h2 className="text-white text-sm font-semibold leading-snug mb-6">
                    AulaBot
                </h2>

                <NavMenu activo={activo} onCambiar={onCambiar} />
            </aside>

            {/* Área de contenido */}
            <div className="flex-1 flex flex-col bg-gray-50 min-w-0">
                <header className="bg-white border-b border-gray-200 px-6 py-3 flex items-center justify-between gap-4">
                    <span className="text-sm text-gray-700">
                        AulaBot — Sistema de Gestión Académica
                    </span>

                    <div className="flex items-center gap-3">
                        {/* Estado de la conexión con el backend */}
                        <span className="flex items-center gap-1.5 text-xs text-gray-500">
                            <span
                                className={
                                    'inline-block w-2 h-2 rounded-full ' +
                                    (conectado ? 'bg-green-500' : 'bg-red-500')
                                }
                            />
                            {conectado ? 'Conectado al backend' : 'Sin conexión con el backend'}
                        </span>
                        <button
                            type="button"
                            onClick={() => onRecargar()}
                            className="text-xs text-blue-600 hover:bg-blue-50 px-2 py-1 rounded cursor-pointer transition-colors"
                        >
                            Actualizar
                        </button>
                    </div>
                </header>

                <main className="flex-1 p-6">{children}</main>
            </div>
        </div>
    )
}

export default MainLayout

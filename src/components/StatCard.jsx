
function StatCard({ etiqueta, valor, color = 'blue' }) {
    const colores = {
        blue:   'bg-blue-50 text-blue-700',
        green:  'bg-green-50 text-green-700',
        purple: 'bg-purple-50 text-purple-700',
        amber:  'bg-amber-50 text-amber-700',
        red:    'bg-red-50 text-red-700',
    }

    return (
        <div className="bg-white border border-gray-200 rounded-lg p-4">
            <span
                className={
                    'inline-block text-xs px-2 py-0.5 rounded ' +
                    (colores[color] ?? colores.blue)
                }
            >
                {etiqueta}
            </span>
            <p className="text-3xl text-gray-800 mt-3">{valor}</p>
        </div>
    )
}

export default StatCard

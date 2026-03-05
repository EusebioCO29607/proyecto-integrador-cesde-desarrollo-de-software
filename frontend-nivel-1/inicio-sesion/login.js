// Guardamos el usuario correcto en una variable constante.
// "const" significa que este valor no puede cambiar.
const Usuario_Correcto = "sergio";

// Guardamos la contraseña correcta en otra constante.
const Clave_Correcta = "1111";


// Creamos una función llamada iniciarSesion.
// Una función es un bloque de código que se ejecuta cuando la llamamos.
function iniciarSesion() {

    // Creamos una variable llamada intentos y la iniciamos en 0.
    // Esta variable contará cuántas veces el usuario ha intentado ingresar.
    let intentos = 0;

    // Definimos el número máximo de intentos permitidos.
    // En este caso solo se permiten 3 intentos.
    const MaximoIntentos = 3;

    // Este es un bucle "while".
    // Significa: "repite esto mientras intentos sea menor que MaximoIntentos".
    while (intentos < MaximoIntentos) {
        
        // Le pedimos al usuario que escriba su nombre.
        // prompt muestra una ventanita donde el usuario puede escribir.
        let user = prompt("Digite su usuario sin espacios o símbolos especiales: ");

        // Le pedimos la contraseña.
        let pass = prompt("Digite su contraseña: ");

        // Mostramos en la consola lo que el usuario escribió.
        // Esto es útil para pruebas (solo lo ve el programador).
        console.log(`Usuario: ${user}, Contraseña: ${pass}`);

        // Comprobamos si el usuario y la contraseña son correctos.
        // El doble igual (==) compara si los valores son iguales.
        if (user == Usuario_Correcto && pass == Clave_Correcta) {

            // Si ambos datos coinciden:
            // Mostramos un mensaje de éxito.
            alert("Ingreso exitoso. Bienvenido!");

            // Forzamos la salida del bucle asignando 3 a intentos.
            // Como 3 ya no es menor que 3, el ciclo termina.
            intentos = 3; 

        } else {

            // Si los datos no coinciden:
            // Aumentamos el contador de intentos en 1.
            intentos++;

            // Calculamos cuántos intentos le quedan al usuario.
            let restantes = MaximoIntentos - intentos;
            
            // Si todavía le quedan intentos:
            if (restantes > 0) {

                // Mostramos mensaje indicando cuántos intentos quedan.
                alert(`Usuario y/o contraseña inválida. Intente nuevamente. Te quedan ${restantes} intentos.`);

            } else {

                // Si ya no quedan intentos:
                alert("Has agotado tus intentos. Se bloqueará tu acceso.");
            }
        }
    }
}

// Aquí llamamos (ejecutamos) la función.
// Sin esta línea, la función estaría creada pero nunca se ejecutaría.
iniciarSesion();
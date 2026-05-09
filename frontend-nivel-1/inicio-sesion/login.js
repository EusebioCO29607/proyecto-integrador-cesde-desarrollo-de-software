const Usuario_Correcto = "sergio";
const Clave_Correcta = "1111";

function iniciarSesion() {
    let intentos = 0;
    const MaximoIntentos = 3;

    while (intentos < MaximoIntentos) {
        
        let user=prompt("Digite su usuario: ");
        let pass = prompt("Digite su contraseña: ");

        alert(`Intento ${intentos + 1}: Usuario digitado: "${user}"`);

        if (user == Usuario_Correcto && pass == Clave_Correcta) {

            alert("Ingreso exitoso. Bienvenido!");
            intentos = 3; 

        } else{

            intentos++;
            let restantes =  MaximoIntentos - intentos;
            
            if (restantes > 0) {
                alert(`Datos incorrectos. Te quedan ${restantes} intentos.`);
            }

            else {
                alert("Has agotado tus intentos. Acceso bloqueado.");
            }

        }

    }

}

iniciarSesion();


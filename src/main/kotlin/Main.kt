import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.material.icons.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.singleWindowApplication

@Composable
@Preview
fun LoginScreen(user:String, onEntrada: (String) -> Unit, psswd:String, onEntrada2: (String) -> Unit, estadoBoton:Boolean, onClick:(Boolean) -> Unit, psswdVisible:Boolean, onLogin : () -> Unit) {

    MaterialTheme{

        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){

            Usuario(user,onEntrada)

            Spacer(modifier = Modifier.size(10.dp))

            Psswd(psswd, psswdVisible, onEntrada2)

            Spacer(modifier = Modifier.size(10.dp))

            Boton(estadoBoton, onLogin)
        }


    }

}
@Composable
fun Usuario(
    user: String,
    onEntrada : (String) -> Unit
){
    OutlinedTextField(
        value = user,
        placeholder = { Text("Nombre de usuario") },
        onValueChange = { onEntrada(it) },
        label = { Text("Usuario")}
    )
}

@Composable
fun Psswd(psswd: String, psswdVisible: Boolean, onEntrada2: (String) -> Unit){
    OutlinedTextField(
        value = psswd,
        placeholder = { Text("Contraseña") },
        visualTransformation = if (psswdVisible) VisualTransformation.None else PasswordVisualTransformation(),
        onValueChange = {onEntrada2(it)},
        label = { Text("Contraseña")},
        trailingIcon = {
            IconToggleButton(
                checked = psswdVisible,
                onCheckedChange = {!psswdVisible}
            ){
                Icon(
                    imageVector = if (psswdVisible) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                    contentDescription = null
                )
            }
        }
    )
}

@Composable
fun Boton(estadoBoton: Boolean, onLogin: () -> Unit){
    Button(
        onClick = {
            onLogin() },
        enabled = estadoBoton,
        modifier = Modifier
            .size(100.dp, 50.dp)
    ){
        Text("LOGIN")
    }
}

fun main() = application {
    var user by remember { mutableStateOf("") }
    var psswd by remember { mutableStateOf("") }
    var estadoBoton = user.isNotBlank() && psswd.isNotBlank()
    var psswdVisible by remember { mutableStateOf(false)}

    Window(onCloseRequest = ::exitApplication) {
        LoginScreen(
            user,
            onEntrada = {user = it },
            psswd,
            onEntrada2 = {psswd = it},
            estadoBoton,
            onClick = {estadoBoton = it},
            psswdVisible,
            onLogin = {
                user = ""
                psswd = ""
            }
        )
    }
}

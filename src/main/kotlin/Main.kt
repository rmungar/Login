import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.BorderStroke
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.singleWindowApplication

@Composable
@Preview
fun Login() {
    MaterialTheme{

        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){

            OutlinedTextField(
                value = "",
                placeholder = { Text("Nombre de usuario") },
                onValueChange = {}
            )
            Spacer(modifier = Modifier.size(10.dp))
            OutlinedTextField(
                value = "",
                placeholder = { Text("Contraseña") },
                visualTransformation = PasswordVisualTransformation(),
                onValueChange = {},
                modifier = Modifier
            )
            Spacer(modifier = Modifier.size(10.dp))
            Button(
                onClick = {},
                modifier = Modifier
                    .size(100.dp, 50.dp)
            ){
                Text("LOGIN")
            }
        }


    }

}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        Login()
    }
}

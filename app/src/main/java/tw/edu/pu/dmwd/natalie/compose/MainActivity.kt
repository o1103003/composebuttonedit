package tw.edu.pu.dmwd.natalie.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tw.edu.pu.dmwd.natalie.compose.ui.theme.ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    var msg= remember { mutableStateOf("World") }
    
    Column {
        Text(text = msg.value,
        modifier = Modifier.clickable { 
            if (msg.value=="World"){
                msg.value=="Hello"
            }
            else{
                msg.value=="World"
            }
        })
        Button(onClick = {
            if (msg.value=="作者：鍾愛麗"){
                msg.value=="課程：行動應用軟體開發"
            }
            else{
                msg.value=="作者：鍾愛麗"
            }
        },
        shape= RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Yellow),
            border = BorderStroke(1.dp, Color.Red)
        ) {
            Image(painterResource(id = R.drawable.koala),
                contentDescription = "icon",
            modifier = Modifier.size(20.dp))
          Text(text = msg.value, color = Color.Blue)
          Text(text = "變換顔色", color = Color.Green)
        }
        TextField(value = msg.value, onValueChange = {newText->
            msg.value=newText
        },
        label = { Text(text = "姓名")},
        placeholder = { Text(text = "請輸入您的姓名")},
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeTheme {
        Greeting("Android")
    }
}
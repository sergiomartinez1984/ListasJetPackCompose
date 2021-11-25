package com.example.listasjetpackcompose




import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.listasjetpackcompose.ui.theme.ListasJetPackComposeTheme
import com.example.listasjetpackcompose.modelos.Personajes
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.*
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.em
import coil.compose.rememberImagePainter
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.listasjetpackcompose.ui.theme.CambioPantalla
import kotlin.system.exitProcess


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListasJetPackComposeTheme(){
                // A surface container using the 'background' color from the theme
                Surface(color = Color.Black) {
                    NavigationHost()
                }
            }
        }
    }
}

fun getLista(): List<Personajes> {

    return listOf(
        Personajes(
            "MarioBros",
            " Saga Super Mario Bros",
            " Mario es retratado como un fontanero ítalo-estadounidense que, junto con su hermano menor Luigi, tiene que derrotar a las criaturas que han venido de las alcantarillas de debajo de Nueva York." +
                      "es un videojuego arcade desarrollado por Nintendo en el año 1983. Fue creado por Shigeru Miyamoto.",
            "https://www.nintenderos.com/wp-content/uploads/2019/01/new-super-mario-bros-u-deluxe.jpg6_.jpg"
        ),
        Personajes(
            "Sonic",
            "Sonic the Hedgehog",
            "Sonic el erizo,es un personaje de ficción, es el protagonista de la saga de videojuegos del mismo nombre y la mascota de la compañía Sega." +
                      "Es un erizo azul antropomórfico que tiene la habilidad de moverse a la velocidad del sonido y más allá,mostrando incluso que puede alcanzar la velocidad de la luz y hasta superarla.",
            "https://pbs.twimg.com/media/Duki_iNW0AAYwkB.jpg"
        ),
        Personajes(
            "DonkeyKong",
            "Donkey Kong Country",
            "Donkey Kong el gorila,es un personaje de ficción, creado por Shigeru Miyamoto en 1981. La franquicia principalmente comprende videojuegos de diferentes géneros sobre el mismo personaje",
            "https://cdn.alfabetajuega.com/wp-content/uploads/2021/07/Donkey-Kong.jpg"
        ),
        Personajes(
            "Megaman",
            "Megaman X",
            "Mega Man, conocido en Japón como Rockman , es una franquicia de videojuegos creada por Capcom, que tiene como protagonista a Mega Man o a sus contrapartes." +
                      "Es uno de los personajes más reconocidos de los videojuegos, creado por Akira Kitamura en 1987 para Nintendo Entertainment System",
            "https://www.playerone.vg/wp-content/uploads/2020/01/mega-man-1-e1579781125907.jpg"
        ),
        Personajes(
            "Sub-Zero",
            "Mortal Kombat",
            "Kuai Liang más conocido como Sub-Zero y anteriormente como Tundra es un personaje ficticio de la saga de videojuegos Mortal Kombat. Sub-Zero es el personaje más popular en la serie de Mortal Kombat junto con Scorpion." +
                      "Es un luchador formidable que posee la capacidad innata de controlar el hielo en muchas formas",
            "https://static.posters.cz/image/750/hrnceky/mortal-kombat-x-sub-zero-i29707.jpg"
        ),
        Personajes(
            "PacMan",
            "PacMan",
            "Pac Man es un videojuego arcade creado por el diseñador de videojuegos Toru Iwatani de la empresa Namco, y distribuido por Midway Games al mercado estadounidense a principios de los años 1980.",
            "https://cdn.pixabay.com/photo/2020/05/10/11/03/pacman-5153518_1280.jpg"
        ),
        Personajes(
            "Q*bert",
            "Qbert Classic",
            "Q*bert es un videojuego de arcade desarrollado y publicado por Gottlieb en 1982. Es un juego de plataformas con gráficos en dos dimensiones." +
                      "El objetivo es cambiar el color de todos los cubos de una pirámide haciendo que el protagonista salte encima de cada cubo mientras evita obstáculos y enemigos.",
            "https://www.gamereactor.se/media/87/_1888753.jpg"
        )
    )
}



@Composable
fun Pantalla1( navController: NavController) {
    LazyColumn(
        contentPadding = PaddingValues(10.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,


    )
    {
        items(getLista()) { personaje ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(onClick = {
                        navController.navigate(
                            CambioPantalla.Pantalla2.crearRuta(
                                personaje.nombre
                            )
                        )
                    })

            ){
                CargarImagen(url = personaje.imagen)
            }
        }
    }
}

@Composable
fun Pantalla2(Nombre:String, navController: NavController) {
    val listaPersonajes = getLista()
    var personajeElegido = Personajes("1","1","1","1")

    for (personaje in listaPersonajes){
        if (personaje.nombre == Nombre){
            personajeElegido = personaje
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = Color.Black)
            .padding(24.dp)
    ) {


        Row(modifier = Modifier
            .background(color = Color.Yellow)
            .fillMaxWidth()
            .padding(start = 10.dp)){
            Text(
                text = personajeElegido.nombre,
                color = Color.Black,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                lineHeight = 2.em,
            )
        }

        Row(modifier = Modifier
            .padding(bottom = 20.dp,top = 10.dp)
        ) {
            CargarImagen(url = personajeElegido.imagen)
        }


        Row{
            Text(text = "("+personajeElegido.videojuego+")\n",fontStyle = FontStyle.Normal,fontWeight = FontWeight.Bold,fontSize = 20.sp,lineHeight = 2.em)
        }

        Row{
            Text(text = personajeElegido.descripcion,color = Color.White,lineHeight = 2.em,textAlign = TextAlign.Center)
        }

        Button(onClick = {navController.navigate(CambioPantalla.Pantalla1.ruta)}, modifier = Modifier
            .padding(top = 35.dp)) {
            Text(text = "Inicio")
        }

        Button(onClick = { exitProcess(0)},modifier = Modifier
            .padding(75.dp,15.dp)){
            Text(text = "Salir")

        }
    }
}

@Composable
fun NavigationHost(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = CambioPantalla.Pantalla1.ruta){
        composable(CambioPantalla.Pantalla1.ruta){
            Pantalla1(navController = navController)
        }

        composable(CambioPantalla.Pantalla2.ruta){ navBackStackEntry ->
            var nombre = navBackStackEntry.arguments?.getString("nombre")
            Pantalla2(nombre!!,navController = navController)
        }
    }

}

@Composable
fun CargarImagen(url: String) {
    Image(
        painter = rememberImagePainter(url),
        contentDescription = "Imagen",
        modifier = Modifier
            .fillMaxWidth()
            .border(3.dp, Color.Yellow, shape = CutCornerShape(50.dp))
            .padding(10.dp)
            .height(120.dp)
            .clip(CutCornerShape(100.dp)),

        contentScale = ContentScale.FillWidth


    )
}
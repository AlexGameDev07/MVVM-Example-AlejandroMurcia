package alejando.murcia.app_mvvm.MVVM.Model

import kotlin.random.Random

class ProveedorCitas {
    companion object {
        fun getCitaAleatoria() : mdlCitas {
            val posicion = (0..10).random()
            return listaCitas[posicion]
        }

        private val listaCitas = listOf(
            mdlCitas(
                cita = "¡No es un bug, es una característica no documentada!",
                autor = "Anónimo"
            ),
            mdlCitas(
                cita = "“Desarrollador de software” – Un organismo que convierte cafeína en software",
                autor = "Anónimo"
            ),
            mdlCitas(
                cita = "Si depurar es el proceso de eliminar errores de software, entonces programar debe ser el proceso de ponerlos",
                autor = "Edsger Dijkstra"
            ),
            mdlCitas(
                cita = "Una interfaz de usuario es como un chiste. Si tienes que explicarlo, no es tan bueno.",
                autor = "Anónimo"
            ),
            mdlCitas(
                cita = "¡No me importa si funciona en tu máquina! ¡No estamos enviando tu máquina!",
                autor = "Vidiu Platon"
            ),
            mdlCitas(
                cita = "Medir el progreso en programación por líneas de código es como medir el progreso en la construcción de aviones por peso.",
                autor = "Bill Gates"
            ),
            mdlCitas(
                cita = "Mi código NO funciona, no tengo idea de por qué. Mi código FUNCIONA, no tengo idea de por qué.",
                autor = "Anónimo"
            ),
            mdlCitas(
                cita = "Las cosas no siempre son #000000 y #FFFFFF",
                autor = "Anónimo"
            ),
            mdlCitas(
                cita = "Hablar es barato. Muéstrame el código.",
                autor = "Linus Torvalds"
            ),
            mdlCitas(
                cita = "El software y las catedrales son muy parecidos: primero los construimos, luego rezamos.",
                autor = "Anónimo"
            ),
            mdlCitas(
                cita = "¿Qué esperas?, suscríbete.",
                autor = "AristiDevs"
            )
        )


    }
}
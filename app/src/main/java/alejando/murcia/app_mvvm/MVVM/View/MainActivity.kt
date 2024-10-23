package alejando.murcia.app_mvvm.MVVM.View

import alejando.murcia.app_mvvm.R
import alejando.murcia.app_mvvm.MVVM.ViewModel.CitasViewModel
import alejando.murcia.app_mvvm.databinding.ActivityMainBinding
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer


class MainActivity : AppCompatActivity() {

    //Todo está programado en base a datos locales

    // Esta variable se utiliza para acceder a la vista (layout) inflada.
    private lateinit var binding: ActivityMainBinding

    /*  Se crea una instancia de CitasViewModel utilizando la delegación de
        propiedades `by viewModels()`,
        lo que nos permite obtener una instancia del ViewModel que será
        mantenida por el ciclo de vida de la actividad.
    */
    private val citasViewModel: CitasViewModel by viewModels()

    // Método que se ejecuta cuando se crea la actividad.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Aquí se infla el layout asociado a la actividad usando `ActivityMainBinding.inflate(layoutInflater)`.
        // Esto permite vincular las vistas del XML con código Kotlin.
        binding = ActivityMainBinding.inflate(layoutInflater)


        // Se establece el contenido de la actividad con la raíz de la vista inflada.
        setContentView(binding.root)

        // Llama a un método que habilita las barras de sistema para adaptarse al modo de borde a borde.
        enableEdgeToEdge()

        // Ajusta el padding del contenedor de la vista principal (`viewContainer`)
        // para evitar superposición con las barras del sistema (como la barra de estado y la de navegación).
        ViewCompat.setOnApplyWindowInsetsListener(binding.viewContainer) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Observa el `LiveData` de citas desde el ViewModel. Cuando el LiveData cambia (una nueva cita se selecciona),
        // se actualizan los textos de los componentes `txtCita` y `txtAutor` con los datos de la cita.
        citasViewModel.listaMdlCitas.observe(this, Observer { cita ->
            binding.txtCita.text = cita.cita
            binding.txtAutor.text = cita.autor
        })

        // Se agrega un listener al contenedor de la vista. Cuando el usuario hace clic en cualquier lugar del contenedor,
        // se llama al método `citaAleatoria()` del ViewModel para obtener una nueva cita.
        binding.viewContainer.setOnClickListener {
            citasViewModel.citaAleatoria()
        }
    }
}

package alejando.murcia.app_mvvm.ViewModel

import alejando.murcia.app_mvvm.Model.ProveedorCitas
import alejando.murcia.app_mvvm.Model.mdlCitas
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CitasViewModel : ViewModel() {

    // Esta es una variable LiveData que contiene un objeto de tipo mdlCitas. MutableLiveData
    // permite que el valor pueda ser actualizado y observado por otras clases (como actividades o fragmentos).
    val listaMdlCitas = MutableLiveData<mdlCitas>()

    // Este método obtiene una cita aleatoria y actualiza el LiveData.
    fun citaAleatoria() {
        // Se obtiene una cita aleatoria usando un proveedor (ProveedorCitas es una clase
        // que probablemente gestiona y suministra las citas).
        val citaActual = ProveedorCitas.getCitaAleatoria()

        // Se actualiza el LiveData con la nueva cita obtenida, lo que notificará a los
        // observadores del cambio (como una UI que esté observando este LiveData).
        listaMdlCitas.postValue(citaActual)
    }
}

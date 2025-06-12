package yocupicio.martin.calculadora_yocupiciomartin_228307

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    var numeroActual = ""
    var numeroAnterior = ""
    var operacion: String? = null
    lateinit var resultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla)

        resultado = findViewById(R.id.resultado)

        val uno: Button = findViewById(R.id.uno)
        val dos: Button = findViewById(R.id.dos)
        val tres: Button = findViewById(R.id.tres)
        val cuatro: Button = findViewById(R.id.cuatro)
        val cinco: Button = findViewById(R.id.cinco)
        val seis: Button = findViewById(R.id.seis)
        val siete: Button = findViewById(R.id.siete)
        val ocho: Button = findViewById(R.id.ocho)
        val nueve: Button = findViewById(R.id.nueve)
        val cero: Button = findViewById(R.id.cero)
        val mas: Button = findViewById(R.id.mas)
        val menos: Button = findViewById(R.id.menos)
        val multiplicar: Button = findViewById(R.id.multiplicar)
        val dividir: Button = findViewById(R.id.dividir)
        val limpiar: Button = findViewById(R.id.limpiar)
        val igual: Button = findViewById(R.id.igual)

        // Números
        val botonesNumeros = listOf(uno, dos, tres, cuatro, cinco, seis, siete, ocho, nueve, cero)
        for (boton in botonesNumeros) {
            boton.setOnClickListener {
                numeroActual += boton.text
                resultado.text = numeroActual
            }
        }

        // Operaciones
        mas.setOnClickListener { seleccionarOperacion("+") }
        menos.setOnClickListener { seleccionarOperacion("-") }
        multiplicar.setOnClickListener { seleccionarOperacion("*") }
        dividir.setOnClickListener { seleccionarOperacion("/") }

        // Igual
        igual.setOnClickListener { calcularResultado() }

        // Limpiar
        limpiar.setOnClickListener {
            numeroActual = ""
            numeroAnterior = ""
            operacion = null
            resultado.text = ""
        }
    }

    private fun seleccionarOperacion(op: String) {
        if (numeroActual.isNotEmpty()) {
            numeroAnterior = numeroActual
            numeroActual = ""
            operacion = op
            resultado.text = op
        }
    }

    private fun calcularResultado() {
        if (numeroAnterior.isNotEmpty() && numeroActual.isNotEmpty()) {
            val num1 = numeroAnterior.toDouble()
            val num2 = numeroActual.toDouble()
            val resultadoFinal = when (operacion) {
                "+" -> num1 + num2
                "-" -> num1 - num2
                "*" -> num1 * num2
                "/" -> if (num2 != 0.0) num1 / num2 else "Error"
                else -> "Error"
            }

            resultado.text = resultadoFinal.toString()
            numeroActual = resultadoFinal.toString()
            numeroAnterior = ""
            operacion = null
        }
    }
}

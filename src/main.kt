import kotlin.coroutines.coroutineContext

const val PI = 3.2
const val va = 2

fun main() {
    println(va)
    var numero = 7
    var resultado = numero.and(4) //Comparación bit a bit
    println(resultado)
    resultado = numero.and(3)
    println(resultado)
    resultado = numero.and(2)
    println(resultado)

    resultado = numero.and(-2)
    println(resultado)

    resultado = numero.dec() //Disminuye el valor en 1
    println(resultado)

    resultado =
        numero.inv() //Invierte los bits del valor: 3 es 0000 0011, que invertido seria -4 => 1111 1100 (los unos anteriores lo convierten en negativo)
    println(resultado)

    resultado = numero.minus(6) //resta
    println(resultado)

    resultado = numero.plus(4) //suma
    println(resultado)

    resultado = numero.or(3) //or bit a bit
    println(resultado)

    resultado = numero.rem(3)// residuo de la division truncada
    println(resultado)

    resultado = numero.shl(3)
    println(resultado) //corrimiento a la izquierda tres veces

}
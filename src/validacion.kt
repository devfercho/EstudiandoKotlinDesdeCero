fun main() {
    haciendoWhen()
    usandoWhileYDoWhile()
    usandoFor()
    usandoTryCatch()
    usandoListas()
    usandoListasOrdenadas()
    usandoMap()
    usandoSet()
    usandoFuncionesDeExtension()
    enviarParametrosPorDefault(edad = 22)
    trabajarFuncionesLambda()
    trabajarFuncionesAltoOrden()
    trabajarConWith()
    trabajarConRun()
    trabajarConApply()
    trabajarConAlso()
}

fun haciendoWhen() {
    println("---- INICIO DE WHEN ----")

    val saludo = when ("Hombre") {
        "Hombre" -> "Hola caballero"
        "Mujer" -> "Hola dama"
        else -> "Hola"
    }

    println(saludo)

    val mensajeFinal = when (205) {
        in 200..399 -> "Todo ha salido bien"
        in 400..499 -> "Todo ha salido mal"
        else -> "Quien sabe"
    }

    println(mensajeFinal)
    println("----FIN DE WHEN----")
}

fun usandoWhileYDoWhile() {
    println("----INICIANDO WHILE Y DO WHIILE----")
    var contador = 10
    while (contador > 0) {
        println("Contador es $contador")
        contador--
    }

    do {
        println("Generando numero aleatorio")
        val numeroAleatorio = (0..100).random()
        println("El numero generado es $numeroAleatorio")
    } while (numeroAleatorio < 50)
    println("----FIN WHILE Y DO WHIILE----")
}

fun usandoFor() {
    val listaDeFrutas = listOf("Manzanas", "Peras", "Bananos")
    val listaFibonacii = listOf(1, 1, 2, 3, 5, 8, 13)


    for (fruta in listaDeFrutas) {
        println("Soy la fruta: $fruta")
    }

    listaDeFrutas.forEach { fruta ->
        println("Soy la fruta: $fruta")
    }

    val caracteresDeFruta: List<Int> = listaDeFrutas.map { fruta ->
        fruta.length
    }
    println(caracteresDeFruta)

    val listaFiltrada = caracteresDeFruta.filter { frutaLen -> frutaLen > 5 }
    println(listaFiltrada)

    val listaReversed = listaDeFrutas.asReversed() //Invierte el orden de la lista
    println("8. $listaReversed")

    val ultimoValor = listaDeFrutas.last()
    println(ultimoValor)

    val listaDropLast = listaDeFrutas.dropLast(2)
    println(listaDropLast)

    val valor = listaDeFrutas.elementAtOrElse(4) { "No existe este indice" }
    println(valor)

    val filterIndexed =
        listaFibonacii.filterIndexed { index, numero -> index == numero } //Recorre la lista y compara el indice con el valor en ese indice
    println(filterIndexed)

    val filterIndexedTo = mutableListOf<Int>()
    listaFibonacii.filterIndexedTo(filterIndexedTo) { index, numero -> index == numero } //El resultado de la anterior, lo envia a la nueva lista
    println(filterIndexedTo)

    val list = listOf("123", "45")
    println(list.flatMap { it.toList() }) // [1, 2, 3, 4, 5]


}

fun usandoTryCatch() {
    try {
        throw NullPointerException("Referencia nula")
    } catch (excepcion: NullPointerException) {
        println(excepcion.message)
    }
}

fun usandoListas() {
    //Listas inmutables: No se pueden modificar
    val listaDeNombres = listOf("Juan", "Fernando")
    println(listaDeNombres)

    //Lista mutable: Si se puede modificar despues de llenada
    val listaMutable = mutableListOf<String>()
    println(listaMutable)
    listaMutable.add("Juan")
    println(listaMutable)

    listaMutable[0] = "Fernando"
    println(listaMutable)


}

fun usandoListasOrdenadas() {
    val numerosDeLoteria = listOf(1, 3, 2, 7, 5, 3)

    println("Ordenada: ${numerosDeLoteria.sorted()}")
    println("Descendiente: ${numerosDeLoteria.sortedDescending()}")
    println(
        "OrdenadasPorCondicion: ${
            numerosDeLoteria.sortedBy { numero ->
                numero < 4
            }
        }"
    )
    println(
        "OrdenadasPorCondicion: ${
            numerosDeLoteria.sortedBy { numero ->
                numero > 4
            }
        }"
    )
    println("Aleatoriamente: ${numerosDeLoteria.shuffled()}")
    println(numerosDeLoteria.map { "numero es ${it}" })


}

fun usandoMap() {
    //Mapa inmutable
    val edadSuperHeroes = mapOf(
        "IronMan" to 35,
        "Spiderman" to 23,
        "Capitan america" to 99
    )
    println(edadSuperHeroes)

    //Mapa mutable
    val edadFamilia = mutableMapOf(
        "PApa" to 35,
        "Hermano" to 23,
        "Hermana" to 99
    )
    println(edadFamilia)
    edadFamilia.put("wolverine", 45)
    edadFamilia["Wolverine"] = 45
    println(edadFamilia)

    val edadHermana = edadFamilia["Hermana"]
    println(edadHermana)

    edadFamilia.remove("Hermana")
    println(edadFamilia)

    println("Estas son las claves ${edadFamilia.keys}")

    println("EStos son los valores ${edadFamilia.values}")

    println("EStos son entries ${edadFamilia.entries}")

}

fun usandoSet() {
    val vocalesRepetidas = setOf("a", "e", "a")
    println(vocalesRepetidas)

    val numerosFavoritos = mutableSetOf(1, 2, 1)
    println(numerosFavoritos)

    numerosFavoritos.add(4)
    println(numerosFavoritos)

    numerosFavoritos.remove(1)
    println(numerosFavoritos)

    val valoresDelSet = numerosFavoritos.first { numero -> numero > 2 }
    println(valoresDelSet)

}

fun usandoFuncionesDeExtension() {
    var valor = 5
    valor = valor.sumarConOTro(4)
    println(valor)
}

fun Int.sumarConOTro(otroValor: Int): Int {
    return this.plus(otroValor)
}

fun enviarParametrosPorDefault(primerNombre: String = "", segundoNombre: String = "", edad: Int) {
    println("Hola soy $primerNombre $segundoNombre, y tengo $edad años")
}

fun trabajarFuncionesLambda() {
    val myLambda: (String) -> Int = { valor -> valor.length }
    val lambdaEjecutada: Int = myLambda("hola")
    println(lambdaEjecutada)

    val saludos = listOf("Hello", "Hola", "Ciao")
    val longitudDeSaludos = saludos.map(myLambda)
    println(longitudDeSaludos)
}

fun trabajarFuncionesAltoOrden() {
    val largoDelValorInicial = superFuncion("Fernando", block = { valor ->
        valor.length
    })
    println(largoDelValorInicial)

    println(funcionInception("fernando")())

    println(funcionInceptionCorta("Fernando")())
}

fun superFuncion(valorInicial: String, block: (String) -> Int): Int {
    return block(valorInicial)
}

fun funcionInception(nombre: String): () -> String {
    return {
        "Hola desde la lambda $nombre"
    }
}

fun funcionInceptionCorta(nombre: String): () -> String = { "Hola desde lambda corta $nombre" }

fun trabajarConWith() {
    //El with nos permite usar las propiedas de una variable dentro del with, sin llamar la variable
    val colores = listOf("Azul", "Amarillo", "Rojo")
    with(colores) {
        println("Nuestros colores son $this")
        println("Hay $size colores")
    }
    val letra: String? = null
    with(letra) {
        println("Nuestros colores son $this")
    }

}

fun trabajarConRun() {
    //Permite hacer una serie de operaciones despues de que se crea o se le asigna un valor a la variable

    val moviles = mutableListOf("Google", "Moto", "Huawei")
        .run {
            removeIf { movil ->
                movil.contains("Google")
            }
            this
        }
    println(moviles)

}

fun trabajarConApply() {
    //Aplica los cambios en una variable, sin devolver un valor this

    val moviles = mutableListOf("Google", "Moto", "Huawei")
        .apply {
            removeIf { movil -> movil.contains("Google") }
        }
    println(moviles)

    //Se puede usar con let para validar que la variable no sea nula
    val colores: MutableList<String>? = null
    colores?.apply {
        println("Nuestros colores $this, no son nulos")
    }
}

fun trabajarConAlso() {
    //Realizar una operación y pasando su resultado a la siguiente función.
    // Osea es una concatenación de operaciones
    val moviles = listOf("Google", "Moto", "Huawei").also { lista ->
        println("El valor original de la lista es $lista")
    }.asReversed()
    println(moviles)
}
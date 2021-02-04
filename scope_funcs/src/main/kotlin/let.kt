fun main(args: Array<String>) {
    println("abc".let {
        val toUpperCase = it.toUpperCase()
        toUpperCase + "a"

    })
    println(1.let { it + 2 })
    println(str("abc")?.let { it.toUpperCase() })
    println(str(null)?.let { it.toUpperCase() })
}

fun str(s: String?): String? = s

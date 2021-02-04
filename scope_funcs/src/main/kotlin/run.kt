fun main() {
    println("foo".run { toUpperCase() })
    println(str("foo")?.run { toUpperCase() })
    println(str("foo")?.run {
        val i = 1 + 2
        toUpperCase() + i
    })
}
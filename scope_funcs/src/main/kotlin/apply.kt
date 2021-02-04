fun main() {
    println("foo".apply { this.toUpperCase() })
    println("foo".apply {
        val i = 1 + 2
        this.toUpperCase() + i
        this.toUpperCase()
        this.padEnd(10,'a')
    })
}
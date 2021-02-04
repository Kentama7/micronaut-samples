fun main() {
    println(with("foo") { this.toUpperCase() })
    println(with("foo") {
        this to "bar"
    })
}
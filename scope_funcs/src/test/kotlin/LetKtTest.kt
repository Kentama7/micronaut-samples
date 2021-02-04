import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class LetKtTest {
    @Test
    fun let() {
        val result = "abc".let { it.toUpperCase() }
        assertEquals(result, "ABC")
    }
}
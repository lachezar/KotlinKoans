import java.util.HashMap

fun <K, V>buildMutableMap(f: MutableMap<K, V>.() -> Unit): Map<K, V> {
    val map = mutableMapOf<K, V>()
    map.f()
    return map
}

fun usage(): Map<Int, String> {
    return buildMutableMap {
        this.put(0, "0")
        for (i in 1..10) {
            this.put(i, "$i")
        }
    }
}

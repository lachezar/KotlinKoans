class LazyProperty(val initializer: () -> Int) {
    private var x: Int? = null
    val lazy: Int
        get() {
            val v = x ?: initializer()
            x = v
            return v
        }
}

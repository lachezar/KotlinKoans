import java.util.*

fun <C: MutableCollection<E>, E>Collection<E>.partitionTo(left: C, right: C, predicate: ((E) -> Boolean)): Pair<C, C> {
    for (e in this) {
        if (predicate(e)) left.add(e) else right.add(e)
    }
    return Pair(left, right)
}

fun partitionWordsAndLines() {
    val (words, lines) = listOf("a", "a b", "c", "d e")
            .partitionTo(ArrayList(), ArrayList()) { s -> !s.contains(" ") }
    check(words == listOf("a", "c"))
    check(lines == listOf("a b", "d e"))
}

fun partitionLettersAndOtherSymbols() {
    val (letters, other) = setOf('a', '%', 'r', '}')
            .partitionTo(HashSet(), HashSet()) { c -> c in 'a'..'z' || c in 'A'..'Z' }
    check(letters == setOf('a', 'r'))
    check(other == setOf('%', '}'))
}

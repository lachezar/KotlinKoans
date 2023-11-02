// Return the set of products that were ordered by all customers
fun Shop.getProductsOrderedByAll(): Set<Product> =
    customers.map(Customer::getOrderedProducts).reduce{ acc: Set<Product>, products: Set<Product> ->
        acc.intersect(products)
    }

fun Customer.getOrderedProducts(): Set<Product> =
    orders.fold(setOf()) { acc: Set<Product>, order: Order -> acc + order.products }
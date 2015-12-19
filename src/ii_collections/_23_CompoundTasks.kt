package ii_collections

fun Shop.getCustomersWhoOrderedProduct(product: Product): Set<Customer> {
    // Return the set of customers who ordered the specified product
    return customers.partition { it.orderedProducts.contains(product) }.first.toSet()
}

fun Customer.getMostExpensiveDeliveredProduct(): Product? {
    // Return the most expensive product among all delivered products
    // (use the Order.isDelivered flag)

    return orders.partition { it.isDelivered }.first.flatMap { it.products }.maxBy { it.price }
}

fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
    // Return the number of times the given product was ordered.
    // Note: a customer may order the same product for several times.
//    customers.partition { it.orderedProducts.contains(product) }.first.sumBy { it }
    return getCustomersWhoOrderedProduct(product).sumBy { it.orders.count { it.products.contains(product) } }
}

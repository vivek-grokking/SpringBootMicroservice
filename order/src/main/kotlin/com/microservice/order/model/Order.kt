package com.microservice.order.model

import jakarta.persistence.*

@Entity
@Table(name = "t_orders")
data class Order (
     @Id @GeneratedValue(strategy = GenerationType.AUTO) var id:Long?,
     val orderNumber: String,

     @OneToMany(cascade = [CascadeType.ALL])
     val orderLineItemsList: Collection<OrderLineItems>
) {
     constructor() : this(null, "", emptyList())
     constructor(orderNumber: String, orderLineItemsList: Collection<OrderLineItems>)
             : this(null, orderNumber, orderLineItemsList)
}

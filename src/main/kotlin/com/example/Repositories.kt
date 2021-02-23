package com.example

import io.micronaut.data.repository.CrudRepository
import io.micronaut.data.annotation.*


@Repository
interface IProductRepository: CrudRepository<Product, Int>{

}

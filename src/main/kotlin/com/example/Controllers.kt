package com.example

import io.micronaut.http.annotation.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import javax.inject.Inject
import javax.inject.Singleton

@Controller("/product")
class ProductController(@Inject val serviceProduct:IProductService){

    @Get("/")
    fun getProducts():ResponseEntity<MutableIterable<Product>>{
        println("Enter")
        return ResponseEntity.ok(serviceProduct.getAll())
    }
    @Post("/")
    fun <T> addProduct(@Body product: Product):ResponseEntity<T>{
        serviceProduct.save(product)
        return ResponseEntity.status(HttpStatus.ACCEPTED).build()
    }
    @Delete("/{id}")
    fun <T> delete(@PathVariable id: Int):ResponseEntity<T>{
        serviceProduct.delete(serviceProduct.index(id))
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @Put("/")
    fun <T> update(@Body product: Product):ResponseEntity<T>{
        serviceProduct.update(product)
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
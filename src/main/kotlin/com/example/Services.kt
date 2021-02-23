package com.example

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.jvm.Throws

interface GenericCRUDService<T>{
    @Throws(RuntimeException::class)
    fun save(t:T)
    @Throws(RuntimeException::class)
    fun index(id: Int):Product
    @Throws(RuntimeException::class)
    fun getAll():MutableIterable<T>
    @Throws(RuntimeException::class)
    fun update(t: T)
    @Throws(RuntimeException::class)
    fun delete(t: T)
}
interface IProductService : GenericCRUDService <Product>
@Singleton
class ProductService(@Inject val productRepository: IProductRepository): IProductService{
    override fun save(t: Product) {
        productRepository.save(t)
    }

    override fun index(id: Int):Product {
       return  productRepository.findById(id).get()
    }

    override fun getAll(): MutableIterable<Product> {
       return productRepository.findAll();
    }

    override fun update(t: Product) {
        productRepository.update(t)
    }

    override fun delete(t: Product) {
        productRepository.delete(t)
    }

}
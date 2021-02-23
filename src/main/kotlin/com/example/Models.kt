package com.example

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
data class Product(@Id @GeneratedValue(strategy = GenerationType.SEQUENCE) var id: Int, @Column val title: String, @Column val description: String, @Column val price: Float)

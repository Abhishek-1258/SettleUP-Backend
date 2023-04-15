package com.sleevesup.settleupkotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SettleupKotlinApplication

fun main(args: Array<String>) {
	println("Hello Kotlin")
	runApplication<SettleupKotlinApplication>(*args)
}

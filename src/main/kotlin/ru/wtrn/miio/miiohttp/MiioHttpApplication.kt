package ru.wtrn.miio.miiohttp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MiioHttpApplication

fun main(args: Array<String>) {
	runApplication<MiioHttpApplication>(*args)
}

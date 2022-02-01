package ru.wtrn.miio.miiohttp.dto

import com.fasterxml.jackson.databind.JsonNode

data class ExecuteCommandRequest(
    val address: String,
    val token: String,
    val method: String,
    val params: List<Any> = emptyList()
)

data class DeviceCommandResponse(
    val deviceResponse: JsonNode?
)

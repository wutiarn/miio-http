package ru.wtrn.miio.miiohttp.controller

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.wtrn.miio.Command
import ru.wtrn.miio.Device
import ru.wtrn.miio.Token
import ru.wtrn.miio.miiohttp.dto.DeviceCommandResponse
import ru.wtrn.miio.miiohttp.dto.ExecuteCommandRequest

@RestController
@RequestMapping(("/miio"))
class MiIoHttpController(private val objectMapper: ObjectMapper) {
    @PostMapping("/command")
    fun sendCommand(@RequestBody request: ExecuteCommandRequest): DeviceCommandResponse {
        val token = Token(request.token)
        val device = Device(request.address, token)
        val command = Command(request.method, request.params)
        val miioResponseData = device.sendCommand(command)
        return DeviceCommandResponse(
            deviceResponse = miioResponseData?.let { objectMapper.readTree(it) }
        )
    }
}

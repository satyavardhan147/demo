package com.liveasy.demo.controller;

import com.liveasy.demo.dto.PayloadDTO;
import com.liveasy.demo.model.Payload;
import com.liveasy.demo.service.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller
{

    private Service service;

    public Controller(Service service) {
        this.service = service;
    }

    @PostMapping("/load")
    public String addLoad(@RequestBody Payload payload)
    {
        if(payload == null)
            return "Payload Object is null";
         return service.addPayload(payload);
    }

    @GetMapping("/load/{loadId}")
    public Payload getPayload(@PathVariable("loadId") int loadId)
    {
       return service.getPayloadByLoadId(loadId);
    }

    @GetMapping("/load")
    public List<Payload> getPayloadByShipperId(@RequestParam("shipperId") String shipperId)
    {
        return service.getPayloadByShipperId(shipperId);
    }

    @PutMapping("/load/{loadId}")
    public String updatePayload(@RequestBody PayloadDTO payloadDTO ,@PathVariable("loadId") int loadId)
    {
        return service.uploadPayload(payloadDTO,loadId);
    }

    @DeleteMapping("/load/{loadId}")
    public String deletePayload(@PathVariable("loadId") int loadId)
    {
        return service.deletePayload(loadId);
    }
}

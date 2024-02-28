package com.liveasy.demo.service;

import com.liveasy.demo.dto.PayloadDTO;
import com.liveasy.demo.model.Payload;
import com.liveasy.demo.repository.PayloadRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {

    private PayloadRepository payloadRepository;

    public Service(PayloadRepository payloadRepository) {
        this.payloadRepository = payloadRepository;
    }

    public String addPayload(Payload payload)
    {
        payloadRepository.save(payload);
        return "loads details added successfully";
    }

    public Payload getPayloadByLoadId(int id)
    {
        Payload payload = payloadRepository.findById(id).get();
        return payload;
    }

    public List<Payload> getPayloadByShipperId(String shipperId)
    {
        List<Payload> payloadList = payloadRepository.findAllByShipperId(shipperId);
        return payloadList;
    }

    public String uploadPayload(PayloadDTO payloadDTO,int loadId)
    {
        Payload payload = payloadRepository.findById(loadId).get();
        payload.setUnloadingPoint(payloadDTO.getUnloadingPoint());
        payload.setWeight(payloadDTO.getWeight());
        payload.setTruckType(payloadDTO.getTruckType());
        payload.setDate(payloadDTO.getDate());
        payload.setComment(payloadDTO.getComment());
        payload.setLoadingPoint(payloadDTO.getLoadingPoint());
        payload.setNoOfTrucks(payloadDTO.getNoOfTrucks());
        payload.setProductType(payloadDTO.getProductType());
        payloadRepository.save(payload);
        return "Payload Updated";
    }

    public String deletePayload(int loadId)
    {
        payloadRepository.deleteById(loadId);
        return "Payload Deleted";
    }
}

package com.liveasy.demo.repository;

import com.liveasy.demo.model.Payload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PayloadRepository extends JpaRepository<Payload,Integer> {

    List<Payload> findAllByShipperId(String shipperId);
}

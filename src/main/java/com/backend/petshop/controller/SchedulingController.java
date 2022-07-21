package com.backend.petshop.controller;

import com.backend.petshop.domain.dto.SchedulingRequest;
import com.backend.petshop.domain.dto.SchedulingResponse;
import com.backend.petshop.service.ServiceScheduling;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/scheduling")
@RequiredArgsConstructor
public class SchedulingController {

    private final ServiceScheduling scheduling;

    @GetMapping
    public List<SchedulingResponse> findAll() {
        return this.scheduling.findAll();
    }

    @PostMapping
    public SchedulingResponse save(@RequestBody @Valid SchedulingRequest schedulingRequest) {
        return this.scheduling.save(schedulingRequest);
    }

    @DeleteMapping(value = "/{id}")
    public void removeById(@PathVariable Integer id) {
        this.scheduling.delete(id);
    }


}

package com.brinquedos.fiap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.brinquedos.fiap.assembler.BrinquedoModelAssembler;
import com.brinquedos.fiap.model.BrinquedoModel;
import com.brinquedos.fiap.service.BrinquedoService;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/brinquedos")
public class BrinquedoController {

    @Autowired
    private BrinquedoService brinquedoService;

    @Autowired
    private BrinquedoModelAssembler assembler;
    

    @PostMapping
    public CollectionModel<EntityModel<BrinquedoModel>> createBrinquedos(@Validated @RequestBody List<BrinquedoModel> brinquedos) {
        List<EntityModel<BrinquedoModel>> brinquedoModels = brinquedoService.createBrinquedos(brinquedos).stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(brinquedoModels,
                linkTo(methodOn(BrinquedoController.class).getAllBrinquedos()).withSelfRel());
    }

    @GetMapping
    public CollectionModel<EntityModel<BrinquedoModel>> getAllBrinquedos() {
        List<EntityModel<BrinquedoModel>> brinquedos = brinquedoService.getAllBrinquedos().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(brinquedos,
                linkTo(methodOn(BrinquedoController.class).getAllBrinquedos()).withSelfRel());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<BrinquedoModel>> getBrinquedoById(@PathVariable Long id) {
        return brinquedoService.getBrinquedoById(id)
                .map(assembler::toModel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<BrinquedoModel>> updateBrinquedo(@PathVariable Long id, @RequestBody BrinquedoModel brinquedoDetails) {
        return brinquedoService.updateBrinquedo(id, brinquedoDetails)
                .map(assembler::toModel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EntityModel<BrinquedoModel>> patchBrinquedo(@PathVariable Long id, @RequestBody BrinquedoModel brinquedoDetails) {
        return brinquedoService.patchBrinquedo(id, brinquedoDetails)
                .map(assembler::toModel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBrinquedo(@PathVariable Long id) {
        if (brinquedoService.deleteBrinquedo(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

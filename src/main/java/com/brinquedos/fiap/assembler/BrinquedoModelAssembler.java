package com.brinquedos.fiap.assembler;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.brinquedos.fiap.controller.BrinquedoController;
import com.brinquedos.fiap.model.BrinquedoModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class BrinquedoModelAssembler implements RepresentationModelAssembler<BrinquedoModel, EntityModel<BrinquedoModel>> {
	
    @Override
    public EntityModel<BrinquedoModel> toModel(BrinquedoModel brinquedo) {
        return EntityModel.of(brinquedo,
                linkTo(methodOn(BrinquedoController.class).getBrinquedoById(brinquedo.getId_brinquedo())).withSelfRel(),
                linkTo(methodOn(BrinquedoController.class).getAllBrinquedos()).withRel("brinquedos"));
    }
}

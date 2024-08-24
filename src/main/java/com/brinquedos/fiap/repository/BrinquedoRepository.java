package com.brinquedos.fiap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brinquedos.fiap.model.BrinquedoModel;

public interface BrinquedoRepository extends JpaRepository<BrinquedoModel, Long> {

}

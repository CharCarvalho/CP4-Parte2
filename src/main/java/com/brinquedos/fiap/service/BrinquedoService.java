package com.brinquedos.fiap.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brinquedos.fiap.model.BrinquedoModel;
import com.brinquedos.fiap.repository.BrinquedoRepository;

@Service
public class BrinquedoService {
	
	@Autowired
	private BrinquedoRepository brinquedoRepository;
	
	public BrinquedoModel createBrinquedo(BrinquedoModel brinquedo) {
		return brinquedoRepository.save(brinquedo);
	}
	
	public List<BrinquedoModel> createBrinquedos(List<BrinquedoModel> brinquedos){
		return brinquedoRepository.saveAll(brinquedos);
	}
	
	public List<BrinquedoModel> getAllBrinquedos(){
		return brinquedoRepository.findAll();
	}
	public Optional<BrinquedoModel> getBrinquedoById(Long id){
		return brinquedoRepository.findById(id);
	}

	public Optional<BrinquedoModel> updateBrinquedo(Long id, BrinquedoModel brinquedoDetails){
		return brinquedoRepository.findById(id).map(brinquedo ->{
			brinquedo.setNm_brinquedo(brinquedoDetails.getNm_brinquedo());
			brinquedo.setTipo_brinquedo(brinquedoDetails.getTipo_brinquedo());
			brinquedo.setClassificacao_brinquedo(brinquedoDetails.getClassificacao_brinquedo());
			brinquedo.setTamanho_brinquedo(brinquedoDetails.getTamanho_brinquedo());
			brinquedo.setPreco_brinquedo(brinquedoDetails.getPreco_brinquedo());
			return brinquedoRepository.save(brinquedo);
		});
	}
	
	public Optional<BrinquedoModel> patchBrinquedo(Long id, BrinquedoModel brinquedoDetails) {
        return brinquedoRepository.findById(id).map(brinquedo -> {
            if (brinquedoDetails.getNm_brinquedo() != null) {
                brinquedo.setNm_brinquedo(brinquedoDetails.getNm_brinquedo());
            }
            if (brinquedoDetails.getTipo_brinquedo() != null) {
                brinquedo.setTipo_brinquedo(brinquedoDetails.getTipo_brinquedo());
            }
            if (brinquedoDetails.getClassificacao_brinquedo() != null) {
                brinquedo.setClassificacao_brinquedo(brinquedoDetails.getClassificacao_brinquedo());
            }
            if (brinquedoDetails.getTamanho_brinquedo() != null) {
                brinquedo.setTamanho_brinquedo(brinquedoDetails.getTamanho_brinquedo());
            }
            if (brinquedoDetails.getPreco_brinquedo() != null) {
                brinquedo.setPreco_brinquedo(brinquedoDetails.getPreco_brinquedo());
            }
            return brinquedoRepository.save(brinquedo);
        });
    }
	
	public boolean deleteBrinquedo(Long id) {
		return brinquedoRepository.findById(id).map(brinquedo ->{
			brinquedoRepository.delete(brinquedo);
			return true;
		}).orElse(false);
	}
	
}

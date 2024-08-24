package com.brinquedos.fiap.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Tb_Brinquedos")
public class BrinquedoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id_brinquedo")
	public Long id_brinquedo;
	
	@Column (name = "nm_brinquedo", nullable = false)
	private String nm_brinquedo;
	
	@Column (name = "tp_brinquedo", nullable = false)
	private String tipo_brinquedo;
	
	@Column (name = "class_brinquedo", nullable = false)
	private String classificacao_brinquedo;
	
	@Column (name = "tamanho_brinquedo", nullable = false)
	private String tamanho_brinquedo;
	
	@Column (name = "preco_brinquedo", nullable = false)
	private BigDecimal preco_brinquedo;
}

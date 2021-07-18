package com.hapVida.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
public class AnimalNewDTO {
	
	private Long codigo;
	
	@NotBlank(message = "Preenchimento obrigatório!")
	private String nome;

	private Long vendedorCodigo;

}

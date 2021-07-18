package com.hapVida.entities;

import com.hapVida.enun.EspecieEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ANIMAL")
public class Animal implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name="NOME")
	private String nome;

	@Enumerated(EnumType.STRING)
	@Column(name="ESPECIE")
	private EspecieEnum especieEnum;

	@NotNull
	@Column(name="RACA")
	private String raca;

	@NotNull
	@Column(name="DATA_NASCIMENTO")
	private Date dataNascimento;


	public Animal(Object o, Long codigo, String nome, Veterinario vendedor) {
	}
}

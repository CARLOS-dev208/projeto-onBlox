package com.hapVida.view;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hapVida.entities.Animal;
import com.hapVida.enun.EspecieEnum;
import com.hapVida.utils.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Tuple;

@Data
@AllArgsConstructor
@NoArgsConstructor
//extends futuro ViewCustom
public class AnimalView {

    public AnimalView(Tuple tuple) {
        super(tuple);
    }

    private static final long serialVersionUID = -1L;

    @Override
    public void carregar(Tuple tuple) {
        this.id = Utils.getLong(tuple.get("id"));
        this.nome = Utils.getString(tuple.get("nome"));
        this.raca = Utils.getString(tuple.get("raca"));
        this.especieEnum = EspecieEnum.getValueOf(Utils.getString(tuple.get("status"))).getValue();
        this.dataNascimento = Utils.formataData(Utils.getDate(tuple.get("dataNascimento")), "dd/MM/yyyy");

    }

    @JsonIgnore
    @Override
    public Animal getEntity() {
        Animal animal = new Animal();
        animal.setId(this.id);
        animal.setNome(this.nome);
        animal.setEspecieEnum(EspecieEnum.getValueOf(this.getEspecieEnum()));
        animal.setRaca(this.raca);
        animal.setDataNascimento(Utils.formataData(this.dataNascimento());

        return animal;
    }


    public static String nativaQuery() {
        return "select\n" +
                "animal.id id, " +
                "animal.nome nome, " +
                "animal.especieEnum especieEnum, " +
                "animal.raca raca, " +
                "animal.data_nascimento dataNascimento " +

                "from pneu\n" +
                "WHERE 1=1\n";
    }

    private Long id;
    private String nome;
    private String especieEnum;
    private String raca;
    private String dataNascimento;

}

package com.hapVida.view;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hapVida.entities.Animal;
import com.hapVida.entities.Tutor;
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
public class TutorView {

    public TutorView(Tuple tuple) {
        super(tuple);
    }

    private static final long serialVersionUID = -1L;

    @Override
    public void carregar(Tuple tuple) {
        this.id = Utils.getLong(tuple.get("id"));
        this.nome = Utils.getString(tuple.get("nome"));
        this.telefone = Utils.getString(tuple.get("telefone"));
        this.email = Utils.getString(tuple.get("email"));

    }

    @JsonIgnore
    @Override
    public Tutor getEntity() {
        Tutor tutor = new Tutor();
        tutor.setId(this.id);
        tutor.setNome(this.nome);
        tutor.setTelefone(this.telefone);
        tutor.setEmail(this.email);


        return tutor;
    }


    public static String nativaQuery() {
        return "select\n" +
                "tutor.id id, " +
                "tutor.nome nome, " +
                "tutor.telefone telefone, " +
                "tutor.email email " +

                "from tutor\n" +
                "WHERE 1=1\n";
    }

    private Long id;
    private String nome;
    private String telefone;
    private String email;
}

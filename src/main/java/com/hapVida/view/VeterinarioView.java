package com.hapVida.view;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hapVida.entities.Tutor;
import com.hapVida.entities.Veterinario;
import com.hapVida.utils.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Tuple;

@Data
@AllArgsConstructor
@NoArgsConstructor
//extends futuro ViewCustom
public class VeterinarioView {

    public VeterinarioView(Tuple tuple) {
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
    public Veterinario getEntity() {
        Veterinario veterinario = new Veterinario();
        veterinario.setId(this.id);
        veterinario.setNome(this.nome);
        veterinario.setTelefone(this.telefone);
        veterinario.setEmail(this.email);


        return veterinario;
    }


    public static String nativaQuery() {
        return "select\n" +
                "veterinario.id id, " +
                "veterinario.nome nome, " +
                "veterinario.telefone telefone, " +
                "veterinario.email email " +

                "from veterinario\n" +
                "WHERE 1=1\n";
    }

    private Long id;
    private String nome;
    private String telefone;
    private String email;
}

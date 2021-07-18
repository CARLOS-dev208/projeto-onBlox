package com.hapVida.view;

import com.hapVida.utils.Utils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Tuple;

@Getter
@NoArgsConstructor
public class AnimalSelectView {

    public AnimalSelectView(Tuple tuple) {
        super(tuple);
    }

    public AnimalSelectView(Long id, String nome) {
    }

    public static AnimalSelectView get(Long id, String nome) {
        if (id == null) {
            return null;
        } else {
            return new AnimalSelectView(id, nome);
        }
    }

    private static final long serialVersionUID = -1L;

    @Override
    public void carregar(Tuple tuple) {
        this.id = Utils.getLong(tuple.get("id"));
        this.nome = Utils.getString(tuple.get("nome"));
    }

    public static String nativeQuery() {
        return "SELECT\n" +
                "animal.id,\n" +
                "animal.nome\n" +
                "FROM\n" +
                "animal order by id\n";
    }

    private Long id;
    private String nome;

}

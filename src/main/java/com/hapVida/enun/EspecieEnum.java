package com.hapVida.enun;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum EspecieEnum {

    RARA("RARA", "rara"),
    TIPOA("TIPOA", "tipoA"),
    TIPOB("TIPOB", "tipoB");

    private final String value;
    private final String label;

    public static EspecieEnum getValueOf(String name) {
        if (name != null) {
            for (EspecieEnum b : EspecieEnum.values()) {
                if (b.getValue().equals(name)) {
                    return b;
                }
            }
        }
        return EspecieEnum.TIPOA;
    }

    @JsonCreator
    public static EspecieEnum fromJson(@JsonProperty(value = "value") String valor) {
        return EspecieEnum.getValueOf(valor);
    }
}

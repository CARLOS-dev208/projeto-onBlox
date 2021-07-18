package com.hapVida.custom;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Tuple;
import java.io.Serializable;

    @Data
    @NoArgsConstructor
    public abstract  class ViewCustom<T, ID extends Serializable> implements CrudView<T, Serializable> {

        public ViewCustom(Tuple tuple) {
            carregar(tuple);
        }

        @Override
        public abstract void carregar(Tuple tuple);

//    @Override
//    public abstract String nativeQuery();

        @JsonIgnore
        @Override
        public abstract T getEntity();
}

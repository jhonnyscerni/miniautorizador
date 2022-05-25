package br.com.vr.miniautorizador.utils;

public interface ModelMapper<T, V> {

    V toModel(T entity);

    T toEntity(V model);
}

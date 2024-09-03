package Dao;

import Model.Medicamento;

public interface iDao<T> {
    //va a tener metodos comunes a los crud
    T guardar(T t);
    T buscarporID(Integer Id);
}

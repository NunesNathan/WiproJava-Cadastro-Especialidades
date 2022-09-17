package app.trybe.specialityapp.service;

import app.trybe.specialityapp.model.Professional;

import java.io.Serializable;
import java.util.List;

public interface ServiceInterface<T, I extends Serializable> {
  String save(T s);

  String update(T p, int id);

  String delete(int id);

  List<T> list();
}
package app.trybe.specialityapp.service;

import app.trybe.specialityapp.model.Professional;
import java.util.List;
import javax.persistence.EntityManager;
import org.jvnet.hk2.annotations.Service;

@Service
public class ProfessionalService implements ServiceInterface<Professional, Integer> {

  @Override
  public void save(Professional s) {
    EntityManager em = emf.createEntityManager();

    em.getTransaction().begin();
    em.persist(s);
    em.getTransaction().commit();

    em.close();
  }

  @Override
  public void update(Professional s) {
    EntityManager em = emf.createEntityManager();

    em.getTransaction().begin();
    em.merge(s);
    em.getTransaction().commit();

    em.close();
  }

  @Override
  public void delete(Integer id) {
    EntityManager em = emf.createEntityManager();

    em.getTransaction().begin();
    em.remove(em.find(Professional.class, id));
    em.getTransaction().commit();

    em.close();
  }

  @Override
  public List<Professional> list() {
    EntityManager em = emf.createEntityManager();

    return em.createQuery("SELECT P FROM Professional P", Professional.class).getResultList();
  }

  @Override
  public Professional findById(Integer id) {
    EntityManager em = emf.createEntityManager();
    return em.find(Professional.class, id);
  }
}

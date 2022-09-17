package app.trybe.specialityapp.service;

import app.trybe.specialityapp.commons.ApplicationError;
import app.trybe.specialityapp.model.Professional;
import app.trybe.specialityapp.repository.ProfessionalRepository;
import java.util.List;
import java.util.Optional;
import javax.ws.rs.core.Response;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ProfessionalService implements ServiceInterface<Professional, Integer> {
  @Autowired
  private ProfessionalRepository professionalRepository;

  @Override
  public String save(Professional p) {
    if (p.getId() != null) {
      throw new ApplicationError(Response.Status.BAD_REQUEST,
              "Não é permitido inserir novos registros com ID explícito");
    }

    professionalRepository.save(p);

    return "Inserido";
  }

  @Override
  public String update(Professional p, int id) {
    Optional<Professional> professional = professionalRepository.findById(id);

    if (professional.isPresent()) {
      professional.get().setProfessional(p);

      return String.format("ID [%d] atualizado", id);
    }

    throw new ApplicationError(Response.Status.NOT_FOUND,
      "Não é possível editar, o ID informado não existe");
  }

  @Override
  public String delete(int id) {
    try {
      professionalRepository.deleteById(id);

      return String.format("ID [%d] atualizado", id);
    } catch (Error e) {
      throw new ApplicationError(Response.Status.NOT_FOUND,
              "Não é possível deletar, o ID informado não existe");
    }
  }

  @Override
  public List<Professional> list() {
    List<Professional> profs = professionalRepository.findAll();

    if (profs == null || profs.isEmpty()) {
      throw new ApplicationError(Response.Status.NOT_FOUND,
              "Nenhum registro foi encontrado!");
    }

    return profs;
  }
}

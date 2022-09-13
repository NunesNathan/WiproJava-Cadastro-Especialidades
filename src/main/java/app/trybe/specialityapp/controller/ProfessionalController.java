package app.trybe.specialityapp.controller;

import app.trybe.specialityapp.model.Professional;
import app.trybe.specialityapp.service.ProfessionalService;
import java.util.NoSuchElementException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@Path("/api/professional")
public class ProfessionalController {
  private final ProfessionalService service;

  @Autowired
  public ProfessionalController() {
    this.service = new ProfessionalService();
  }

  @POST
  @Consumes("application/json") // tipo de dado que é consumido
  @Produces("application/json") // tipo de dado enviado como resposta
  public Response insert(Professional professional) {
    service.save(professional);
    return Response.ok(professional).build();
  }

  @GET
  @Consumes("application/json")
  @Produces("application/json")
  public Response findAll() {
    return Response.ok(service.list()).build();
  }

  /** update book method.*/
  @PUT
  @Path("/{id}")
  @Consumes("application/json")
  @Produces("application/json")
  public Response edit(@PathParam("id") Integer id, Professional toUpdate) {
    try {
      Professional professional = service.list().stream()
              .filter(p -> p.getId().equals(id)).findAny().orElseThrow();

      professional.setProfessional(toUpdate);

      return Response.ok(professional).build();
    } catch (NoSuchElementException e) {
      return Response.status(Response.Status.NOT_FOUND).build();
    }
  }

  /** delete book method.*/
  @DELETE
  @Path("/{id}")
  @Consumes("application/json")
  @Produces("application/json")
  public Response delete(@PathParam("id") Integer id) {
    try {
      service.delete(id);

      return Response.status(Response.Status.NO_CONTENT).build();
    } catch (NoSuchElementException e) {
      return Response.status(Response.Status.NOT_FOUND).build();
    }
  }
}
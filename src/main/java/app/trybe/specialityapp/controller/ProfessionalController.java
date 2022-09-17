package app.trybe.specialityapp.controller;

import app.trybe.specialityapp.commons.ApplicationError;
import app.trybe.specialityapp.model.Professional;
import app.trybe.specialityapp.service.ProfessionalService;
import java.util.List;
import java.util.NoSuchElementException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@Path("/professional")
public class ProfessionalController {
  private final ProfessionalService service;

  @Autowired
  public ProfessionalController() {
    this.service = new ProfessionalService();
  }

  /** insert path.*/
  @POST
  @Path("/add")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response insert(Professional p) {
    try {
      String saved = service.save(p);

      return Response.status(Response.Status.CREATED).entity(saved).build();
    } catch (ApplicationError appError) {
      System.out.println(appError.getStatus());
      return Response.status(appError.getStatus())
              .entity(appError)
              .build();
    }
  }

  /** find all path.*/
  @GET
  @Path("/all")
  @Produces(MediaType.APPLICATION_JSON)
  public Response findAll() {
    try {
      List<Professional> professionals = service.list();

      return Response.status(Response.Status.OK).entity(professionals).build();
    } catch (ApplicationError appError) {
      System.out.println(appError.getStatus().getStatusCode());
      return Response.status(appError.getStatus())
              .entity(appError)
              .build();
    }
  }

  /** update book method.*/
  @PUT
  @Path("/edit/{id}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response edit(@PathParam("id") Integer id, Professional toUpdate) {
    try {
      String updated = service.update(toUpdate, id);

      return Response.status(Response.Status.OK).entity(updated).build();
    } catch (ApplicationError appError) {
      System.out.println(appError.getStatus());
      return Response.status(appError.getStatus())
              .entity(appError)
              .build();
    }
  }

  /** delete book method.*/
  @DELETE
  @Path("/delete/{id}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response delete(@PathParam("id") Integer id) {
    try {
      String updated = service.delete(id);

      return Response.status(Response.Status.OK).entity(updated).build();
    } catch (ApplicationError appError) {
      System.out.println(appError.getStatus());
      return Response.status(appError.getStatus())
              .entity(appError)
              .build();
    }
  }
}
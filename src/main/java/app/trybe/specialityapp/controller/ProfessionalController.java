package app.trybe.specialityapp.controller;

import app.trybe.specialityapp.commons.ApplicationError;
import app.trybe.specialityapp.model.Professional;
import app.trybe.specialityapp.service.ProfessionalService;
import java.util.List;
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
@Path("/professional")
public class ProfessionalController {

  @Autowired
  private ProfessionalService professionalService;

  /** insert path.*/
  @POST
  @Path("/add")
  @Consumes("application/json")
  @Produces("application/json")
  public Response insert(Professional p) {
    try {
      String saved = professionalService.save(p);

      return Response.status(Response.Status.CREATED).entity(saved).build();
    } catch (ApplicationError appError) {
      return Response.status(appError.getStatus())
              .entity(appError)
              .build();
    }
  }

  /** find all path.*/
  @GET
  @Path("/all")
  @Produces("application/json")
  public Response findAll() {
    try {
      List<Professional> professionals = professionalService.list();

      return Response.status(Response.Status.OK).entity(professionals).build();
    } catch (ApplicationError appError) {
      return Response.status(appError.getStatus())
              .entity(appError)
              .build();
    }
  }

  /** update book method.*/
  @PUT
  @Path("/edit/{id}")
  @Consumes("application/json")
  @Produces("application/json")
  public Response edit(@PathParam("id") Integer id, Professional toUpdate) {
    try {
      String updated = professionalService.update(toUpdate, id);

      return Response.status(Response.Status.OK).entity(updated).build();
    } catch (ApplicationError appError) {
      return Response.status(appError.getStatus())
              .entity(appError)
              .build();
    }
  }

  /** delete book method.*/
  @DELETE
  @Path("/delete/{id}")
  @Consumes("application/json")
  @Produces("application/json")
  public Response delete(@PathParam("id") Integer id) {
    try {
      String deleted = professionalService.delete(id);

      return Response.status(Response.Status.OK).entity(deleted).build();
    } catch (ApplicationError appError) {
      return Response.status(appError.getStatus())
              .entity(appError)
              .build();
    }
  }
}
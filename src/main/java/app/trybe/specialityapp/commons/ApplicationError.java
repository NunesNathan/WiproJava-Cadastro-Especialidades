package app.trybe.specialityapp.commons;

import javax.ws.rs.core.Response.Status;

public class ApplicationError extends RuntimeException {
  private Status status;
  private String message;

  /** app error constructor.*/
  public ApplicationError(Status status, String message) {
    super(message);
    this.status = status;
    this.message = message;
  }

  public ApplicationError() { }

  public Status getStatus() {
    return status;
  }

  public String getMessage() {
    return message;
  }
}

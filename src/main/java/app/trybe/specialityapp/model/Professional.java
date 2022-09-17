package app.trybe.specialityapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Professional {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "name")
  private String name;

  @Column(name = "speciality")
  private String speciality;

  /** professional constructor for tests.*/
  public Professional(Integer id, String name, String speciality) {
    this.id = id;
    this.name = name;
    this.speciality = speciality;
  }

  /** professional constructor.*/
  public Professional() { }

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setProfessional(Professional professional) {
    this.name = professional.getName();
    this.speciality = professional.getSpeciality();
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSpeciality() {
    return speciality;
  }

  public void setSpeciality(String speciality) {
    this.speciality = speciality;
  }
}

package learningSpringMVC.models;

import jakarta.validation.constraints.NotEmpty;

public class Person {
  private int id;
  @NotEmpty(message = "name should not be empty")
  private String name;

  public Person(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Person() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}

package learningSpringMVC.dao;

import java.util.ArrayList;
import java.util.List;
import learningSpringMVC.models.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonDao {
  private List<Person> people;
  {
    people = new ArrayList<>();
    people.add(new Person(1, "ww"));
    people.add(new Person(2, "pop"));
    people.add(new Person(3, "none"));
  }

  public List<Person> index() {
    return people;
  }

  public Person show(int id) {
    return people.stream().filter(person -> person.getId() == id)
        .findAny().orElseThrow();
  }
}

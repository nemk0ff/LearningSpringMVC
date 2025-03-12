package learningSpringMVC.dao;

import java.util.ArrayList;
import java.util.List;
import learningSpringMVC.models.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonDao {
  private static int COUNTER;
  private List<Person> people;
  {
    people = new ArrayList<>();
    people.add(new Person(++COUNTER, "ww"));
    people.add(new Person(++COUNTER, "pop"));
    people.add(new Person(++COUNTER, "none"));
  }

  public List<Person> index() {
    return people;
  }

  public Person show(int id) {
    return people.stream().filter(person -> person.getId() == id)
        .findAny().orElseThrow();
  }

  public void save(Person person) {
    person.setId(++COUNTER);
    people.add(person);
  }

  public void update(int id, Person person) {
    Person personToBeUpdated = show(id);
    personToBeUpdated.setName(person.getName());
  }

  public void delete(int id) {
    people.removeIf(person -> person.getId() == id);
  }
}

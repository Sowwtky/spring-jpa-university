package jana60.repository;

import org.springframework.data.repository.CrudRepository;

import jana60.model.Teacher;

public interface TeachersRepository extends CrudRepository<Teacher, Integer> {

}

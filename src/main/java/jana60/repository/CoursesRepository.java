package jana60.repository;

import org.springframework.data.repository.CrudRepository;

import jana60.model.Course;

public interface CoursesRepository extends CrudRepository<Course, Integer> {

}

package carrepair;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LogRepository extends CrudRepository<Log, Long> {
    List<Log> findByacceptid(Long acceptid);


}
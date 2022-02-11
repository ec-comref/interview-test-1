package eu.cec.digit.comref.interview.persistent.repository;

import eu.cec.digit.comref.interview.persistent.domain.Watch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WatchRepository extends JpaRepository<Watch, String> {

}

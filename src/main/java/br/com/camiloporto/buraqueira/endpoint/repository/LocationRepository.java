package br.com.camiloporto.buraqueira.endpoint.repository;

import br.com.camiloporto.buraqueira.endpoint.model.Id;
import br.com.camiloporto.buraqueira.endpoint.model.Location;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by camiloporto on 25/04/16.
 */
public interface LocationRepository extends MongoRepository<Location, Id> {
}

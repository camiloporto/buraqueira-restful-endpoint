package br.com.camiloporto.buraqueira.endpoint.repository;

import br.com.camiloporto.buraqueira.endpoint.model.AccelerometerData;
import br.com.camiloporto.buraqueira.endpoint.model.Id;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by camiloporto on 10/04/16.
 */

public interface AccelerometerDataRepository extends MongoRepository<AccelerometerData, Id> {
}

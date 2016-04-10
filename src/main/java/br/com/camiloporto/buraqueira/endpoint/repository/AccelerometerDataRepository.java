package br.com.camiloporto.buraqueira.endpoint.repository;

import br.com.camiloporto.buraqueira.endpoint.model.AccelerometerData;
import br.com.camiloporto.buraqueira.endpoint.model.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by camiloporto on 10/04/16.
 */
@Repository
public interface AccelerometerDataRepository extends JpaRepository<AccelerometerData, Id> {
}

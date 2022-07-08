package kz.aigulsharip.repositories;

import kz.aigulsharip.models.Temparature;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemperatureRepository extends MongoRepository<Temparature, String>{



}

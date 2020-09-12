package ar.com.noaa.mongo.api.repos;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ar.com.noaa.mongo.api.entities.Boya;

@Repository
public interface BoyaRepository extends MongoRepository<Boya, ObjectId> {
    Boya findBy_id(ObjectId _id);
}

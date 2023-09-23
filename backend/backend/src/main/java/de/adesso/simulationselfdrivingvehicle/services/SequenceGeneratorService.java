package de.adesso.simulationselfdrivingvehicle.services;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import java.util.Objects;
import de.adesso.simulationselfdrivingvehicle.entities.DatabaseSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.persistence.Transient;

/**
 * this service that'll generate the auto-incremented value that can be used as id for our Entities
 */
@Service
public class SequenceGeneratorService {
    /**
     * this is a unique reference to the auto-incremented sequence for all entities collection
     */
    public static final String SEQUENCE_ID = "sequence_id";
    final private MongoOperations mongoOperations;

    @Autowired
    public SequenceGeneratorService(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }


    public long generateSequence() {
        DatabaseSequence counter = mongoOperations.findAndModify(query(where("id").is(SEQUENCE_ID)),
                new Update().inc("seq", 1), options().returnNew(true).upsert(true),
                DatabaseSequence.class);
        return !Objects.isNull(counter) ? counter.getSeq() : 1;
    }

}

package de.adesso.simulationselfdrivingvehicle.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

/**
 * this Class (Collection) that'll store the auto-incremented sequence for other collections
 */
@Document(collection = "database_sequences_ids")
@Data
@NoArgsConstructor
public class DatabaseSequence {
    @Id
    private String id;
    private long seq;
}

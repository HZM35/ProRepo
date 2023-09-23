package de.adesso.simulationselfdrivingvehicle.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Id;
import java.time.LocalDateTime;
/** Base  class for all entities */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseElement {

    @Id
    private long id;
    @CreationTimestamp
    private LocalDateTime createdTime;

    @UpdateTimestamp
    private LocalDateTime updatedTime;



}

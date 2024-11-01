package io.cycevents.app.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // Unique identifier for the entity
    private String title;
    @Enumerated(EnumType.STRING)
    private JobType type;
    private String location="Alipur, Kolkata";
    private int vacancies;
    @ElementCollection
    private List<String> responsibilities;
    @Temporal(TemporalType.DATE)
    private Date postDate=new Date();
}

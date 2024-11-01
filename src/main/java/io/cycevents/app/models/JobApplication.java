    package io.cycevents.app.models;

    import jakarta.persistence.*;
    import lombok.AllArgsConstructor;
    import lombok.Builder;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    @Entity
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Data
    public class JobApplication {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String name;
        private String educationQualification;
        private String professionalQualification;
        private int yearOfExperience;
        private String contactNumber;
        private String email;
        private String cv;
        @Column(unique = false)
        private int jobId;
    }

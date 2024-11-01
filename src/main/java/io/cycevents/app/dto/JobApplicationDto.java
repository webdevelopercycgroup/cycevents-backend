package io.cycevents.app.dto;

import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class JobApplicationDto {
    private Long id;
    private String name;
    private String educationQualification;
    private String professionalQualification;
    private int yearOfExperience;
    private String contactNumber;
    private String email;
    private byte[] imageByte;
}

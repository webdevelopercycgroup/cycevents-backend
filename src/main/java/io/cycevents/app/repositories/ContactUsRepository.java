package io.cycevents.app.repositories;

import io.cycevents.app.models.ContactUs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactUsRepository extends JpaRepository<ContactUs,Integer> {
}

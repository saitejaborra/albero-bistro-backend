package com.albero.restro.repository;

import com.albero.restro.model.Mailbody;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MailBodyRepository extends JpaRepository<Mailbody, Integer> {
}

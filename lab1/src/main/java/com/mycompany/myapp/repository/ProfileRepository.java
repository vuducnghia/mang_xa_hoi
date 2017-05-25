package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.Profile;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the Profile entity.
 */
@SuppressWarnings("unused")
public interface ProfileRepository extends JpaRepository<Profile,Long> {

}

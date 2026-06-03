package c.d.pertemuan11.repository;

import c.d.pertemuan11.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, String> {
}
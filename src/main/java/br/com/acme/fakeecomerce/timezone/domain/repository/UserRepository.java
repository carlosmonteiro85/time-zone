package br.com.acme.fakeecomerce.timezone.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.acme.fakeecomerce.timezone.domain.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
}

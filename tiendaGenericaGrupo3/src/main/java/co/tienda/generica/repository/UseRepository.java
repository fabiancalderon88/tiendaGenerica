package co.tienda.generica.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.tienda.generica.model.User;
@Repository
public interface UseRepository extends CrudRepository<User, Long>  {
    public Optional<User> findByUsername(String username);
}
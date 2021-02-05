package br.ufrn.bsi.supplies.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.ufrn.bsi.supplies.entity.User;

public interface UserDao extends CrudRepository<User, Long> {

    List<User> findByLastName(String lastName);

    User findById(long id);

}

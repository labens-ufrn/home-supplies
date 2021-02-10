package br.ufrn.bsi.supplies.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufrn.bsi.supplies.entity.Address;

/**
 * Info:
 * O JpaRepository extende de PagingAndSortingRepository que extende de CrudRepository.
 * https://stackoverflow.com/questions/14014086/what-is-difference-between-crudrepository-and-jparepository-interfaces-in-spring
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    Optional<Address> findByCep(String cep);

}

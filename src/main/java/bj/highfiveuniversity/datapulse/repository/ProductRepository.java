package bj.highfiveuniversity.datapulse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bj.highfiveuniversity.datapulse.model.Product;

// pour dire que c'est un repository
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}

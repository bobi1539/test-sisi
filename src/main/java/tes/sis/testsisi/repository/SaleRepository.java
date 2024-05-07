package tes.sis.testsisi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tes.sis.testsisi.entity.TSale;

public interface SaleRepository extends JpaRepository<TSale, Long> {
}

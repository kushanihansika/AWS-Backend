package lk.aws.inventorysystem.repository;

import lk.aws.inventorysystem.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock,String>{


}

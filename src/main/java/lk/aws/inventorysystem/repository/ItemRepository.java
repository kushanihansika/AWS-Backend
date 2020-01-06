package lk.aws.inventorysystem.repository;

import lk.aws.inventorysystem.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, String> {

}

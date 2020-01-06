package lk.aws.inventorysystem.repository;

import lk.aws.inventorysystem.entity.OrderDetail;
import lk.aws.inventorysystem.entity.OrderDetailPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailPK> {

}

package lk.aws.inventorysystem.repository;

import lk.aws.inventorysystem.entity.CustomEntity;

import java.util.List;

public interface QueryRepository {

    List<CustomEntity> getOrdersTotal();

}

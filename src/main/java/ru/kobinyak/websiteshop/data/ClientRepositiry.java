package ru.kobinyak.websiteshop.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.kobinyak.websiteshop.models.Client;

public interface ClientRepositiry extends
        CrudRepository<Client, Integer>,
        PagingAndSortingRepository<Client, Integer>,
        JpaRepository<Client, Integer>,
        JpaSpecificationExecutor<Client> {
    @Override
    <S extends Client> S save(S s);
}

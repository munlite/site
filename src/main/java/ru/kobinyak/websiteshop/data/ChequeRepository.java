package ru.kobinyak.websiteshop.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.kobinyak.websiteshop.models.Cheque;

public interface ChequeRepository extends CrudRepository<Cheque, Integer>, PagingAndSortingRepository<Cheque, Integer>,
        JpaRepository<Cheque, Integer>, JpaSpecificationExecutor<Cheque> {
}

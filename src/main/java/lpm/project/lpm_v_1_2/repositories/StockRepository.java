package lpm.project.lpm_v_1_2.repositories;

import lpm.project.lpm_v_1_2.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock,Long> {
    Stock findStockByNomProduit(String nomP);
    //void deleteStockByNomProduit(String nomP);

    @Override
    void delete(Stock entity);
}

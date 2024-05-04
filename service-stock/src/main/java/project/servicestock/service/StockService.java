package project.servicestock.service;

import project.servicestock.model.entity.StockEntity;
import project.servicestock.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StockService {
    private final StockRepository stockRepository;
    @Transactional
    public void transfer(StockEntity stock) {
        stockRepository.save(stock);
    }


}

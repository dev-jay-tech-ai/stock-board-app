package project.servicestock.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.servicestock.model.Stock;
import project.servicestock.model.Stocks;
import project.servicestock.model.entity.StocksEntity;
import project.servicestock.repository.StockRepository;
import project.servicestock.repository.StocksRepository;

@Service
@RequiredArgsConstructor
public class StocksService {
    private final StocksRepository stocksRepository;

    @Transactional
    public void transfer(StocksEntity stock) {
        stocksRepository.save(stock);
    }

    public Page<Stocks> list(Pageable pageable) {
        return stocksRepository.findAll(pageable).map(Stocks::fromEntity);
    }

}

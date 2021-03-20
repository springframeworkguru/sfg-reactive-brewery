package guru.springframework.sfgrestbrewery.services;

import guru.springframework.sfgrestbrewery.bootstrap.BeerLoader;
import guru.springframework.sfgrestbrewery.repositories.BeerRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jt on 3/13/21.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ResetService {

    private final BeerRepository beerRepository;
    private final BeerLoader beerLoader;

    @Scheduled(fixedRate = 15000)
    @Transactional
    public void checkBeerCount(){
        if (beerRepository.count() > 100){
            resetBeers();
        }
    }

    @Scheduled(fixedRate = 3600000, initialDelay = 2000)
    @SneakyThrows
    @Transactional
    public void resetBeers(){
        log.info("Resetting Beer Data");
        beerRepository.deleteAllInBatch();
        beerRepository.flush();
        beerLoader.run();
    }

}

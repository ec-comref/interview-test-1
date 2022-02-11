package eu.cec.digit.comref.interview;

import eu.cec.digit.comref.interview.persistent.domain.Watch;
import eu.cec.digit.comref.interview.persistent.repository.WatchRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.function.Predicate.not;

@Slf4j
@SpringBootApplication
public class InterviewTest1Application implements CommandLineRunner {

    @Autowired
    private WatchRepository watchRepository;

    public static void main(String[] args) {
        SpringApplication.run(InterviewTest1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Starting test one");
    }

    public void slowAddWatches(List<Watch> watches) {
        for (Watch watch : watches) {
            watchRepository.save(watch);
        }
    }

    public void fastAddWatches(List<Watch> watches) {
        watchRepository.saveAll(watches);
    }

    public void removeOutOfStockWatches() {
        List<Watch> notAvailableWatches = watchRepository.findAll().stream()
                .filter(not(Watch::getAvailable))
                .collect(Collectors.toList());

        watchRepository.deleteAll(notAvailableWatches);
    }

    public Watch addWatch(String name, Integer value, Integer sold, Boolean available) {
        Watch watch = new Watch();
        watch.setName(name);
        watch.setValue(value);
        watch.setSold(sold);
        watch.setAvailable(available);

        return watchRepository.save(watch);
    }

    public Watch updateWatch(String name, Integer value, Integer sold, Boolean available) {
        Watch watch = getWatch(name);
        watch.setValue(value);
        watch.setSold(sold);
        watch.setAvailable(available);

        return watchRepository.save(watch);
    }

    public Watch getWatch(String name) {
        return watchRepository.findById(name).orElse(null);
    }

    public Watch incrementWatchSales(String name) {
        Watch watch = watchRepository.findById(name).orElse(null);
        if (watch == null) {
            return null;
        }

        watch.setSold(watch.getSold() + 1);
        return watchRepository.save(watch);
    }

    public List<Watch> findAll() {
        return watchRepository.findAll();
    }

    public void deleteWatch(String name) {
        watchRepository.deleteById(name);
    }

}

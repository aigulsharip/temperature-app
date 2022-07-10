package kz.aigulsharip.controllers;

import kz.aigulsharip.models.Temparature;
import kz.aigulsharip.repositories.TemperatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.concurrent.*;

@RestController
public class TempRESTController {

    @Autowired
    TemperatureRepository temperatureRepository;

    @GetMapping("/temps")
    public List<Temparature> getAllTemperatures () {
        return temperatureRepository.findAll();
    }

    @GetMapping("/timer")
    public void getOneRandomTemperature () throws InterruptedException {
        Timer timer = new Timer();

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Random random = new Random();
                List<Temparature> temps = temperatureRepository.findAll();
                int rand = random.nextInt(temps.size());
                System.out.println(temps.get(rand));
            }

        };

        timer.scheduleAtFixedRate(timerTask, new Date(), 5000);
    }

    @GetMapping("/run")
    public Object getOneRandom () throws ExecutionException, InterruptedException {
        //With Runnable
        Random random = new Random();
        Runnable task = () -> {
            List<Temparature> temps = temperatureRepository.findAll();
            int rand = random.nextInt(temps.size());
            System.out.println(temps.get(rand));
            temps.get(rand);
        };
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        ScheduledFuture result = executorService.scheduleAtFixedRate(task, 5,5, TimeUnit.SECONDS);

        return result.get();
    }


    @GetMapping("/cal")
    public Object getOneRandoms () throws ExecutionException, InterruptedException {
        //With Callable
        Random random = new Random();
        List<Temparature> temps = temperatureRepository.findAll();

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        ScheduledFuture scheduledFuture =
                executorService.schedule((Callable) () -> {
                    int rand = random.nextInt(temps.size());
                    System.out.println(temps.get(rand));
                    return temps.get(rand);

                },3,
                        TimeUnit.SECONDS);
        return scheduledFuture.get();
    }


}

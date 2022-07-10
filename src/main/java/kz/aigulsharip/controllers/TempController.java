package kz.aigulsharip.controllers;

import kz.aigulsharip.models.Temparature;
import kz.aigulsharip.repositories.TemperatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;
import java.util.concurrent.*;

@Controller
public class TempController {

    @Autowired
    TemperatureRepository temperatureRepository;

    @GetMapping(value = "/")
    public String index(Model model) throws ExecutionException, InterruptedException {
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

        Temparature randomTemp = (Temparature) scheduledFuture.get();
        String city = randomTemp.getCity();
        String temperature = randomTemp.getTemperature();
        model.addAttribute("city", city);
        model.addAttribute("temperature", temperature);
        return "temps.html";
    }


}

package kz.aigulsharip.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Temparature {

    public Temparature() {
    }

    public Temparature(String city, String temperature) {
        this.city = city;
        this.temperature = temperature;
    }

    @Id
    private String id;

    @Field
    private String city;

    @Field
    private String temperature;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "Temparature{" +
                "id='" + id + '\'' +
                ", city='" + city + '\'' +
                ", temperature='" + temperature + '\'' +
                '}';
    }
}

package com.unac.salescarpremium;
import com.unac.salescarpremium.dao.CarDAO;
import com.unac.salescarpremium.dtos.CarDTO;
import com.unac.salescarpremium.entities.Car;
import com.unac.salescarpremium.services.interfaces.CarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class CarTest {

    @MockBean
    private CarDAO carDAO;
    @Autowired
    private CarService carService;
    private List<Car> carList;


    @BeforeEach
    void setUp() {
        carList = new ArrayList<>();
        Car car1 = new Car();
        car1.setId(1L);
        car1.setModel(2024);
        car1.setColor("Blanco");
        car1.setFechafabri(LocalDate.of(2024, 2, 4));
        car1.setLinea("Yaris");
        car1.setMarca("Toyota");
        car1.setPlaca("GGT-563");

        carList.add(car1);

        Car car2 = new Car();
        car2.setId(2L);
        car2.setModel(2022);
        car2.setColor("Gris");
        car2.setFechafabri(LocalDate.of(2024, 2, 4));
        car2.setLinea("Hilux");
        car2.setMarca("Toyota");
        car2.setPlaca("WGT-889");

        carList.add(car2);

    }


    @Test
    @DisplayName("Should return a list cars")
    void findAllCars() {
        // Contenido del Test

        when(carDAO.findAll()).thenReturn(carList);

        List<CarDTO> reponse = carService.findAllService();

        assertEquals("Toyota", reponse.get(0).getMarca());
        assertEquals(2, reponse.size());
    }

    @Test
    @DisplayName("Should return a car by Id")
    void findOneCar() {

        when(carDAO.findById(1L)).thenReturn(Optional.of(carList.get(0)));
        Optional<CarDTO> responde = carService.findOneService(1L);
        assertEquals(1L, responde.get().getId());
    }
}

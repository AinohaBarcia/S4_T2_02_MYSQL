package cat.itacademy.barcelonactiva.Barcia.Ainoha.s04.t02.model.services;



import cat.itacademy.barcelonactiva.Barcia.Ainoha.s04.t02.model.domain.Fruit;

import java.util.List;

public interface IServices {


        Fruit createFruit(Fruit fruit);

        Fruit updateFruit(Fruit fruit);

        void deleteFruit(Integer id);

        Fruit getFruitById(Integer id);

        List<Fruit> getAllFruits();
    }

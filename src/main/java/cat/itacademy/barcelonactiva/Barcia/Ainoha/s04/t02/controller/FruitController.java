package cat.itacademy.barcelonactiva.Barcia.Ainoha.s04.t02.controller;

import cat.itacademy.barcelonactiva.Barcia.Ainoha.s04.t02.FruitException;
import cat.itacademy.barcelonactiva.Barcia.Ainoha.s04.t02.model.domain.Fruit;
import cat.itacademy.barcelonactiva.Barcia.Ainoha.s04.t02.model.services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/fruits")
public class FruitController {
    @Autowired
    private FruitService fruitService;

    @PostMapping("/createFruit")
    public ResponseEntity<Fruit> createFruit (@RequestBody Fruit fruit){
        Fruit fruitObj = fruitService.createFruit(fruit);

        return new ResponseEntity<>(fruitObj, HttpStatus.OK);
    }


    @PostMapping("/updateFruitById/{id}")
    public ResponseEntity<Fruit> updateFruitById(@PathVariable Integer id, @RequestBody Fruit newFruitData) {
        try {
            Fruit updatedFruit = fruitService.updateFruit(id, newFruitData);
            return new ResponseEntity<>(updatedFruit, HttpStatus.OK);
        } catch (FruitException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/deleteFruitById/{id}")
    public ResponseEntity<HttpStatus> deleteFruitById (@PathVariable Integer id){
        fruitService.deletfruit(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getFruitById/{id}")
    public ResponseEntity<Fruit> getFruitById(@PathVariable("id") Integer id) {
        try {
            Fruit fruit = fruitService.getFruitById(id);
            return new ResponseEntity<>(fruit, HttpStatus.OK);
        } catch (FruitException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/getAllFruits")
    public ResponseEntity<List<Fruit>> getAllFruits() {
        try {
            List<Fruit> fruitList = fruitService.findAllFruit();
            if (fruitList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(fruitList, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}







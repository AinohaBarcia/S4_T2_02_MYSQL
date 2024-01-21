package cat.itacademy.barcelonactiva.Barcia.Ainoha.s04.t02.model.services;


import cat.itacademy.barcelonactiva.Barcia.Ainoha.s04.t02.FruitException;
import cat.itacademy.barcelonactiva.Barcia.Ainoha.s04.t02.model.domain.Fruit;
import cat.itacademy.barcelonactiva.Barcia.Ainoha.s04.t02.model.repository.IFruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitService implements IServices{

    @Autowired
    private IFruitRepository fruitRepository;

    public Fruit createFruit (Fruit fruit){
        return fruitRepository.save(fruit);
    }

    @Override
    public Fruit updateFruit(Fruit fruit) {
        return null;
    }

    @Override
    public void deleteFruit(Integer id) {

    }

    //TODO implementar logica
    public Fruit updateFruit(Integer id, Fruit newFruitData) throws FruitException {
        Optional<Fruit> optionalFruit = fruitRepository.findById(id);
        if (optionalFruit.isPresent()) {
            Fruit oldFruit = optionalFruit.get();
            oldFruit.setName(newFruitData.getName());
            oldFruit.setAmountKilos(newFruitData.getAmountKilos());
            return fruitRepository.save(oldFruit);
        } else {
            throw new FruitException ("Fruit with id: " + id + " not found ");
        }
    }

    public void deletfruit(Integer id){
        fruitRepository.deleteById(id);
        System.out.println("The fruit with ID " + id + "is delete");
    }
    public Fruit getFruitById (Integer id){
        Optional<Fruit> optionalFruit = fruitRepository.findById(id);
        return optionalFruit.get();
    }

    @Override
    public List<Fruit> getAllFruits() {
        return null;
    }

    public List<Fruit> findAllFruit (){
        return fruitRepository.findAll();
    }





}

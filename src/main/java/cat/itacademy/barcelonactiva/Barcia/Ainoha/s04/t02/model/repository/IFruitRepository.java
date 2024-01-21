package cat.itacademy.barcelonactiva.Barcia.Ainoha.s04.t02.model.repository;

import cat.itacademy.barcelonactiva.Barcia.Ainoha.s04.t02.model.domain.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFruitRepository extends JpaRepository<Fruit,Integer> {
}


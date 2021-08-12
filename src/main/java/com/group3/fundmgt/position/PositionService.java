package com.group3.fundmgt.position;

import com.group3.fundmgt.manager.Manager;
import com.group3.fundmgt.manager.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PositionService {

    @Autowired
    private final PositionRepository positionRepository;

    @Autowired
    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    public List<Position> getPositions(){
        return positionRepository.findAll();
    }

    public Position getPosition(Long id){
        Optional<Position> position = positionRepository.findById(id);
        //查Position是否存在
        if(position.isEmpty()){
            throw new PositionNotFoundException(id);
        }
        return position.get();
    }

    public void addPosition(Position position){
        //查security是否存在,需要先写security

        positionRepository.save(position);
    }

    public void deletePosition(Long id){
        if(positionRepository.existsById(id)){
            positionRepository.deleteById(id);
        }
        else{
            throw new PositionNotFoundException(id);
        }
    }

    @Transactional
    public void updatePosition(Long id, Position updatePosition){
        Optional<Position> positionOptional = positionRepository.findById(id);
        if(positionOptional.isEmpty()){
            throw new PositionNotFoundException(id);
        }
        Position position=positionOptional.get();
        //check id
        if (updatePosition.getId() != null && updatePosition.getId() != position.getId()){
            //TODO USe custom exception.
            throw new IllegalStateException("Position ID in path and in request body are different.");
        }

        //check
    }
}

package com.group3.fundmgt.position;

import com.group3.fundmgt.manager.Manager;
import com.group3.fundmgt.manager.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void updatePosition(){

    }
}

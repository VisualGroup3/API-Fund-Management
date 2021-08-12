package com.group3.fundmgt.position;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/FounManager/position")
public class PositionController {

    @Autowired
    private PositionService positionService;

    @PostMapping(path="/addPosition")
    public void addPosition(@RequestBody Position position){
        System.out.println(position.toString());
        positionService.addPosition(position);
    }

    @GetMapping(path="/getPositions")
    public List<Position> getPositions(){
        List<Position> positions=positionService.getPositions();
        for(Position p:positions){
            System.out.println(p.toString());
        }
        return positions;
    }

    @GetMapping(path="/getPosition/{positionId}")
    public Position getPositions(@PathVariable("positionId") Long id){
        Position position=positionService.getPosition(id);
        System.out.println(position.toString());
        return position;
    }

    @DeleteMapping(path="/delete/{positionId}")
    public void deletePosition(@PathVariable("positionId") Long id){
        System.out.println("delete");
        positionService.deletePosition(id);
    }
}

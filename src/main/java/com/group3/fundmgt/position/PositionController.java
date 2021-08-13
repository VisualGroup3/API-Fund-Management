package com.group3.fundmgt.position;

import com.group3.fundmgt.manager.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/v1/positions")
public class PositionController {

    @Autowired
    private PositionService positionService;

    @PostMapping(path="/createNewPosition/{positionId}")
    public void addPosition(@RequestBody Position position){
        System.out.println(position.toString());
        positionService.addPosition(position);
    }

    @GetMapping
    public List<Position> getPositions(){
        List<Position> positions=positionService.getPositions();
        for(Position p:positions){
            System.out.println(p.toString());
        }
        return positions;
    }

    @GetMapping(path="/getPositions/{positionId}")
    public Position getPositions(@PathVariable("positionId") Long id){
        Position position=positionService.getPosition(id);
        System.out.println(position.toString());
        return position;
    }

    @DeleteMapping(path="/deletePosition/{positionId}")
    public void deletePosition(@PathVariable("positionId") Long id){
        System.out.println("delete");
        positionService.deletePosition(id);
    }

    @PutMapping("{positionId}")
    public void updateManager(@PathVariable("positionId") Long positionId,
                              @RequestBody Position position) {
        positionService.updatePosition(positionId, position);
    }
}

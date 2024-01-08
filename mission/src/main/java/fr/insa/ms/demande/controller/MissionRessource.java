package fr.insa.ms.demande.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.ms.demande.service.MissionService;

@RestController
@RequestMapping("/mission")
public class MissionRessource {

    private final MissionService missionService;

    @Autowired
    public MissionRessource(MissionService missionService) {
        this.missionService = missionService;
    }

    @GetMapping("/all")
    public List<Map<String, Object>> getAllMissions() {
        return missionService.getAllMissions();
    }

    @GetMapping("/{id}")
    public Map<String, Object> getMissionById(@PathVariable("id") int id) {
        return missionService.getMissionById(id);
    }

    @PostMapping("/add")
    public void addMission(@RequestParam int id,@RequestParam int iddemandeur, @RequestParam String state,
            @RequestParam int score, @RequestParam String comment) {
        missionService.saveMission(id,iddemandeur, state,score,comment);
    }

    @PostMapping("/validate/{id}")
    public void validateMission(@PathVariable("id") int id) {
        missionService.validateMission(id);
    }

    @PostMapping("/refuse/{id}")
    public void refuseMission(@PathVariable("id") int id) {
        missionService.refuseMission(id);
    }

    @PostMapping("/finish/{id}")
    public void finishMission(@PathVariable("id") int id,
                              @RequestParam int score,
                              @RequestParam String comment) {
        missionService.finishMission(id, score, comment);
    }

    @PutMapping("/updateState/{id}")
    public void updateMission(@PathVariable("id") int id, @RequestBody String state) {
        missionService.updateMissionState(id, state);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMission(@PathVariable("id") int id) {
        missionService.deleteMission(id);
    }
}

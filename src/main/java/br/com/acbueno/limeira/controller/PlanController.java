package br.com.acbueno.limeira.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.acbueno.limeira.controller.dto.request.PlanRequestDTO;
import br.com.acbueno.limeira.controller.dto.response.PlanResponseDTO;
import br.com.acbueno.limeira.controller.dto.response.UserResponseDTO;
import br.com.acbueno.limeira.service.PlanService;

@RestController
@RequestMapping("/plan")
public class PlanController {

  @Autowired
  private PlanService planService;

  @GetMapping("/{userId}")
  public ResponseEntity<List<PlanResponseDTO>> getAllPlans(@PathVariable("userId") String idUser) {
    return ResponseEntity.ok().body(planService.getAllPlanByUser(idUser));
  }

  @GetMapping("/{userId}/{planId}")
  public ResponseEntity<UserResponseDTO> updatePlan(@PathVariable("userId") String userId,
      @PathVariable("planId") String planId, @RequestBody PlanRequestDTO plan) {
    return ResponseEntity.ok().body(planService.updatePlan(userId, planId, plan));
  }

}

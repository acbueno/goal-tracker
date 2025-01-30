package br.com.acbueno.limeira.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.acbueno.limeira.controller.dto.request.GoalRequestDTO;
import br.com.acbueno.limeira.controller.dto.request.PlanRequestDTO;
import br.com.acbueno.limeira.controller.dto.request.UserRequestDTO;
import br.com.acbueno.limeira.controller.dto.response.UserResponseDTO;
import br.com.acbueno.limeira.service.GoalService;

@RestController
@RequestMapping("/users")
public class GoalController {

  @Autowired
  private GoalService goalService;

  @GetMapping
  public ResponseEntity<List<UserResponseDTO>> getAllUser() {
    return ResponseEntity.ok().body(goalService.getAllUser());
  }

  @PostMapping
  public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO dto) {
    return ResponseEntity.ok().body(goalService.createUser(dto));
  }

  @PostMapping("/{userId}/plans")
  public ResponseEntity<UserResponseDTO> addPlanToUser(@PathVariable("userId") String userId,
      @RequestBody PlanRequestDTO plan) {
    return ResponseEntity.ok().body(goalService.addPlanToUser(userId, plan));
  }

  @PatchMapping("/{userId}/plans/{planId}/goals/{goalsId}")
  public ResponseEntity<UserResponseDTO> updateGoalProgress(@PathVariable("userId") String userId,
      @PathVariable("planId") String planId, @PathVariable("goalId") String goalId,
      @RequestParam int progress) {
    return ResponseEntity.ok()
        .body(goalService.updateGoalProgress(userId, planId, goalId, progress));
  }

  @GetMapping("/{userId}/plans/{planId}/goals/{goalsId}")
  public ResponseEntity<UserResponseDTO> updateGoal(@PathVariable("userId") String userId,
      @PathVariable("planId") String planId, @PathVariable("goalId") String goalId,
      @RequestBody GoalRequestDTO request) {
    return ResponseEntity.ok(goalService.updateGoal(userId, planId, goalId, request));

  }

}

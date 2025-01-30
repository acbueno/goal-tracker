package br.com.acbueno.limeira.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.acbueno.limeira.controller.dto.request.GoalRequestDTO;
import br.com.acbueno.limeira.controller.dto.request.PlanRequestDTO;
import br.com.acbueno.limeira.controller.dto.request.UserRequestDTO;
import br.com.acbueno.limeira.controller.dto.response.UserResponseDTO;
import br.com.acbueno.limeira.model.Goal;
import br.com.acbueno.limeira.model.Plan;
import br.com.acbueno.limeira.model.User;
import br.com.acbueno.limeira.repository.PlanRepository;
import br.com.acbueno.limeira.repository.UserRepository;

@Service
public class GoalService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PlanRepository planRepository;

  @Autowired
  private ModelMapper modelMapper;

  public UserResponseDTO createUser(UserRequestDTO dto) {
    User entity = modelMapper.map(dto, User.class);
    return modelMapper.map(userRepository.save(entity), UserResponseDTO.class);
  }

  public List<UserResponseDTO> getAllUser() {
    List<UserResponseDTO> usersResponse = new ArrayList<>();
    userRepository.findAll().forEach(user -> {
      usersResponse.add(modelMapper.map(user, UserResponseDTO.class));
    });;
    return usersResponse;
  }

  public List<Plan> getAllPlan() {
    return planRepository.findAll();
  }

  public UserResponseDTO addPlanToUser(String userId, PlanRequestDTO plan) {
    Optional<User> user = userRepository.findById(userId);

    if (user.isPresent()) {
      user.get().getPlans().add(modelMapper.map(plan, Plan.class));
      return modelMapper.map(userRepository.save(user.get()), UserResponseDTO.class);
    }
    return null;
  }

  public UserResponseDTO updateGoalProgress(String userId, String planId, String goalId,
      int progress) {
    Optional<User> user = userRepository.findById(userId);

    if (user.isPresent()) {
      List<Plan> plans = user.get().getPlans();
      for (Plan plan : plans) {
        if (plan.getPlanId().equals(planId)) {
          for (Goal goal : plan.getGoals()) {
            if (goal.getGoalId().equals(goalId)) {
              goal.setProgress(progress);
              return modelMapper.map(userRepository.save(user.get()), UserResponseDTO.class);
            }
          }
        }
      }
    }
    return null;
  }

  public UserResponseDTO updateGoal(String userId, String planId, String goalId,
      GoalRequestDTO goalUpdate) {
    Optional<User> user = userRepository.findById(userId);

    if (user.isPresent()) {
      for (Plan plan : user.get().getPlans()) {
        if (plan.getPlanId().equals(planId)) {
          List<Goal> goals = plan.getGoals();
          for (int i = 0; i < goals.size(); i++) {
            if (goals.get(i).getGoalId().equals(goalId)) {
              Goal goal = modelMapper.map(goalUpdate, Goal.class);
              goals.set(i, goal);
              return modelMapper.map(userRepository.save(user.get()), UserResponseDTO.class);
            }
          }
        }
      }
    }
    return null;
  }

}

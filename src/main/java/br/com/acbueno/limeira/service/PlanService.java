package br.com.acbueno.limeira.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.acbueno.limeira.controller.dto.request.PlanRequestDTO;
import br.com.acbueno.limeira.controller.dto.response.PlanResponseDTO;
import br.com.acbueno.limeira.controller.dto.response.UserResponseDTO;
import br.com.acbueno.limeira.model.Plan;
import br.com.acbueno.limeira.model.User;
import br.com.acbueno.limeira.repository.UserRepository;

@Service
public class PlanService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private ModelMapper modelMapper;

  public List<PlanResponseDTO> getAllPlanByUser(String userId) {
    List<PlanResponseDTO> listPlanReponse = new ArrayList<>();
    Optional<User> user = userRepository.findById(userId);
    if (user.isPresent()) {
      user.get().getPlans().forEach(p -> {
        listPlanReponse.add(modelMapper.map(p, PlanResponseDTO.class));
      });

    }
    return listPlanReponse;
  }

  public UserResponseDTO updatePlan(String userId, String planId, PlanRequestDTO planUpdate) {
    Optional<User> user = userRepository.findById(userId);

    if (user.isPresent()) {
      List<Plan> plans = user.get().getPlans();
      for (int i = 0; i < plans.size(); i++) {
        if (plans.get(i).getPlanId().equals(planId)) {
          Plan plan = modelMapper.map(planUpdate, Plan.class);
          plans.set(i, plan);
          return modelMapper.map(userRepository.save(user.get()), UserResponseDTO.class);
        }
      }
    }
    return null;
  }

}

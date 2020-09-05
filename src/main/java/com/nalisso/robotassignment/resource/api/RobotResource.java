package com.nalisso.robotassignment.resource.api;

import com.nalisso.robotassignment.resource.api.dto.RobotMovementResponseDTO;
import com.nalisso.robotassignment.resource.api.dto.RobotMovementSpecificationDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface RobotResource {

    @Operation(summary = "Move a robot according to a provided movement specification")
    @PostMapping
    RobotMovementResponseDTO moveRobot(@RequestBody RobotMovementSpecificationDTO robotMovementSpecificationDTO);

}

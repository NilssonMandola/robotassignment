package com.nalisso.robotassignment.resource.api;

import com.nalisso.robotassignment.resource.api.dto.RobotMovementResponseDTO;
import com.nalisso.robotassignment.resource.api.dto.RobotMovementSpecificationDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface RobotResource {

    @PostMapping
    public RobotMovementResponseDTO moveRobot(@RequestBody RobotMovementSpecificationDTO robotMovementSpecificationDTO);

}

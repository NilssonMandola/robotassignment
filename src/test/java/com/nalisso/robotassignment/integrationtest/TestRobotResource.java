package com.nalisso.robotassignment.integrationtest;

import com.nalisso.robotassignment.resource.api.dto.DirectionDTO;
import com.nalisso.robotassignment.resource.api.dto.PositionDTO;
import com.nalisso.robotassignment.resource.api.dto.RobotMovementResponseDTO;
import com.nalisso.robotassignment.resource.api.dto.RobotMovementSpecificationDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
final class TestRobotResource {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int port;

    private static final String MOVE_URL_NO_PORT = "http://localhost:%s/move";

    @Test
    public void testProperObject() {
        RobotMovementSpecificationDTO robotMovementSpecificationDTO = new RobotMovementSpecificationDTO("LFR", 5, new PositionDTO(2, 2, DirectionDTO.N));
        ResponseEntity<RobotMovementResponseDTO> response = testRestTemplate.postForEntity(String.format(MOVE_URL_NO_PORT, port), robotMovementSpecificationDTO, RobotMovementResponseDTO.class);
        assertTrue(response.getStatusCode().is2xxSuccessful());
    }

    @Test
    public void testBadObject() {
        ResponseEntity<RobotMovementResponseDTO> response = testRestTemplate.postForEntity(String.format(MOVE_URL_NO_PORT, port), "This is not what I am supposed to be POSTing", RobotMovementResponseDTO.class);
        assertTrue(response.getStatusCode().is4xxClientError());
    }

    @Test
    public void testMatrixTooSmall() {
        RobotMovementSpecificationDTO robotMovementSpecificationDTO = new RobotMovementSpecificationDTO("LFR", 5, new PositionDTO(20, 2, DirectionDTO.E));
        ResponseEntity<RobotMovementResponseDTO> response = testRestTemplate.postForEntity(String.format(MOVE_URL_NO_PORT, port), robotMovementSpecificationDTO, RobotMovementResponseDTO.class);
        assertTrue(response.getStatusCode().is4xxClientError());
    }

    @Test
    public void testWeirdPositions() {
        RobotMovementSpecificationDTO robotMovementSpecificationDTO = new RobotMovementSpecificationDTO("LFR", 5, new PositionDTO(-1, -2, DirectionDTO.S));
        ResponseEntity<RobotMovementResponseDTO> response = testRestTemplate.postForEntity(String.format(MOVE_URL_NO_PORT, port), robotMovementSpecificationDTO, RobotMovementResponseDTO.class);
        assertTrue(response.getStatusCode().is4xxClientError());
    }

    @Test
    public void testBadCommandString() {
        RobotMovementSpecificationDTO robotMovementSpecificationDTO = new RobotMovementSpecificationDTO("LFRLOKQWS(183'ä", 5, new PositionDTO(2, 2, DirectionDTO.W));
        ResponseEntity<RobotMovementResponseDTO> response = testRestTemplate.postForEntity(String.format(MOVE_URL_NO_PORT, port), robotMovementSpecificationDTO, RobotMovementResponseDTO.class);
        assertTrue(response.getStatusCode().is2xxSuccessful());
    }

}

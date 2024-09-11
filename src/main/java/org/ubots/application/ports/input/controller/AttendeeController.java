package org.ubots.application.ports.input.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ubots.domain.models.attendee.assign.RespondRequest;
import org.ubots.domain.models.attendee.finish.FinishRequest;
import org.ubots.application.ports.input.AttendeePort;

@AllArgsConstructor
@RestController
@RequestMapping("/service-desk/attendee")
public class AttendeeController {

    private final AttendeePort attendeePort;

    @PostMapping("/assign")
    public ResponseEntity<String> assign(@RequestBody RespondRequest respondRequest) throws Exception {
        attendeePort.assign(respondRequest);
        return ResponseEntity.ok("Success");
    }

    @PostMapping("/finish")
    public ResponseEntity<String> finish(@RequestBody FinishRequest finishRequest) throws Exception {
        attendeePort.finish(finishRequest);
        return ResponseEntity.ok("Success");
    }
}

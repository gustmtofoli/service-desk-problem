package org.ubots.application.ports.input.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ubots.domain.models.issue.deliver.ServiceDeskRequest;
import org.ubots.application.ports.input.IssuePort;

@AllArgsConstructor
@RestController
@RequestMapping("/service-desk/issue")
public class IssueController {

    private final IssuePort issuePort;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody ServiceDeskRequest serviceDeskRequest) throws Exception {
        issuePort.deliver(serviceDeskRequest);
        return ResponseEntity.ok("Success");
    }

}

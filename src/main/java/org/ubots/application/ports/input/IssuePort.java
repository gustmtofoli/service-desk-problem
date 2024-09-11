package org.ubots.application.ports.input;

import org.ubots.domain.models.issue.deliver.ServiceDeskRequest;

public interface IssuePort {
    void deliver(ServiceDeskRequest serviceDeskRequest) throws Exception;
}

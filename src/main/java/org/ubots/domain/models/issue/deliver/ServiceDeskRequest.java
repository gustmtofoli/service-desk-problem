package org.ubots.domain.models.issue.deliver;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ServiceDeskRequest {

    @Getter
    private String id;

    @Getter
    private String type;

}

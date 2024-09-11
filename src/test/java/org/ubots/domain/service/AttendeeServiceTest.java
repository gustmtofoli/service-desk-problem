package org.ubots.domain.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.ubots.application.ports.output.exception.ExceptionTeamNotFound;
import org.ubots.domain.models.attendee.Attendee;
import org.ubots.domain.models.attendee.assign.RespondRequest;
import org.ubots.domain.models.attendee.finish.FinishRequest;
import org.ubots.domain.models.team.ServiceDeskTeam;
import org.ubots.domain.validator.RequestValidator;
import org.ubots.infrastructure.adapters.persistence.AttendeeRepository;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class AttendeeServiceTest {
    @Mock
    private RequestValidator validator;

    @Mock
    private AttendeeRepository attendeeRepository;

    @InjectMocks
    private AttendeeService attendeeService;

    @BeforeEach
    void setUp() {
        //teamManager = TeamManager.getInstance();
    }

    @Test
    void testAssignTask_Success() {
        String issueId = "1";
        String issueType = "CARDS";
        String attendeeId = "1";
        RespondRequest request = new RespondRequest(issueId, issueType, attendeeId);
        Attendee attendee = mock(Attendee.class);

        when(attendeeRepository.getAttendee(Mockito.any(), Mockito.any())).thenReturn(attendee);

        attendeeService.assign(request);

        verify(validator).validateAttendeeId(attendeeId);
        verify(validator).validateIssueType(issueType);
        verify(attendee).assignTask(Mockito.any());
    }

    @Test
    void testFinishTask_Success() {
        String issueId = "1";
        String issueType = "CARDS";
        String attendeeId = "1";
        FinishRequest request = new FinishRequest(issueId, issueType, attendeeId);
        Attendee attendee = mock(Attendee.class);

        when(attendeeRepository.getAttendee(Mockito.any(), Mockito.any())).thenReturn(attendee);

        attendeeService.finish(request);

        verify(validator).validateAttendeeId(attendeeId);
        verify(validator).validateIssueType(issueType);
        verify(attendee).finishTask(Mockito.any());
    }

    @Test
    void testAssignTask_TeamNotFound() {
        String issueId = "1";
        String issueType = "ThisTeamDoesNotExists";
        String attendeeId = "1";
        RespondRequest request = new RespondRequest(issueId, issueType, attendeeId);

        assertThrows(ExceptionTeamNotFound.class, () -> attendeeService.assign(request));
    }

}

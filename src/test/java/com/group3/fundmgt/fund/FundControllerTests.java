package com.group3.fundmgt.fund;

import com.group3.fundmgt.Securities.SecurityController;
import com.group3.fundmgt.Securities.SecurityRepository;
import com.group3.fundmgt.Securities.SecurityService;
import com.group3.fundmgt.manager.ManagerController;
import com.group3.fundmgt.manager.ManagerRepository;
import com.group3.fundmgt.manager.ManagerService;
import com.group3.fundmgt.position.PositionController;
import com.group3.fundmgt.position.PositionRepository;
import com.group3.fundmgt.position.PositionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(FundController.class)
public class FundControllerTests {
    @MockBean
    FundService fundService;

    @MockBean
    FundRepository fundRepository;

    @MockBean
    ManagerService managerService;

    @MockBean
    ManagerRepository managerRepository;

    @MockBean
    ManagerController managerController;

    @MockBean
    PositionService positionService;

    @MockBean
    PositionRepository positionRepository;

    @MockBean
    PositionController positionController;

    @MockBean
    SecurityService securityService;

    @MockBean
    SecurityRepository securityRepository;

    @MockBean
    SecurityController securityController;

    @Autowired
    MockMvc mockMvc;

    List<Fund> defaultFunds = List.of(
            new Fund(1L, "technology select sector fund"),
            new Fund( 2L, "communication services select sector fund"),
            new Fund( 3L, "industrial select sector fund")
    );

    @Test
    public void testGetFundSuccess() throws Exception {
        when(fundService.getFund(1L)).thenReturn(defaultFunds.get(0));
        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/v1/funds/1"))
                .andExpect(status().isOk());
    }

}

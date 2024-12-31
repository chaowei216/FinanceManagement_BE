package com.weiz.loanservice.query.controller.impl;

import com.weiz.loanservice.query.controller.LoanTypeQueryController;
import com.weiz.loanservice.query.model.LoanTypeResponseDTO;
import com.weiz.loanservice.query.queries.GetAllLoanTypeQuery;
import com.weiz.loanservice.query.queries.GetLoanTypeQuery;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class LoanTypeQueryControllerImpl implements LoanTypeQueryController {

    QueryGateway queryGateway;

    @Override
    public List<LoanTypeResponseDTO> getLoanTypes() {

        log.info("LOAN TYPE QUERY CONTROLLER: Get all loan types request...");

        // init query
        GetAllLoanTypeQuery query = new GetAllLoanTypeQuery();

        // return value
        return queryGateway.query(query, ResponseTypes.multipleInstancesOf(LoanTypeResponseDTO.class)).join();
    }

    @Override
    public LoanTypeResponseDTO getLoanType(String id) {

        log.info("LOAN TYPE QUERY CONTROLLER: Get loan type request...");

        // init query
        GetLoanTypeQuery query = new GetLoanTypeQuery(id);

        // return value
        return queryGateway.query(query, ResponseTypes.instanceOf(LoanTypeResponseDTO.class)).join();
    }
}

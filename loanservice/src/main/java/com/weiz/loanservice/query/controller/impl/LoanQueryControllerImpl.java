package com.weiz.loanservice.query.controller.impl;

import com.weiz.loanservice.query.controller.LoanQueryController;
import com.weiz.loanservice.query.model.LoanResponseDTO;
import com.weiz.loanservice.query.queries.GetAllLoansQuery;
import com.weiz.loanservice.query.queries.GetLoanQuery;
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
public class LoanQueryControllerImpl implements LoanQueryController {

    QueryGateway queryGateway;

    @Override
    public List<LoanResponseDTO> getLoanTypes() {

        log.info("LOAN QUERY CONTROLLER: Get all loans request...");

        // init query
        GetAllLoansQuery query = new GetAllLoansQuery();

        // return value
        return queryGateway.query(query, ResponseTypes.multipleInstancesOf(LoanResponseDTO.class)).join();
    }

    @Override
    public LoanResponseDTO getLoanType(String id) {

        log.info("LOAN QUERY CONTROLLER: Get loan request...");

        // init query
        GetLoanQuery query = new GetLoanQuery(id);

        // return value
        return queryGateway.query(query, ResponseTypes.instanceOf(LoanResponseDTO.class)).join();
    }
}

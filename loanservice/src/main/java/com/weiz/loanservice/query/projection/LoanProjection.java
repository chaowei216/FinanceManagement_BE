package com.weiz.loanservice.query.projection;

import com.weiz.loanservice.command.data.Loan;
import com.weiz.loanservice.command.data.repository.LoanRepository;
import com.weiz.loanservice.query.model.LoanResponseDTO;
import com.weiz.loanservice.query.queries.GetAllLoansQuery;
import com.weiz.loanservice.query.queries.GetLoanQuery;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Slf4j
public class LoanProjection {

    LoanRepository loanRepository;

    @QueryHandler
    public List<LoanResponseDTO> handle(GetAllLoansQuery query) {

        log.info("Loan Projection: handle get all loans processing...");

        // get all items in db
        List<Loan> loans = loanRepository.findAll();

        // init response data
        List<LoanResponseDTO> loanResponseDTOS = new ArrayList<>();

        // mapping
        loans.forEach(type -> {
            LoanResponseDTO responseDTO = new LoanResponseDTO();
            BeanUtils.copyProperties(type, responseDTO);
            responseDTO.setLoanTypeName(type.getLoanType().getName());
            loanResponseDTOS.add(responseDTO);
        });

        // return value
        return loanResponseDTOS;
    }

    @QueryHandler
    public LoanResponseDTO handle(GetLoanQuery query) {

        log.info("Loan Projection: handle get loan processing...");

        // return value
        return loanRepository.findById(query.getId())
                .map(type -> {
                    LoanResponseDTO responseDTO = new LoanResponseDTO();
                    BeanUtils.copyProperties(type, responseDTO);
                    responseDTO.setLoanTypeName(type.getLoanType().getName());
                    return responseDTO;
                })
                .orElseThrow(() -> new RuntimeException("Loan not found"));
    }
}

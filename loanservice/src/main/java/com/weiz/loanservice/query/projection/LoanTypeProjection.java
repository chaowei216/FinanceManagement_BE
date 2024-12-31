package com.weiz.loanservice.query.projection;

import com.weiz.loanservice.command.data.LoanType;
import com.weiz.loanservice.command.data.repository.LoanTypeRepository;
import com.weiz.loanservice.query.model.LoanTypeResponseDTO;
import com.weiz.loanservice.query.queries.GetAllLoanTypeQuery;
import com.weiz.loanservice.query.queries.GetLoanTypeQuery;
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
public class LoanTypeProjection {

    LoanTypeRepository loanTypeRepository;

    @QueryHandler
    public List<LoanTypeResponseDTO> handle(GetAllLoanTypeQuery query) {

        log.info("Loan Type Projection: handle get all loan types processing...");

        // get all items in db
        List<LoanType> loanTypes = loanTypeRepository.findAll();

        // init response data
        List<LoanTypeResponseDTO> loanTypeResponseDTOS = new ArrayList<>();

        // mapping
        loanTypes.forEach(type -> {
            LoanTypeResponseDTO responseDTO = new LoanTypeResponseDTO();
            BeanUtils.copyProperties(type, responseDTO);
            loanTypeResponseDTOS.add(responseDTO);
        });

        // return value
        return loanTypeResponseDTOS;
    }

    @QueryHandler
    public LoanTypeResponseDTO handle(GetLoanTypeQuery query) {

        log.info("Loan Type Projection: handle get loan type processing...");

        // return value
        return loanTypeRepository.findById(query.getId())
                .map(type -> {
                    LoanTypeResponseDTO responseDTO = new LoanTypeResponseDTO();
                    BeanUtils.copyProperties(type, responseDTO);
                    return responseDTO;
                })
                .orElseThrow(() -> new RuntimeException("Loan Type not found"));
    }
}

package com.francopaiz.financialManagementAPI.controller.financial;

import com.francopaiz.financialManagementAPI.caster.UserCaster;
import com.francopaiz.financialManagementAPI.dto.user.UserResponse;
import com.francopaiz.financialManagementAPI.model.FinancialSummary;
import com.francopaiz.financialManagementAPI.model.User;
import com.francopaiz.financialManagementAPI.service.financial.FinanceService;
import com.francopaiz.financialManagementAPI.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/summaries")
public class FinanceController {

    @Autowired
    private FinanceService financialService;

    @Autowired
    private UserService userService;

    @Autowired
    UserCaster userCaster;

    @GetMapping()
    public ResponseEntity<FinancialSummary> getFinancialSummary(
            /*@PathVariable String userId,*/
            @RequestParam("from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
            @RequestParam("to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to) {

       /* UserResponse userFound = userService.findUserById(userId);
        System.out.println(userFound);*/
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String idUser = ((User) userDetails).getId();

        System.out.println(idUser);

        UserResponse userFound = userService.findUserById(idUser);
        System.out.println(userFound);

        User userTransformed = userCaster.userResponseToUser(userFound);
        System.out.println(userTransformed);
        FinancialSummary summary = financialService.generateSummary(userTransformed, from, to);
        return ResponseEntity.ok(summary);
    }
}
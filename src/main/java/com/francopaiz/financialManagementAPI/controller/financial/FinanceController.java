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
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/summaries")
public class FinanceController {

    @Autowired
    private FinanceService financialService;

    @Autowired
    private UserService userService;

    UserCaster userCaster;

    @GetMapping("/{userId}")
    public ResponseEntity<FinancialSummary> getFinancialSummary(
            @PathVariable String userId,
            @RequestParam("from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
            @RequestParam("to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to) {

        UserResponse userFound = userService.findUserById(userId);

        User userTransformed = userCaster.userResponseToUser(userFound);

        FinancialSummary summary = financialService.generateSummary(userTransformed, from, to);
        return ResponseEntity.ok(summary);
    }
}
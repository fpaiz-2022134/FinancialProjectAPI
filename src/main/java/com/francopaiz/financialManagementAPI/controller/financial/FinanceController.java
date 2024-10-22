package com.francopaiz.financialManagementAPI.controller.financial;

import com.francopaiz.financialManagementAPI.model.FinancialSummary;
import com.francopaiz.financialManagementAPI.model.User;
import com.francopaiz.financialManagementAPI.service.financial.FinanceService;
import com.francopaiz.financialManagementAPI.service.usuario.UsuarioService;
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
    private UsuarioService usuarioService;

    @GetMapping("/{userId}")
    public ResponseEntity<FinancialSummary> getFinancialSummary(
            @PathVariable String userId,
            @RequestParam("from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
            @RequestParam("to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to) {

        User userFound = usuarioService.findById(userId);

        FinancialSummary summary = financialService.generateSummary(userFound, from, to);
        return ResponseEntity.ok(summary);
    }
}
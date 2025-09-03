package lll.whobuys.investor.presentation;

import lll.whobuys.investor.application.InvestorCRUDService;
import lll.whobuys.investor.dto.InvestorCreateRequestDto;
import lll.whobuys.investor.dto.InvestorUpdateRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class InvestorCRUDController {

    private final InvestorCRUDService investorCRUDService;

    @Autowired
    public InvestorCRUDController(InvestorCRUDService investorCRUDService) {
        this.investorCRUDService = investorCRUDService;
    }

    @PostMapping("/investors")
    public ResponseEntity createInvestor(@RequestBody final InvestorCreateRequestDto requestDto) {
        return ResponseEntity.ok(investorCRUDService.createInvestor(requestDto));
    }

    @GetMapping("/investors/{investorId}")
    public ResponseEntity getInvestor(@PathVariable final Long investorId) {
        return ResponseEntity.ok(investorCRUDService.selectInvestor(investorId));
    }

    @PutMapping("/investors")
    public ResponseEntity updateInvestor(@RequestBody final InvestorUpdateRequestDto requestDto) {
        return ResponseEntity.ok(investorCRUDService.updateInvestor(requestDto));
    }

    @DeleteMapping("/investors")
    public ResponseEntity deleteInvestor(@RequestParam final Long investorId) {
        return ResponseEntity.ok(investorCRUDService.deleteInvestor(investorId));
    }
}

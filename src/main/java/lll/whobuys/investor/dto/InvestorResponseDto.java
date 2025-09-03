package lll.whobuys.investor.dto;

import lll.whobuys.investor.domain.InvestorType;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class InvestorResponseDto {

    private Long investorId;
    private String investorName;
    private InvestorType investorType;

    public InvestorResponseDto(final Long investorId,
                               final String InvestorName,
                               final InvestorType investorType) {
        this.investorId = investorId;
        this.investorName = InvestorName;
        this.investorType = investorType;
    }
}

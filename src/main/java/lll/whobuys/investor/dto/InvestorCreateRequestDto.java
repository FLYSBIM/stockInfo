package lll.whobuys.investor.dto;

import lll.whobuys.investor.domain.InvestorType;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class InvestorCreateRequestDto implements InvestorRequestDto {

    private String investorName;
    private InvestorType investorType;

    public InvestorCreateRequestDto(final String name, final InvestorType type) {
        this.investorName = name;
        this.investorType = type;
    }

}

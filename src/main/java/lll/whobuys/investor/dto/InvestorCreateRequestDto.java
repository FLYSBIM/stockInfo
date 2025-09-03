package lll.whobuys.investor.dto;

import lll.whobuys.investor.domain.InvestorType;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class InvestorCreateRequestDto implements InvestorRequestDto {

    private String name;
    private InvestorType investorType;

    public InvestorCreateRequestDto(final String name, final InvestorType type) {
        this.name = name;
        this.investorType = type;
    }
}

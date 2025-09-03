package lll.whobuys.investor.dto;

import lll.whobuys.investor.domain.InvestorType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class InvestorUpdateRequestDto implements InvestorRequestDto{

    private Long investorId;
    private InvestorUpdateData investorUpdateData;

    public InvestorUpdateRequestDto(final Long investorId,final InvestorUpdateData investorUpdateData) {
        this.investorId = investorId;
        this.investorUpdateData = investorUpdateData;
    }

    public Long getInvestorId() {
        return investorId;
    }

    public InvestorUpdateData getInvestorUpdateData() {
        return investorUpdateData;
    }

    @Override
    public String getInvestorName() {
        return investorUpdateData.getUpdateName();
    }

    @Override
    public InvestorType getInvestorType() {
        return investorUpdateData.getUpdateType();
    }
}

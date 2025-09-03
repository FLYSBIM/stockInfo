package lll.whobuys.investor.dto;

import lll.whobuys.investor.domain.InvestorType;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class InvestorUpdateData {

    private String updateName;
    private InvestorType updateType;

    public InvestorUpdateData(final String updateName, final InvestorType updateType) {
        this.updateName = updateName;
        this.updateType = updateType;
    }
}

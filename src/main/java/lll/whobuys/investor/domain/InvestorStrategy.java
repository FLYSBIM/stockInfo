package lll.whobuys.investor.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access= AccessLevel.PROTECTED)
@Getter
@Embeddable
public class InvestorStrategy {

    @Column(name="investor_type", nullable=false)
    private InvestorType investorType;

    public InvestorStrategy(final InvestorType investorType) {
        this.investorType = investorType;
    }
}

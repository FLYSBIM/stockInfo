package lll.whobuys.investor.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Embeddable
public class InvestorName {

    @Column(name="investor_name",nullable = false)
    private String investorName;

    public InvestorName(final String investorName) {
        this.investorName = investorName;
    }
}

package lll.whobuys.investor.domain;

import jakarta.persistence.*;
import lll.whobuys.common.domain.ModifiableEntity;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EqualsAndHashCode(of="investorId",callSuper = false)
@Table(name="INVESTOR")
@Entity
public class Investor extends ModifiableEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="investor_id",updatable=false)
    private Long investorId;

    @Embedded
    private InvestorName investorName;

    @Embedded
    private InvestorStrategy investorStrategy;

    public String getName(){
        return investorName.getInvestorName();
    }

    public InvestorType getInvestorType(){
        return investorStrategy.getInvestorType();
    }

    public Investor(final String investorName, final InvestorType investorStrategy) {
        this.investorName = new InvestorName(investorName);
        this.investorStrategy = new InvestorStrategy(investorStrategy);
    }

    public void updateName(final String updateName) {
        this.investorName = new InvestorName(updateName);
    }

    public void updateStrategy(final InvestorType updateType) {
        this.investorStrategy = new InvestorStrategy(updateType);
    }
}

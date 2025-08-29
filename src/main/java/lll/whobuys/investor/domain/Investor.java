package lll.whobuys.investor.domain;

import jakarta.persistence.*;
import lll.whobuys.common.ModifiableEntity;
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

    public Investor(final InvestorName investorName, final InvestorStrategy investorStrategy) {
        this.investorName = investorName;
        this.investorStrategy = investorStrategy;
    }
}

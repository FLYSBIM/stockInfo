package lll.whobuys.investor.dto;

import lll.whobuys.investor.domain.InvestorType;

public interface InvestorRequestDto {
    String getName();
    InvestorType getInvestorType();
}

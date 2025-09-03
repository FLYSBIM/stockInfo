package lll.whobuys.investor.application;

import lombok.Getter;

@Getter
public class InvestorNotFoundException extends RuntimeException {

    private static final String NOT_FOUND_INVESTOR_EXCEPTION_MESSAGE = "Investor not found";

    private Long requestNo;

    public InvestorNotFoundException(final Long requestNo) {
        super(NOT_FOUND_INVESTOR_EXCEPTION_MESSAGE);
        this.requestNo = requestNo;
    }
}

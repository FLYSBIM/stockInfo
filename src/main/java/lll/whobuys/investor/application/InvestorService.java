package lll.whobuys.investor.application;

import jakarta.transaction.Transactional;
import lll.whobuys.investor.domain.*;
import lll.whobuys.investor.dto.InvestorUpdateData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvestorService {

    private final InvestorRepository investorRepository;

    @Autowired
    public InvestorService(InvestorRepository investorRepository) {
        this.investorRepository = investorRepository;
    }

    public Investor createInvestor(String name, InvestorType investorType) {
        Investor investor = new Investor(name,investorType);
        return investorRepository.save(investor);
    }

    public List<Investor> selectPageInvestors(final int page,final int num) {
        return investorRepository.findAll(PageRequest.of(page - 1,num))
                .stream()
                .collect(Collectors.toList());
    }

    public Investor findById(final Long id) {
        return investorRepository.findById(id)
                .orElseThrow(() -> new InvestorNotFoundException(id));
    }

    @Transactional
    public Investor updateInvestor(final Long InvestorId, final InvestorUpdateData investorUpdateData) {
        Investor savedInvestor = findById(InvestorId);
        savedInvestor.updateName(investorUpdateData.getUpdateName());
        savedInvestor.updateStrategy(investorUpdateData.getUpdateType());
        return savedInvestor;
    }

    public void deleteInvestor(final Investor investor) {
        investorRepository.delete(investor);
    }
}

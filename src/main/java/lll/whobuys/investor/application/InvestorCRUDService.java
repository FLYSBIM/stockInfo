package lll.whobuys.investor.application;

import lll.whobuys.common.dto.ResponseData;
import lll.whobuys.common.dto.ResponseDto;
import lll.whobuys.common.dto.ResponseDtoMethod;
import lll.whobuys.common.dto.ResponseDtoStatusCode;
import lll.whobuys.investor.domain.Investor;
import lll.whobuys.investor.dto.InvestorRequestDto;
import lll.whobuys.investor.dto.InvestorResponseDto;
import lll.whobuys.investor.dto.InvestorUpdateRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvestorCRUDService {

    private static final String INVESTORS_SERVLET_PATH = "/api/v1/investors";
    private static final String PAGE_QUERY_FORMAT = "?page=%d&num=%d";
    private static final String INVESTOR_CREATE_SUCCEED_RESPONSE_MESSAGE = "투자자 등록 성공";
    private static final String INVESTOR_SELECT_PAGE_SUCCEED_RESPONSE_MESSAGE = "%d 페이지의 투자자 목록 %d개";
    private static final String INVESTOR_SELECT_SUCCEED_RESPONSE_MESSAGE = "투자자 조회 성공";
    private static final String INVESTOR_UPDATE_SUCCEED_RESPONSE_MESSAGE = "투자자 업데이트 성공";
    private static final String INVESTOR_DELETE_SUCCEED_RESPONSE_MESSAGE = "투자자 삭제 성공";

    private final InvestorService investorService;

    @Autowired
    public InvestorCRUDService(InvestorService investorService) {
        this.investorService = investorService;
    }

    public ResponseDto createInvestor(InvestorRequestDto requestDto) {
        Investor savedInvestor = investorService.createInvestor(requestDto.getInvestorName(),requestDto.getInvestorType());
        return ResponseDto.builder()
                .path(INVESTORS_SERVLET_PATH)
                .method(ResponseDtoMethod.POST)
                .message(INVESTOR_CREATE_SUCCEED_RESPONSE_MESSAGE)
                .data(ResponseData.builder()
                        .insert("investor",mapInvestorResponseDto(savedInvestor))
                        .build())
                .statusCode(ResponseDtoStatusCode.OK)
                .build();
    }

    public ResponseDto selectPageInvestors(final int page, final int num){
        List<Investor>investors = investorService.selectPageInvestors(page,num);
        List<InvestorResponseDto> pageInvestors = investors.stream()
                .map(this::mapInvestorResponseDto)
                .collect(Collectors.toList());
        return ResponseDto.builder()
                .path(String.format(INVESTORS_SERVLET_PATH + PAGE_QUERY_FORMAT, page, num))
                .method(ResponseDtoMethod.GET)
                .message(String.format(INVESTOR_SELECT_PAGE_SUCCEED_RESPONSE_MESSAGE, page, num))
                .data(ResponseData.builder()
                        .insert("investors",pageInvestors).build())
                .statusCode(ResponseDtoStatusCode.OK)
                .build();
    }

    public ResponseDto selectInvestor(final Long investorId) {
        Investor findInvestor = investorService.findById(investorId);
        return ResponseDto.builder()
                .path(String.format(INVESTORS_SERVLET_PATH + "/%d", investorId))
                .method(ResponseDtoMethod.GET)
                .message(INVESTOR_SELECT_SUCCEED_RESPONSE_MESSAGE)
                .data(ResponseData.builder()
                        .insert("investor",mapInvestorResponseDto(findInvestor))
                        .build())
                .statusCode(ResponseDtoStatusCode.OK)
                .build();
    }

    public ResponseDto updateInvestor(final InvestorUpdateRequestDto requestDto) {
        Investor updateInvestor = investorService.updateInvestor(requestDto.getInvestorId(),requestDto.getInvestorUpdateData());
        return ResponseDto.builder()
                .path(INVESTORS_SERVLET_PATH)
                .method(ResponseDtoMethod.PUT)
                .message(INVESTOR_UPDATE_SUCCEED_RESPONSE_MESSAGE)
                .data(ResponseData.builder()
                        .insert("updatedInvestor",mapInvestorResponseDto(updateInvestor))
                        .build())
                .statusCode(ResponseDtoStatusCode.OK)
                .build();
    }

    private InvestorResponseDto mapInvestorResponseDto(final Investor investor) {
        return new InvestorResponseDto(investor.getInvestorId(),investor.getName(),investor.getInvestorType());
    }

    public ResponseDto deleteInvestor(final Long investorId) {
        Investor findInvestor = investorService.findById(investorId);
        investorService.deleteInvestor(findInvestor);
        return ResponseDto.builder()
                .path(INVESTORS_SERVLET_PATH)
                .method(ResponseDtoMethod.DELETE)
                .message(INVESTOR_DELETE_SUCCEED_RESPONSE_MESSAGE)
                .data(ResponseData.builder()
                        .insert("deletedInvestor",mapInvestorResponseDto(findInvestor))
                        .build())
                .statusCode(ResponseDtoStatusCode.OK)
                .build();
    }

}

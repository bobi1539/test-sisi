package tes.sis.testsisi.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tes.sis.testsisi.dto.response.GenerateReportResponseDto;
import tes.sis.testsisi.entity.TSale;
import tes.sis.testsisi.repository.SaleRepository;
import tes.sis.testsisi.service.ReportService;
import tes.sis.testsisi.template.excel.SaleReport;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ReportServiceImpl implements ReportService {

    private final SaleRepository saleRepository;


    @Override
    public GenerateReportResponseDto generateSaleReport() {
        List<TSale> sales = saleRepository.findAll();
        SaleReport report = new SaleReport(sales);
        return report.generateReport();
    }
}

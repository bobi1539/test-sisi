package tes.sis.testsisi.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tes.sis.testsisi.constant.Endpoint;
import tes.sis.testsisi.dto.response.GenerateReportResponseDto;
import tes.sis.testsisi.service.ReportService;

@RestController
@RequestMapping(Endpoint.REPORT)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ReportController {

    private final ReportService reportService;

    @GetMapping("/generate/sale-report")
    public ResponseEntity<InputStreamResource> hello() {
        GenerateReportResponseDto dto = reportService.generateSaleReport();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + dto.getFilename())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new InputStreamResource(dto.getByteArrayInputStream()));
    }
}

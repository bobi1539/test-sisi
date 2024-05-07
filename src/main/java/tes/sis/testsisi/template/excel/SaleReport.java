package tes.sis.testsisi.template.excel;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.xssf.usermodel.*;
import tes.sis.testsisi.constant.Constant;
import tes.sis.testsisi.constant.GlobalMessage;
import tes.sis.testsisi.dto.response.GenerateReportResponseDto;
import tes.sis.testsisi.entity.TSale;
import tes.sis.testsisi.exception.AppException;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class SaleReport {
    private final List<TSale> sales;
    private final XSSFWorkbook workbook = new XSSFWorkbook();
    private final XSSFSheet sheet = workbook.createSheet();
    private static final String ARIAL = "Arial";
    private final String[] headerTable = new String[]{
            "no",
            "sale_id",
            "customer_name",
            "customer_phone_number",
            "customer_address",
            "driver_name",
            "destination_address",
            "cement_name",
            "price",
            "quantity",
            "total_price"
    };
    private long startTime;

    public SaleReport(List<TSale> sales) {
        this.sales = sales;
    }

    public GenerateReportResponseDto generateReport() {
        adjustColumn();
        writeLogStart();
        writeHeader();
        writeBody();
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            workbook.write(outputStream);
            return GenerateReportResponseDto.builder()
                    .filename("sales_report.xlsx")
                    .byteArrayInputStream(new ByteArrayInputStream(outputStream.toByteArray()))
                    .build();
        } catch (IOException e) {
            log.error(Constant.ERROR, e);
            throw new AppException(GlobalMessage.INTERNAL_SERVER_ERROR);
        } finally {
            writeLogFinish();
        }
    }

    private void adjustColumn() {
        for (int i = 0; i < 11; i++) {
            sheet.setColumnWidth(i, 4250);
        }
    }

    private void writeHeader() {
        XSSFRow row = sheet.createRow(0);
        row.setHeightInPoints(25);
        for (int i = 0; i < headerTable.length; i++) {
            XSSFCell cell = row.createCell(i);
            cell.setCellStyle(getCellStyle(true));
            cell.setCellValue(headerTable[i]);
        }
    }

    private void writeBody() {
        AtomicInteger rowNum = new AtomicInteger(1);
        sales.forEach(sale -> {
            XSSFRow row = sheet.createRow(rowNum.get());
            writeCellBody(row, 0, rowNum.toString());
            writeCellBody(row, 1, sale.getId().toString());
            writeCellBody(row, 2, sale.getCustomer().getName());
            writeCellBody(row, 3, sale.getCustomer().getPhoneNumber());
            writeCellBody(row, 4, sale.getCustomer().getAddress());
            writeCellBody(row, 5, sale.getDestinationAddress());
            writeCellBody(row, 6, sale.getDriver().getName());
            writeCellBody(row, 7, sale.getCement().getVariant());
            writeCellBody(row, 8, sale.getPrice().toString());
            writeCellBody(row, 9, sale.getQuantity().toString());
            writeCellBody(row, 10, sale.getTotalPrice().toString());

            rowNum.getAndIncrement();
        });
    }

    private void writeCellBody(XSSFRow row, int index, String value) {
        XSSFCell cell = row.createCell(index);
        cell.setCellStyle(getCellStyle(false));
        cell.setCellValue(value);
    }

    private XSSFCellStyle getCellStyle(boolean bold) {
        XSSFCellStyle cellStyle = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontName(SaleReport.ARIAL);
        font.setFontHeight(10);
        font.setBold(bold);
        cellStyle.setFont(font);
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setBorderTop(BorderStyle.THIN);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);
        return cellStyle;
    }

    private void writeLogStart() {
        long start = System.currentTimeMillis();
        this.startTime = start;
        log.info("start : {}", start);
    }

    private void writeLogFinish() {
        long finish = System.currentTimeMillis();
        log.info("finish : {}", finish);
        log.info("total time : {} ms", finish - startTime);
    }
}

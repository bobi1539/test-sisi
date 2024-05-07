package tes.sis.testsisi.dto.response;

import lombok.*;

import java.io.ByteArrayInputStream;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class GenerateReportResponseDto {
    private String filename;
    private ByteArrayInputStream byteArrayInputStream;
}

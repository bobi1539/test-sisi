## Teknikal Test PT Sinergi Informatika Semen Indonesia (SISI),

### Endpoint: /report/generate/sale-report
    - Deskripsi: Endpoint ini digunakan untuk menghasilkan laporan penjualan dalam format file Excel.
    - Metode HTTP: GET
    - Parameter: Tidak ada parameter yang diperlukan.
    - Response: Tipe Konten: application/octet-stream (excel file)
    - Status Code:
        - 200 OK - Laporan berhasil dihasilkan dan dikirim sebagai file Excel.
        - 500 Internal Server Error - Terjadi kesalahan saat menghasilkan laporan.
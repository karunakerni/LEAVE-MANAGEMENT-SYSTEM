$excelPath = 'C:\Users\KarunaKerni\OneDrive - Sixsentix AG\Desktop\Agent AI\MCP\LeaveManagementTestCases.xlsx'
$excel = New-Object -ComObject Excel.Application
$excel.Visible = $false
$wb = $excel.Workbooks.Open($excelPath)
$ws = $wb.Worksheets.Item(1)
$used = $ws.UsedRange.Rows.Count
Write-Output "Rows=$used"
for ($r = 1; $r -le [math]::Min($used, 20); $r++) {
    $rowVals = @()
    for ($c = 1; $c -le 10; $c++) {
        $rowVals += $ws.Cells.Item($r,$c).Text
    }
    Write-Output ($rowVals -join '|')
}
$wb.Close($false)
$excel.Quit()

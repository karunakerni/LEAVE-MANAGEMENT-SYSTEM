$excelPath = 'C:\Users\KarunaKerni\OneDrive - Sixsentix AG\Desktop\Agent AI\MCP\LeaveManagementTestCases.xlsx'
$excel = New-Object -ComObject Excel.Application
$excel.Visible = $false
$wb = $excel.Workbooks.Open($excelPath)
$ws = $wb.Worksheets.Item(1)
$count = $ws.UsedRange.Rows.Count
Write-Output "Rows=$count"
$wb.Close($false)
$excel.Quit()

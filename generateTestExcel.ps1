$source = 'c:\Users\KarunaKerni\Ai Projects\leave-management-system\test artifacts\test cases.md'
$destDir = 'C:\Users\KarunaKerni\OneDrive - Sixsentix AG\Desktop\Agent AI\MCP'
$dest = Join-Path $destDir 'LeaveManagementTestCases.xlsx'
if (-not (Test-Path $destDir)) { New-Item -ItemType Directory -Path $destDir | Out-Null }
$lines = Get-Content -Encoding UTF8 -Path $source
$cases = @()
$current = $null
$category = ''
foreach ($line in $lines) {
    $trim = $line.Trim()
    if ($trim -match '^(?:##)\s+(.*)$') {
        $category = $matches[1].Trim()
        continue
    }
    if ($trim -match '^(?:###)\s+(TC\d+)\s*[-–—]\s*(.*)$') {
        if ($current -ne $null) { $cases += $current }
        $current = [ordered]@{
            'Test ID' = $matches[1]
            'Category' = $category
            'Scenario' = $matches[2].Trim()
            'Preconditions' = ''
            'Steps' = ''
            'Expected output' = ''
            'Test data' = ''
            'Positive' = ''
            'Level of test' = ''
            'Notes' = ''
        }
        continue
    }
    if ($current -ne $null -and $trim -like '-*:*') {
        $parts = $trim.Substring(1).Split(':', 2)
        if ($parts.Count -eq 2) {
            $field = $parts[0].Trim()
            $value = $parts[1].Trim()
            switch -Wildcard ($field.ToLower()) {
                'scenario' { $current['Scenario'] = $value }
                'preconditions' { $current['Preconditions'] = $value }
                'steps' { $current['Steps'] = $value }
                'expected output' { $current['Expected output'] = $value }
                'test data' { $current['Test data'] = $value }
                'positive' { $current['Positive'] = $value }
                'level of test' { $current['Level of test'] = $value }
                'notes' { $current['Notes'] = $value }
            }
        }
    }
}
if ($current -ne $null) { $cases += $current }
Write-Output "Found $($cases.Count) cases"
if ($cases.Count -eq 0) { throw 'No test cases found in markdown file.' }
$excel = New-Object -ComObject Excel.Application
$excel.Visible = $false
$wb = $excel.Workbooks.Add()
$ws = $wb.Worksheets.Item(1)
$headers = @('Test ID','Category','Scenario','Preconditions','Steps','Expected output','Test data','Positive','Level of test','Notes')
for ($i = 0; $i -lt $headers.Count; $i++) { $ws.Cells.Item(1, $i+1).Value2 = $headers[$i] }
$row = 2
foreach ($case in $cases) {
    for ($i = 0; $i -lt $headers.Count; $i++) {
        $ws.Cells.Item($row, $i+1).Value2 = $case[$headers[$i]]
    }
    $row++
}
$range = $ws.Range($ws.Cells.Item(1,1), $ws.Cells.Item($row-1, $headers.Count))
$range.EntireColumn.AutoFit() | Out-Null
$wb.SaveAs($dest, 51)
$wb.Close($true)
$excel.Quit()
Write-Output "Saved: $dest"

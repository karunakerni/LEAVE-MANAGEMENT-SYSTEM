$source = 'c:\Users\KarunaKerni\Ai Projects\leave-management-system\test artifacts\test cases.md'
$lines = Get-Content -Path $source
$cases = @()
$current = $null
$category = ''
foreach ($line in $lines) {
    $trim = $line.Trim()
    if ($trim -match '^##\s+(.*)') {
        $category = $matches[1].Trim()
        continue
    }
    if ($trim -match '^###\s+(TC\d+)\s+–\s+(.*)') {
        if ($current -ne $null) { $cases += $current }
        $current = [ordered]@{ TestID = $matches[1]; Category = $category; Scenario = $matches[2].Trim(); Preconditions = ''; Steps = ''; Expected = ''; TestData = ''; Positive = ''; Level = ''; Notes = '' }
        continue
    }
    if ($current -ne $null -and $trim -match '^-\s*([^:]+):\s*(.*)$') {
        $field = $matches[1].Trim()
        $value = $matches[2].Trim()
        switch ($field) {
            'Scenario' { $current['Scenario'] = $value }
            'Preconditions' { $current['Preconditions'] = $value }
            'Steps' { $current['Steps'] = $value }
            'Expected output' { $current['Expected'] = $value }
            'Test data' { $current['TestData'] = $value }
            'Positive' { $current['Positive'] = $value }
            'Level of test' { $current['Level'] = $value }
            'Notes' { $current['Notes'] = $value }
        }
    }
}
if ($current -ne $null) { $cases += $current }
Write-Output "Found $($cases.Count) cases"
if ($cases.Count -gt 0) {
    $cases[0] | Format-List
}

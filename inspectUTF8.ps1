Get-Content -Encoding UTF8 -Path "c:\Users\KarunaKerni\Ai Projects\leave-management-system\test artifacts\test cases.md" | Select-Object -First 5 | ForEach-Object { Write-Output $_ }

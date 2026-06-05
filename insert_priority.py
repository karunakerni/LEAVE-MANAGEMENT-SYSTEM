from pathlib import Path
path = Path(r'test artifacts\test cases.md')
text = path.read_text(encoding='utf-8')
priority_map = {
    'TC001': 'High', 'TC002': 'Medium', 'TC003': 'Medium', 'TC004': 'High',
    'TC005': 'High', 'TC006': 'High', 'TC007': 'Medium', 'TC008': 'Medium',
    'TC009': 'Medium', 'TC010': 'Medium', 'TC011': 'High', 'TC012': 'High',
    'TC013': 'Medium', 'TC014': 'High', 'TC015': 'Low', 'TC016': 'Medium',
    'TC017': 'High', 'TC018': 'Medium', 'TC019': 'Low', 'TC020': 'Medium',
    'TC021': 'Low', 'TC022': 'Low', 'TC023': 'Low'
}
lines = text.splitlines()
out = []
test_id = None
for line in lines:
    out.append(line)
    if line.startswith('### TC'):
        test_id = line.split()[1]
    if line.startswith('- Level of test:') and test_id:
        out.append(f'- Test priority: {priority_map.get(test_id, "Medium")}')
new_text = '\n'.join(out)
# remove separate Test priority section if present
sep = '## Test priority'
if sep in new_text:
    new_text = new_text[:new_text.index(sep)].rstrip() + '\n'
path.write_text(new_text + '\n', encoding='utf-8')
print('Done updating inline priority fields.')

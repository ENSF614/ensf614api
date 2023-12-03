
with open("users.txt", 'r') as f:
    entries = f.read().split("),")
    output = ""
    for entry in entries:
        atts = entry.split(",")
        if(atts[-1].strip() == "'User'"):
            atts[-2] = 'null'
            atts[-3] = False
            atts[-4] = False
        atts[-1] += ")"
        for att in atts:
            output += str(att) + ","

with open("usersfixed.txt", 'wt') as f:
    f.write(output)

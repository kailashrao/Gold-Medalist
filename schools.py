import os
with open("schools.txt", "w") as txt:
    for file in os.listdir("Schools"):
        txt.write(file + "\n")



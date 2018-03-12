import os
import subprocess

def integral_calculator(formula):
    print("coming soon!")


isCorrect = True
while isCorrect:
    os.system('cls')
    next_part = """
====================== WELCOME TO WINDOWS ======================
|    Welcome authorized user!                                  |
|    Now you have three choices, the choices are               |
|       Open Chrome: [1]                                       |
|       Log Off: [2]                                           |
|       Unlock Computer: [3]                                   |
|       Integral Calculator: [4]                               |
|                                                              |
================================================================
"""
    print(next_part)
    choice = int(input("Your choice: "))

    if choice == 1:
        os.startfile(r"C:\Program Files (x86)\Google\Chrome\Application\chrome.exe")
    elif choice == 2:
        subprocess.call(["shutdown", "/l"])
        break
    elif choice == 3:
        os.system('cls')
        isCorrect = False
    elif choice == 4:
        print("Coming Soon!")
        os.system('pause')
#         os.system('cls')
#         int_part = """
# ===================== INTEGRAL CALCULATOR ======================
# |    Welcome to THE INTEGRAL CALCULATOR                        |
# |    Please enter the integral formula you want                |
# |    to be solved.                                             |
# ================================================================
#         """
#         print(int_part)
#         formula = input("Formula: ")
#         os.system('pause')
#         print(integral_calculator(formula))





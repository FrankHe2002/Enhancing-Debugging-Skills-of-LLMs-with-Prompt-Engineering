import pyautogui
import time

# Print current mouse position every second
while True:
    print(pyautogui.position())
    time.sleep(1)
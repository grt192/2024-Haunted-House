# Kevin will strangle me for putting this file here-- I know. -- LOL 
# Deal with and save it to the DS computer to be run whenever the HH is on. 

# BEFORE RUNNING THIS:
# run 'python3 -m pip install pynetworktables' to install the module needed for networktables comms
# run 'python3 -m pip install pygame' to install the module needed for sound playback

import time
from networktables import NetworkTables # <--- this will raise an error when in the java env, create a python venv on DS and run this there
import pygame
from numpy import random

NetworkTables.initialize(server='10.1.92.2') 

audio_table = NetworkTables.getTable("audio")

pygame.mixer.init()
sound1 = pygame.mixer.Sound('creeper') 
sound2 = pygame.mixer.Sound('explode') 

while True:
    trigger_value = audio_table.getNumber("trigger_audio", -1.0)
    print("trigger:", trigger_value)
    
    if trigger_value == 1.0:
        # creeper hiss plays, AND THEN the actual explosion plays
        sound1.play()
    if trigger_vaue == 2.0:
        sound2.play()



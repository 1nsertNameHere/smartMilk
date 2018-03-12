from pymongo import MongoClient
from pprint import pprint
import serial

ser = serial.Serial('/dev/ttyACM0', 9600)

client = MongoClient(<<mongo URI>>)
db = client.milkData
serverStatusResult=db.command("serverStatus")
pprint(serverStatusResult)

dataIN = "5.00"
milkBottle = { 'data' : dataIN } 
result = db.milkBottles.insert_one(milkBottle)
pprint(result)

while 1:
 dataIN = ser.readline()
 result = db.milkBottles.update_one({}, {"$set": {"data":dataIN}} )
 pprint(result)

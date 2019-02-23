import time
import Adafruit_DHT
import RPi.GPIO as GPIO
import requests
import urllib.request
import smtplib

counter=-1

sensorbmp = 21

sensorpressure = 'sensor.read_pressure()'

Pressure = sensorpressure
 
GPIO.setmode(GPIO.BCM)
GPIO.setwarnings(False)


sensor = Adafruit_DHT.DHT11
pin = 4



GPIO.setup(10,GPIO.OUT)
GPIO.setup(26,GPIO.OUT)

led = 10
ledred = 26

def messenger(temp, hum, pres):
                                email="";
                                emailall = urllib.request.urlopen("http://192.168.2.238:8080/TermProject/rest/evlservice/getuserlist").read().decode()
                                email  = emailall.split(",")
                                emaillen= len(email)
                                
                                message = 'Environment Listener Warning Notification !!! \nTemperature = '+str(temp)+ '\nHumidity = '+str(hum)+'\nPressure = '+str(pres)
                
                                for i in range(0,emaillen-1):
                                    receiver  = str(email[i])
                                    
                                    server = smtplib.SMTP("smtp.gmail.com",587)    
                                    server.starttls()
                                    server.login("oobserverver1@gmail.com","Oobserver1")
                                    server.sendmail("oobserverver1@gmail.com",receiver,message)
                                    server.quit()
                

def blink(led):
		GPIO.output(led,GPIO.HIGH)
		time.sleep(0.1)
		GPIO.output(led,GPIO.LOW)
		time.sleep(0.1)
	                    
	            
try: 
    while 1:
       
        counter=counter+1
       
        humidity, temperature = Adafruit_DHT.read_retry(sensor, pin)
        
        contentstemp = urllib.request.urlopen("http://192.168.2.238:8080/TermProject/rest/evlservice/lasttempcondition").read().decode()
        
        contentshum = urllib.request.urlopen("http://192.168.2.238:8080/TermProject/rest/evlservice/lasthumcondition").read().decode()
        
        tempmin = urllib.request.urlopen("http://192.168.2.238:8080/TermProject/rest/evlservice/setmintempwarningcondition").read().decode()
        
        tempmax = urllib.request.urlopen("http://192.168.2.238:8080/TermProject/rest/evlservice/setmaxtempwarningcondition").read().decode()
        
        TempResponse = temperature-float(contentstemp)
        
        HumResponse = humidity-float(contentshum)
        
        pressure = (humidity*(temperature)*(0.85-(TempResponse*0.01)-(HumResponse*0.01)))/(((temperature*0.015)+(TempResponse*0.008))+((humidity*0.015)+(HumResponse*0.01)))
        
        if(humidity>30 and humidity<100):
                if(temperature>float(tempmin) and temperature<float(tempmax)):
        
                    response = requests.get("http://192.168.2.238:8080/TermProject/rest/evlservice/addservice/"+str(temperature)+"/"+str(humidity)+"/"+str(pressure)+"/"+str(time.asctime(time.localtime(time.time()))))
                    blink(10)
                    time.sleep(1)
                    
                else:
                   
                    response = requests.get("http://192.168.2.238:8080/TermProject/rest/evlservice/addservice/"+str(temperature)+"/"+str(humidity)+"/"+str(pressure)+"/"+str(time.asctime(time.localtime(time.time()))))
                    blink(26)
                    
                    if(counter==0):
                                  messenger(temperature,humidity,pressure)
                        
                    elif(counter==21):
                                  messenger(temperature,humidity,pressure)
                                  counter=1
                    time.sleep(1)
except TypeError:
    while 1:
        
        counter=counter+1
        
        humidity, temperature = Adafruit_DHT.read_retry(sensor, pin)
        
        contentstemp = urllib.request.urlopen("http://192.168.2.238:8080/TermProject/rest/evlservice/lasttempcondition").read().decode()
        
        contentshum = urllib.request.urlopen("http://192.168.2.238:8080/TermProject/rest/evlservice/lasthumcondition").read().decode()
        
        tempmin = urllib.request.urlopen("http://192.168.2.238:8080/TermProject/rest/evlservice/setmintempwarningcondition").read().decode()
        
        tempmax = urllib.request.urlopen("http://192.168.2.238:8080/TermProject/rest/evlservice/setmaxtempwarningcondition").read().decode()
        
        TempResponse = temperature-float(contentstemp)
        
        HumResponse = humidity-float(contentshum)
        
        pressure = (humidity*(temperature)*(0.85-(TempResponse*0.01)-(HumResponse*0.01)))/(((temperature*0.015)+(TempResponse*0.008))+((humidity*0.015)+(HumResponse*0.01)))
        
        if(humidity>30 and humidity<100):
                if(temperature>tempmin and temperature<tempmax):
                   
                    response = requests.get("http://192.168.2.238:8080/TermProject/rest/evlservice/addservice/"+str(temperature)+"/"+str(humidity)+"/"+str(pressure)+"/"+str(time.asctime(time.localtime(time.time()))))
                    blink(10)
                    time.sleep(1)  
                    
                else:
                    
                    response = requests.get("http://192.168.2.238:8080/TermProject/rest/evlservice/addservice/"+str(temperature)+"/"+str(humidity)+"/"+str(pressure)+"/"+str(time.asctime(time.localtime(time.time()))))
                    blink(26)
                    
                    if(counter==0):
                                  messenger(temperature,humidity,pressure)
                        
                    elif(counter==21):
                                  messenger(temperature,humidity,pressure)
                                  counter=1
                    time.sleep(1)   
                        
                   
#    GPIO.cleanup()
    
            
except KeyboardInterrupt:
    print("Quit")
    #GPIO.cleanup()
    
finally:
    GPIO.cleanup()
   

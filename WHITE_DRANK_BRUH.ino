
float voltage = 0;

void setup() {
  // put your setup code here, to run once:

Serial.begin(9600);
pinMode(A0, INPUT);
pinMode(A1, INPUT);
pinMode(A2, INPUT);
pinMode(A3, INPUT);
Serial.println("Start");
}

void loop() {
 voltage = analogRead(A0) * (5.0/1023);
 voltage1 = analogRead(A1)
 voltage2 = analogRead(A2)  
 voltage3 = analogRead(A3) 

   Serial.println(voltage,voltage1,voltage2,voltage3)
  // put your main code here, to run repeatedly:
  delay(1000);
}

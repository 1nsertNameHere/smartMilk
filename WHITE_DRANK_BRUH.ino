
float voltage = 0;
float voltage1 = 0;
float voltage2 = 0;
float voltage3 = 0;

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
 voltage1 = analogRead(A1) * (5.0/1023);
 voltage2 = analogRead(A2) * (5.0/1023);
 voltage3 = analogRead(A3) * (5.0/1023); 

   Serial.print(voltage);
   Serial.print(" ");
   Serial.print(voltage1);
   Serial.print(" ");
   Serial.print(voltage2);
   Serial.print(" ");
   Serial.println(voltage3);
  // put your main code here, to run repeatedly:
  delay(1000);
}


float voltage = 0;

void setup() {
  // put your setup code here, to run once:

Serial.begin(9600);
pinMode(A0, INPUT);
Serial.println("Start");
}

void loop() {
  voltage = analogRead(A0) * (5.0/1023);
  Serial.print(voltage);
  // put your main code here, to run repeatedly:
  delay(100);
}

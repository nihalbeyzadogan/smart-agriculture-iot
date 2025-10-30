genel olarak beklendik structure (bize yol olsun die buraya koyuyom)
smart-agriculture-iot/
│
├── README.md
├── .gitignore
├── pom.xml                  # (Eğer Maven kullanacaksak)
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── de/thws/agriculture/
│   │   │        ├── domain/
│   │   │        │    ├── Farmer.java
│   │   │        │    ├── Field.java
│   │   │        │    ├── Sensor.java
│   │   │        │    ├── Measurement.java
│   │   │        │    ├── AlertRule.java
│   │   │        │    └── Alert.java
│   │   │        │
│   │   │        ├── service/
│   │   │        │    ├── AlertService.java
│   │   │        │    └── MeasurementService.java
│   │   │        │
│   │   │        ├── controller/
│   │   │        │    ├── MeasurementController.java
│   │   │        │    └── AlertController.java
│   │   │        │
│   │   │        └── repository/
│   │   │             ├── MeasurementRepository.java
│   │   │             └── AlertRepository.java
│   │   │
│   │   └── resources/
│   │        ├── application.properties
│   │        └── import.sql        # örnek veri
│   │
│   └── test/
│        └── java/
│             └── de/thws/agriculture/
│                  └── service/
│                       └── MeasurementServiceTest.java
│
└── docs/
    ├── uml/
    │    └── domain-model.png
    └── portfolio/
         └── portfolio01_report.pdf

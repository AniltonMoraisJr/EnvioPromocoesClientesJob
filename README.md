# Spring Boot Project with Spring Batch and Quartz for Email Automation
## Overview
This Spring Boot project demonstrates the integration of Spring Batch and Quartz to automate the process of sending emails to clients. The combination of Spring Batch provides batch processing capabilities, while Quartz is used for scheduling tasks.

## Features
- Spring Batch: Implements batch processing to handle large volumes of data efficiently.
- Quartz Scheduler: Manages the scheduling of email sending tasks.
- Email Sending: Utilizes Spring's email functionality to send emails to clients.
- Configurable: Easily configurable through properties for flexibility.
## Prerequisites
- Java 21
- Maven
- IDE of your choice (E.g., IntelliJ, Eclipse)
## Setup

1) Clone the repository:

Copy code
```bash
git clone https://github.com/AniltonMoraisJr/EnvioPromocoesClientesJob.git
```
Open the project in your preferred IDE.

2) Configure database properties in application.properties:

```properties
# Spring Batch database
spring.datasource.driver-class-name= com.mysql.cj.jdbc.Driver
spring.datasource.jdbcUrl=jdbc:mysql://localhost:3306/spring_batch
spring.datasource.username=root
spring.datasource.password=root

# Spring application database
app.datasource.driver-class-name= com.mysql.cj.jdbc.Driver
app.datasource.jdbcUrl=jdbc:mysql://localhost:3306/envio_promocoes_clientes
app.datasource.username=root
app.datasource.password=root
```

3) Execute script.sql in folder files to initiate tables: cliente, produto and interesse_produto_cliente
4) Configure email properties in application.properties:

```properties
# Email Configuration
spring.mail.host=email-host
spring.mail.port=email-host-port
spring.mail.username=email-host-user
spring.mail.password=email-host-password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.startt.enable=true
```

5) Run the application.

## Usage
Once the application is running, the batch job will be executed based on the configured schedule, and emails will be sent to clients.

## Contributing
Feel free to contribute by opening issues or creating pull requests. Your feedback and contributions are highly appreciated.

## License
This project is licensed under the MIT License - see the LICENSE file for details.
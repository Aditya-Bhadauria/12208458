## Why I Chose This Stack and How I Tackled the Problem

I chose **Spring Boot** because it’s an ideal framework for applications requiring a microservice-style solution. The app cleanly exposes the required endpoints, and I’ve attached screenshots below to showcase the working of the application.

I followed clean and simple naming conventions, intentionally avoiding third-party libraries that alter Java’s default syntax. The project is structured into clear layers like **Controllers** and **Services** to align with industry best practices.

A custom **logging service** is implemented, which is automatically initialized and invoked inside the **URL service**. Additionally, a **click counter** parameter has been added as requested in the problem statement.

The entire application is designed to be highly **object-oriented**, easy to **debug**, and simple to **extend or modify** in the future.



###  Application Screenshots  

<p align="center">
  <img src="https://github.com/user-attachments/assets/db75b386-0448-4c5b-b834-b0bcf8d3bd9a" alt="Screenshot 1" width="600"/>
</p>

<p align="center">
  <img src="https://github.com/user-attachments/assets/64698b8b-fddc-4725-aae1-04fe4142a024" alt="Screenshot 2" width="600"/>
</p>

<p align="center">
  <img src="https://github.com/user-attachments/assets/08f44989-26b2-4ef5-b4da-8f48a7c4f08f" alt="Screenshot 3" width="600"/>
</p>

<p align="center">
  <img src="https://github.com/user-attachments/assets/f566987f-53e0-4ed8-9cf4-4d914f7f0a15" alt="Screenshot 4" width="600"/>
</p>

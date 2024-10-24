# JavaFX Project Collection

## Description
This repository contains a collection of JavaFX projects demonstrating various features of JavaFX, including user interfaces, event handling, and layouts. Each project focuses on solving a different real-world problem using JavaFX components.

## Projects Overview

### 1. Login Form Application
A simple login interface where users can input a username and password. It validates the fields and provides feedback for invalid entries.

#### Features:
- Username and password input fields
- Validation for empty fields
- Error messages for invalid input

#### How to Use:
Run `LoginFormApp.java` to launch the login form. Enter a username and password to simulate a login action.

---

### 2. Paint Application
A simple paint tool where users can draw on a canvas. Brush settings like color and size can be customized.

#### Features:
- Canvas for drawing
- Color picker for brush customization
- Adjustable brush size
- Clear button to reset the canvas

#### How to Use:
Run `PaintApp.java` to start the paint application. Select a color and brush size from the toolbar, then draw on the canvas.

---

### 3. Temperature Converter
A utility app to convert temperatures between Celsius, Fahrenheit, and Kelvin.

#### Features:
- Input validation for temperature values
- Convert between Celsius, Fahrenheit, and Kelvin
- Error messages for invalid input

#### How to Use:
Run `TempConverterApp.java` to start the temperature converter. Enter a temperature value, select the unit to convert from and to, and click "Convert."

---

### 4. Calculator Application
A basic calculator that performs simple arithmetic operations like addition, subtraction, multiplication, and division.

#### Features:
- Support for addition, subtraction, multiplication, and division
- Clear button to reset calculations
- Input validation

#### How to Use:
Run `CalculatorApp.java` to start the calculator. Use the on-screen buttons to perform calculations and see results instantly.

---

### 5. To-Do List Application
A task manager where users can add tasks, mark them as complete, or remove them from the list.

#### Features:
- Add, remove, and complete tasks
- Persist tasks during the session
- Clear all tasks with a single click

#### How to Use:
Run `TodoListApp.java` to start the to-do list application. Add tasks using the input field, mark them as complete by checking the box, and remove tasks when done.

---

## Installation

### Prerequisites
- Java 11 or higher installed
- JavaFX SDK installed

### Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/javafx-projects.git
   ```
2. Navigate to the project directory:
```bash
cd javafx-projects
```
3. Open the project in your preferred IDE (IntelliJ, Eclipse, etc.).
4. Ensure your IDE is configured to use JavaFX (add the JavaFX SDK to the build path).

### Running from Command Line
1. Compile any JavaFX project
```bash
javac --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml src/*.java
```
2. Run the desired application (replace MainClass with the correct main class):
```bash
java --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml -cp src MainClass
```

### Technologies Used
- **Java:** Core programming language used.
- **JavaFX:** GUI framework for building the user interfaces.

### Contributing
Contributions are welcome! Please follow these steps:
1. Fork the repository.
2. Create a new branch (git checkout -b feature/your-feature).
3. Commit your changes (git commit -m 'Add feature').
4. Push to the branch (git push origin feature/your-feature).
5. Open a pull request.

### License
This project is licensed under the MIT License. See the LICENSE file for more details.

### Contact
For any questions or feedback, feel free to reach out:
- Ryan Kerby - rkerby@memphis.edu
- GitHub: @ryankerbyIT


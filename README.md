# Maximum Height by Stacking Blocks 


## Description
This project implements a solution to the "Maximum Height by Stacking Blocks" problem using Java 8 and Spring Boot. The application calculates the maximum height achievable by stacking blocks on top of each other, adhering to certain conditions regarding their dimensions. The solution leverages dynamic programming and block rotation to find the optimal stacking height.

## Problem Statement
Given n blocks where the dimensions of the i-th block are represented as blocks[i] = [width_i, length_i, height_i]. Choose a subset of blocks and stack them on top of each other. A block i can be placed on block j if width_i <= width_j, length_i <= length_j, and height_i <= height_j. You can rotate any block to change its dimensions to fit onto another block.

Return the maximum height of the stacked blocks.

### Examples
#### Example 1
input: blocks = [[50,45,20],[95,37,53],[45,23,12]]
Output: 190
Explanation:
Block 1 is placed on the bottom with the 53x37 side facing down with height 95.
Block 0 is placed next with the 45x20 side facing down with height 50.
Block 2 is placed next with the 23x12 side facing down with height 45.
The total height is 95 + 50 + 45 = 190.


#### Example 2
Input: blocks = [[38,25,45],[76,35,3]]
Output: 76
Explanation:
You can't place any of the blocks on the other.
We choose block 1 and rotate it so that the 35x3 side is facing down and its height is 76.


#### Example 3
Input: blocks = [[7,11,17],[7,17,11],[11,7,17],[11,17,7],[17,7,11],[17,11,7]]
Output: 102
Explanation:
After rearranging the blocks, you can see that all blocks have the same dimension.
You can place the 11x7 side down on all blocks so their heights are 17.
The maximum height of stacked blocks is 6 * 17 = 102.


#### Constraints

    n == blocks.length
    1 <= n <= 100
    1 <= width_i, length_i, height_i <= 100


## Project Structure
```
src
├── main
│   ├── java
│   │   └── com.example.blockstack
│   │       ├── BlockStackApplication.java       // Main Spring Boot Application
│   │       ├── controller
│   │       │   └── BlockStackController.java    // REST Controller for Block Operations
│   │       └── service
│   │           └── BlockStackService.java       // ** Core Logic for Calculating Max Height **
└── resources                                    // Application resources
├── test
│   ├── java
│   │   └── com.example.blockstack
│   │       └── BlockStackServiceTest.java       // Unit tests for BlockStackService
└── resources                                    // Test resources
```



## Getting Started
### Prerequisites
- **Java**: Ensure Java is installed and `JAVA_HOME` is set correctly.
- **Gradle**: The project uses Gradle for build automation.
- **Spring Boot**: The project is built using Spring Boot framework.

### Installation
1. **Clone the repository:**
   ```bash
   git clone https://github.com/yourusername/block-stack-test.git
   cd block-stack-test

2. **Build the Project::**
   ```bash
   ./gradlew clean build

3. **Build the Project::**
   ```bash
   ./gradlew bootRun

## Usage
### API Endpoint

The application exposes a single API endpoint to calculate the maximum stack height:

- **POST /api/blocks/max-height**
    - **Request**: A 2D array representing block dimensions [width, length, height].
    - **Response**: Maximum stack height.
  
### Example Request and Response
1. **Example**
**Request:**
```
[
[50, 45, 20],
[95, 37, 53],
[45, 23, 12]
]
```

**Response:**
```
190
```

2. **Example**
**Request:**
```
[
[38, 25, 45],
[76, 35, 3]
]
```

**Response:**
```
76
```
3. **Example**
**Request:**
```
[
[7, 11, 17],
[7, 17, 11],
[11, 7, 17],
[11, 17, 7],
[17, 7, 11],
[17, 11, 7]
]
```

**Response:**
```
102
```
#### You can try any request input and get the response
### Using Postman to Test the API
This section explains how to test the API endpoint using Postman.

#### Step-by-Step Guide to Using Postman
1. Open Postman:

   - Download and install Postman if you haven't already, or open the application if it's already installed.

2. Create a New Request:

   - Click on the + button in the Postman app to create a new request tab.

3. Set the Request Type:

   - Change the request type from GET to POST using the dropdown menu next to the URL bar.

4. Enter the API Endpoint URL:

    - In the URL bar, enter http://localhost:8080/api/blocks/max-height.

5. Set the Request Body:

    - Click on the Body tab below the URL bar.

    - Select the raw option.

    - From the dropdown menu next to raw, select JSON as the format.

    - Paste the following JSON data into the text area:
```
[
[50, 45, 20],
[95, 37, 53],
[45, 23, 12]
]
```
6. Send the Request:

    - Click on the Send button.

    - You should receive a response like this:
```
190
```
7. Verify the Response:

    - The response should display the maximum height achievable by stacking the provided blocks, which in this case is 190.
      
## Running Tests
To run the test cases included in the project, use the following command:
```
./gradlew test
```
### Test Cases Included

A test file **BlockStackServiceTest.java** is included in the project with all possible test cases to ensure the correctness of the solution. 
These tests cover various scenarios such as basic stacking, non-stackable blocks, identical dimensions, single block scenarios, and more.

### Built With

- Java  - The programming language used.
- Spring Boot - Framework for building the application.
- Gradle - Build automation tool.  
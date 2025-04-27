# https://github.com/Premprakash6260 

# PickSpot
A simple Spring Boot service that selects the best spot to place a container in a busy port, based on a mathematical Formula.

# How to Build and Run
1. Clone the repository:
git clone https://github.com/Premprakash6260/PickSpot.git
cd PickSpot

2. Build the project
./gradlew build

3. Run the Project:
./gradlew bootRun

The project will run on: http://localhost:8080

# API Usage
POST http://localhost:8080/pickSpot
Content-Type: application/json

# Request Sample Body:
{
  "container": {
    "id": "C1",
    "size": "small",
    "needsCold": false,
    "x": 1,
    "y": 1
  },
  "yardMap": [
    {
      "x": 1,
      "y": 2,
      "sizeCap": "small",
      "hasColdUnit": false,
      "occupied": false
    },
    {
      "x": 2,
      "y": 2,
      "sizeCap": "big",
      "hasColdUnit": true,
      "occupied": false
    }
  ]
}

# Response Sample Body:
{
  "containerId": "C1",
  "targetX": 1,
  "targetY": 2
}

If no suitable slot is found:

{
  "error": "no suitable slot"
}

# Latency Benchmark
I conducted a basic load test to measure the API's response time under concurrent requests.

Test Setup:
Tool: Postman Collection Runner
Collection: Single POST request to /pickSpot
Iterations: 1000
Concurrency: 100

# Benchmark Result
Metric	                    Result
Average Response Time	        4 ms
Min Response Time	            2 ms
Max Response Time	         1002 ms
95th Percentile               8ms 

✅ Test confirms the API can efficiently handle fast-moving container logistics scenarios.
4 Seperate APIs for each of the basic math operations
dockerHub url : https://hub.docker.com/layers/vikasmanohar/mathapi/v2/images/sha256-6e93e566b23894aeea769469dfba0e5f565cbd8b3c3219c6da131986fb09502f?context=explore
Command for image pull: docker pull vikasmanohar/mathapi:v2

Command to run the application: docker run -p 8082:8082 mathapi:v2

endPoints: 
Addition:
http://localhost:8082/math/add/1,2,3,4
Op: {"result":"10.0"}

Subtraction:
localhost:8082/math/sub/1,2,3,4
Op: {"result":"-8.0"}

Multiplication:
localhost:8082/math/mul/1,2,3,4
Op: {"result":"24.0"}

Division: (takes first two operands for performing the operation)
http://localhost:8082/math/div/1,2
Op: {"result":"0.5"}

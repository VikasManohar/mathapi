Single end point handles all basic operations

dockerHub url : Image Layer Details - https://hub.docker.com/layers/vikasmanohar/mathapi/latest/images/sha256-9f1a5311bad08bd4c3fda55aadc0ef8a84f553d42e79a35bbaae0774b0801716?context=explore
Command for image pull: docker pull vikasmanohar/mathapi:latest

Command to run the application: docker run -p 8080:8080 mathapi:latest

endPoints: 
Addition:
http://localhost:8080/math/add/1,2,3,4
Op: {"result":"10.0"}

Subtraction:
localhost:8080/math/sub/1,2,3,4
Op: {"result":"-8.0"}

Multiplication:
localhost:8080/math/mul/1,2,3,4
Op: {"result":"24.0"}

Division: (takes first two operands for performing the operation)
http://localhost:8080/math/div/1,2
Op: {"result":"0.5"}

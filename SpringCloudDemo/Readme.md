### Thứ tự khởi động các project

1. Khởi động Eureka Server (Service Discovery)
- Mô tả: Eureka Server là thành phần trung tâm, quản lý việc đăng ký và khám phá các service.
  + Mở project Eureka Server trong IDE.
  + Chạy lệnh Maven để build project:
    
    > mvn clean install
    
  + Chạy EurekaServerApplication.java.
  + Kiểm tra: Truy cập vào http://localhost:8761 để kiểm tra trang quản lý của Eureka Server. Nếu thấy giao diện Eureka Dashboard và không có service nào đăng ký (lúc đầu), thì Eureka Server đã hoạt động.

2. Khởi động Config Server (Cấu hình tập trung)
- Mô tả: Config Server cung cấp cấu hình tập trung cho các microservice
  + Mở project Config Server trong IDE.
  + Chạy lệnh Maven:
       
    > mvn clean install

  + Chạy ConfigServerApplication.java.
  + Kiểm tra: Truy cập http://localhost:8888/user-service/default để kiểm tra xem cấu hình của user-service có được trả về từ Config Server hay không.
3. Khởi động các microservices (User Service và Order Service)
  + User Service
  + Order Service
    > mvn clean install
  + Truy cập vào Eureka Dashboard (http://localhost:8761) để kiểm tra xem User Service và Order Service  đã đăng ký thành công hay chưa.
4. Khởi động API Gateway (Spring Cloud Gateway)
- Mô tả: API Gateway là nơi nhận các yêu cầu từ client và định tuyến chúng đến các microservice thích hợp.
  + Chạy lệnh Maven:
       
    > mvn clean install
  + Chạy ApiGatewayApplication.java.
  + Kiểm tra: Truy cập Eureka Dashboard (http://localhost:8761) để xem API Gateway đã đăng ký thành công hay chưa.
 
###  Kiểm tra hệ thống
 - Kiểm tra Eureka Dashboard:
   + Truy cập vào Eureka Dashboard tại http://localhost:8761
       + Eureka Server hoạt động.
       + Các microservice user-service, order-service và api-gateway đã đăng ký thành công.
 - Kiểm tra API Gateway:
   + Kiểm tra User Service qua API Gateway
     
     ```
     http://localhost:8080/users/{id}

     http://localhost:8080/users/123

     ```
   + Kiểm tra Order Service qua API Gateway
     
     ```
     http://localhost:8080/orders/{id}

     http://localhost:8080/orders/456

     ```

  ### Một số lưu ý:
  
  - Đảm bảo thứ tự khởi động: Eureka Server và Config Server phải được khởi động trước, sau đó mới khởi động các microservice khác (User Service, Order Service, API Gateway).

  - Cấu hình Git: Nếu bạn đang sử dụng Spring Cloud Config Server và cấu hình Git để quản lý cấu hình tập trung, hãy đảm bảo bạn đã thiết lập đúng URL Git trong Config Server và đã đẩy các file cấu hình lên repository.

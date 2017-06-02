![](https://camo.githubusercontent.com/21caea3d7f67f451630012f657ae59a56709365c/687474703a2f2f692e696d6775722e636f6d2f6838316e39694b2e706e67)

**Load balancers** tiếp nhận và phân phối các request từ client tới các
thực thể tính toán hoặc lưu trữ như server/ database, sau đó trả về các
response lại client từ các thực thể đó.

**Lợi ích**:
* phòng ngừa việc request đc gửi tới các server lỗi/ unhealthy
* phòng ngừa việc overloading tài nguyên
* loại trừ single point failure

Load balancers có thể phân phối request dựa trên nhiều tiêu chí khác nhau:

* random
* least loaded: request được gửi đến server với ít active connection nhất
* session
* hash: dựa trên hash IP, port, protocol header..
* round robin
* weighted round robin
* layer 4
* layer 7

##### Layer 4 load balancing (Layer 4 LB)

Layer 4 LB sử dụng thông tin định nghĩa trong tầng Transport (Layer 4 trong OSI)
để quyết định phân phối request như thế nào. Cụ thể, Layer 4 LB dựa vào
IP của nguồn và đích, port trong package header mà không dựa vào content bên trong packet.

Khi nhận được request, Layer 4 LB đưa ra quyết định phân phối request sau đó
perform Network Address Translation (NAT) để chuyển IP đích từ IP của nó thành
IP của server tương ứng. Tương tự, khi nhận được response từ server, nó chuyển IP nguồn
từ của server thành IP của nó.

Azure Load Balancer là 1 Layer 4 Lb, sử dụng phương pháp Hash.

##### Layer 7 load balancing
Layer 7 LB sử dụng thông tin định nghĩa trong tầng Application (Layer 7 trong OSI)
để quyết định phân phối request như thế nào. Cụ thể, Layer 7 LB sẽ đọc content của package như
URL, kiểu dữ liệu (text, video, image..).

Khác với Layer 4 LB, Layer 7 Lb không sử dụng NAT mà LB hoạt động như một reverse proxy server. (Sẽ viết về cái này sau)

Ví dụ: Azure Application Gateway, NGNIX Plus là các Layer 7.
Layer 7 LB có thể được sử dụng trong trường hợp bạn muốn các request các nội dung
tĩnh như video, ảnh được xử lí bởi 1 server riêng.








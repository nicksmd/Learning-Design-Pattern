### Các phương pháp scale cơ sở dữ liệu quan hệ

##### Master-slave replication

![](https://camo.githubusercontent.com/6a097809b9690236258747d969b1d3e0d93bb8ca/687474703a2f2f692e696d6775722e636f6d2f4339696f47746e2e706e67)

Server Master sẽ chịu trách nhiệm đọc và ghi dữ liệu, ghi sao chép
dữ liệu lên các server slave. Trong khi đó các server slave chỉ chịu
trách nhiệm đọc.

Nếu server master đột nhiên chết, hệ thống có thể tiếp tục hoạt động
ở chế độ read-only cho đến khi 1 server slave được config để
trở thành server master.

**Nhược điểm:**

* Cần thêm các logic để config 1 server slave thành server master

##### Master-master replication

![](https://camo.githubusercontent.com/5862604b102ee97d85f86f89edda44bde85a5b7f/687474703a2f2f692e696d6775722e636f6d2f6b7241484c47672e706e67)

Cả 2 server master đọc, ghi dữ liệu và đồng bộ dữ liệu với nhau. Nếu
một trong 2 master chết, server kia sẽ tiếp tục hoạt động bình thường.

**Nhược điểm:**

* Cần 1 load-balancer
* Có độ trễ để đồng bộ giữa các master => không đồng nhất, vi phạm tính
ACID

Nhược điểm chung của **replication**:

* nguy cơ mất mát dữ liệu khi 1 server chết trước khi dữ liệu nó chứa được
đồng bộ với các server khác.
* càng nhiều server càng lag vì phải đồng bộ dữ liệu càng nhiều
* chi phí hardware và độ phức tạp tăng

##### Federation

Là chia nhỏ database dự trên chức năng.

![](https://camo.githubusercontent.com/6eb6570a8b6b4e1d52e3d7cc07e7959ea5dac75f/687474703a2f2f692e696d6775722e636f6d2f553371563333652e706e67)

Ví dụ như trong hình trên, thay vì sử dụng 1 db với 3 bảng,
ta dùng 3 db khác nhau cho mỗi loại dữ liệu: user, product, forum. Ưu điểm là
 giảm traffic dữ liệu lên mỗi server, từ đó giảm lag. Tăng cache hit, tăng lưu lượng vì
 ta có thể ghi dữ liệu song song.

 **Nhược điểm:**

 * Không phù hợp khi hệ thống có quá nhiều bảng, function.
 * join bảng giữa các server khác nhau là rất phức tạp.
 * tăng chi phí hardware và độ phức tạp khi triển khai hệ thống.

##### Sharding

![](https://camo.githubusercontent.com/1df78be67b749171569a0e11a51aa76b3b678d4f/687474703a2f2f692e696d6775722e636f6d2f775538783549642e706e67)

Phôi phối data giữa các server sao cho mỗi server chỉ lưu trữ 1 tập con 
của tập dữ liệu. Ưu điểm tương tự Federation. Ví dụ để chia nhỏ tập dữ liệu user, 
ta có thể chia nhỏ dựa trên tên hoặc vị trí địa lí.

**Nhược điểm:**

* join data trở nên phức tạp
* tăng chi phí hardware
* mất cân bằng giữa các server

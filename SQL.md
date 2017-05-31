#### Giải thích tính ACID của cơ sở dữ liệu quan hệ

##### A - Atomicity
Vào những năm 1800, các nhà khoa học dùng từ **atom** - **nguyên tử** để mô tả những hạt vật chất nhỏ nhất.
Họ chọn từ này bởi vì nó có nghĩa là *không thể chia nhỏ*. Đến những năm 1900, họ lại nhận thây
nguyên tử thực chất có thể chia nhỏ ra hơn nữa (thành proton, electron, ...). Nhưng đã quá muộn để thay đổi ngôn ngữ.

Quá trình chia nhỏ nguyên tử hấp dẫn đến nỗi từ **atomic** lại được
dùng để chỉ quá trình chia nhỏ nguyên tử (ví dụ: atomic bomb, atomic energy)

![](http://michaeljswart.com/wp-content/uploads/2011/07/Atomic.png)

Nhưng khi chúng ta đề cập đến tính atomicity trong SQL, từ atomicity giữ nguyên ý nghĩa nguyên thủy của nó:
không thể chia nhỏ. Một transaction của SQL server luôn atomic. Nó là tất cả hoặc
không gì cả, nghĩa là một transaction hoặc được thực hiện hoặc không được thực hiện,
sẽ không có trường hợp 1 giao dịch được thực hiện 1 phần.

Để đảm bảo tính atomic cho các transaction, SQL server dùng [log](https://msdn.microsoft.com/en-us/library/ms186259.aspx?f=255&MSPPError=-2147217396)
để ghi lại trạng thái trước khi thực hiện transaction. Bằng cách đó,
trong trường hợp có lỗi xảy ra, nó hoàn toàn có thể quay lại trạng thái cũ.

Ví dụ: vào năm 2009, quốc đảo Samoa quyết định buộc người dân chuyển
 từ lái xe ở tay phải sang lái xe bên tay trái. Sự chuyển đổi này phải có tính atomic,
 nghĩa là nó phải được thực hiện đồng bộ khắp cả nước, ở mọi
  lĩnh vực liên quan như đèn giao thông, đường sá...;không có
 ngoại lệ, bằng không sẽ có tai nạn giao thông xảy ra.

```SQL
BEGIN TRANSACTION

UPDATE ROADS
SET TrafficDirection = 'Left'
WHERE Country = 'Samoa';

UPDATE TRAFFIC_LIGHTS
SET TrafficDirectionMode = 'Left'
WHERE Country = 'Samoa';

UPDATE INTERSECTIONS
SET TrafficDirectionConfigurationMode = 'Left'
WHERE Country = 'Samoa'

COMMIT
```

##### C - Consistency
##### I - Isolation
##### D - Durability

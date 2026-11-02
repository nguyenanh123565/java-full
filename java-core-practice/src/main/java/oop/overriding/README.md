# Overriding

## Dùng để làm gì?
Ghi đè thay thế hành vi instance được kế thừa, để object lớp con phản hồi phù hợp khi được sử dụng qua reference lớp cha.

## Bắt buộc hiểu
- Tên và danh sách tham số phải phù hợp; kiểu trả về phải tương thích. Có thể dùng kiểu trả về reference cụ thể hơn.
- `@Override` giúp compiler phát hiện viết sai hợp đồng ghi đè.
- Không giảm quyền truy cập; không mở rộng checked exception ngoài hợp đồng method cha.
- Method final không được override; private method không được kế thừa để override.
- Static method và field cùng tên bị hide, không có dispatch như instance method.
- `super.method()` gọi cài đặt cha; `this.method()` vẫn có thể quay lại method đang override.

## Lỗi thường gặp
- Đổi tham số rồi tưởng là override; thực tế có thể thành overload.
- Quên @Override nên không nhận ra sai chữ hoặc sai chữ hoa/thường.
- Gọi this.describe trong chính describe dẫn tới đệ quy.
- Đoán field/static method theo kiểu object như method instance.

## Tự kiểm tra
1. Khi nào compiler chọn signature, khi nào runtime chọn cài đặt override?
2. Vì sao private/final method không ghi đè như method thông thường?
3. super.describe khác this.describe trong Child ra sao?
4. b.label và b.getLabel có thể lấy dữ liệu từ hai field khác nhau không?

## Bài tập từ dễ đến khó
1. Animal/Dog với @Override và lời gọi qua reference cha.
2. Child mở rộng kết quả Parent bằng super.describe; giải thích nguy cơ đệ quy.
3. So sánh field hiding, static hiding và instance overriding trên cùng hệ lớp.

Đoán `OverridingDemo.java`; làm TODO trong `OverridingExercise.java`; xem `OverridingSolution.java` riêng.


## Bộ bài tập tự làm bổ sung

Sau README → tutorial/Demo → ví dụ, làm [bộ bài tập có thứ tự và cách chạy](exercises/README.md), tự [review](exercises/review.md), rồi ghi chú. Gợi ý và lời giải nằm riêng trong bộ bài. Các bài/code/ghi chú hiện có được giữ nguyên.

package oop.overriding;

public class OverridingExercise {
    public static void main(String[] args) {
        // Bài 1 - Dễ: TODO tạo Animal.speak(), Dog override speak() với @Override.
        // Gọi qua Animal giữ Dog; giải thích vì sao tên + tham số phải phù hợp.

        // Bài 2 - Vừa: TODO tạo Parent.describe() trả "Parent".
        // Child.describe() dùng super.describe() rồi thêm thông tin riêng.
        // Giải thích vì sao gọi this.describe() tại đây dễ gây đệ quy vô hạn.

        // Bài 3 - Khó: TODO tạo Base/Child có field label cùng tên,
        // static kind() cùng tên và method instance getLabel() bị override.
        // Dùng Base b = new Child(), đọc b.label, b.getLabel(),
        // gọi Base.kind()/Child.kind(); dự đoán từng kết quả trước khi chạy.
        // Giải thích field hiding, static hiding khác overriding thế nào.
    }
}

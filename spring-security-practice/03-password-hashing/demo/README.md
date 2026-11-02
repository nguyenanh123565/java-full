# Demo — BCrypt và kiểm tra mật khẩu

Minh họa có chủ đích, không phải ứng dụng chạy riêng. Dùng project được chỉ ở README workspace nếu cần thực thi. Mỗi lần chỉ đổi một yếu tố.

```java
var encoder = new BCryptPasswordEncoder();
String first = encoder.encode("learning-only");
String second = encoder.encode("learning-only");
System.out.println(first.equals(second));
System.out.println(encoder.matches("learning-only", first));
```
Cần dependency Security; đây là snippet, không phải file javac độc lập. Không in mật khẩu thật.

Trước khi thử, ghi request đầu vào, đối tượng Java được gọi và response dự kiến. Sau khi thử, đối chiếu với HTTP status/body hoặc biến Java quan sát được.

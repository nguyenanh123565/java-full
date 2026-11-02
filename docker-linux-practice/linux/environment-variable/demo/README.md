# Demo Bash — chỉ dùng giá trị giả

```bash
export APP_LABEL=learning
sh -c 'printf "child sees: %s\n" "$APP_LABEL"'
APP_LABEL=changed
sh -c 'printf "new child sees: %s\n" "$APP_LABEL"'
```

Không in toàn bộ environment. Vì biến đã export, giá trị mới cũng được export khi gán lại. Process đã tạo trước đó không tự nhận bản cập nhật. Khi học Java, đặt `System.getenv("APP_LABEL")` trong một main thử riêng để thấy cơ chế tương ứng.
